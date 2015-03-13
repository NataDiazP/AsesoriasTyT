package co.poli.asesoriastyt.model;

public class TipoIdentificacion {
	
	private String idtipo;
	private String nombretipo;
	
	
	public String getIdTipoIdentificacion() {
		return idtipo;
	}
	public void setIdTipoIdentificacion(String idtipo) {
		this.idtipo = idtipo;
	}
	public String getNombreTipoIdentificacion() {
		return nombretipo;
	}
	public void setNombreTipoIdentificacion(String nombretipo) {
		this.nombretipo = nombretipo;
	}
	
	@Override
	public String toString() {
		return "TipoIdentificacion [idtipo=" + idtipo + ", nombretipo=" + nombretipo+ "]";
	}

}
