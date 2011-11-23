package com.logansrings.booklibrary.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
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

	@Transactional(readOnly=false)
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

	@Transactional(readOnly=true)
	public User findByEmail(String email) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User where email = ?");
		query.setParameter(0, email);
		return (User) query.uniqueResult();		
	}


	public static void main(String arg[]) {
		String encrypt1 = Encrypting.encrypt("admin");
		String encrypt2 = Encrypting.encrypt("admin");
		boolean isEqual = encrypt1.equals(encrypt2);

		encrypt1 = Encrypting.encrypt("admin");
		encrypt2 = Encrypting.encrypt("logan");

		isEqual = encrypt1.equals(encrypt2);

		encrypt1 = Encrypting.encrypt("admin"); // 21232f297a57a5a743894a0e4a801fc3
		encrypt2 = Encrypting.encrypt("mark"); // ea82410c7a9991816b5eeeebe195e20a

		isEqual = encrypt1.equals(encrypt2);

		encrypt1 = Encrypting.encrypt("admin");
		encrypt2 = Encrypting.encrypt("abcdefghijklmnopqrstuvwxyz");

		isEqual = encrypt1.equals(encrypt2);
	}

}

class Encrypting {

	static PasswordEncoder encoder = new Md5PasswordEncoder();
	
	/**
	 * Encrypts aString
	 * @param aString
	 * @return an encrypted String or null if unable to encrypt aString
	 */
	public static synchronized String encrypt(String aString) {
	    String hashedPass = encoder.encodePassword(aString, null);
	    return hashedPass;
	}

	private static MessageDigest messageDigest;

	/**
	 * Encrypts aString
	 * @param aString
	 * @return an encrypted String or null if unable to encrypt aString
	 */
	public static synchronized String encryptold(String aString) {
		String encryptedString = null;
		try {
			MessageDigest messageDigest = getMessageDigest();
			messageDigest.reset();
			messageDigest.update(aString.getBytes());
			byte[] messageDigestBytes = messageDigest.digest();

//			encryptedString = new String(Base64.encode(messageDigestBytes)); 
			encryptedString = new String(messageDigestBytes); 
			return encryptedString;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	static protected MessageDigest getMessageDigest() throws NoSuchAlgorithmException {
		if (messageDigest == null) {
			setMessageDigest(MessageDigest.getInstance("MD5"));
		}
		return messageDigest;
	}

	protected static void setMessageDigest(MessageDigest messageDigest) {
		Encrypting.messageDigest = messageDigest;
	}

}
