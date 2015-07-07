/**
 * 
 */
package co.poli.asesoriastyt.model;


/**
 *  Class Persona.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class Persona 
{
	
	/**  tipo identificacion. */
	private String tipoIdentificacion;
    
    /**  numero identificacion. */
    private String numeroIdentificacion;
    
    /**  nombre completo. */
    private String nombreCompleto;
    
    /**  primer apellido. */
    private String primerApellido;
    
    /**  segundo apellido. */
    private String segundoApellido;
    
    /**  genero. */
    private String genero;
    
    /**  fecha nacimiento. */
    private String fechaNacimiento;
    
    /**  direccion. */
    private String direccion;
    
    /**  telefono. */
    private String telefono;
    
    /**  celular. */
    private String celular;
    
    /**  correo electronico. */
    private String correoElectronico;
    
    /**  Plan estudios_ estudiante. */
    private String PlanEstudios_Estudiante;
    
    /**  Semestre_ estudiante. */
    private String Semestre_Estudiante;
    
    /**  estado. */
    private String estado;
    
    /**  perfil. */
    private String perfil;
    
    /** nombre concatenado */
    private String concatNombre;
	
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
	 * Gets  primer apellido.
	 *
	 * @return  primerApellido
	 */
	public String getPrimerApellido() {
		return primerApellido;
	}
	
	/**
	 * Sets  primer apellido.
	 *
	 * @param primerApellido  primerApellido to set
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	
	/**
	 * Gets  segundo apellido.
	 *
	 * @return  segundoApellido
	 */
	public String getSegundoApellido() {
		return segundoApellido;
	}
	
	/**
	 * Sets  segundo apellido.
	 *
	 * @param segundoApellido  segundoApellido to set
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	
	/**
	 * Gets  genero.
	 *
	 * @return  genero
	 */
	public String getGenero() {
		return genero;
	}
	
	/**
	 * Sets  genero.
	 *
	 * @param genero  genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	/**
	 * Gets  fecha nacimiento.
	 *
	 * @return  fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	/**
	 * Sets  fecha nacimiento.
	 *
	 * @param fechaNacimiento  fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
	 * Gets  plan estudios_ estudiante.
	 *
	 * @return  planEstudios_Estudiante
	 */
	public String getPlanEstudios_Estudiante() {
		return PlanEstudios_Estudiante;
	}
	
	/**
	 * Sets  plan estudios_ estudiante.
	 *
	 * @param planEstudios_Estudiante  planEstudios_Estudiante to set
	 */
	public void setPlanEstudios_Estudiante(String planEstudios_Estudiante) {
		PlanEstudios_Estudiante = planEstudios_Estudiante;
	}
	
	/**
	 * Gets  semestre_ estudiante.
	 *
	 * @return  semestre_Estudiante
	 */
	public String getSemestre_Estudiante() {
		return Semestre_Estudiante;
	}
	
	/**
	 * Sets  semestre_ estudiante.
	 *
	 * @param semestre_Estudiante  semestre_Estudiante to set
	 */
	public void setSemestre_Estudiante(String semestre_Estudiante) {
		Semestre_Estudiante = semestre_Estudiante;
	}
	
	/**
	 * Gets  estado.
	 *
	 * @return  estado
	 */
	public String getEstado() {
		return estado;
	}
	
	/**
	 * Sets  estado.
	 *
	 * @param estado  estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	/**
	 * Gets  perfil.
	 *
	 * @return  perfil
	 */
	public String getPerfil() {
		return perfil;
	}
	
	/**
	 * Sets  perfil.
	 *
	 * @param perfil  perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	/**
	 * Gets nombre concatenado
	 * 
	 * @return the concatNombre
	 */
	public String getConcatNombre() {
		return concatNombre;
	}

	/**
	 * Sets nombre concatenado
	 * 
	 * @param concatNombre the concatNombre to set
	 */
	public void setConcatNombre(String concatNombre) {
		this.concatNombre = concatNombre;
	}
}
