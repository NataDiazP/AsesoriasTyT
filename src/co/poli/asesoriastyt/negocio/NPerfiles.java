/**
 * 
 */
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import co.poli.asesoriastyt.dao.DAOPerfiles;
import co.poli.asesoriastyt.model.Perfil;
import co.poli.asesoriastyt.util.Conexion;
import co.poli.asesoriastyt.util.JRDataSource;


/**
 * The Class NPerfiles.
 *
 * @author natad_000
 */
public class NPerfiles {

	/** The dao perfiles. */
	DAOPerfiles daoPerfiles;
	DataSource ds = JRDataSource.getMySQLDataSource();
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
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Perfil resultadoBuscar = daoPerfiles.Buscar(c, Perfiles);
		return resultadoBuscar;
	}
	
	public int consultarUsuario(String correo) {
		daoPerfiles = new DAOPerfiles();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoPerfiles.consultarUsuario(c, correo);
	}

	/**
	 * Eliminar.
	 *
	 * @param Perfiles the perfiles
	 * @return the int
	 */
	public int Eliminar(Perfil Perfiles) {
		daoPerfiles = new DAOPerfiles();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoPerfiles.listarPerfiles(c);
	}
}
