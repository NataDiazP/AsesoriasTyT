/*
 * 
 */
package co.poli.asesoriastyt.model;


/**
 *  Class GooglePlusUser.
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class GooglePlusUser {
	
	/**  id. */
	private String id;
	
	/**  email. */
	private String email;
	
	/**  firstname. */
	private String firstname;
	
	/**  lastname. */
	private String lastname;
	
	/**  fullname. */
	private String fullname; 
	
	/**  google plus link. */
	private String googlePlusLink; 
	
	/**  profile pic link. */
	private String profilePicLink;
	
	/**  gender. */
	private String gender;
	
	/**  birthday. */
	private String birthday;
	
	/**  language. */
	private String language;
	

	/**
	 * Instantiates a new google plus user.
	 *
	 * @param id  id
	 * @param email  email
	 */
	public GooglePlusUser(String id, String email) {
		this.id = id;
		this.email = email;
		
	}

	/**
	 * Gets  id.
	 *
	 * @return  id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets  id.
	 *
	 * @param id  new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets  email.
	 *
	 * @return  email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets  email.
	 *
	 * @param email  new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets  firstname.
	 *
	 * @return  firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets  firstname.
	 *
	 * @param firstname  new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets  lastname.
	 *
	 * @return  lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets  lastname.
	 *
	 * @param lastname  new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets  fullname.
	 *
	 * @return  fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * Sets  fullname.
	 *
	 * @param fullname  new fullname
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * Gets  google plus link.
	 *
	 * @return  google plus link
	 */
	public String getGooglePlusLink() {
		return googlePlusLink;
	}

	/**
	 * Sets  google plus link.
	 *
	 * @param googlePlusLink  new google plus link
	 */
	public void setGooglePlusLink(String googlePlusLink) {
		this.googlePlusLink = googlePlusLink;
	}

	/**
	 * Gets  profile pic link.
	 *
	 * @return  profile pic link
	 */
	public String getProfilePicLink() {
		return profilePicLink;
	}

	/**
	 * Sets  profile pic link.
	 *
	 * @param profilePicLink  new profile pic link
	 */
	public void setProfilePicLink(String profilePicLink) {
		this.profilePicLink = profilePicLink;
	}

	/**
	 * Gets  gender.
	 *
	 * @return  gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets  gender.
	 *
	 * @param gender  new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets  birthday.
	 *
	 * @return  birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * Sets  birthday.
	 *
	 * @param birthday  new birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * Gets  language.
	 *
	 * @return  language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets  language.
	 *
	 * @param language  new language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

}