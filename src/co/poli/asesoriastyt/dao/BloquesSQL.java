/**
 * 
 */
package co.poli.asesoriastyt.dao;

/**
 * @author pavargas
 *
 */
public class BloquesSQL {
	
	public static String Crear() {
		return "INSERT INTO bloques (Id_Bloque,Encargado_Bloque) VALUES (?, ?)";
	}

	public static String Modificar() {
		return "UPDATE bloques SET Encargado_Bloque=? WHERE Id_Bloque=?";
	}

	public static String Consultar(String Id_Bloque) {
		return "SELECT * FROM bloques WHERE Id_Bloque = " + Id_Bloque + "";
	}

	public static String Eliminar() {
		return "DELETE FROM bloques WHERE Id_Bloque=?";
	}
}
