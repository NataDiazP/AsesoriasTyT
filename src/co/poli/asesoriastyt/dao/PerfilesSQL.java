/**
 * 
 */
package co.poli.asesoriastyt.dao;

/**
 * @author natad_000
 *
 */
public class PerfilesSQL {

    public static String Crear() {
        return "INSERT INTO perfiles (Nombre_Perfil) VALUES (?)";
    }

    public static String Modificar() {
        return "UPDATE perfiles SET Nombre_Perfil=? WHERE Id_Perfil=?";
    }

    public static String Consultar(int Id_Perfil) {
        return "SELECT * FROM perfiles WHERE Id_Perfil = " + Id_Perfil + "";
    }

    public static String Eliminar() {
        return "DELETE FROM perfiles WHERE Id_Perfil=?";
    }

}
