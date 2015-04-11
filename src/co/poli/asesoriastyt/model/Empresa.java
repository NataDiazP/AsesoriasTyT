/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.poli.asesoriastyt.model;


/**
 * The Class Empresa.
 *
 * @author nvelez
 */
public class Empresa {
    
    /** The nit. */
    private String nit;
    
    /** The razon social. */
    private String razonSocial;
    
    /** The direccion. */
    private String direccion;
    
    /** The telefono. */
    private String telefono;
    
    /** The correo electronico. */
    private String correoElectronico;
    
    /** The contacto. */
    private String contacto;
    
    /** The usuario. */
    private String usuario;
    
    /** The clave. */
    private String clave;
    
    /** The tipo. */
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
     * Gets the nit.
     *
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * Sets the nit.
     *
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * Gets the razon social.
     *
     * @return the razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Sets the razon social.
     *
     * @param razonSocial the razonSocial to set
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * Gets the direccion.
     *
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Sets the direccion.
     *
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Gets the telefono.
     *
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Sets the telefono.
     *
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Gets the correo electronico.
     *
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Sets the correo electronico.
     *
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Gets the contacto.
     *
     * @return the contacto
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * Sets the contacto.
     *
     * @param contacto the contacto to set
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * Gets the usuario.
     *
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Sets the usuario.
     *
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Gets the clave.
     *
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * Sets the clave.
     *
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets the tipo.
     *
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
