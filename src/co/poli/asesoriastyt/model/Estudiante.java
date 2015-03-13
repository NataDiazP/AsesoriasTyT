/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.poli.asesoriastyt.model;

/**
 *
 * @author 
 */
public class Estudiante {

    private String NumDoc_Estudiante;
    private String Tipo_Identificacion;
    private String Nombres_Estudiante;
    private String PApellido_Estudiante;
    private String SApellido_Estudiante;
    private String Genero_Estudiante;
    private String FechaNac_Estudiante;
    private String Direccion_Estudiante;
    private String Telefono_Estudiante;
    private String Celular_Estudiante;
    private String Correo_Estudiante;
    private String PlanEstudios_Estudiante;
    private String Semestre_Estudiante;
    private String Estado_Estudiantes;
    
	/**
	 * @return the tipoIdentificacion
	 */
	public String getTipoIdentificacion() {
		return Tipo_Identificacion;
	}
	/**
	 * @param tipoIdentificacion the tipoIdentificacion to set
	 */
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.Tipo_Identificacion = tipoIdentificacion;
	}
	/**
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return NumDoc_Estudiante;
	}
	/**
	 * @param numeroIdentificacion the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.NumDoc_Estudiante = numeroIdentificacion;
	}
	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return Nombres_Estudiante;
	}
	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.Nombres_Estudiante = nombreCompleto;
	}
	/**
	 * @return the papellidoCompleto
	 */
	public String getPapellidoCompleto() {
		return PApellido_Estudiante;
	}
	/**
	 * @param papellidoCompleto the papellidoCompleto to set
	 */
	public void setPapellidoCompleto(String papellidoCompleto) {
		PApellido_Estudiante = papellidoCompleto;
	}
	/**
	 * @return the sapellidoCompleto
	 */
	public String getSapellidoCompleto() {
		return SApellido_Estudiante;
	}
	/**
	 * @param sapellidoCompleto the sapellidoCompleto to set
	 */
	public void setSapellidoCompleto(String sapellidoCompleto) {
		SApellido_Estudiante = sapellidoCompleto;
	}
	/**
	 * @return the genero
	 */
	public String getGenero() {
		return Genero_Estudiante;
	}
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.Genero_Estudiante = genero;
	}
	/**
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return FechaNac_Estudiante;
	}
	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.FechaNac_Estudiante = fechaNacimiento;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return Direccion_Estudiante;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.Direccion_Estudiante = direccion;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return Telefono_Estudiante;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.Telefono_Estudiante = telefono;
	}
	/**
	 * @return the celular
	 */
	public String getCelular() {
		return Celular_Estudiante;
	}
	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.Celular_Estudiante = celular;
	}
	/**
	 * @return the correoElectronico
	 */
	public String getCorreoElectronico() {
		return Correo_Estudiante;
	}
	/**
	 * @param correoElectronico the correoElectronico to set
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.Correo_Estudiante = correoElectronico;
	}
	/**
	 * @return the planEstudios
	 */
	public String getPlanEstudios() {
		return PlanEstudios_Estudiante;
	}
	/**
	 * @param planEstudios the planEstudios to set
	 */
	public void setPlanEstudios(String planEstudios) {
		this.PlanEstudios_Estudiante = planEstudios;
	}
	/**
	 * @return the semestreActual
	 */
	public String getSemestreActual() {
		return Semestre_Estudiante;
	}
	/**
	 * @param semestreActual the semestreActual to set
	 */
	public void setSemestreActual(String semestreActual) {
		this.Semestre_Estudiante = semestreActual;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return Estado_Estudiantes;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.Estado_Estudiantes = estado;
	}
	
	@Override
	public String toString() {
		return "Estudiante [NumDoc_Estudiante=" + NumDoc_Estudiante + ", Tipo_Identificacion=" + Tipo_Identificacion+  ", Nombres_Estudiante=" + Nombres_Estudiante+ 
				", PApellido_Estudiante=" + PApellido_Estudiante+", SApellido_Estudiante=" + SApellido_Estudiante+", Genero_Estudiante=" + Genero_Estudiante+
				", FechaNac_Estudiante=" + FechaNac_Estudiante+", Direccion_Estudiante=" + Direccion_Estudiante+", Telefono_Estudiante=" + Telefono_Estudiante+
				", Celular_Estudiante=" + Celular_Estudiante+", Correo_Estudiante=" + Correo_Estudiante+", PlanEstudios_Estudiante=" + PlanEstudios_Estudiante+
				", Semestre_Estudiante=" + Semestre_Estudiante+", Estado_Estudiantes=" + Estado_Estudiantes+"]";
	}
}