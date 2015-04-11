/**
 * 
 */
package co.poli.asesoriastyt.dao;


/**
 * The Class PerfilesSQL.
 *
 * @author natad_000
 */
public class PerfilesSQL {

    /**
     * Crear.
     *
     * @return the string
     */
    public static String Crear() {
        return "INSERT INTO perfiles (Nombre_Perfil) VALUES (?)";
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    public static String Modificar() {
        return "UPDATE perfiles SET Nombre_Perfil=? WHERE Id_Perfil=?";
    }

    /**
     * Consultar.
     *
     * @param Id_Perfil the id_ perfil
     * @return the string
     */
    public static String Consultar(int Id_Perfil) {
        return "SELECT * FROM perfiles WHERE Id_Perfil = " + Id_Perfil + "";
    }

    /**
     * Eliminar.
     *
     * @return the string
     */
    public static String Eliminar() {
        return "DELETE FROM perfiles WHERE Id_Perfil=?";
    }

}
