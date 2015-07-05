/**
 * 
 */
package co.poli.asesoriastyt.dao;


/**
 *  Class PerfilesSQL.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class PerfilesSQL {

    /**
     * Crear.
     *
     * @return  string
     */
    public static String Crear() {
        return "INSERT INTO perfiles (Nombre_Perfil) VALUES (?)";
    }

    /**
     * Modificar.
     *
     * @return  string
     */
    public static String Modificar() {
        return "UPDATE perfiles SET Nombre_Perfil=? WHERE Id_Perfil=?";
    }

    /**
     * Consultar.
     *
     * @param Id_Perfil  id_ perfil
     * @return  string
     */
    public static String Consultar(int Id_Perfil) {
        return "SELECT * FROM perfiles WHERE Id_Perfil = " + Id_Perfil + "";
    }

    /**
     * Eliminar.
     *
     * @return  string
     */
    public static String Eliminar() {
        return "DELETE FROM perfiles WHERE Id_Perfil=?";
    }

}
