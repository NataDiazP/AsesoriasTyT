/**
 * 
 */
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.util.List;

import co.poli.asesoriastyt.dao.DAOAsesorias;
import co.poli.asesoriastyt.model.Asesoria;
import co.poli.asesoriastyt.util.Conexion;

/**
 * @author pavargas
 *
 */
public class NAsesoria {

	/**
	 * 
	 */
	DAOAsesorias daoAsesorias;
	Connection c;

	public int Crear(Asesoria Asesorias) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		int resultadoCrear = daoAsesorias.Crear(c, Asesorias);
		return resultadoCrear;
	}

	public int Modificar(Asesoria Asesorias) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		int resultadoModificar = daoAsesorias.Modificar(c, Asesorias);
		return resultadoModificar;
	}

	public Asesoria Buscar(String Asesorias) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		Asesoria resultadoBuscar = daoAsesorias.Buscar(c, Asesorias);
		return resultadoBuscar;
	}

	public int Eliminar(Asesoria Asesorias) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		int resultadoEliminar = daoAsesorias.Eliminar(c, Asesorias);
		return resultadoEliminar;
	}

	public List<Asesoria> ListadoAsesorias() {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.listarAsesorias(c);
	}
}
