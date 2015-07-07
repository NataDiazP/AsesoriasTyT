/**
 * 
 */
package co.poli.asesoriastyt.dao;

/**
 * Class AsesoriasSQL.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class AsesoriasSQL {

	/**
	 * Crear.
	 *
	 * @return string
	 */
	public static String Crear() {
		return "INSERT INTO asesorias (Nombre_Asesoria, Docente_Asesoria, Asignatura_Asesoria, Fecha_Asesoria, HoraInicio_Asesoria, HoraFin_Asesoria, Lugar_Asesoria, Cupos_Asesoria, CuposDisp_Asesoria, RecursosApoyo_Asesoria, Observaciones_Asesoria, Estado_Asesoria) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	}

	/**
	 * Modificar.
	 *
	 * @return string
	 */
	public static String Modificar() {
		return "UPDATE asesorias SET Nombre_Asesoria=?,Docente_Asesoria=?,Asignatura_Asesoria=?,Fecha_Asesoria=?,HoraInicio_Asesoria=?,HoraFin_Asesoria=?,Lugar_Asesoria=?,Cupos_Asesoria=?,CuposDisp_Asesoria=?,RecursosApoyo_Asesoria=?,Observaciones_Asesoria=?,Estado_Asesoria=? WHERE Id_Asesoria=?";
	}

	/**
	 * Consultar.
	 *
	 * @param Id_Asesoria
	 *            id_ asesoria
	 * @return string
	 */
	public static String Consultar(String Id_Asesoria) {
		return "SELECT Id_Asesoria, Nombre_Asesoria, Docente_Asesoria, Asignatura_Asesoria, Fecha_Asesoria, HoraInicio_Asesoria, "
				+ "HoraFin_Asesoria, Lugar_Asesoria, Cupos_Asesoria, CuposDisp_Asesoria, RecursosApoyo_Asesoria, Observaciones_Asesoria, "
				+ "Estado_Asesoria, asig.nombre_asignatura, CONCAT_WS(  ' ', nombres_persona, papellido_persona, sapellido_persona ) AS "
				+ "NombreDocente FROM asesorias, asignaturas asig, personas doc WHERE Asignatura_Asesoria = asig.codigo_asignatura AND "
				+ "doc.NumDoc_persona = Docente_asesoria AND Id_Asesoria =" + Id_Asesoria + "";
	}

	/**
	 * Asistir asesoria.
	 *
	 * @return string
	 */
	public static String AsistirAsesoria() {
		return "UPDATE estudiantes_asesoria SET Asistencia_Asesoria = ? WHERE Id_Estudiante = ? AND Id_Asesoria = ?";
	}

	/**
	 * Consultar id.
	 *
	 * @return string
	 */
	public static String ConsultarID() {
		return " SELECT LAST_INSERT_ID(Id_Asesoria)+1 FROM asesorias ORDER BY Id_Asesoria DESC LIMIT 1";
	}
}
