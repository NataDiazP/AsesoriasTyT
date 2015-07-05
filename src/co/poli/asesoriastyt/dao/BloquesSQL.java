/**
 * 
 */
package co.poli.asesoriastyt.dao;


/**
 *  Class BloquesSQL.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class BloquesSQL {
	
	/**
	 * Crear.
	 *
	 * @return  string
	 */
	public static String Crear() {
		return "INSERT INTO bloques (Id_Bloque,Encargado_Bloque) VALUES (?, ?)";
	}

	/**
	 * Modificar.
	 *
	 * @return  string
	 */
	public static String Modificar() {
		return "UPDATE bloques SET Encargado_Bloque=? WHERE Id_Bloque=?";
	}

	/**
	 * Consultar.
	 *
	 * @param Id_Bloque  id_ bloque
	 * @return  string
	 */
	public static String Consultar(String Id_Bloque) {
		return "SELECT * FROM bloques WHERE Id_Bloque = '"+ Id_Bloque +"'";
	}

	/**
	 * Eliminar.
	 *
	 * @return  string
	 */
	public static String Eliminar() {
		return "DELETE FROM bloques WHERE Id_Bloque=?";
	}
}
