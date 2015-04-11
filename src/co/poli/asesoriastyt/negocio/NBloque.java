/**
 * 
 */
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.util.List;

import co.poli.asesoriastyt.dao.DAOBloques;
import co.poli.asesoriastyt.model.Bloque;
import co.poli.asesoriastyt.util.Conexion;


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

	/**
	 * Crear.
	 *
	 * @param Bloques the bloques
	 * @return the int
	 */
	public int Crear(Bloque Bloques) {
		daoBloques = new DAOBloques();
		c = new Conexion().getConnection();
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
		c = new Conexion().getConnection();
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
		c = new Conexion().getConnection();
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
		c = new Conexion().getConnection();
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
		c = new Conexion().getConnection();
		return daoBloques.listarBloques(c);
	}
}
