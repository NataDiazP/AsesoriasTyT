/**
 * 
 */
package co.poli.asesoriastyt.dao;


/**
 *  Class EstudiantesAsesoriasSQL.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class EstudiantesAsesoriasSQL {

	/**
	 * Crear.
	 *
	 * @return  string
	 */
	public static String Crear() {
		return "INSERT INTO estudiantes_asesoria (Id_Estudiante, Id_Asesoria, Asistencia_Asesoria) VALUES (?,?,?)";
	}

	/**
	 * Consultar.
	 *
	 * @param Id_Asesoria  id_ asesoria
	 * @return  string
	 */
	public static String Consultar(String Id_Asesoria) {
		return "SELECT * FROM estudiantes_asesoria WHERE Id_Asesoria = " + Id_Asesoria + "";
	}
}
