/**
 * 
 */
package co.poli.asesoriastyt.dao;

/**
 * @author natad_000
 *
 */
public class ProgAcademicaSQL {

	public static String Crear() {
		return "INSERT INTO programaciones_academicas (Id_ProgAcademica, Docente_ProgAcademica, Asignatura, Grupo_Asignatura, Nro_Estudiantes_Asignatura, Dias_Asignatura, HoraInicio_Asignatura, HoraFin_Asignatura, Aula_Clase) VALUES (?,?,?,?,?,?,?,?,?)";
	}

	public static String Modificar() {
		return "UPDATE programaciones_academicas SET Docente_ProgAcademica=?,Asignatura=?,Grupo_Asignatura=?,Nro_Estudiantes_Asignatura=?,Dias_Asignatura=?,HoraInicio_Asignatura=?,HoraFin_Asignatura=?,Aula_Clase=? WHERE Id_ProgAcademica=?";
	}

	public static String Consultar(String Id_ProgAcademica) {
		return "SELECT * FROM programaciones_academicas WHERE Id_ProgAcademica = " + Id_ProgAcademica + "";
	}

	public static String Eliminar() {
		return "DELETE FROM programaciones_academicas WHERE Id_ProgAcademica=?";
	}
}
