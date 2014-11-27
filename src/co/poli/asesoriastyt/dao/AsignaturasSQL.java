/**
 * 
 */
package co.poli.asesoriastyt.dao;


public class AsignaturasSQL {

    public static String Crear() {
        return "INSERT INTO asignaturas (Codigo_Asignatura,Nombre_Asignatura,PlanEstudios_Asignatura) VALUES (?, ?)";
    }

    public static String Modificar() {
        return "UPDATE asignaturas SET Nombre_Asignatura=?, PlanEstudios_Asignatura=? WHERE Codigo_Asignatura=?";
    }

    public static String Consultar(int Codigo_Asignatura) {
        return "SELECT * FROM asignaturas WHERE Codigo_Asignatura = " + Codigo_Asignatura + "";
    }

    public static String Eliminar() {
        return "DELETE FROM asignaturas WHERE Codigo_Asignatura=?";
    }

}
