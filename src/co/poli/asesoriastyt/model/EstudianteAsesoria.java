/**
 * 
 */
package co.poli.asesoriastyt.model;


/**
 *  Class EstudianteAsesoria.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class EstudianteAsesoria {

	 /**  num doc estudiante. */
 	private String numDocEstudiante;
 	
 	private String nombreCompleto;
	 
 	/**  id asesoria. */
 	private String idAsesoria;
	 
 	/**  asistencia asesoria. */
 	private String asistenciaAsesoria;
	 
 	/**  email estudiante. */
 	private String emailEstudiante;
	 
	/**
	 * Gets  id asesoria.
	 *
	 * @return  idAsesoria
	 */
	public String getIdAsesoria() {
		return idAsesoria;
	}
	
	/**
	 * Sets  id asesoria.
	 *
	 * @param idAsesoria  idAsesoria to set
	 */
	public void setIdAsesoria(String idAsesoria) {
		this.idAsesoria = idAsesoria;
	}
	
	/**
	 * Gets  num doc estudiante.
	 *
	 * @return  numDocEstudiante
	 */
	public String getNumDocEstudiante() {
		return numDocEstudiante;
	}
	
	/**
	 * Sets  num doc estudiante.
	 *
	 * @param numDocEstudiante  numDocEstudiante to set
	 */
	public void setNumDocEstudiante(String numDocEstudiante) {
		this.numDocEstudiante = numDocEstudiante;
	}
	
	/**
	 * Gets  asistencia asesoria.
	 *
	 * @return  asistenciaAsesoria
	 */
	public String getAsistenciaAsesoria() {
		return asistenciaAsesoria;
	}
	
	/**
	 * Sets  asistencia asesoria.
	 *
	 * @param asistenciaAsesoria  asistenciaAsesoria to set
	 */
	public void setAsistenciaAsesoria(String asistenciaAsesoria) {
		this.asistenciaAsesoria = asistenciaAsesoria;
	}
	
	/**
	 * Gets  email estudiante.
	 *
	 * @return  emailEstudiante
	 */
	public String getEmailEstudiante() {
		return emailEstudiante;
	}
	
	/**
	 * Sets  email estudiante.
	 *
	 * @param emailEstudiante  emailEstudiante to set
	 */
	public void setEmailEstudiante(String emailEstudiante) {
		this.emailEstudiante = emailEstudiante;
	}

	/**
	 * @return  nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * @param nombreCompleto  nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	
}
