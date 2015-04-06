package co.poli.asesoriastyt.util;

public enum Constantes {
	FORMATO_EXCEL_XLSX("xlsx"),
	FORMATO_EXCEL_XLS("xls");
	
	private String constantes;
	 
	private Constantes(String s) {
		this.constantes = s;
	}
 
	public String getConstante() {
		return this.constantes;
	}
}



