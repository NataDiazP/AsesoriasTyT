/**
 * 
 */
package co.poli.asesoriastyt.dao;



/**
 * The Class AsignaturasSQL.
 */
public class AsignaturasSQL {

    /**
     * Crear.
     *
     * @return the string
     */
    public static String Crear() {
        return "INSERT INTO asignaturas (Codigo_Asignatura,Nombre_Asignatura) VALUES (?, ?)";
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    public static String Modificar() {
        return "UPDATE asignaturas SET Nombre_Asignatura=? WHERE Codigo_Asignatura=?";
    }

    /**
     * Consultar.
     *
     * @param Codigo_Asignatura the codigo_ asignatura
     * @return the string
     */
    public static String Consultar(String Codigo_Asignatura) {
        return "SELECT * FROM asignaturas WHERE Codigo_Asignatura = '" + Codigo_Asignatura + "'";
    }

    /**
     * Eliminar.
     *
     * @return the string
     */
    public static String Eliminar() {
        return "DELETE FROM asignaturas WHERE Codigo_Asignatura=?";
    }

}
