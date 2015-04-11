/*
 * 
 */
package co.poli.asesoriastyt.dao;


/**
 * The Class AulasSQL.
 *
 * @author pavargas
 */
public class AulasSQL {
	
	/**
	 * Crear.
	 *
	 * @return the string
	 */
	public static String Crear() {
		return "INSERT INTO aulas (Id_Aula,Id_Bloque_Aula) VALUES (?, ?)";
	}

	/**
	 * Modificar.
	 *
	 * @return the string
	 */
	public static String Modificar() {
		return "UPDATE aulas SET Id_Bloque_Aula=? WHERE Id_Aula=?";
	}

	/**
	 * Consultar.
	 *
	 * @param Id_Aula the id_ aula
	 * @return the string
	 */
	public static String Consultar(String Id_Aula) {
		return "SELECT * FROM aulas WHERE Id_Aula = " + Id_Aula + "";
	}

	/**
	 * Eliminar.
	 *
	 * @return the string
	 */
	public static String Eliminar() {
		return "DELETE FROM aulas WHERE Id_Aula=? and Id_Bloque_Aula=?";
	}
}
