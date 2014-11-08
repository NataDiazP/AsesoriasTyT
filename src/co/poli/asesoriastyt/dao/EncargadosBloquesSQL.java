/**
 * 
 */
package co.poli.asesoriastyt.dao;

/**
 * @author natad_000
 *
 */
public class EncargadosBloquesSQL {

	public static String Crear() {
		return "INSERT INTO encargados_bloques (Id_Encargado_Bloque,Correo_Encargado_Bloque) VALUES (?, ?)";
	}

	public static String Modificar() {
		return "UPDATE encargados_bloques SET Correo_Encargado_Bloque=? WHERE Id_Encargado_Bloque=?";
	}

	public static String Consultar(String Id_Encargado_Bloque) {
		return "SELECT * FROM encargados_bloques WHERE Id_Encargado_Bloque = " + Id_Encargado_Bloque + "";
	}

	public static String Eliminar() {
		return "DELETE FROM encargados_bloques WHERE Id_Encargado_Bloque=?";
	}
}
