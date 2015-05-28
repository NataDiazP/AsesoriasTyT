
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import co.poli.asesoriastyt.dao.DAOAulas;
import co.poli.asesoriastyt.model.Aula;
import co.poli.asesoriastyt.util.Conexion;
import co.poli.asesoriastyt.util.JRDataSource;


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
	DataSource ds = JRDataSource.getMySQLDataSource();

	/**
	 * Crear.
	 *
	 * @param Aulas the aulas
	 * @return the int
	 */
	public int Crear(Aula Aulas) {
		daoAulas = new DAOAulas();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		return daoAulas.listarAula(c);
	}
}
