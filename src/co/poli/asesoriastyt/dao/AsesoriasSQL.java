/**
 * 
 */
package co.poli.asesoriastyt.dao;

/**
 * @author pavargas
 *
 */
public class AsesoriasSQL {

    public static String Crear() {
        return "INSERT INTO asesorias (Nombre_Asesoria, Docente_Asesoria, Asignatura_Asesoria, Fecha_Asesoria, HoraInicio_Asesoria, HoraFin_Asesoria, Lugar_Asesoria, Cupos_Asesoria, CuposDisp_Asesoria, RecursosApoyo_Asesoria, Observaciones_Asesoria, Estado_Asesoria) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public static String Modificar() {
        return "UPDATE asesorias SET Nombre_Asesoria=?,Docente_Asesoria=?,Asignatura_Asesoria=?,Fecha_Asesoria=?,HoraInicio_Asesoria=?,HoraFin_Asesoria=?,Lugar_Asesoria=?,Cupos_Asesoria=?,CuposDisp_Asesoria=?,RecursosApoyo_Asesoria=?,Observaciones_Asesoria=?,Estado_Asesoria=? WHERE Id_Asesoria=?";
    }

    public static String Consultar(String Id_Asesoria) {
        return "SELECT * FROM asesorias WHERE Id_Asesoria = " + Id_Asesoria + "";
    }
    
    public static String AsistirAsesoria () {
    	return "UPDATE estudiantes_asesoria SET Asistencia_Asesoria = ? WHERE Id_Estudiante = ? AND Id_Asesoria = ?";
    }
    
    public static String ConsultarID () {
    	return " SELECT LAST_INSERT_ID(Id_Asesoria)+1 FROM asesorias ORDER BY Id_Asesoria DESC LIMIT 1";
    }
}
