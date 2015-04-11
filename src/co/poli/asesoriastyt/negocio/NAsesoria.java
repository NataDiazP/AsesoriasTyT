/**
 * 
 */
package co.poli.asesoriastyt.negocio;

import java.sql.Connection;
import java.util.List;

import co.poli.asesoriastyt.dao.DAOAsesorias;
import co.poli.asesoriastyt.model.Asesoria;
import co.poli.asesoriastyt.model.EstudianteAsesoria;
import co.poli.asesoriastyt.model.ReporteAsistencia;
import co.poli.asesoriastyt.model.ReporteMaterialAsesoria;
import co.poli.asesoriastyt.model.ReporteNumAsistencia;
import co.poli.asesoriastyt.util.Conexion;


/**
 * The Class NAsesoria.
 *
 * @author pavargas
 */
public class NAsesoria {

	/** The dao asesorias. */
	DAOAsesorias daoAsesorias;
	
	/** The c. */
	Connection c;

	/**
	 * Crear.
	 *
	 * @param Asesorias the asesorias
	 * @return the int
	 */
	public int Crear(Asesoria Asesorias) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		int resultadoCrear = daoAsesorias.Crear(c, Asesorias);
		return resultadoCrear;
	}

	/**
	 * Asistir.
	 *
	 * @param idUser the id user
	 * @param idAsesoria the id asesoria
	 * @return the int
	 */
	public int Asistir(String idUser, String idAsesoria) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		int resultadoCrear = daoAsesorias.Asistir(c, idUser, idAsesoria);
		return resultadoCrear;
	}

	/**
	 * Modificar.
	 *
	 * @param Asesorias the asesorias
	 * @return the int
	 */
	public int Modificar(Asesoria Asesorias) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		int resultadoModificar = daoAsesorias.Modificar(c, Asesorias);
		return resultadoModificar;
	}

	/**
	 * Guardar asistencia.
	 *
	 * @param idAsesoria the id asesoria
	 * @param idEstudiante the id estudiante
	 * @param asistio the asistio
	 * @return the int
	 */
	public int GuardarAsistencia(String idAsesoria, String idEstudiante, String asistio) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		int resultadoModificar = daoAsesorias.GuardarAsistencia(c, idAsesoria, idEstudiante, asistio);
		return resultadoModificar;
	}

	/**
	 * Buscar.
	 *
	 * @param Asesorias the asesorias
	 * @return the asesoria
	 */
	public Asesoria Buscar(String Asesorias) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		Asesoria resultadoBuscar = daoAsesorias.Buscar(c, Asesorias);
		return resultadoBuscar;
	}

	/**
	 * Generar id asesoria.
	 *
	 * @return the asesoria
	 */
	public Asesoria generarIdAsesoria() {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		Asesoria resultadoGenerar = daoAsesorias.generarIdAsesoria(c);
		return resultadoGenerar;
	}

	/**
	 * Listado asesorias.
	 *
	 * @return the list
	 */
	public List<Asesoria> ListadoAsesorias() {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.listarAsesorias(c);
	}

	/**
	 * Listado asesorias profesor.
	 *
	 * @param profesor the profesor
	 * @return the list
	 */
	public List<Asesoria> ListadoAsesoriasProfesor(String profesor) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.listarAsesoriasProfesor(c, profesor);
	}

	/**
	 * Listado asistentes.
	 *
	 * @param idAsesoria the id asesoria
	 * @return the list
	 */
	public List<EstudianteAsesoria> ListadoAsistentes(String idAsesoria) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.listarAsistentes(c, idAsesoria);
	}

	/**
	 * Material asesorias.
	 *
	 * @return the list
	 */
	public List<ReporteMaterialAsesoria> MaterialAsesorias() {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.MaterialAsesorias(c);
	}

	/**
	 * Material asesorias fechas.
	 *
	 * @param fechaInicio the fecha inicio
	 * @param fechaFin the fecha fin
	 * @return the list
	 */
	public List<ReporteMaterialAsesoria> MaterialAsesoriasFechas(String fechaInicio, String fechaFin) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.MaterialAsesoriasFechas(c, fechaInicio, fechaFin);
	}

	/**
	 * Material asesorias asesoria.
	 *
	 * @param asesoria the asesoria
	 * @return the list
	 */
	public List<ReporteMaterialAsesoria> MaterialAsesoriasAsesoria(String asesoria) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.MaterialAsesoriasAsesoria(c, asesoria);
	}

	/**
	 * Asistencia asesoria.
	 *
	 * @return the list
	 */
	public List<ReporteAsistencia> AsistenciaAsesoria() {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.AsitenciaAsesoria(c);
	}

	/**
	 * Asistencia asesoria asesoria.
	 *
	 * @param asesoria the asesoria
	 * @return the list
	 */
	public List<ReporteAsistencia> AsistenciaAsesoriaAsesoria(String asesoria) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.AsitenciaAsesoriaAsesoria(c, asesoria);
	}

	/**
	 * Asistencia asesoria fecha.
	 *
	 * @param fechaI the fecha i
	 * @param fechaF the fecha f
	 * @return the list
	 */
	public List<ReporteAsistencia> AsistenciaAsesoriaFecha(String fechaI, String fechaF) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.AsitenciaAsesoriaFecha(c, fechaI, fechaF);
	}

	/**
	 * Cantidad asitencia asesoria asesoria.
	 *
	 * @param asesoria the asesoria
	 * @return the list
	 */
	public List<ReporteNumAsistencia> CantidadAsitenciaAsesoriaAsesoria(String asesoria) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.CantidadAsitenciaAsesoriaAsesoria(c, asesoria);
	}

	/**
	 * Cantidad asitencia asesoria.
	 *
	 * @return the list
	 */
	public List<ReporteNumAsistencia> CantidadAsitenciaAsesoria() {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.CantidadAsitenciaAsesoria(c);
	}

	/**
	 * Cantidad asitencia asesoria fecha.
	 *
	 * @param fechaInicio the fecha inicio
	 * @param fechaFin the fecha fin
	 * @return the list
	 */
	public List<ReporteNumAsistencia> CantidadAsitenciaAsesoriaFecha(String fechaInicio, String fechaFin) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.CantidadAsitenciaAsesoriaFecha(c, fechaInicio, fechaFin);
	}
}
