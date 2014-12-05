/**
 * 
 */
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.util.List;

import co.poli.asesoriastyt.dao.DAOBloques;
import co.poli.asesoriastyt.model.Bloque;
import co.poli.asesoriastyt.model.PlanEstudio;
import co.poli.asesoriastyt.util.Conexion;

/**
 * @author natad_000
 *
 */
public class NBloque {

	DAOBloques daoBloques;
	Connection c;

	public int Crear(Bloque Bloques) {
		daoBloques = new DAOBloques();
		c = new Conexion().getConnection();
		int resultadoCrear = daoBloques.Crear(c, Bloques);
		return resultadoCrear;
	}

	public int Modificar(Bloque Bloques) {
		daoBloques = new DAOBloques();
		c = new Conexion().getConnection();
		int resultadoModificar = daoBloques.Modificar(c, Bloques);
		return resultadoModificar;
	}

	public Bloque Buscar(String Bloques) {
		daoBloques = new DAOBloques();
		c = new Conexion().getConnection();
		Bloque resultadoBuscar = daoBloques.Buscar(c, Bloques);
		return resultadoBuscar;
	}

	public int Eliminar(Bloque Bloques) {
		daoBloques = new DAOBloques();
		c = new Conexion().getConnection();
		int resultadoEliminar = daoBloques.Eliminar(c, Bloques);
		return resultadoEliminar;
	}

	public List<Bloque> ListadoBloques() {
		daoBloques = new DAOBloques();
		c = new Conexion().getConnection();
		return daoBloques.listarBloques(c);
	}
}
