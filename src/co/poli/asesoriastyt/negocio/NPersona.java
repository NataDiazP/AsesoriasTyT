
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import co.poli.asesoriastyt.dao.DAOPersonas;
import co.poli.asesoriastyt.model.Persona;
import co.poli.asesoriastyt.util.Conexion;



/**
 * The Class NPersona.
 */
public class NPersona {

	/** The dao personas. */
	DAOPersonas daoPersonas;
	
	/** The c. */
	Connection c;

	/**
	 * Crear docentes.
	 *
	 * @param listaDocentes the lista docentes
	 */
	public void CrearDocentes(ArrayList<Persona> listaDocentes) {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		daoPersonas.CrearDocentes(c, listaDocentes);
		
	}
	
	/**
	 * Crear.
	 *
	 * @param Personas the personas
	 * @return the int
	 */
	public int Crear(Persona Personas) {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		int resultadoCrear = daoPersonas.Crear(c, Personas);
		return resultadoCrear;
	}
	
	/**
	 * Validar existencia persona.
	 *
	 * @param documento the documento
	 * @return true, if successful
	 */
	public boolean validarExistenciaPersona(String documento)
	{
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		boolean existe= daoPersonas.validarExistenciaPersona(c,documento);
		
		return existe;
		
	}
	
	/**
	 * Validar existencia correo.
	 *
	 * @param correo the correo
	 * @return true, if successful
	 */
	public boolean validarExistenciaCorreo(String correo)
	{
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		boolean existe= daoPersonas.validarExistenciaCorreo(c,correo);
		
		return existe;
		
	}

	/**
	 * Modificar.
	 *
	 * @param Personas the personas
	 * @return the int
	 */
	public int Modificar(Persona Personas) {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		int resultadoModificar = daoPersonas.Modificar(c, Personas);
		return resultadoModificar;
	}

	/**
	 * Buscar.
	 *
	 * @param Personas the personas
	 * @return the persona
	 */
	public Persona Buscar(String Personas) {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		Persona resultadoBuscar = daoPersonas.Buscar(c, Personas);
		return resultadoBuscar;
	}
	
	/**
	 * Buscar docente.
	 *
	 * @param Email the email
	 * @return the string
	 */
	public String BuscarDocente(String Email) {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		String resultadoBuscarDoc = daoPersonas.BuscarDocente(c, Email);
		return resultadoBuscarDoc;
	}

	/**
	 * Eliminar.
	 *
	 * @param Personas the personas
	 * @return the int
	 */
	public int Eliminar(Persona Personas) {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		int resultadoEliminar = daoPersonas.Eliminar(c, Personas);
		return resultadoEliminar;
	}

	/**
	 * Listado personas.
	 *
	 * @return the list
	 */
	public List<Persona> ListadoPersonas() {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		return daoPersonas.listarPersonas(c);
	}
	
	/**
	 * Listado personas estudiantes.
	 *
	 * @return the list
	 */
	public List<Persona> ListadoPersonasEstudiantes() {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		return daoPersonas.listarPersonasEstudiantes(c);
	}
	
	/**
	 * Listado personas docentes.
	 *
	 * @return the list
	 */
	public List<Persona> ListadoPersonasDocentes() {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		return daoPersonas.listarPersonasDocentes(c);
	}
}
