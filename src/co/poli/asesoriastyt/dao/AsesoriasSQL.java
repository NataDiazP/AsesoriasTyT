/**
 * 
 */
package co.poli.asesoriastyt.dao;


/**
 * The Class AsesoriasSQL.
 *
 * @author pavargas
 */
public class AsesoriasSQL {

    /**
     * Crear.
     *
     * @return the string
     */
    public static String Crear() {
        return "INSERT INTO asesorias (Nombre_Asesoria, Docente_Asesoria, Asignatura_Asesoria, Fecha_Asesoria, HoraInicio_Asesoria, HoraFin_Asesoria, Lugar_Asesoria, Cupos_Asesoria, CuposDisp_Asesoria, RecursosApoyo_Asesoria, Observaciones_Asesoria, Estado_Asesoria) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    public static String Modificar() {
        return "UPDATE asesorias SET Nombre_Asesoria=?,Docente_Asesoria=?,Asignatura_Asesoria=?,Fecha_Asesoria=?,HoraInicio_Asesoria=?,HoraFin_Asesoria=?,Lugar_Asesoria=?,Cupos_Asesoria=?,CuposDisp_Asesoria=?,RecursosApoyo_Asesoria=?,Observaciones_Asesoria=?,Estado_Asesoria=? WHERE Id_Asesoria=?";
    }

    /**
     * Consultar.
     *
     * @param Id_Asesoria the id_ asesoria
     * @return the string
     */
    public static String Consultar(String Id_Asesoria) {
        return "SELECT * FROM asesorias WHERE Id_Asesoria = " + Id_Asesoria + "";
    }
    
    /**
     * Asistir asesoria.
     *
     * @return the string
     */
    public static String AsistirAsesoria () {
    	return "UPDATE estudiantes_asesoria SET Asistencia_Asesoria = ? WHERE Id_Estudiante = ? AND Id_Asesoria = ?";
    }
    
    /**
     * Consultar id.
     *
     * @return the string
     */
    public static String ConsultarID () {
    	return " SELECT LAST_INSERT_ID(Id_Asesoria)+1 FROM asesorias ORDER BY Id_Asesoria DESC LIMIT 1";
    }
}
