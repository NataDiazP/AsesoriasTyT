package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.util.List;

import co.poli.asesoriastyt.dao.DAOAsignaturas;
import co.poli.asesoriastyt.model.Asignatura;
import co.poli.asesoriastyt.util.Conexion;


public class NAsignatura {

	/**
	 * 
	 */
	DAOAsignaturas daoAsignaturas;
	Connection c;

	public int Crear(Asignatura Asignaturas) {
		daoAsignaturas = new DAOAsignaturas();
		c = new Conexion().getConnection();
		int resultadoCrear = daoAsignaturas.Crear(c, Asignaturas);
		return resultadoCrear;
	}

	public int Modificar(Asignatura Asignaturas) {
		daoAsignaturas = new DAOAsignaturas();
		c = new Conexion().getConnection();
		int resultadoModificar = daoAsignaturas.Modificar(c, Asignaturas);
		return resultadoModificar;
	}

	public Asignatura Buscar(int Asignaturas) {
		daoAsignaturas = new DAOAsignaturas();
		c = new Conexion().getConnection();
		Asignatura resultadoBuscar = daoAsignaturas.Buscar(c, Asignaturas);
		return resultadoBuscar;
	}

	public int Eliminar(Asignatura Asignaturas) {
		daoAsignaturas = new DAOAsignaturas();
		c = new Conexion().getConnection();
		int resultadoEliminar = daoAsignaturas.Eliminar(c, Asignaturas);
		return resultadoEliminar;
	}

	public List<Asignatura> ListadoAsignaturas() {
		daoAsignaturas = new DAOAsignaturas();
		c = new Conexion().getConnection();
		return daoAsignaturas.listarAsignaturas(c);
	}
}
