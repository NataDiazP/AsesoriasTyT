/**
 * 
 */
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import co.poli.asesoriastyt.dao.DAOProgAcademica;
import co.poli.asesoriastyt.model.Asignatura;
import co.poli.asesoriastyt.model.ProgAcademica;
import co.poli.asesoriastyt.util.JRDataSource;


/**
 *  Class NProgAcademica.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class NProgAcademica {

	/**  dao prog academica. */
	DAOProgAcademica daoProgAcademica;
	
	/**  Conexion Datasource */
	Connection c;
	DataSource ds = JRDataSource.getMySQLDataSource();
	
	/**
	 * Crear.
	 *
	 * @param ProgAcademica  prog academica
	 * @return  int
	 */
	public int Crear(ProgAcademica ProgAcademica) {
		daoProgAcademica = new DAOProgAcademica();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoCrear = daoProgAcademica.Crear(c, ProgAcademica);
		return resultadoCrear;
	}

	/**
	 * Modificar.
	 *
	 * @param ProgAcademica  prog academica
	 * @return  int
	 */
	public int Modificar(ProgAcademica ProgAcademica) {
		daoProgAcademica = new DAOProgAcademica();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoModificar = daoProgAcademica.Modificar(c, ProgAcademica);
		return resultadoModificar;
	}

	/**
	 * Buscar.
	 *
	 * @param ProgAcademica  prog academica
	 * @return  prog academica
	 */
	public ProgAcademica Buscar(String ProgAcademica) {
		daoProgAcademica = new DAOProgAcademica();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProgAcademica resultadoBuscar = daoProgAcademica.Buscar(c, ProgAcademica);
		return resultadoBuscar;
	}

	/**
	 * Eliminar.
	 *
	 * @param ProgAcademica  prog academica
	 * @return  int
	 */
	public int Eliminar(ProgAcademica ProgAcademica) {
		daoProgAcademica = new DAOProgAcademica();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoEliminar = daoProgAcademica.Eliminar(c, ProgAcademica);
		return resultadoEliminar;
	}

	/**
	 * Asignaturas docente.
	 *
	 * @param idDocente  id docente
	 * @return  list
	 */
	public List<Asignatura> AsignaturasDocente(String idDocente) {
		daoProgAcademica = new DAOProgAcademica();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoProgAcademica.asignaturasDocente(c, idDocente);
	}

	/**
	 * Listado prog academica.
	 *
	 * @return  list
	 */
	public List<ProgAcademica> ListadoProgAcademica() {
		daoProgAcademica = new DAOProgAcademica();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoProgAcademica.listarProgAcademica(c);
	}
	
	public List<ProgAcademica> ListadoProgAcademicaDocente(String idDocente) {
		daoProgAcademica = new DAOProgAcademica();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoProgAcademica.listarProgAcademicaDocente(c, idDocente);
	}
}