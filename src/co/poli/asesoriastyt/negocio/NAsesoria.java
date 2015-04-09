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
 * @author pavargas
 *
 */
public class NAsesoria {

	/**
	 * 
	 */
	DAOAsesorias daoAsesorias;
	Connection c;

	public int Crear(Asesoria Asesorias) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		int resultadoCrear = daoAsesorias.Crear(c, Asesorias);
		return resultadoCrear;
	}
	
	public int Asistir (String idUser, String idAsesoria) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		int resultadoCrear = daoAsesorias.Asistir(c, idUser, idAsesoria);
		return resultadoCrear;
	}

	public int Modificar(Asesoria Asesorias) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		int resultadoModificar = daoAsesorias.Modificar(c, Asesorias);
		return resultadoModificar;
	}

	public int GuardarAsistencia(String idAsesoria, String idEstudiante, String asistio) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		int resultadoModificar = daoAsesorias.GuardarAsistencia(c, idAsesoria, idEstudiante, asistio);
		return resultadoModificar;
	}
	
	public Asesoria Buscar(String Asesorias) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		Asesoria resultadoBuscar = daoAsesorias.Buscar(c, Asesorias);
		return resultadoBuscar;
	}
	
//	public id
	
	public List<Asesoria> ListadoAsesorias() {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.listarAsesorias(c);
	}
	
	public List<Asesoria> ListadoAsesoriasProfesor(String profesor) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.listarAsesoriasProfesor(c, profesor);
	}
	
	public List<EstudianteAsesoria> ListadoAsistentes(String idAsesoria) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.listarAsistentes(c, idAsesoria);
	}
	
	public List<ReporteMaterialAsesoria> MaterialAsesorias() {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.MaterialAsesorias(c);
	}

	/**
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public List<ReporteMaterialAsesoria> MaterialAsesoriasFechas(String fechaInicio, String fechaFin) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.MaterialAsesoriasFechas(c,fechaInicio,fechaFin);
	}

	/**
	 * @param asesoria
	 * @return
	 */
	public List<ReporteMaterialAsesoria> MaterialAsesoriasAsesoria(String asesoria) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.MaterialAsesoriasAsesoria(c, asesoria);
	}
	
	public List<ReporteAsistencia> AsistenciaAsesoria() {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.AsitenciaAsesoria(c);
	}
	
	public List<ReporteAsistencia> AsistenciaAsesoriaAsesoria(String asesoria) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.AsitenciaAsesoriaAsesoria(c,asesoria);
	}
	
	public List<ReporteAsistencia> AsistenciaAsesoriaFecha(String fechaI, String fechaF) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.AsitenciaAsesoriaFecha(c,fechaI,fechaF);
	}
	
	public List<ReporteNumAsistencia> CantidadAsitenciaAsesoriaAsesoria(String asesoria) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.CantidadAsitenciaAsesoriaAsesoria(c,asesoria);
	}
	
	public List<ReporteNumAsistencia> CantidadAsitenciaAsesoria() {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.CantidadAsitenciaAsesoria(c);
	}

	/**
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public List<ReporteNumAsistencia> CantidadAsitenciaAsesoriaFecha(String fechaInicio, String fechaFin) {
		daoAsesorias = new DAOAsesorias();
		c = new Conexion().getConnection();
		return daoAsesorias.CantidadAsitenciaAsesoriaFecha(c, fechaInicio, fechaFin);
	}
}
