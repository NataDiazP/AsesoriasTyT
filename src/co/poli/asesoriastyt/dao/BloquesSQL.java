/**
 * 
 */
package co.poli.asesoriastyt.dao;


/**
 * The Class BloquesSQL.
 *
 * @author pavargas
 */
public class BloquesSQL {
	
	/**
	 * Crear.
	 *
	 * @return the string
	 */
	public static String Crear() {
		return "INSERT INTO bloques (Id_Bloque,Encargado_Bloque) VALUES (?, ?)";
	}

	/**
	 * Modificar.
	 *
	 * @return the string
	 */
	public static String Modificar() {
		return "UPDATE bloques SET Encargado_Bloque=? WHERE Id_Bloque=?";
	}

	/**
	 * Consultar.
	 *
	 * @param Id_Bloque the id_ bloque
	 * @return the string
	 */
	public static String Consultar(String Id_Bloque) {
		return "SELECT * FROM bloques WHERE Id_Bloque = '"+ Id_Bloque +"'";
	}

	/**
	 * Eliminar.
	 *
	 * @return the string
	 */
	public static String Eliminar() {
		return "DELETE FROM bloques WHERE Id_Bloque=?";
	}
}
