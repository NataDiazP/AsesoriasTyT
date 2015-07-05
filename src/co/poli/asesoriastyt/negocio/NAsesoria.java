/**
 * 
 */
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import co.poli.asesoriastyt.dao.DAOAsesorias;
import co.poli.asesoriastyt.model.Asesoria;
import co.poli.asesoriastyt.model.EstudianteAsesoria;
import co.poli.asesoriastyt.model.ReporteAsistencia;
import co.poli.asesoriastyt.model.ReporteMaterialAsesoria;
import co.poli.asesoriastyt.model.ReporteNumAsistencia;
import co.poli.asesoriastyt.util.Conexion;
import co.poli.asesoriastyt.util.JRDataSource;


/**
 *  Class NAsesoria.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class NAsesoria {

	/**  dao asesorias. */
	DAOAsesorias daoAsesorias;
	DataSource ds = JRDataSource.getMySQLDataSource();
	/**  c. */
	Connection c;

	/**
	 * Crear.
	 *
	 * @param Asesorias  asesorias
	 * @return  int
	 */
	public int Crear(Asesoria Asesorias) {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoCrear = daoAsesorias.Crear(c, Asesorias);
		return resultadoCrear;
	}

	/**
	 * Asistir.
	 *
	 * @param idUser  id user
	 * @param idAsesoria  id asesoria
	 * @return  int
	 */
	public int Asistir(String idUser, String idAsesoria) {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoCrear = daoAsesorias.Asistir(c, idUser, idAsesoria);
		return resultadoCrear;
	}

	/**
	 * Modificar.
	 *
	 * @param Asesorias  asesorias
	 * @return  int
	 */
	public int Modificar(Asesoria Asesorias) {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoModificar = daoAsesorias.Modificar(c, Asesorias);
		return resultadoModificar;
	}

	/**
	 * Guardar asistencia.
	 *
	 * @param idAsesoria  id asesoria
	 * @param idEstudiante  id estudiante
	 * @param asistio  asistio
	 * @return  int
	 */
	public int GuardarAsistencia(String idAsesoria, String idEstudiante, String asistio) {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int resultadoModificar = daoAsesorias.GuardarAsistencia(c, idAsesoria, idEstudiante, asistio);
		return resultadoModificar;
	}

	/**
	 * Buscar.
	 *
	 * @param Asesorias  asesorias
	 * @return  asesoria
	 */
	public Asesoria Buscar(String Asesorias) {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Asesoria resultadoBuscar = daoAsesorias.Buscar(c, Asesorias);
		return resultadoBuscar;
	}

	/**
	 * Generar id asesoria.
	 *
	 * @return  asesoria
	 */
	public Asesoria generarIdAsesoria() {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Asesoria resultadoGenerar = daoAsesorias.generarIdAsesoria(c);
		return resultadoGenerar;
	}

	/**
	 * Listado asesorias.
	 *
	 * @return  list
	 */
	public List<Asesoria> ListadoAsesorias() {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoAsesorias.listarAsesorias(c);
	}

	/**
	 * Listado asesorias profesor.
	 *
	 * @param profesor  profesor
	 * @return  list
	 */
	public List<Asesoria> ListadoAsesoriasProfesor(String profesor) {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoAsesorias.listarAsesoriasProfesor(c, profesor);
	}

	/**
	 * Listado asistentes.
	 *
	 * @param idAsesoria  id asesoria
	 * @return  list
	 */
	public List<EstudianteAsesoria> ListadoAsistentes(String idAsesoria) {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoAsesorias.listarAsistentes(c, idAsesoria);
	}

	/**
	 * Material asesorias.
	 *
	 * @return  list
	 */
	public List<ReporteMaterialAsesoria> MaterialAsesorias() {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoAsesorias.MaterialAsesorias(c);
	}

	/**
	 * Material asesorias fechas.
	 *
	 * @param fechaInicio  fecha inicio
	 * @param fechaFin  fecha fin
	 * @return  list
	 */
	public List<ReporteMaterialAsesoria> MaterialAsesoriasFechas(String fechaInicio, String fechaFin) {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoAsesorias.MaterialAsesoriasFechas(c, fechaInicio, fechaFin);
	}

	/**
	 * Material asesorias asesoria.
	 *
	 * @param asesoria  asesoria
	 * @return  list
	 */
	public List<ReporteMaterialAsesoria> MaterialAsesoriasAsesoria(String asesoria) {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoAsesorias.MaterialAsesoriasAsesoria(c, asesoria);
	}

	/**
	 * Asistencia asesoria.
	 *
	 * @return  list
	 */
	public List<ReporteAsistencia> AsistenciaAsesoria() {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoAsesorias.AsitenciaAsesoria(c);
	}

	/**
	 * Asistencia asesoria asesoria.
	 *
	 * @param asesoria  asesoria
	 * @return  list
	 */
	public List<ReporteAsistencia> AsistenciaAsesoriaAsesoria(String asesoria) {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoAsesorias.AsitenciaAsesoriaAsesoria(c, asesoria);
	}

	/**
	 * Asistencia asesoria fecha.
	 *
	 * @param fechaI  fecha i
	 * @param fechaF  fecha f
	 * @return  list
	 */
	public List<ReporteAsistencia> AsistenciaAsesoriaFecha(String fechaI, String fechaF) {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoAsesorias.AsitenciaAsesoriaFecha(c, fechaI, fechaF);
	}

	/**
	 * Cantidad asitencia asesoria asesoria.
	 *
	 * @param asesoria  asesoria
	 * @return  list
	 */
	public List<ReporteNumAsistencia> CantidadAsitenciaAsesoriaAsesoria(String asesoria) {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoAsesorias.CantidadAsitenciaAsesoriaAsesoria(c, asesoria);
	}

	/**
	 * Cantidad asitencia asesoria.
	 *
	 * @return  list
	 */
	public List<ReporteNumAsistencia> CantidadAsitenciaAsesoria() {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.CantidadAsitenciaAsesoria(c);
	}

	/**
	 * Cantidad asitencia asesoria fecha.
	 *
	 * @param fechaInicio  fecha inicio
	 * @param fechaFin  fecha fin
	 * @return  list
	 */
	public List<ReporteNumAsistencia> CantidadAsitenciaAsesoriaFecha(String fechaInicio, String fechaFin) {
		daoAsesorias = new DAOAsesorias();
		try {
			c = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoAsesorias.CantidadAsitenciaAsesoriaFecha(c, fechaInicio, fechaFin);
	}
}
