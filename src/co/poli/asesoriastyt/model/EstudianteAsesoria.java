/**
 * 
 */
package co.poli.asesoriastyt.model;


/**
 * The Class EstudianteAsesoria.
 *
 * @author natad_000
 */
public class EstudianteAsesoria {

	 /** The num doc estudiante. */
 	private String numDocEstudiante;
 	
 	private String nombreCompleto;
	 
 	/** The id asesoria. */
 	private String idAsesoria;
	 
 	/** The asistencia asesoria. */
 	private String asistenciaAsesoria;
	 
 	/** The email estudiante. */
 	private String emailEstudiante;
	 
	/**
	 * Gets the id asesoria.
	 *
	 * @return the idAsesoria
	 */
	public String getIdAsesoria() {
		return idAsesoria;
	}
	
	/**
	 * Sets the id asesoria.
	 *
	 * @param idAsesoria the idAsesoria to set
	 */
	public void setIdAsesoria(String idAsesoria) {
		this.idAsesoria = idAsesoria;
	}
	
	/**
	 * Gets the num doc estudiante.
	 *
	 * @return the numDocEstudiante
	 */
	public String getNumDocEstudiante() {
		return numDocEstudiante;
	}
	
	/**
	 * Sets the num doc estudiante.
	 *
	 * @param numDocEstudiante the numDocEstudiante to set
	 */
	public void setNumDocEstudiante(String numDocEstudiante) {
		this.numDocEstudiante = numDocEstudiante;
	}
	
	/**
	 * Gets the asistencia asesoria.
	 *
	 * @return the asistenciaAsesoria
	 */
	public String getAsistenciaAsesoria() {
		return asistenciaAsesoria;
	}
	
	/**
	 * Sets the asistencia asesoria.
	 *
	 * @param asistenciaAsesoria the asistenciaAsesoria to set
	 */
	public void setAsistenciaAsesoria(String asistenciaAsesoria) {
		this.asistenciaAsesoria = asistenciaAsesoria;
	}
	
	/**
	 * Gets the email estudiante.
	 *
	 * @return the emailEstudiante
	 */
	public String getEmailEstudiante() {
		return emailEstudiante;
	}
	
	/**
	 * Sets the email estudiante.
	 *
	 * @param emailEstudiante the emailEstudiante to set
	 */
	public void setEmailEstudiante(String emailEstudiante) {
		this.emailEstudiante = emailEstudiante;
	}

	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	
}
