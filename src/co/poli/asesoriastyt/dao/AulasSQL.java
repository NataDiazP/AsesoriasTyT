/*
 * 
 */
package co.poli.asesoriastyt.dao;


/**
 *  Class AulasSQL.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class AulasSQL {
	
	/**
	 * Crear.
	 *
	 * @return  string
	 */
	public static String Crear() {
		return "INSERT INTO aulas (Id_Aula,Id_Bloque_Aula) VALUES (?, ?)";
	}

	/**
	 * Modificar.
	 *
	 * @return  string
	 */
	public static String Modificar() {
		return "UPDATE aulas SET Id_Bloque_Aula=? WHERE Id_Aula=?";
	}

	/**
	 * Consultar.
	 *
	 * @param Id_Aula  id_ aula
	 * @return  string
	 */
	public static String Consultar(String Id_Aula) {
		return "SELECT * FROM aulas WHERE Id_Aula = " + Id_Aula + "";
	}

	/**
	 * Eliminar.
	 *
	 * @return  string
	 */
	public static String Eliminar() {
		return "DELETE FROM aulas WHERE Id_Aula=? and Id_Bloque_Aula=?";
	}
}
