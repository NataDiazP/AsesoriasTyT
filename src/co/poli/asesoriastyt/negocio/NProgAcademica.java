/**
 * 
 */
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.util.List;

import co.poli.asesoriastyt.dao.DAOProgAcademica;
import co.poli.asesoriastyt.model.Asignatura;
import co.poli.asesoriastyt.model.ProgAcademica;
import co.poli.asesoriastyt.util.Conexion;


/**
 * The Class NProgAcademica.
 *
 * @author natad_000
 */
public class NProgAcademica {

	/** The dao prog academica. */
	DAOProgAcademica daoProgAcademica;
	
	/** The c. */
	Connection c;

	/**
	 * Crear.
	 *
	 * @param ProgAcademica the prog academica
	 * @return the int
	 */
	public int Crear(ProgAcademica ProgAcademica) {
		daoProgAcademica = new DAOProgAcademica();
		c = new Conexion().getConnection();
		int resultadoCrear = daoProgAcademica.Crear(c, ProgAcademica);
		return resultadoCrear;
	}

	/**
	 * Modificar.
	 *
	 * @param ProgAcademica the prog academica
	 * @return the int
	 */
	public int Modificar(ProgAcademica ProgAcademica) {
		daoProgAcademica = new DAOProgAcademica();
		c = new Conexion().getConnection();
		int resultadoModificar = daoProgAcademica.Modificar(c, ProgAcademica);
		return resultadoModificar;
	}

	/**
	 * Buscar.
	 *
	 * @param ProgAcademica the prog academica
	 * @return the prog academica
	 */
	public ProgAcademica Buscar(String ProgAcademica) {
		daoProgAcademica = new DAOProgAcademica();
		c = new Conexion().getConnection();
		ProgAcademica resultadoBuscar = daoProgAcademica.Buscar(c, ProgAcademica);
		return resultadoBuscar;
	}

	/**
	 * Eliminar.
	 *
	 * @param ProgAcademica the prog academica
	 * @return the int
	 */
	public int Eliminar(ProgAcademica ProgAcademica) {
		daoProgAcademica = new DAOProgAcademica();
		c = new Conexion().getConnection();
		int resultadoEliminar = daoProgAcademica.Eliminar(c, ProgAcademica);
		return resultadoEliminar;
	}

	/**
	 * Asignaturas docente.
	 *
	 * @param idDocente the id docente
	 * @return the list
	 */
	public List<Asignatura> AsignaturasDocente(String idDocente) {
		daoProgAcademica = new DAOProgAcademica();
		c = new Conexion().getConnection();
		return daoProgAcademica.asignaturasDocente(c, idDocente);
	}

	/**
	 * Listado prog academica.
	 *
	 * @return the list
	 */
	public List<ProgAcademica> ListadoProgAcademica() {
		daoProgAcademica = new DAOProgAcademica();
		c = new Conexion().getConnection();
		return daoProgAcademica.listarProgAcademica(c);
	}
}