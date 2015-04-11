/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.poli.asesoriastyt.model;


/**
 * The Class Usuario.
 *
 * @author Santi Monsalve
 */
public class Usuario {

    /** The tipo identificacion. */
    private String tipoIdentificacion;
    
    /** The numero identificacion. */
    private String numeroIdentificacion;
    
    /** The nombre completo. */
    private String nombreCompleto;
    
    /** The apellido completo. */
    private String apellidoCompleto;
    
    /** The direccion. */
    private String direccion;
    
    /** The telefono. */
    private String telefono;
    
    /** The celular. */
    private String celular;
    
    /** The correo electronico. */
    private String correoElectronico;
    
    /** The usuario. */
    private String usuario;
    
    /** The clave. */
    private String clave;
    
    /** The tipo. */
    private String tipo;

    /**
     * Instantiates a new usuario.
     */
    public Usuario() 
    {
        
        tipoIdentificacion=null;
        numeroIdentificacion=null;
        nombreCompleto=null;
        direccion=null;
        telefono=null;
        celular=null;
        correoElectronico=null;
        usuario=null;
        clave=null;
        tipo=null;
        
    }

    /**
     * Gets the tipo identificacion.
     *
     * @return the tipoIdentificacion
     */
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    /**
     * Sets the tipo identificacion.
     *
     * @param tipoIdentificacion the tipoIdentificacion to set
     */
    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    /**
     * Gets the numero identificacion.
     *
     * @return the numeroIdentificacion
     */
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /**
     * Sets the numero identificacion.
     *
     * @param numeroIdentificacion the numeroIdentificacion to set
     */
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    /**
     * Gets the nombre completo.
     *
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Sets the nombre completo.
     *
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
       
       /**
        * Gets the apellido completo.
        *
        * @return the nombreCompleto
        */
    public String getApellidoCompleto() {
        return apellidoCompleto;
    }

    /**
     * Sets the apellido completo.
     *
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setApellidoCompleto(String nombreCompleto) {
        this.apellidoCompleto = nombreCompleto;
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
     * Gets the celular.
     *
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Sets the celular.
     *
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
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
