
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.util.List;

import co.poli.asesoriastyt.dao.DAOAulas;
import co.poli.asesoriastyt.model.Aula;
import co.poli.asesoriastyt.util.Conexion;


/**
 * The Class NAula.
 *
 * @author pavargas
 */
public class NAula {

	/** The dao aulas. */
	DAOAulas daoAulas;
	
	/** The c. */
	Connection c;

	/**
	 * Crear.
	 *
	 * @param Aulas the aulas
	 * @return the int
	 */
	public int Crear(Aula Aulas) {
		daoAulas = new DAOAulas();
		c = new Conexion().getConnection();
		int resultadoCrear = daoAulas.Crear(c, Aulas);
		return resultadoCrear;
	}

	/**
	 * Modificar.
	 *
	 * @param Aulas the aulas
	 * @return the int
	 */
	public int Modificar(Aula Aulas) {
		daoAulas = new DAOAulas();
		c = new Conexion().getConnection();
		int resultadoModificar = daoAulas.Modificar(c, Aulas);
		return resultadoModificar;
	}

	/**
	 * Buscar.
	 *
	 * @param Aulas the aulas
	 * @return the aula
	 */
	public Aula Buscar(String Aulas) {
		daoAulas = new DAOAulas();
		c = new Conexion().getConnection();
		Aula resultadoBuscar = daoAulas.Buscar(c, Aulas);
		return resultadoBuscar;
	}

	/**
	 * Eliminar.
	 *
	 * @param Aulas the aulas
	 * @return the int
	 */
	public int Eliminar(Aula Aulas) {
		daoAulas = new DAOAulas();
		c = new Conexion().getConnection();
		int resultadoEliminar = daoAulas.Eliminar(c, Aulas);
		return resultadoEliminar;
	}

	/**
	 * Listado aulas.
	 *
	 * @return the list
	 */
	public List<Aula> ListadoAulas() {
		daoAulas = new DAOAulas();
		c = new Conexion().getConnection();
		return daoAulas.listarAula(c);
	}
}
