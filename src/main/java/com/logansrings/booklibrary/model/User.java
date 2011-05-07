package com.logansrings.booklibrary.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javax.persistence.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "users" )
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;
	@Version
    @Column(name="version")
    private Integer version;
	
	@Column(name = "username")
	private String username = "";
	@Column(name = "password")
	private String password = "";
	
	@Transient
	private String email = "";

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinTable(name = "userbook",
			joinColumns = {@JoinColumn(name = "userName")},
			inverseJoinColumns = {@JoinColumn(name = "bookId")})
	private Set<Book> books = new HashSet<Book>();
	public void setBooks(Set<Book> books) {this.books = books;}
	public Set<Book> getBooks() {return books;}
	
	@Transient
	private boolean valid;
	@Transient
	private String context = "";
//	@Transient
//	private static Encrypting encrypting = null;
	@Transient
	private String persistMode = "";

//	public static void main(String[] args) throws ServletException {
////		System.out.println(User.getTestUser().toString());
//		User testUser = User.find("mark", "mark");
//		System.out.println(testUser.toString());
//	}

	public User() {}

//	private User(String inUserName) {
//		this.userName = inUserName;
//		if (ApplicationUtilities.isEmpty(inUserName)) {
//			valid = false;
//			context = "must have userName and password";
//			return;
//		}
//		valid = true;
//	}
//	
//	private User(String inUserName, String inPassword) {
//		this(inUserName);
//		if (isNotValid()) {
//			return;
//		}
//		this.password = User.encryptPassword(inPassword);
//		if (this.password == null) {
//			valid = false;
//			context = "unable to encrypt password";
//		}
//	}
//	
//	public static User find(String inUserName, String inPassword) {
//		User user = new User(inUserName, inPassword);
//		if (user.isNotValid()) {
//			return user;
//		}
//		Persistable persistable = getPersistenceDelegate().findOne(user);
//		if (persistable == null) {
//			user.valid = false;
//			user.context = "invalid user name or password";
//			return user;
//		}
//		user = (User)persistable;
//		user.valid = true;
//		return user;
//	}
//
//	public static User create(String inUserName, String inPassword) {
//		User user = new User(inUserName);
//		if (user.isNotValid()) {
//			return user;
//		}
//		if (getPersistenceDelegate().exists(user)) {
//			user.valid = false;
//			user.context = "already exists";
//			return user;
//		}
//		user = new User(inUserName, inPassword);
//		if (user.isNotValid()) {
//			return user;
//		}
//		if (getPersistenceDelegate().persist(user)) {
//			user.valid = true;
//		} else {
//			user.valid = false;
//			user.context = "unable to persist user";
//		}
//		return user;
//	}
//
//	/**
//	 * @param password 
//	 * @return encrypted password or null if process failed
//	 */
//	private static String encryptPassword(String password) {
//		String encryptedPassword = getEncrypting().encrypt(password);
//		if (encryptedPassword == null) {
//			Notification.newNotification(
//					null, "User.encryptPassword()" , "failed", 
//					"", Type.DOMAIN, Severity.ERROR);					
//		}
//		return encryptedPassword;
//	}

	public boolean isValid() {return valid;}

	public boolean isNotValid() {return ! isValid();}

	public String getContext() {return context;}

	public String toString() {
		StringBuilder returnValue = new StringBuilder();
		returnValue.append(
				String.format("[%s] id:%d userName:%s valid:%s context:%s version:%d bookCount:%d",
				"User", id, username, valid, context, version, books.size()));
		for (Book book : this.books) {
			returnValue.append("\n");
			returnValue.append(book.toString());
		}
		return returnValue.toString();
	}

	public static User getTestUser() {
		User user = new User();
		user.id = 1L;
		user.username = "userName";
		user.password = "password";
		user.valid = true;
		user.context = "context";
		return user;
	}

//	static void setEncrypting(Encrypting encrypting) {
//		User.encrypting = encrypting;
//	}
//	static private Encrypting getEncrypting() {
//		if (encrypting == null) {
//			setEncrypting(Encrypting.getInstance());
//		}
//		return encrypting;
//	}
//
//	static private PersistenceDelegate getPersistenceDelegate() {
//		return ApplicationContext.getPersistenceDelegate();
//	}
//
//	public Long getId() {return id;}
//	@Override
//	public void setId(Long id) {this.id = id;}
//	
//	@Override
//	public Integer getVersion() {return version;}
//	@Override
//	public void setVersion(Integer version) {this.version = version;}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof User)) {
			return false;
		}		
		final User that = (User)other;
		return this == that || (this.username.equals(that.username));
	}
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (null == username ? 0 : username.hashCode());
		return hash;
	}
//	public void addBook(Long bookId) {
//		persistMode = "add";
//		Book book = new Book(bookId);
//		getPersistenceDelegate().persist(this, book);		
//	}
//
//	public void deleteBooks(List<Long> bookIdsToDelete) {
//		persistMode = "delete";
//		for (Long bookId : bookIdsToDelete) {
//			Book book = new Book(bookId);
//			getPersistenceDelegate().persist(this, book);		
//		}
//	}
//
//	@Override
//	public void setAssociatedPersistable(Persistable persistable) {
//		if ("add".equals(persistMode)) {
//			books.add((Book) persistable);
//		} else if ("delete".equals(persistMode)) {
//			if (books.contains((Book)persistable)) {
//				books.remove(persistable);
//			}
//		}
//	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}