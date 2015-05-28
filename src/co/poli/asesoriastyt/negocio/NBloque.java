/**
 * 
 */
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import co.poli.asesoriastyt.dao.DAOBloques;
import co.poli.asesoriastyt.model.Bloque;
import co.poli.asesoriastyt.util.Conexion;
import co.poli.asesoriastyt.util.JRDataSource;


/**
 * The Class NBloque.
 *
 * @author natad_000
 */
public class NBloque {

	/** The dao bloques. */
	DAOBloques daoBloques;
	
	/** The c. */
	Connection c;
	DataSource ds = JRDataSource.getMySQLDataSource();

	/**
	 * Crear.
	 *
	 * @param Bloques the bloques
	 * @return the int
	 */
	public int Crear(Bloque Bloques) {
		daoBloques = new DAOBloques();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoCrear = daoBloques.Crear(c, Bloques);
		return resultadoCrear;
	}

	/**
	 * Modificar.
	 *
	 * @param Bloques the bloques
	 * @return the int
	 */
	public int Modificar(Bloque Bloques) {
		daoBloques = new DAOBloques();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoModificar = daoBloques.Modificar(c, Bloques);
		return resultadoModificar;
	}

	/**
	 * Buscar.
	 *
	 * @param Bloques the bloques
	 * @return the bloque
	 */
	public Bloque Buscar(String Bloques) {
		daoBloques = new DAOBloques();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Bloque resultadoBuscar = daoBloques.Buscar(c, Bloques);
		return resultadoBuscar;
	}

	/**
	 * Eliminar.
	 *
	 * @param Bloques the bloques
	 * @return the int
	 */
	public int Eliminar(Bloque Bloques) {
		daoBloques = new DAOBloques();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoEliminar = daoBloques.Eliminar(c, Bloques);
		return resultadoEliminar;
	}

	/**
	 * Listado bloques.
	 *
	 * @return the list
	 */
	public List<Bloque> ListadoBloques() {
		daoBloques = new DAOBloques();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoBloques.listarBloques(c);
	}
}
