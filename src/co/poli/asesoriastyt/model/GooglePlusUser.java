package co.poli.asesoriastyt.model;


/**
 * The Class GooglePlusUser.
 */
public class GooglePlusUser {
	
	/** The id. */
	private String id;
	
	/** The email. */
	private String email;
	
	/** The firstname. */
	private String firstname;
	
	/** The lastname. */
	private String lastname;
	
	/** The fullname. */
	private String fullname; 
	
	/** The google plus link. */
	private String googlePlusLink; 
	
	/** The profile pic link. */
	private String profilePicLink;
	
	/** The gender. */
	private String gender;
	
	/** The birthday. */
	private String birthday;
	
	/** The language. */
	private String language;
	

	/**
	 * Instantiates a new google plus user.
	 *
	 * @param id the id
	 * @param email the email
	 */
	public GooglePlusUser(String id, String email) {
		this.id = id;
		this.email = email;
		
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the fullname.
	 *
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * Sets the fullname.
	 *
	 * @param fullname the new fullname
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * Gets the google plus link.
	 *
	 * @return the google plus link
	 */
	public String getGooglePlusLink() {
		return googlePlusLink;
	}

	/**
	 * Sets the google plus link.
	 *
	 * @param googlePlusLink the new google plus link
	 */
	public void setGooglePlusLink(String googlePlusLink) {
		this.googlePlusLink = googlePlusLink;
	}

	/**
	 * Gets the profile pic link.
	 *
	 * @return the profile pic link
	 */
	public String getProfilePicLink() {
		return profilePicLink;
	}

	/**
	 * Sets the profile pic link.
	 *
	 * @param profilePicLink the new profile pic link
	 */
	public void setProfilePicLink(String profilePicLink) {
		this.profilePicLink = profilePicLink;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the birthday.
	 *
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * Sets the birthday.
	 *
	 * @param birthday the new birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * Gets the language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 *
	 * @param language the new language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

}