/**
 * 
 */
package co.poli.asesoriastyt.dao;


/**
 * The Class ProgAcademicaSQL.
 *
 * @author natad_000
 */
public class ProgAcademicaSQL {

	/**
	 * Crear.
	 *
	 * @return the string
	 */
	public static String Crear() {
		return "INSERT INTO programaciones_academicas (Docente_ProgAcademica, Asignatura, Grupo_Asignatura, Nro_Estudiantes_Asignatura, Dias_Asignatura, HoraInicio_Asignatura, HoraFin_Asignatura, Aula_Clase, Semestre_ProgAcademica, Ano_ProgAcademica) VALUES (?,?,?,?,?,?,?,?,?,?)";
	}

	/**
	 * Modificar.
	 *
	 * @return the string
	 */
	public static String Modificar() {
		return "UPDATE programaciones_academicas SET Docente_ProgAcademica=?,Asignatura=?,Grupo_Asignatura=?,Nro_Estudiantes_Asignatura=?,Dias_Asignatura=?,HoraInicio_Asignatura=?,HoraFin_Asignatura=?,Aula_Clase=?,Semestre_ProgAcademica=?,Ano_ProgAcademica=? WHERE Id_ProgAcademica=?";
	}

	/**
	 * Consultar.
	 *
	 * @param Id_ProgAcademica the id_ prog academica
	 * @return the string
	 */
	public static String Consultar(String Id_ProgAcademica) {
		return "SELECT * FROM programaciones_academicas WHERE Id_ProgAcademica = " + Id_ProgAcademica + "";
	}

	/**
	 * Eliminar.
	 *
	 * @return the string
	 */
	public static String Eliminar() {
		return "DELETE FROM programaciones_academicas WHERE Id_ProgAcademica=?";
	}
}
