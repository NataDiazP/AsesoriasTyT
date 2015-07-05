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
 *  Class NPerfiles.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class NPerfiles {

	/**  dao perfiles. */
	DAOPerfiles daoPerfiles;
	DataSource ds = JRDataSource.getMySQLDataSource();
	/**  c. */
	Connection c;

	/**
	 * Crear.
	 *
	 * @param Perfiles  perfiles
	 * @return  int
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
	 * @param Perfiles  perfiles
	 * @return  int
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
	 * @param Perfiles  perfiles
	 * @return  perfil
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
	 * @param Perfiles  perfiles
	 * @return  int
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
	 * @return  list
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
