/**
 * 
 */
package co.poli.asesoriastyt.dao;


/**
 * The Class PersonasSQL.
 *
 * @author pavargas
 */
public class PersonasSQL {

    /**
     * Crear.
     *
     * @return the string
     */
    public static String Crear() {
        return "INSERT INTO personas (NumDoc_Persona, Tipo_Identificacion, Nombres_Persona, PApellido_Persona, SApellido_Persona, Genero_Persona, FechaNac_Persona, Direccion_Persona, Telefono_Persona, Celular_Persona, Correo_Persona, PlanEstudios_Persona, Semestre_Persona, Estado_Persona, Perfil_Persona) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    /**
     * Modificar.
     *
     * @return the string
     */
    public static String Modificar() {
        return "UPDATE personas SET  Tipo_Identificacion=?, Nombres_Persona=?, PApellido_Persona=?, SApellido_Persona=?, Genero_Persona=?, FechaNac_Persona=?, Direccion_Persona=?, Telefono_Persona=?, Celular_Persona=?, Correo_Persona=?, PlanEstudios_Persona=?, Semestre_Persona=?, Estado_Persona=? WHERE NumDoc_Persona=?";
    }

    /**
     * Consultar.
     *
     * @param NumDoc the num doc
     * @return the string
     */
    public static String Consultar(String NumDoc) {
        return "SELECT * FROM personas WHERE NumDoc_Persona = " + NumDoc + "";
    }

    /**
     * Eliminar.
     *
     * @return the string
     */
    public static String Eliminar() {
        return "DELETE FROM personas WHERE NumDoc_Persona=?";
    }

}
