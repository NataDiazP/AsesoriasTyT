/*
 * To change this template, choose Tools | Templates
 * and open  template in  editor.
 */
package co.poli.asesoriastyt.model;


/**
 *  Class Estudiante.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class Estudiante {

    /**  Num doc_ estudiante. */
    private String NumDoc_Estudiante;
    
    /**  Tipo_ identificacion. */
    private String Tipo_Identificacion;
    
    /**  Nombres_ estudiante. */
    private String Nombres_Estudiante;
    
    /**  P apellido_ estudiante. */
    private String PApellido_Estudiante;
    
    /**  S apellido_ estudiante. */
    private String SApellido_Estudiante;
    
    /**  Genero_ estudiante. */
    private String Genero_Estudiante;
    
    /**  Fecha nac_ estudiante. */
    private String FechaNac_Estudiante;
    
    /**  Direccion_ estudiante. */
    private String Direccion_Estudiante;
    
    /**  Telefono_ estudiante. */
    private String Telefono_Estudiante;
    
    /**  Celular_ estudiante. */
    private String Celular_Estudiante;
    
    /**  Correo_ estudiante. */
    private String Correo_Estudiante;
    
    /**  Plan estudios_ estudiante. */
    private String PlanEstudios_Estudiante;
    
    /**  Semestre_ estudiante. */
    private String Semestre_Estudiante;
    
    /**  Estado_ estudiantes. */
    private String Estado_Estudiantes;
    
	/**
	 * Gets  tipo identificacion.
	 *
	 * @return  tipoIdentificacion
	 */
	public String getTipoIdentificacion() {
		return Tipo_Identificacion;
	}
	
	/**
	 * Sets  tipo identificacion.
	 *
	 * @param tipoIdentificacion  tipoIdentificacion to set
	 */
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.Tipo_Identificacion = tipoIdentificacion;
	}
	
	/**
	 * Gets  numero identificacion.
	 *
	 * @return  numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return NumDoc_Estudiante;
	}
	
	/**
	 * Sets  numero identificacion.
	 *
	 * @param numeroIdentificacion  numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.NumDoc_Estudiante = numeroIdentificacion;
	}
	
	/**
	 * Gets  nombre completo.
	 *
	 * @return  nombreCompleto
	 */
	public String getNombreCompleto() {
		return Nombres_Estudiante;
	}
	
	/**
	 * Sets  nombre completo.
	 *
	 * @param nombreCompleto  nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.Nombres_Estudiante = nombreCompleto;
	}
	
	/**
	 * Gets  papellido completo.
	 *
	 * @return  papellidoCompleto
	 */
	public String getPapellidoCompleto() {
		return PApellido_Estudiante;
	}
	
	/**
	 * Sets  papellido completo.
	 *
	 * @param papellidoCompleto  papellidoCompleto to set
	 */
	public void setPapellidoCompleto(String papellidoCompleto) {
		PApellido_Estudiante = papellidoCompleto;
	}
	
	/**
	 * Gets  sapellido completo.
	 *
	 * @return  sapellidoCompleto
	 */
	public String getSapellidoCompleto() {
		return SApellido_Estudiante;
	}
	
	/**
	 * Sets  sapellido completo.
	 *
	 * @param sapellidoCompleto  sapellidoCompleto to set
	 */
	public void setSapellidoCompleto(String sapellidoCompleto) {
		SApellido_Estudiante = sapellidoCompleto;
	}
	
	/**
	 * Gets  genero.
	 *
	 * @return  genero
	 */
	public String getGenero() {
		return Genero_Estudiante;
	}
	
	/**
	 * Sets  genero.
	 *
	 * @param genero  genero to set
	 */
	public void setGenero(String genero) {
		this.Genero_Estudiante = genero;
	}
	
	/**
	 * Gets  fecha nacimiento.
	 *
	 * @return  fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return FechaNac_Estudiante;
	}
	
	/**
	 * Sets  fecha nacimiento.
	 *
	 * @param fechaNacimiento  fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.FechaNac_Estudiante = fechaNacimiento;
	}
	
	/**
	 * Gets  direccion.
	 *
	 * @return  direccion
	 */
	public String getDireccion() {
		return Direccion_Estudiante;
	}
	
	/**
	 * Sets  direccion.
	 *
	 * @param direccion  direccion to set
	 */
	public void setDireccion(String direccion) {
		this.Direccion_Estudiante = direccion;
	}
	
	/**
	 * Gets  telefono.
	 *
	 * @return  telefono
	 */
	public String getTelefono() {
		return Telefono_Estudiante;
	}
	
	/**
	 * Sets  telefono.
	 *
	 * @param telefono  telefono to set
	 */
	public void setTelefono(String telefono) {
		this.Telefono_Estudiante = telefono;
	}
	
	/**
	 * Gets  celular.
	 *
	 * @return  celular
	 */
	public String getCelular() {
		return Celular_Estudiante;
	}
	
	/**
	 * Sets  celular.
	 *
	 * @param celular  celular to set
	 */
	public void setCelular(String celular) {
		this.Celular_Estudiante = celular;
	}
	
	/**
	 * Gets  correo electronico.
	 *
	 * @return  correoElectronico
	 */
	public String getCorreoElectronico() {
		return Correo_Estudiante;
	}
	
	/**
	 * Sets  correo electronico.
	 *
	 * @param correoElectronico  correoElectronico to set
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.Correo_Estudiante = correoElectronico;
	}
	
	/**
	 * Gets  plan estudios.
	 *
	 * @return  planEstudios
	 */
	public String getPlanEstudios() {
		return PlanEstudios_Estudiante;
	}
	
	/**
	 * Sets  plan estudios.
	 *
	 * @param planEstudios  planEstudios to set
	 */
	public void setPlanEstudios(String planEstudios) {
		this.PlanEstudios_Estudiante = planEstudios;
	}
	
	/**
	 * Gets  semestre actual.
	 *
	 * @return  semestreActual
	 */
	public String getSemestreActual() {
		return Semestre_Estudiante;
	}
	
	/**
	 * Sets  semestre actual.
	 *
	 * @param semestreActual  semestreActual to set
	 */
	public void setSemestreActual(String semestreActual) {
		this.Semestre_Estudiante = semestreActual;
	}
	
	/**
	 * Gets  estado.
	 *
	 * @return  estado
	 */
	public String getEstado() {
		return Estado_Estudiantes;
	}
	
	/**
	 * Sets  estado.
	 *
	 * @param estado  estado to set
	 */
	public void setEstado(String estado) {
		this.Estado_Estudiantes = estado;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Estudiante [NumDoc_Estudiante=" + NumDoc_Estudiante + ", Tipo_Identificacion=" + Tipo_Identificacion+  ", Nombres_Estudiante=" + Nombres_Estudiante+ 
				", PApellido_Estudiante=" + PApellido_Estudiante+", SApellido_Estudiante=" + SApellido_Estudiante+", Genero_Estudiante=" + Genero_Estudiante+
				", FechaNac_Estudiante=" + FechaNac_Estudiante+", Direccion_Estudiante=" + Direccion_Estudiante+", Telefono_Estudiante=" + Telefono_Estudiante+
				", Celular_Estudiante=" + Celular_Estudiante+", Correo_Estudiante=" + Correo_Estudiante+", PlanEstudios_Estudiante=" + PlanEstudios_Estudiante+
				", Semestre_Estudiante=" + Semestre_Estudiante+", Estado_Estudiantes=" + Estado_Estudiantes+"]";
	}
}