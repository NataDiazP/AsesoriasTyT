/*
 * To change this template, choose Tools | Templates
 * and open  template in  editor.
 */
package co.poli.asesoriastyt.model;


/**
 *  Class Usuario.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class Usuario {

    /**  tipo identificacion. */
    private String tipoIdentificacion;
    
    /**  numero identificacion. */
    private String numeroIdentificacion;
    
    /**  nombre completo. */
    private String nombreCompleto;
    
    /**  apellido completo. */
    private String apellidoCompleto;
    
    /**  direccion. */
    private String direccion;
    
    /**  telefono. */
    private String telefono;
    
    /**  celular. */
    private String celular;
    
    /**  correo electronico. */
    private String correoElectronico;
    
    /**  usuario. */
    private String usuario;
    
    /**  clave. */
    private String clave;
    
    /**  tipo. */
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
     * Gets  tipo identificacion.
     *
     * @return  tipoIdentificacion
     */
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    /**
     * Sets  tipo identificacion.
     *
     * @param tipoIdentificacion  tipoIdentificacion to set
     */
    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    /**
     * Gets  numero identificacion.
     *
     * @return  numeroIdentificacion
     */
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /**
     * Sets  numero identificacion.
     *
     * @param numeroIdentificacion  numeroIdentificacion to set
     */
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    /**
     * Gets  nombre completo.
     *
     * @return  nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Sets  nombre completo.
     *
     * @param nombreCompleto  nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
       
       /**
        * Gets  apellido completo.
        *
        * @return  nombreCompleto
        */
    public String getApellidoCompleto() {
        return apellidoCompleto;
    }

    /**
     * Sets  apellido completo.
     *
     * @param nombreCompleto  nombreCompleto to set
     */
    public void setApellidoCompleto(String nombreCompleto) {
        this.apellidoCompleto = nombreCompleto;
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
     * Gets  celular.
     *
     * @return  celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Sets  celular.
     *
     * @param celular  celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
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
