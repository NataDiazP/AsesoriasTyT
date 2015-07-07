/**
 * 
 */
package co.poli.asesoriastyt.dao;

/**
 * Class ProgAcademicaSQL.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class ProgAcademicaSQL {

	/**
	 * Crear.
	 *
	 * @return string
	 */
	public static String Crear() {
		return "INSERT INTO programaciones_academicas (Docente_ProgAcademica, Asignatura, Grupo_Asignatura, Nro_Estudiantes_Asignatura, Dias_Asignatura, HoraInicio_Asignatura, HoraFin_Asignatura, Aula_Clase, Semestre_ProgAcademica, Ano_ProgAcademica) VALUES (?,?,?,?,?,?,?,?,?,?)";
	}

	/**
	 * Modificar.
	 *
	 * @return string
	 */
	public static String Modificar() {
		return "UPDATE programaciones_academicas SET Docente_ProgAcademica=?,Asignatura=?,Grupo_Asignatura=?,Nro_Estudiantes_Asignatura=?,Dias_Asignatura=?,HoraInicio_Asignatura=?,HoraFin_Asignatura=?,Aula_Clase=?,Semestre_ProgAcademica=?,Ano_ProgAcademica=? WHERE Id_ProgAcademica=?";
	}

	/**
	 * Consultar.
	 *
	 * @param Id_ProgAcademica
	 *            id_ prog academica
	 * @return string
	 */
	public static String Consultar(String Id_ProgAcademica) {
		return "SELECT Id_ProgAcademica, Docente_ProgAcademica, Asignatura, Grupo_Asignatura, Nro_Estudiantes_Asignatura, Dias_Asignatura,"
				+ " HoraInicio_Asignatura, HoraFin_Asignatura, Aula_Clase, Semestre_ProgAcademica, Ano_ProgAcademica, asig.nombre_asignatura, "
				+ " CONCAT_WS(  ' ', nombres_persona, papellido_persona, sapellido_persona ) AS NombreDocente FROM programaciones_academicas,"
				+ " asignaturas asig, personas doc WHERE docente_progacademica = doc.numdoc_persona AND asignatura = asig.codigo_asignatura"
				+ " AND Id_ProgAcademica = " + Id_ProgAcademica + "";
	}

	/**
	 * Eliminar.
	 *
	 * @return string
	 */
	public static String Eliminar() {
		return "DELETE FROM programaciones_academicas WHERE Id_ProgAcademica=?";
	}
}
