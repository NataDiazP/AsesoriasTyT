
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.util.List;

import co.poli.asesoriastyt.dao.DAOAulas;
import co.poli.asesoriastyt.model.Aula;
import co.poli.asesoriastyt.util.Conexion;

/**
 * @author pavargas
 *
 */
public class NAula {

	DAOAulas daoAulas;
	Connection c;

	public int Crear(Aula Aulas) {
		daoAulas = new DAOAulas();
		c = new Conexion().getConnection();
		int resultadoCrear = daoAulas.Crear(c, Aulas);
		return resultadoCrear;
	}

	public int Modificar(Aula Aulas) {
		daoAulas = new DAOAulas();
		c = new Conexion().getConnection();
		int resultadoModificar = daoAulas.Modificar(c, Aulas);
		return resultadoModificar;
	}

	public Aula Buscar(String Aulas) {
		daoAulas = new DAOAulas();
		c = new Conexion().getConnection();
		Aula resultadoBuscar = daoAulas.Buscar(c, Aulas);
		return resultadoBuscar;
	}

	public int Eliminar(Aula Aulas) {
		daoAulas = new DAOAulas();
		c = new Conexion().getConnection();
		int resultadoEliminar = daoAulas.Eliminar(c, Aulas);
		return resultadoEliminar;
	}

	public List<Aula> ListadoAulas() {
		daoAulas = new DAOAulas();
		c = new Conexion().getConnection();
		return daoAulas.listarAula(c);
	}
}
