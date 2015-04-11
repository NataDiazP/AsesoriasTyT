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
 * The Class NEncargadoBloque.
 *
 * @author natad_000
 */
public class NEncargadoBloque {

	/** The dao enc bloques. */
	DAOEncargadosBloques daoEncBloques;
	
	/** The c. */
	Connection c;

	/**
	 * Crear.
	 *
	 * @param EncBloques the enc bloques
	 * @return the int
	 */
	public int Crear(EncargadoBloque EncBloques) {
		daoEncBloques = new DAOEncargadosBloques();
		c = new Conexion().getConnection();
		int resultadoCrear = daoEncBloques.Crear(c, EncBloques);
		return resultadoCrear;
	}

	/**
	 * Modificar.
	 *
	 * @param EncBloques the enc bloques
	 * @return the int
	 */
	public int Modificar(EncargadoBloque EncBloques) {
		daoEncBloques = new DAOEncargadosBloques();
		c = new Conexion().getConnection();
		int resultadoModificar = daoEncBloques.Modificar(c, EncBloques);
		return resultadoModificar;
	}

	/**
	 * Buscar.
	 *
	 * @param EncBloque the enc bloque
	 * @return the encargado bloque
	 */
	public EncargadoBloque Buscar(String EncBloque) {
		daoEncBloques = new DAOEncargadosBloques();
		c = new Conexion().getConnection();
		EncargadoBloque resultadoBuscar = daoEncBloques.Buscar(c, EncBloque);
		return resultadoBuscar;
	}

	/**
	 * Eliminar.
	 *
	 * @param EncBloque the enc bloque
	 * @return the int
	 */
	public int Eliminar(EncargadoBloque EncBloque) {
		daoEncBloques = new DAOEncargadosBloques();
		c = new Conexion().getConnection();
		int resultadoEliminar = daoEncBloques.Eliminar(c, EncBloque);
		return resultadoEliminar;
	}

	/**
	 * Listado encargados bloques.
	 *
	 * @return the list
	 */
	public List<EncargadoBloque> ListadoEncargadosBloques() {
		daoEncBloques = new DAOEncargadosBloques();
		c = new Conexion().getConnection();
		return daoEncBloques.listarEncargadosBloques(c);
	}
}
