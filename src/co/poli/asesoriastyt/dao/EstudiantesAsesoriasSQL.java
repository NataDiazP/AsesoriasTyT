/**
 * 
 */
package co.poli.asesoriastyt.dao;


/**
 * The Class EstudiantesAsesoriasSQL.
 *
 * @author pavargas
 */
public class EstudiantesAsesoriasSQL {

	/**
	 * Crear.
	 *
	 * @return the string
	 */
	public static String Crear() {
		return "INSERT INTO estudiantes_asesoria (Id_Estudiante, Id_Asesoria, Asistencia_Asesoria) VALUES (?,?,?)";
	}

	/**
	 * Consultar.
	 *
	 * @param Id_Asesoria the id_ asesoria
	 * @return the string
	 */
	public static String Consultar(String Id_Asesoria) {
		return "SELECT * FROM estudiantes_asesoria WHERE Id_Asesoria = " + Id_Asesoria + "";
	}
}
