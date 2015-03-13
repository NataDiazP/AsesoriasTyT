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
 * @author natad_000
 *
 */
public class NPerfiles {

	/**
	 * 
	 */
	DAOPerfiles daoPerfiles;
	Connection c;

	public int Crear(Perfil Perfiles) {
		daoPerfiles = new DAOPerfiles();
		c = new Conexion().getConnection();
		int resultadoCrear = daoPerfiles.Crear(c, Perfiles);
		return resultadoCrear;
	}

	public int Modificar(Perfil Perfiles) {
		daoPerfiles = new DAOPerfiles();
		c = new Conexion().getConnection();
		int resultadoModificar = daoPerfiles.Modificar(c, Perfiles);
		return resultadoModificar;
	}

	public Perfil Buscar(int Perfiles) {
		daoPerfiles = new DAOPerfiles();
		c = new Conexion().getConnection();
		Perfil resultadoBuscar = daoPerfiles.Buscar(c, Perfiles);
		return resultadoBuscar;
	}

	public int Eliminar(Perfil Perfiles) {
		daoPerfiles = new DAOPerfiles();
		c = new Conexion().getConnection();
		int resultadoEliminar = daoPerfiles.Eliminar(c, Perfiles);
		return resultadoEliminar;
	}

	public List<Perfil> ListadoPerfiles() {
		daoPerfiles = new DAOPerfiles();
		c = new Conexion().getConnection();
		return daoPerfiles.listarPerfiles(c);
	}
}
