/**
 * 
 */
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import co.poli.asesoriastyt.dao.DAOEncargadosBloques;
import co.poli.asesoriastyt.model.EncargadoBloque;
import co.poli.asesoriastyt.util.Conexion;
import co.poli.asesoriastyt.util.JRDataSource;


/**
 *  Class NEncargadoBloque.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class NEncargadoBloque {

	/**  dao enc bloques. */
	DAOEncargadosBloques daoEncBloques;
	
	/**  c. */
	Connection c;
	DataSource ds = JRDataSource.getMySQLDataSource();

	/**
	 * Crear.
	 *
	 * @param EncBloques  enc bloques
	 * @return  int
	 */
	public int Crear(EncargadoBloque EncBloques) {
		daoEncBloques = new DAOEncargadosBloques();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoCrear = daoEncBloques.Crear(c, EncBloques);
		return resultadoCrear;
	}

	/**
	 * Modificar.
	 *
	 * @param EncBloques  enc bloques
	 * @return  int
	 */
	public int Modificar(EncargadoBloque EncBloques) {
		daoEncBloques = new DAOEncargadosBloques();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoModificar = daoEncBloques.Modificar(c, EncBloques);
		return resultadoModificar;
	}

	/**
	 * Buscar.
	 *
	 * @param EncBloque  enc bloque
	 * @return  encargado bloque
	 */
	public EncargadoBloque Buscar(String EncBloque) {
		daoEncBloques = new DAOEncargadosBloques();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EncargadoBloque resultadoBuscar = daoEncBloques.Buscar(c, EncBloque);
		return resultadoBuscar;
	}

	/**
	 * Buscar.
	 *
	 * @param EncBloque  enc bloque
	 * @return  encargado bloque
	 */
	public EncargadoBloque BuscarIdEncargado(String EncBloque) {
		daoEncBloques = new DAOEncargadosBloques();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EncargadoBloque resultadoBuscar = daoEncBloques.BuscarIdEncargado(c, EncBloque);
		return resultadoBuscar;
	}
	
	/**
	 * Eliminar.
	 *
	 * @param EncBloque  enc bloque
	 * @return  int
	 */
	public int Eliminar(EncargadoBloque EncBloque) {
		daoEncBloques = new DAOEncargadosBloques();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoEliminar = daoEncBloques.Eliminar(c, EncBloque);
		return resultadoEliminar;
	}

	/**
	 * Listado encargados bloques.
	 *
	 * @return  list
	 */
	public List<EncargadoBloque> ListadoEncargadosBloques() {
		daoEncBloques = new DAOEncargadosBloques();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoEncBloques.listarEncargadosBloques(c);
	}
}
