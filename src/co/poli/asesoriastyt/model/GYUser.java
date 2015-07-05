/*
 * 
 */
package co.poli.asesoriastyt.model;


/**
 *  Class GYUser.
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class GYUser {
	
	/**  id. */
	private String id;
	
	/**  fullname. */
	private String fullname;
	
	/**  email. */
	private String email;
	
	/**  firstname. */
	private String firstname;
	
	/**  lastname. */
	private String lastname;
	
	/**  gender. */
	private String gender;
	
	/**  lang. */
	private String lang;
	
	/**
	 * Instantiates a new GY user.
	 *
	 * @param id  id
	 * @param fullname  fullname
	 * @param email  email
	 * @param firstname  firstname
	 * @param lastname  lastname
	 * @param gender  gender
	 * @param lang  lang
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
	 * Gets  lang.
	 *
	 * @return  lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * Sets  lang.
	 *
	 * @param lang  new lang
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

}
