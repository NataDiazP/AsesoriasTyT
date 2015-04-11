package co.poli.asesoriastyt.model;


/**
 * The Class Asignatura.
 */
public class Asignatura {
	
	/** The idasignatura. */
	private String idasignatura;
	
	/** The nombreasignatura. */
	private String nombreasignatura;
	
	/**
	 * Gets the id asignatura.
	 *
	 * @return the id asignatura
	 */
	public String getIdAsignatura() {
		return idasignatura;
	}
	
	/**
	 * Sets the id asignatura.
	 *
	 * @param idasignatura the new id asignatura
	 */
	public void setIdAsignatura(String idasignatura) {
		this.idasignatura = idasignatura;
	}
	
	/**
	 * Gets the nombre asignatura.
	 *
	 * @return the nombre asignatura
	 */
	public String getNombreAsignatura() {
		return nombreasignatura;
	}
	
	/**
	 * Sets the nombre asignatura.
	 *
	 * @param nombreasignatura the new nombre asignatura
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
