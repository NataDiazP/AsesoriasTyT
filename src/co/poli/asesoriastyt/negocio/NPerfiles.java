/**
 * 
 */
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.util.List;

import co.poli.asesoriastyt.dao.DAOPerfiles;
import co.poli.asesoriastyt.model.Perfil;
import co.poli.asesoriastyt.util.Conexion;


/**
 * The Class NPerfiles.
 *
 * @author natad_000
 */
public class NPerfiles {

	/** The dao perfiles. */
	DAOPerfiles daoPerfiles;
	
	/** The c. */
	Connection c;

	/**
	 * Crear.
	 *
	 * @param Perfiles the perfiles
	 * @return the int
	 */
	public int Crear(Perfil Perfiles) {
		daoPerfiles = new DAOPerfiles();
		c = new Conexion().getConnection();
		int resultadoCrear = daoPerfiles.Crear(c, Perfiles);
		return resultadoCrear;
	}

	/**
	 * Modificar.
	 *
	 * @param Perfiles the perfiles
	 * @return the int
	 */
	public int Modificar(Perfil Perfiles) {
		daoPerfiles = new DAOPerfiles();
		c = new Conexion().getConnection();
		int resultadoModificar = daoPerfiles.Modificar(c, Perfiles);
		return resultadoModificar;
	}

	/**
	 * Buscar.
	 *
	 * @param Perfiles the perfiles
	 * @return the perfil
	 */
	public Perfil Buscar(int Perfiles) {
		daoPerfiles = new DAOPerfiles();
		c = new Conexion().getConnection();
		Perfil resultadoBuscar = daoPerfiles.Buscar(c, Perfiles);
		return resultadoBuscar;
	}

	/**
	 * Eliminar.
	 *
	 * @param Perfiles the perfiles
	 * @return the int
	 */
	public int Eliminar(Perfil Perfiles) {
		daoPerfiles = new DAOPerfiles();
		c = new Conexion().getConnection();
		int resultadoEliminar = daoPerfiles.Eliminar(c, Perfiles);
		return resultadoEliminar;
	}

	/**
	 * Listado perfiles.
	 *
	 * @return the list
	 */
	public List<Perfil> ListadoPerfiles() {
		daoPerfiles = new DAOPerfiles();
		c = new Conexion().getConnection();
		return daoPerfiles.listarPerfiles(c);
	}
}
