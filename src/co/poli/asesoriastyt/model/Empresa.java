package co.poli.asesoriastyt.model;


/**
 *  Class Empresa.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class Empresa {
    
    /**  nit. */
    private String nit;
    
    /**  razon social. */
    private String razonSocial;
    
    /**  direccion. */
    private String direccion;
    
    /**  telefono. */
    private String telefono;
    
    /**  correo electronico. */
    private String correoElectronico;
    
    /**  contacto. */
    private String contacto;
    
    /**  usuario. */
    private String usuario;
    
    /**  clave. */
    private String clave;
    
    /**  tipo. */
    private String tipo;
    
    /**
     * Instantiates a new empresa.
     */
    public Empresa(){
        nit=null;
        razonSocial=null;
        direccion=null;
        telefono=null;
        correoElectronico=null;
        contacto=null;
        tipo=null;
    }

    /**
     * Gets  nit.
     *
     * @return  nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * Sets  nit.
     *
     * @param nit  nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * Gets  razon social.
     *
     * @return  razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Sets  razon social.
     *
     * @param razonSocial  razonSocial to set
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * Gets  direccion.
     *
     * @return  direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Sets  direccion.
     *
     * @param direccion  direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Gets  telefono.
     *
     * @return  telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Sets  telefono.
     *
     * @param telefono  telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Gets  correo electronico.
     *
     * @return  correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Sets  correo electronico.
     *
     * @param correoElectronico  correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Gets  contacto.
     *
     * @return  contacto
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * Sets  contacto.
     *
     * @param contacto  contacto to set
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * Gets  usuario.
     *
     * @return  usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Sets  usuario.
     *
     * @param usuario  usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Gets  clave.
     *
     * @return  clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * Sets  clave.
     *
     * @param clave  clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Gets  tipo.
     *
     * @return  tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets  tipo.
     *
     * @param tipo  tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
