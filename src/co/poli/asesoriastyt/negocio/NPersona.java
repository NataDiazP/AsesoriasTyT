
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import co.poli.asesoriastyt.dao.DAOPersonas;
import co.poli.asesoriastyt.model.Persona;
import co.poli.asesoriastyt.util.Conexion;
import co.poli.asesoriastyt.util.JRDataSource;



/**
 * The Class NPersona.
 */
public class NPersona {

	/** The dao personas. */
	DAOPersonas daoPersonas;
	
	/** The c. */
	Conexion conexion= new Conexion();
	Connection c;
	DataSource ds = JRDataSource.getMySQLDataSource();
	/**
	 * Crear docentes.
	 *
	 * @param listaDocentes the lista docentes
	 * @throws SQLException 
	 */
	public int CrearDocentes(Persona Personas) {
		daoPersonas = new DAOPersonas();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoCrear = daoPersonas.CrearDocente(c, Personas);
		return resultadoCrear;
	}
	
	/**
	 * Crear.
	 *
	 * @param Personas the personas
	 * @return the int
	 */
	public int Crear(Persona Personas) {
		daoPersonas = new DAOPersonas();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		daoPersonas = new DAOPersonas();
		boolean existe= daoPersonas.validarExistenciaPersona(c,documento);
		
		return existe;
		
	}
	
	public boolean validarExistenciaDocente(String documento)
	{
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		daoPersonas = new DAOPersonas();
		boolean existe= daoPersonas.validarExistenciaDocente(c,documento);
		
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
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		daoPersonas = new DAOPersonas();
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
