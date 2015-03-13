/**
 * 
 */
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.util.List;

import co.poli.asesoriastyt.dao.DAOEncargadosBloques;
import co.poli.asesoriastyt.model.EncargadoBloque;
import co.poli.asesoriastyt.util.Conexion;

/**
 * @author natad_000
 *
 */
public class NEncargadoBloque {

	DAOEncargadosBloques daoEncBloques;
	Connection c;

	public int Crear(EncargadoBloque EncBloques) {
		daoEncBloques = new DAOEncargadosBloques();
		c = new Conexion().getConnection();
		int resultadoCrear = daoEncBloques.Crear(c, EncBloques);
		return resultadoCrear;
	}

	public int Modificar(EncargadoBloque EncBloques) {
		daoEncBloques = new DAOEncargadosBloques();
		c = new Conexion().getConnection();
		int resultadoModificar = daoEncBloques.Modificar(c, EncBloques);
		return resultadoModificar;
	}

	public EncargadoBloque Buscar(String EncBloque) {
		daoEncBloques = new DAOEncargadosBloques();
		c = new Conexion().getConnection();
		EncargadoBloque resultadoBuscar = daoEncBloques.Buscar(c, EncBloque);
		return resultadoBuscar;
	}

	public int Eliminar(EncargadoBloque EncBloque) {
		daoEncBloques = new DAOEncargadosBloques();
		c = new Conexion().getConnection();
		int resultadoEliminar = daoEncBloques.Eliminar(c, EncBloque);
		return resultadoEliminar;
	}

	public List<EncargadoBloque> ListadoEncargadosBloques() {
		daoEncBloques = new DAOEncargadosBloques();
		c = new Conexion().getConnection();
		return daoEncBloques.listarEncargadosBloques(c);
	}
}
