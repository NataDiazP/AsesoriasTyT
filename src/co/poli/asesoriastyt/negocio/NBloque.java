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
 *  Class NBloque.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class NBloque {

	/**  dao bloques. */
	DAOBloques daoBloques;
	
	/**  c. */
	Connection c;
	DataSource ds = JRDataSource.getMySQLDataSource();

	/**
	 * Crear.
	 *
	 * @param Bloques  bloques
	 * @return  int
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
	 * @param Bloques  bloques
	 * @return  int
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
	 * @param Bloques  bloques
	 * @return  bloque
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
	 * @param Bloques  bloques
	 * @return  int
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
	 * @return  list
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
