package com.logansrings.booklibrary.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.codec.Base64;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.logansrings.booklibrary.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.hibernate.Query;


@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly=true)
	public User save(String username, String password, String email) {
		String encryptedPassword = Encrypting.encrypt(password);
		if (encryptedPassword == null) {
			return User.getInvalidUser("unable to encrypt password");
		}

		User user = new User(username, encryptedPassword, email);
		sessionFactory.getCurrentSession().save(user);
		
		

		return user;
	}
	

	@Transactional(readOnly=true)
	public User findByUsername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User where username = ?");
		query.setParameter(0, username);
		return (User) query.uniqueResult();
	} 

	public User findByEmail(String email) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User where email = ?");
		query.setParameter(0, email);
		return (User) query.uniqueResult();
		
	}
}

class Encrypting {
	private static MessageDigest messageDigest;

	/**
	 * Encrypts aString
	 * @param aString
	 * @return an encrypted String or null if unable to encrypt aString
	 */
	public static synchronized String encrypt(String aString) {
		String encryptedString = null;
		try {
			MessageDigest messageDigest = getMessageDigest();
			messageDigest.reset();
			messageDigest.update(aString.getBytes());
			byte[] messageDigestBytes = messageDigest.digest();

			encryptedString = new String(Base64.encode(messageDigestBytes)); 
			return encryptedString;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	static protected MessageDigest getMessageDigest() throws NoSuchAlgorithmException {
		if (messageDigest == null) {
			setMessageDigest(MessageDigest.getInstance("SHA-1"));
		}
		return messageDigest;
	}

	protected static void setMessageDigest(MessageDigest messageDigest) {
		Encrypting.messageDigest = messageDigest;
	}

	public static void main(String arg[]) {
		String encrypt1 = Encrypting.encrypt("admin");
		String encrypt2 = Encrypting.encrypt("admin");
		boolean isEqual = encrypt1.equals(encrypt2);

		encrypt1 = Encrypting.encrypt("admin");
		encrypt2 = Encrypting.encrypt("x");

		isEqual = encrypt1.equals(encrypt2);

		encrypt1 = Encrypting.encrypt("admin");
		encrypt2 = Encrypting.encrypt("password");

		isEqual = encrypt1.equals(encrypt2);

		encrypt1 = Encrypting.encrypt("admin");
		encrypt2 = Encrypting.encrypt("abcdefghijklmnopqrstuvwxyz");

		isEqual = encrypt1.equals(encrypt2);
	}

}
