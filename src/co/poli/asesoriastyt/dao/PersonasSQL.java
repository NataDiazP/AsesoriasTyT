/**
 * 
 */
package co.poli.asesoriastyt.dao;

/**
 * @author pavargas
 *
 */
public class PersonasSQL {

    public static String Crear() {
        return "INSERT INTO personas (NumDoc, Tipo_Identificacion, Nombres_Estudiante, PApellido, SApellido, Genero, FechaNac, Direccion, Telefono, Celular, Correo, PlanEstudios_Estudiante, Semestre_Estudiante, Estado, Perfil) VALUES (?, ?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public static String Modificar() {
        return "UPDATE personas SET  Tipo_Identificacion=?, Nombres_Estudiante=?, PApellido=?, SApellido=?, Genero=?, FechaNac=?, Direccion=?, Telefono=?, Celular=?, Correo=?, PlanEstudios_Estudiante=?, Semestre_Estudiante=?, Estado=? WHERE NumDoc=?";
    }

    public static String Consultar(String NumDoc) {
        return "SELECT * FROM personas WHERE NumDoc = " + NumDoc + "";
    }

    public static String Eliminar() {
        return "DELETE FROM personas WHERE NumDoc=?";
    }

}
