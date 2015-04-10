
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import co.poli.asesoriastyt.dao.DAOPersonas;
import co.poli.asesoriastyt.model.Persona;
import co.poli.asesoriastyt.util.Conexion;


public class NPersona {

	/**
	 * 
	 */
	DAOPersonas daoPersonas;
	Connection c;

	public void CrearDocentes(ArrayList<Persona> listaDocentes) {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		daoPersonas.CrearDocentes(c, listaDocentes);
		
	}
	
	public int Crear(Persona Personas) {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		int resultadoCrear = daoPersonas.Crear(c, Personas);
		return resultadoCrear;
	}
	
	public boolean validarExistenciaPersona(String documento)
	{
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		boolean existe= daoPersonas.validarExistenciaPersona(c,documento);
		
		return existe;
		
	}
	
	public boolean validarExistenciaCorreo(String correo)
	{
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		boolean existe= daoPersonas.validarExistenciaCorreo(c,correo);
		
		return existe;
		
	}

	public int Modificar(Persona Personas) {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		int resultadoModificar = daoPersonas.Modificar(c, Personas);
		return resultadoModificar;
	}

	public Persona Buscar(String Personas) {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		Persona resultadoBuscar = daoPersonas.Buscar(c, Personas);
		return resultadoBuscar;
	}
	
	public String BuscarDocente(String Email) {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		String resultadoBuscarDoc = daoPersonas.BuscarDocente(c, Email);
		return resultadoBuscarDoc;
	}

	public int Eliminar(Persona Personas) {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		int resultadoEliminar = daoPersonas.Eliminar(c, Personas);
		return resultadoEliminar;
	}

	public List<Persona> ListadoPersonas() {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		return daoPersonas.listarPersonas(c);
	}
	
	public List<Persona> ListadoPersonasEstudiantes() {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		return daoPersonas.listarPersonasEstudiantes(c);
	}
	
	public List<Persona> ListadoPersonasDocentes() {
		daoPersonas = new DAOPersonas();
		c = new Conexion().getConnection();
		return daoPersonas.listarPersonasDocentes(c);
	}
}
