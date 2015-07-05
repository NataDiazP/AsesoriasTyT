package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import co.poli.asesoriastyt.dao.DAOAsignaturas;
import co.poli.asesoriastyt.dao.DAOPersonas;
import co.poli.asesoriastyt.model.Asignatura;
import co.poli.asesoriastyt.util.Conexion;
import co.poli.asesoriastyt.util.JRDataSource;



/**
 *  Class NAsignatura.
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class NAsignatura {

	/**  dao asignaturas. */
	DAOAsignaturas daoAsignaturas;
	
	/**  c. */
	Connection c;
	DataSource ds = JRDataSource.getMySQLDataSource();

	/**
	 * Crear.
	 *
	 * @param Asignaturas  asignaturas
	 * @return  int
	 */
	public int Crear(Asignatura Asignaturas) {
		daoAsignaturas = new DAOAsignaturas();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoCrear = daoAsignaturas.Crear(c, Asignaturas);
		return resultadoCrear;
	}
	


	/**
	 * Modificar.
	 *
	 * @param Asignaturas  asignaturas
	 * @return  int
	 */
	public int Modificar(Asignatura Asignaturas) {
		daoAsignaturas = new DAOAsignaturas();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoModificar = daoAsignaturas.Modificar(c, Asignaturas);
		return resultadoModificar;
	}

	/**
	 * Buscar.
	 *
	 * @param Asignaturas  asignaturas
	 * @return  asignatura
	 */
	public Asignatura Buscar(String Asignaturas) {
		daoAsignaturas = new DAOAsignaturas();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Asignatura resultadoBuscar = daoAsignaturas.Buscar(c, Asignaturas);
		return resultadoBuscar;
	}

	/**
	 * Eliminar.
	 *
	 * @param Asignaturas  asignaturas
	 * @return  int
	 */
	public int Eliminar(Asignatura Asignaturas) {
		daoAsignaturas = new DAOAsignaturas();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoEliminar = daoAsignaturas.Eliminar(c, Asignaturas);
		return resultadoEliminar;
	}

	/**
	 * Listado asignaturas.
	 *
	 * @return  list
	 */
	public List<Asignatura> ListadoAsignaturas() {
		daoAsignaturas = new DAOAsignaturas();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoAsignaturas.listarAsignaturas(c);
	}



	/**
	 * @param string
	 * @return
	 */
	public boolean validarExistenciaAsignatura(String string) {
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		daoAsignaturas = new DAOAsignaturas();
		boolean existe= daoAsignaturas.validarExistenciaAsignatura(c,string);
		
		return existe;
	}
}
