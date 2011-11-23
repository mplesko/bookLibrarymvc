package com.logansrings.booklibrary.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.logansrings.booklibrary.model.User;
import com.logansrings.booklibrary.model.UserAuthority;

import org.hibernate.Query;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly=false)
	public User save(String username, String password, String email) {
		String encryptedPassword = Encrypting.encode(password);
		if (encryptedPassword == null) {
			return User.getInvalidUser("unable to encrypt password");
		}
		UserAuthority userAuthority = UserAuthority.getDefaultAuthority(username);
		User user = new User(username, encryptedPassword, email, userAuthority);
		sessionFactory.getCurrentSession().save(userAuthority);
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
		String encoded2 = Encrypting.encode("mark"); // ea82410c7a9991816b5eeeebe195e20a
		String encoded3 = Encrypting.encode("logan"); // ea82410c7a9991816b5eeeebe195e20a
		// mark base64 - 6oJBDHqZkYFrXu7r4ZXiCg==
		// mark        - ea82410c7a9991816b5eeeebe195e20a
		// logan base64 - NEet/XQs37kEijspuvGufQ==
		// logan        - 3447adfd742cdfb9048a3b29baf1ae7d

		
//		String encrypt1 = Encrypting.encrypt("admin");
//		String encrypt2 = Encrypting.encrypt("admin");
//		boolean isEqual = encrypt1.equals(encrypt2);
//
//		encrypt1 = Encrypting.encrypt("admin");
//		encrypt2 = Encrypting.encrypt("logan");
//
//		isEqual = encrypt1.equals(encrypt2);
//
//
//		encrypt1 = Encrypting.encrypt("admin");
//		encrypt2 = Encrypting.encrypt("abcdefghijklmnopqrstuvwxyz");
//
//		isEqual = encrypt1.equals(encrypt2);
	}
}

class Encrypting implements PasswordEncoder {

	static PasswordEncoder encoder = new Md5PasswordEncoder();
//	static PasswordEncoder encoder = new MessageDigestPasswordEncoder("MD5", true);
	
	/**
	 * Encodes aString
	 * @param aString
	 * @return an encoded String or null if unable to encrypt aString
	 */
	public static synchronized String encode(String aString) {
		String encodedString = encoder.encodePassword(aString, null);
	    return encodedString;
	}

	@Override
	public String encodePassword(String rawPassword, Object salt) throws DataAccessException {
		return encode(rawPassword);
	}

	@Override
	public boolean isPasswordValid(String encodedPassword, String rawPassword, Object salt) throws DataAccessException {
		String rawPasswordEncoded = encodePassword(rawPassword, null);
		return rawPasswordEncoded.equals(encodedPassword);
	}

//	private static MessageDigest messageDigest;

	/**
	 * Encrypts aString
	 * @param aString
	 * @return an encrypted String or null if unable to encrypt aString
	 */
//	public static synchronized String encrypt(String aString) {
//		String encryptedString = null;
//		try {
//			MessageDigest messageDigest = getMessageDigest();
//			messageDigest.reset();
//			messageDigest.update(aString.getBytes());
//			byte[] messageDigestBytes = messageDigest.digest();
//
////			encryptedString = new String(Base64.encode(messageDigestBytes)); 
//			encryptedString = new String(messageDigestBytes); 
//			return encryptedString;
//		}
//		catch (Exception e){
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	static protected MessageDigest getMessageDigest() throws NoSuchAlgorithmException {
//		if (messageDigest == null) {
//			setMessageDigest(MessageDigest.getInstance("MD5"));
//		}
//		return messageDigest;
//	}

//	protected static void setMessageDigest(MessageDigest messageDigest) {
//		Encrypting.messageDigest = messageDigest;
//	}

}
