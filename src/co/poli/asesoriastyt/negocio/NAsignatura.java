package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.util.List;

import co.poli.asesoriastyt.dao.DAOAsignaturas;
import co.poli.asesoriastyt.model.Asignatura;
import co.poli.asesoriastyt.util.Conexion;



/**
 * The Class NAsignatura.
 */
public class NAsignatura {

	/** The dao asignaturas. */
	DAOAsignaturas daoAsignaturas;
	
	/** The c. */
	Connection c;

	/**
	 * Crear.
	 *
	 * @param Asignaturas the asignaturas
	 * @return the int
	 */
	public int Crear(Asignatura Asignaturas) {
		daoAsignaturas = new DAOAsignaturas();
		c = new Conexion().getConnection();
		int resultadoCrear = daoAsignaturas.Crear(c, Asignaturas);
		return resultadoCrear;
	}

	/**
	 * Modificar.
	 *
	 * @param Asignaturas the asignaturas
	 * @return the int
	 */
	public int Modificar(Asignatura Asignaturas) {
		daoAsignaturas = new DAOAsignaturas();
		c = new Conexion().getConnection();
		int resultadoModificar = daoAsignaturas.Modificar(c, Asignaturas);
		return resultadoModificar;
	}

	/**
	 * Buscar.
	 *
	 * @param Asignaturas the asignaturas
	 * @return the asignatura
	 */
	public Asignatura Buscar(String Asignaturas) {
		daoAsignaturas = new DAOAsignaturas();
		c = new Conexion().getConnection();
		Asignatura resultadoBuscar = daoAsignaturas.Buscar(c, Asignaturas);
		return resultadoBuscar;
	}

	/**
	 * Eliminar.
	 *
	 * @param Asignaturas the asignaturas
	 * @return the int
	 */
	public int Eliminar(Asignatura Asignaturas) {
		daoAsignaturas = new DAOAsignaturas();
		c = new Conexion().getConnection();
		int resultadoEliminar = daoAsignaturas.Eliminar(c, Asignaturas);
		return resultadoEliminar;
	}

	/**
	 * Listado asignaturas.
	 *
	 * @return the list
	 */
	public List<Asignatura> ListadoAsignaturas() {
		daoAsignaturas = new DAOAsignaturas();
		c = new Conexion().getConnection();
		return daoAsignaturas.listarAsignaturas(c);
	}
}
