/**
 * 
 */
package co.poli.asesoriastyt.dao;



/**
 *  Class AsignaturasSQL.
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class AsignaturasSQL {

    /**
     * Crear.
     *
     * @return  string
     */
    public static String Crear() {
        return "INSERT INTO asignaturas (Codigo_Asignatura,Nombre_Asignatura) VALUES (?, ?)";
    }

    /**
     * Modificar.
     *
     * @return  string
     */
    public static String Modificar() {
        return "UPDATE asignaturas SET Nombre_Asignatura=? WHERE Codigo_Asignatura=?";
    }

    /**
     * Consultar.
     *
     * @param Codigo_Asignatura  codigo_ asignatura
     * @return  string
     */
    public static String Consultar(String Codigo_Asignatura) {
        return "SELECT * FROM asignaturas WHERE Codigo_Asignatura = '" + Codigo_Asignatura + "'";
    }

    /**
     * Eliminar.
     *
     * @return  string
     */
    public static String Eliminar() {
        return "DELETE FROM asignaturas WHERE Codigo_Asignatura=?";
    }

}
