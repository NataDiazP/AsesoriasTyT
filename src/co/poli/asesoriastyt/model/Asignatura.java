/*
 * 
 */
package co.poli.asesoriastyt.model;


/**
 *  Class Asignatura.
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class Asignatura {
	
	/**  idasignatura. */
	private String idasignatura;
	
	/**  nombreasignatura. */
	private String nombreasignatura;
	
	/**
	 * Gets  id asignatura.
	 *
	 * @return  id asignatura
	 */
	public String getIdAsignatura() {
		return idasignatura;
	}
	
	/**
	 * Sets  id asignatura.
	 *
	 * @param idasignatura  new id asignatura
	 */
	public void setIdAsignatura(String idasignatura) {
		this.idasignatura = idasignatura;
	}
	
	/**
	 * Gets  nombre asignatura.
	 *
	 * @return  nombre asignatura
	 */
	public String getNombreAsignatura() {
		return nombreasignatura;
	}
	
	/**
	 * Sets  nombre asignatura.
	 *
	 * @param nombreasignatura  new nombre asignatura
	 */
	public void setNombreAsignatura(String nombreasignatura) {
		this.nombreasignatura = nombreasignatura;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Asignatura [idasignatura=" + idasignatura + ", nombreasignatura=" + nombreasignatura+ "]";
	}

}
