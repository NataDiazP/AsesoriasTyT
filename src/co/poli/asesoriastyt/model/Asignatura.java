package co.poli.asesoriastyt.model;

public class Asignatura {
	
	private String idasignatura;
	private String nombreasignatura;
	
	public String getIdAsignatura() {
		return idasignatura;
	}
	public void setIdAsignatura(String idasignatura) {
		this.idasignatura = idasignatura;
	}
	public String getNombreAsignatura() {
		return nombreasignatura;
	}
	public void setNombreAsignatura(String nombreasignatura) {
		this.nombreasignatura = nombreasignatura;
	}
	
	@Override
	public String toString() {
		return "Asignatura [idasignatura=" + idasignatura + ", nombreasignatura=" + nombreasignatura+ "]";
	}

}
