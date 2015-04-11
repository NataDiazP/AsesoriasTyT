/**
 * 
 */
package co.poli.asesoriastyt.dao;


/**
 * The Class EncargadosBloquesSQL.
 *
 * @author natad_000
 */
public class EncargadosBloquesSQL {

	/**
	 * Crear.
	 *
	 * @return the string
	 */
	public static String Crear() {
		return "INSERT INTO encargados_bloques (Id_Encargado_Bloque,Correo_Encargado_Bloque) VALUES (?, ?)";
	}

	/**
	 * Modificar.
	 *
	 * @return the string
	 */
	public static String Modificar() {
		return "UPDATE encargados_bloques SET Correo_Encargado_Bloque=? WHERE Id_Encargado_Bloque=?";
	}

	/**
	 * Consultar.
	 *
	 * @param Id_Encargado_Bloque the id_ encargado_ bloque
	 * @return the string
	 */
	public static String Consultar(String Id_Encargado_Bloque) {
		return "SELECT * FROM encargados_bloques WHERE Id_Encargado_Bloque = " + Id_Encargado_Bloque + "";
	}

	/**
	 * Eliminar.
	 *
	 * @return the string
	 */
	public static String Eliminar() {
		return "DELETE FROM encargados_bloques WHERE Id_Encargado_Bloque=?";
	}
}
