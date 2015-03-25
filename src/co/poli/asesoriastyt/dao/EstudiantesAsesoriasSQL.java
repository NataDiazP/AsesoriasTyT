/**
 * 
 */
package co.poli.asesoriastyt.dao;

/**
 * @author pavargas
 *
 */
public class EstudiantesAsesoriasSQL {

	public static String Crear() {
		return "INSERT INTO estudiantes_asesoria (Id_Estudiante, Id_Asesoria, Asistencia_Asesoria) VALUES (?,?,?)";
	}

	public static String Consultar(String Id_Asesoria) {
		return "SELECT * FROM estudiantes_asesoria WHERE Id_Asesoria = " + Id_Asesoria + "";
	}
}
