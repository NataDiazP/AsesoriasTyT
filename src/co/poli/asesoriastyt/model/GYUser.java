package co.poli.asesoriastyt.model;


/**
 * The Class GYUser.
 */
public class GYUser {
	
	/** The id. */
	private String id;
	
	/** The fullname. */
	private String fullname;
	
	/** The email. */
	private String email;
	
	/** The firstname. */
	private String firstname;
	
	/** The lastname. */
	private String lastname;
	
	/** The gender. */
	private String gender;
	
	/** The lang. */
	private String lang;
	
	/**
	 * Instantiates a new GY user.
	 *
	 * @param id the id
	 * @param fullname the fullname
	 * @param email the email
	 * @param firstname the firstname
	 * @param lastname the lastname
	 * @param gender the gender
	 * @param lang the lang
	 */
	public GYUser(String id, String fullname, String email, String firstname, String lastname, String gender, String lang) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.lang = lang;
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
	 * Gets the lang.
	 *
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * Sets the lang.
	 *
	 * @param lang the new lang
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

}
