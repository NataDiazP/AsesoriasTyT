/**
 * 
 */
package co.poli.asesoriastyt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.poli.asesoriastyt.model.Asesoria;
import co.poli.asesoriastyt.model.EstudianteAsesoria;
import co.poli.asesoriastyt.model.ReporteAsistencia;
import co.poli.asesoriastyt.model.ReporteMaterialAsesoria;
import co.poli.asesoriastyt.model.ReporteNumAsistencia;

/**
 * @author pavargas
 *
 */
public class DAOAsesorias {

	public int Crear(Connection c, Asesoria Asesorias) {
		String sql = AsesoriasSQL.Crear();
		int resultadoCrear = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, Asesorias.getIdAsesoria());
			st.setString(2, Asesorias.getNombreAsesoria());
			st.setString(3, Asesorias.getDocente());
			st.setString(4, Asesorias.getAsignatura());
			st.setString(5, Asesorias.getFecha());
			st.setString(6, Asesorias.getHoraI());
			st.setString(7, Asesorias.getHoraF());
			st.setString(8, Asesorias.getLugar());
			st.setString(9, Asesorias.getCupos());
			st.setString(10, Asesorias.getCuposD());
			st.setString(11, Asesorias.getRecursosApoyo());
			st.setString(12, Asesorias.getObservaciones());
			st.setString(13, Asesorias.getEstado());
			resultadoCrear = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOAsesorias.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOAsesorias.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoCrear;
	}

	public int Asistir(Connection c, String idUser, String idAsesoria) {
		EstudianteAsesoria EstudianteAsesoria = new EstudianteAsesoria();
		String sql = EstudiantesAsesoriasSQL.Crear();
		int resultadoCrear = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, idUser);
			st.setString(2, idAsesoria);
			st.setString(3, EstudianteAsesoria.getAsistenciaAsesoria());
			resultadoCrear = st.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DAOAsesorias.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOAsesorias.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoCrear;
	}

	public int Modificar(Connection c, Asesoria Asesorias) {
		String sql = AsesoriasSQL.Modificar();
		int resultadoModificar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(13, Asesorias.getIdAsesoria());
			st.setString(1, Asesorias.getNombreAsesoria());
			st.setString(2, Asesorias.getDocente());
			st.setString(3, Asesorias.getAsignatura());
			st.setString(4, Asesorias.getFecha());
			st.setString(5, Asesorias.getHoraI());
			st.setString(6, Asesorias.getHoraF());
			st.setString(7, Asesorias.getLugar());
			st.setString(8, Asesorias.getCupos());
			st.setString(9, Asesorias.getCuposD());
			st.setString(10, Asesorias.getRecursosApoyo());
			st.setString(11, Asesorias.getObservaciones());
			st.setString(12, Asesorias.getEstado());
			resultadoModificar = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOAsesorias.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOAsesorias.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoModificar;
	}

	public Asesoria Buscar(Connection con, String IdAsesoria) {
		Asesoria c = new Asesoria();
		try {
			PreparedStatement cl = con.prepareStatement(AsesoriasSQL.Consultar(IdAsesoria));
			ResultSet r = cl.executeQuery();
			while (r.next()) {
				c.setIdAsesoria(r.getString(1));
				c.setNombreAsesoria(r.getString(2));
				c.setDocente(r.getString(3));
				c.setAsignatura(r.getString(4));
				c.setFecha(r.getString(5));
				c.setHoraI(r.getString(6));
				c.setHoraF(r.getString(7));
				c.setLugar(r.getString(8));
				c.setCupos(r.getString(9));
				c.setCuposD(r.getString(10));
				c.setRecursosApoyo(r.getString(11));
				c.setObservaciones(r.getString(12));
				c.setEstado(r.getString(13));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return c;

		} finally {
			try {
				con.close();
			} catch (Exception ex) {
			}

		}
		return c;
	}

	public List<EstudianteAsesoria> listarAsistentes(Connection c, String idAsesoria) {
		List<EstudianteAsesoria> EstudianteAsesorias = new ArrayList<EstudianteAsesoria>();
		try {
			String sql = "SELECT es.Id_Asesoria, es.Id_Estudiante, es.Asistencia_Asesoria, p.Correo_Persona FROM estudiantes_asesoria es, personas p WHERE Id_Asesoria=" + idAsesoria + " AND es.Id_Estudiante = p.NumDoc_Persona";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				EstudianteAsesoria EstudianteAsesoria = new EstudianteAsesoria();
				EstudianteAsesoria.setIdAsesoria(r.getString(1));
				EstudianteAsesoria.setNumDocEstudiante(r.getString(2));
				EstudianteAsesoria.setAsistenciaAsesoria(r.getString(3));
				EstudianteAsesoria.setEmailEstudiante(r.getString(4));
				EstudianteAsesorias.add(EstudianteAsesoria);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return EstudianteAsesorias;
	}

	public List<Asesoria> listarAsesorias(Connection c) {
		List<Asesoria> Asesorias = new ArrayList<Asesoria>();
		try {
			String sql = "SELECT Id_Asesoria, Nombre_Asesoria, Docente_Asesoria, Asignatura_Asesoria, Fecha_Asesoria, HoraInicio_Asesoria, HoraFin_Asesoria, Lugar_Asesoria, Cupos_Asesoria, CuposDisp_Asesoria, RecursosApoyo_Asesoria, Observaciones_Asesoria, Estado_Asesoria FROM asesorias";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				Asesoria Asesoria = new Asesoria();
				Asesoria.setIdAsesoria(r.getString(1));
				Asesoria.setNombreAsesoria(r.getString(2));
				Asesoria.setDocente(r.getString(3));
				Asesoria.setAsignatura(r.getString(4));
				Asesoria.setFecha(r.getString(5));
				Asesoria.setHoraI(r.getString(6));
				Asesoria.setHoraF(r.getString(7));
				Asesoria.setLugar(r.getString(8));
				Asesoria.setCupos(r.getString(9));
				Asesoria.setCuposD(r.getString(10));
				Asesoria.setRecursosApoyo(r.getString(11));
				Asesoria.setObservaciones(r.getString(12));
				Asesoria.setEstado(r.getString(13));
				Asesorias.add(Asesoria);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return Asesorias;
	}

	public List<ReporteMaterialAsesoria> MaterialAsesorias(Connection c) {

		List<ReporteMaterialAsesoria> reportes = new ArrayList<ReporteMaterialAsesoria>();

		try {
			String sql = "select a.id_Asesoria, a.Nombre_Asesoria, a.Fecha_Asesoria, b.NumDoc_Persona, b.Nombres_Persona, b.PApellido_Persona, b.SApellido_Persona, a.RecursosApoyo_Asesoria from asesorias as a inner join personas as b on a.Docente_Asesoria = b.NumDoc_Persona ORDER BY a.id_Asesoria;";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				ReporteMaterialAsesoria reporte = new ReporteMaterialAsesoria();
				reporte.setId_Asesoria(r.getString(1));
				reporte.setNombre_Asesoria(r.getString(2));
				reporte.setFecha_Asesoria(r.getString(3));
				reporte.setNumDoc_Persona(r.getString(4));
				reporte.setNombres_Persona(r.getString(5));
				reporte.setpApellido_Persona(r.getString(6));
				reporte.setsApellido_Persona(r.getString(7));
				reporte.setObservaciones_Asesoria(r.getString(8));
				reportes.add(reporte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return reportes;
	}

	public List<ReporteMaterialAsesoria> MaterialAsesoriasFechas(Connection c, String fechaI, String fechaF) {

		List<ReporteMaterialAsesoria> reportes = new ArrayList<ReporteMaterialAsesoria>();

		try {
			String sql = "select a.id_Asesoria, a.Nombre_Asesoria, a.Fecha_Asesoria, b.NumDoc_Persona, b.Nombres_Persona, b.PApellido_Persona,"
					+ "b.SApellido_Persona, a.RecursosApoyo_Asesoria from asesorias as a inner join personas as b on a.Docente_Asesoria =" +
					"b.NumDoc_Persona where a.Fecha_Asesoria>='" + fechaI + "' and a.Fecha_Asesoria<='" + fechaF + "' ORDER BY a.id_Asesoria";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				ReporteMaterialAsesoria reporte = new ReporteMaterialAsesoria();
				reporte.setId_Asesoria(r.getString(1));
				reporte.setNombre_Asesoria(r.getString(2));
				reporte.setFecha_Asesoria(r.getString(3));
				reporte.setNumDoc_Persona(r.getString(4));
				reporte.setNombres_Persona(r.getString(5));
				reporte.setpApellido_Persona(r.getString(6));
				reporte.setsApellido_Persona(r.getString(7));
				reporte.setObservaciones_Asesoria(r.getString(8));
				reportes.add(reporte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return reportes;
	}

	public List<ReporteMaterialAsesoria> MaterialAsesoriasAsesoria(Connection c, String asesoria) {

		List<ReporteMaterialAsesoria> reportes = new ArrayList<ReporteMaterialAsesoria>();

		try {
			String sql = "select a.id_Asesoria, a.Nombre_Asesoria, a.Fecha_Asesoria, b.NumDoc_Persona, b.Nombres_Persona, b.PApellido_Persona,"
					+ "b.SApellido_Persona, a.RecursosApoyo_Asesoria from asesorias as a inner join personas as b on a.Docente_Asesoria =" +
					"b.NumDoc_Persona where a.id_Asesoria='" + asesoria + "' ORDER BY a.id_Asesoria";
			PreparedStatement ps = c.prepareStatement(sql);

			ResultSet r = ps.executeQuery();
			while (r.next()) {
				ReporteMaterialAsesoria reporte = new ReporteMaterialAsesoria();
				reporte.setId_Asesoria(r.getString(1));
				reporte.setNombre_Asesoria(r.getString(2));
				reporte.setFecha_Asesoria(r.getString(3));
				reporte.setNumDoc_Persona(r.getString(4));
				reporte.setNombres_Persona(r.getString(5));
				reporte.setpApellido_Persona(r.getString(6));
				reporte.setsApellido_Persona(r.getString(7));
				reporte.setObservaciones_Asesoria(r.getString(8));
				reportes.add(reporte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return reportes;
	}

	/**
	 * @param c
	 * @return
	 */
	public List<ReporteAsistencia> AsitenciaAsesoria(Connection c)
	{
		List<ReporteAsistencia> reportes = new ArrayList<ReporteAsistencia>();

		try {
			String sql = "select a.id_Asesoria, c.Nombre_Asesoria, c.Fecha_Asesoria, b.NumDoc_Persona, b.Nombres_Persona, b.PApellido_Persona, b.SApellido_Persona " +
					"from estudiantes_asesoria as a inner join personas as b on a.Id_Estudiante = b.NumDoc_Persona inner "
					+ "join asesorias as c on a.id_Asesoria = c.id_Asesoria Where a.Asistencia_Asesoria='Si' order by a.id_Asesoria;";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				ReporteAsistencia reporte = new ReporteAsistencia();
				reporte.setId_Asesoria(r.getString(1));
				reporte.setNombre_Asesoria(r.getString(2));
				reporte.setFecha_Asesoria(r.getString(3));
				reporte.setNumDoc_Persona(r.getString(4));
				reporte.setNombres_Persona(r.getString(5));
				reporte.setpApellido_Persona(r.getString(6));
				reporte.setsApellido_Persona(r.getString(7));
				reportes.add(reporte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return reportes;

	}

	public List<ReporteAsistencia> AsitenciaAsesoriaAsesoria(Connection c, String asesoria)
	{
		List<ReporteAsistencia> reportes = new ArrayList<ReporteAsistencia>();

		try {
			String sql = "select a.id_Asesoria, c.Nombre_Asesoria, c.Fecha_Asesoria, b.NumDoc_Persona, b.Nombres_Persona, b.PApellido_Persona, b.SApellido_Persona " +
					"from estudiantes_asesoria as a inner join personas as b on a.Id_Estudiante = b.NumDoc_Persona inner "
					+ "join asesorias as c on a.id_Asesoria = c.id_Asesoria Where a.id_Asesoria ='" + asesoria + "' and a.Asistencia_Asesoria='Si' order by a.id_Asesoria;";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				ReporteAsistencia reporte = new ReporteAsistencia();
				reporte.setId_Asesoria(r.getString(1));
				reporte.setNombre_Asesoria(r.getString(2));
				reporte.setFecha_Asesoria(r.getString(3));
				reporte.setNumDoc_Persona(r.getString(4));
				reporte.setNombres_Persona(r.getString(5));
				reporte.setpApellido_Persona(r.getString(6));
				reporte.setsApellido_Persona(r.getString(7));
				reportes.add(reporte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return reportes;

	}

	public List<ReporteAsistencia> AsitenciaAsesoriaFecha(Connection c, String fechaI, String fechaF)
	{
		List<ReporteAsistencia> reportes = new ArrayList<ReporteAsistencia>();

		try {
			String sql = "select a.id_Asesoria, c.Nombre_Asesoria, c.Fecha_Asesoria, b.NumDoc_Persona, b.Nombres_Persona, b.PApellido_Persona , b.SApellido_Persona " +
					"from estudiantes_asesoria as a inner join personas as b on a.Id_Estudiante = b.NumDoc_Persona inner "
					+ "join asesorias as c on a.id_Asesoria = c.id_Asesoria Where a.Asistencia_Asesoria='Si'and c.Fecha_Asesoria >='" + fechaI + "' and c.Fecha_Asesoria <='" + fechaF
					+ "' order by a.id_Asesoria";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				ReporteAsistencia reporte = new ReporteAsistencia();
				reporte.setId_Asesoria(r.getString(1));
				reporte.setNombre_Asesoria(r.getString(2));
				reporte.setFecha_Asesoria(r.getString(3));
				reporte.setNumDoc_Persona(r.getString(4));
				reporte.setNombres_Persona(r.getString(5));
				reporte.setpApellido_Persona(r.getString(6));
				reporte.setsApellido_Persona(r.getString(7));
				reportes.add(reporte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return reportes;

	}

	public List<ReporteNumAsistencia> CantidadAsitenciaAsesoriaAsesoria(Connection c, String asesoria)
	{
		List<ReporteNumAsistencia> reportes = new ArrayList<ReporteNumAsistencia>();

		try {
			String sql = "SELECT a.id_Asesoria , b.Nombre_Asesoria, b.Fecha_Asesoria , COUNT(*) as Cantidad from estudiantes_asesoria as a inner join asesorias as b on a.id_Asesoria = b.id_Asesoria WHERE a.Asistencia_Asesoria='Si' and a.id_Asesoria='"
					+ asesoria + "' order by a.id_Asesoria";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				ReporteNumAsistencia reporte = new ReporteNumAsistencia();
				reporte.setId_Asesoria(r.getString(1));
				reporte.setNombre_Asesoria(r.getString(2));
				reporte.setFecha_Asesoria(r.getString(3));
				reporte.setCantidad(r.getString(4));
				reportes.add(reporte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return reportes;

	}

	public List<ReporteNumAsistencia> CantidadAsitenciaAsesoria(Connection c)
	{
		List<ReporteNumAsistencia> reportes = new ArrayList<ReporteNumAsistencia>();

		try {
			String sql = "SELECT a.id_Asesoria , b.Nombre_Asesoria, b.Fecha_Asesoria , COUNT(*) as Cantidad from estudiantes_asesoria as a inner join asesorias as b on a.id_Asesoria = b.id_Asesoria WHERE a.Asistencia_Asesoria='Si' group by a.id_Asesoria , b.Nombre_Asesoria, b.Fecha_Asesoria order by a.id_Asesoria";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				ReporteNumAsistencia reporte = new ReporteNumAsistencia();
				reporte.setId_Asesoria(r.getString(1));
				reporte.setNombre_Asesoria(r.getString(2));
				reporte.setFecha_Asesoria(r.getString(3));
				reporte.setCantidad(r.getString(4));
				reportes.add(reporte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}
		return reportes;

	}

	/**
	 * @param c
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	public List<ReporteNumAsistencia> CantidadAsitenciaAsesoriaFecha(Connection c, String fechaInicio, String fechaFin)
	{

		List<ReporteNumAsistencia> reportes = new ArrayList<ReporteNumAsistencia>();

		try {
			String sql = "SELECT a.id_Asesoria , b.Nombre_Asesoria, b.Fecha_Asesoria , COUNT(*) as Cantidad from estudiantes_asesoria as a " +
					"inner join asesorias as b on a.id_Asesoria = b.id_Asesoria WHERE a.Asistencia_Asesoria='Si' and " +
					"b.Fecha_Asesoria >='" + fechaInicio + "' and b.Fecha_Asesoria <= '" + fechaFin + "' group by a.id_Asesoria , b.Nombre_Asesoria, b.Fecha_Asesoria order by a.id_Asesoria";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				ReporteNumAsistencia reporte = new ReporteNumAsistencia();
				reporte.setId_Asesoria(r.getString(1));
				reporte.setNombre_Asesoria(r.getString(2));
				reporte.setFecha_Asesoria(r.getString(3));
				reporte.setCantidad(r.getString(4));
				reportes.add(reporte);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return reportes;

	}

	/**
	 * @param c
	 * @param profesor
	 * @return
	 */
	public List<Asesoria> listarAsesoriasProfesor(Connection c, String profesor) {
		
		List<Asesoria> Asesorias = new ArrayList<Asesoria>();
		try {
			String sql = "SELECT a.Id_Asesoria, a.Docente_Asesoria, a.Asignatura_Asesoria, a.Fecha_Asesoria, a.HoraInicio_Asesoria, "
					+ "a.HoraFin_Asesoria, a.Lugar_Asesoria, a.Cupos_Asesoria, a.CuposDisp_Asesoria, a.RecursosApoyo_Asesoria, a.Observaciones_Asesoria, "
					+ "a.Estado_Asesoria FROM asesorias as a inner join personas as b on a.Docente_Asesoria = b.NumDoc_Persona where  b.Correo_Persona ='"+profesor+"'";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				Asesoria Asesoria = new Asesoria();
				Asesoria.setIdAsesoria(r.getString(1));
				Asesoria.setNombreAsesoria(r.getString(2));
				Asesoria.setDocente(r.getString(3));
				Asesoria.setAsignatura(r.getString(4));
				Asesoria.setFecha(r.getString(5));
				Asesoria.setHoraI(r.getString(6));
				Asesoria.setHoraF(r.getString(7));
				Asesoria.setLugar(r.getString(8));
				Asesoria.setCupos(r.getString(9));
				Asesoria.setCuposD(r.getString(10));
				Asesoria.setRecursosApoyo(r.getString(11));
				Asesoria.setObservaciones(r.getString(12));
				Asesoria.setEstado(r.getString(13));
				Asesorias.add(Asesoria);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return Asesorias;
	}
}
