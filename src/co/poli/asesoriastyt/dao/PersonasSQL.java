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
        return "INSERT INTO personas ( NumDoc_Persona, Tipo_Identificacion, Nombres_Persona, PApellido_Persona, SApellido_Persona, Genero_Persona, FechaNac_Persona, Direccion_Persona, Telefono_Persona, Celular_Persona, Correo_Persona, PlanEstudios_Persona, Semestre_Persona, Estado_Persona, Perfil_Persona) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public static String Modificar() {
        return "UPDATE personas SET  Tipo_Identificacion=?, Nombres_Persona=?, PApellido_Persona=?, SApellido_Persona=?, Genero_Persona=?, FechaNac_Persona=?, Direccion_Persona=?, Telefono_Persona=?, Celular_Persona=?, Correo_Persona=?, PlanEstudios_Persona=?, Semestre_Persona=?, Estado_Persona=? WHERE NumDoc_Persona=?";
    }

    public static String Consultar(String NumDoc) {
        return "SELECT * FROM personas WHERE NumDoc_Persona = " + NumDoc + "";
    }

    public static String Eliminar() {
        return "DELETE FROM personas WHERE NumDoc_Persona=?";
    }

}
