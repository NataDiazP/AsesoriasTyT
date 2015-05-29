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
import co.poli.asesoriastyt.model.AsesoriaBK;
import co.poli.asesoriastyt.model.EstudianteAsesoria;
import co.poli.asesoriastyt.model.ReporteAsistencia;
import co.poli.asesoriastyt.model.ReporteMaterialAsesoria;
import co.poli.asesoriastyt.model.ReporteNumAsistencia;


/**
 * The Class DAOAsesorias.
 *
 * @author pavargas
 */
public class DAOAsesorias {

	/**
	 * Crear.
	 *
	 * @param c the c
	 * @param Asesorias the asesorias
	 * @return the int
	 */
	public int Crear(Connection c, Asesoria Asesorias) {
		String sql = AsesoriasSQL.Crear();
		int resultadoCrear = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, Asesorias.getNombreAsesoria());
			st.setString(2, Asesorias.getDocente());
			st.setString(3, Asesorias.getAsignatura());
			st.setString(4, Asesorias.getFecha());
			st.setString(5, Asesorias.getHoraI());
			st.setString(6, Asesorias.getHoraF());
			st.setString(7, Asesorias.getLugar());
			st.setString(8, Asesorias.getCupos());
			st.setString(9, Asesorias.getCupos());
			st.setString(10, Asesorias.getRecursosApoyo());
			st.setString(11, Asesorias.getObservaciones());
			st.setString(12, Asesorias.getEstado());
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

		/**
	 * Asistir.
	 *
	 * @param c the c
	 * @param idUser the id user
	 * @param idAsesoria the id asesoria
	 * @return the int
	 */
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

	/**
	 * Guardar asistencia.
	 *
	 * @param c the c
	 * @param idAsesoria the id asesoria
	 * @param idEstudiante the id estudiante
	 * @param asistio the asistio
	 * @return the int
	 */
	public int GuardarAsistencia(Connection c, String idAsesoria, String idEstudiante, String asistio) {
		String sql = AsesoriasSQL.AsistirAsesoria();
		int resultadoModificar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, asistio);
			st.setString(2, idEstudiante);
			st.setString(3, idAsesoria);
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
	
	/**
	 * Modificar.
	 *
	 * @param c the c
	 * @param Asesorias the asesorias
	 * @return the int
	 */
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

	/**
	 * Buscar.
	 *
	 * @param con the con
	 * @param IdAsesoria the id asesoria
	 * @return the asesoria
	 */
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

	/**
	 * Listar asistentes.
	 *
	 * @param c the c
	 * @param idAsesoria the id asesoria
	 * @return the list
	 */
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

	/**
	 * Listar asesorias.
	 *
	 * @param c the c
	 * @return the list
	 */
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
	
	public int guardarAsesoriasBK(Connection c) {
		int resultadoCrear=0;
		try {
			String sql = "insert into BackupAsesorias select a.id_Asesoria, a.Nombre_Asesoria, b.NumDoc_Persona, b.Nombres_Persona, b.PApellido_Persona || b.SApellido_Persona, a.Asignatura_Asesoria, c.Nombre_Asignatura,"+
					"a.Fecha_Asesoria, a.HoraInicio_Asesoria, a. HoraFin_Asesoria, a.Lugar_Asesoria, a.Cupos_Asesoria,a.CuposDisp_Asesoria, a.RecursosApoyo_Asesoria, a.Observaciones_Asesoria, a.Estado_Asesoria from asesorias as a inner join personas as b on a.Docente_Asesoria = b.NumDoc_Persona "
					+ "inner join asignaturas as c on a.Asignatura_Asesoria = c.Codigo_Asignatura ORDER BY a.id_Asesoria";
			System.out.print(sql);
			PreparedStatement ps = c.prepareStatement(sql);
			resultadoCrear = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return resultadoCrear;
	}

	/**
	 * Material asesorias.
	 *
	 * @param c the c
	 * @return the list
	 */
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

	/**
	 * Material asesorias fechas.
	 *
	 * @param c the c
	 * @param fechaI the fecha i
	 * @param fechaF the fecha f
	 * @return the list
	 */
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

	/**
	 * Material asesorias asesoria.
	 *
	 * @param c the c
	 * @param asesoria the asesoria
	 * @return the list
	 */
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
	 * Asitencia asesoria.
	 *
	 * @param c the c
	 * @return the list
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

	/**
	 * Asitencia asesoria asesoria.
	 *
	 * @param c the c
	 * @param asesoria the asesoria
	 * @return the list
	 */
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

	/**
	 * Asitencia asesoria fecha.
	 *
	 * @param c the c
	 * @param fechaI the fecha i
	 * @param fechaF the fecha f
	 * @return the list
	 */
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

	/**
	 * Cantidad asitencia asesoria asesoria.
	 *
	 * @param c the c
	 * @param asesoria the asesoria
	 * @return the list
	 */
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

	/**
	 * Cantidad asitencia asesoria.
	 *
	 * @param c the c
	 * @return the list
	 */
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
	 * Cantidad asitencia asesoria fecha.
	 *
	 * @param c the c
	 * @param fechaInicio the fecha inicio
	 * @param fechaFin the fecha fin
	 * @return the list
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
	 * Listar asesorias profesor.
	 *
	 * @param c the c
	 * @param profesor the profesor
	 * @return the list
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

	/**
	 * Generar id asesoria.
	 *
	 * @param con the con
	 * @return the asesoria
	 */
	public Asesoria generarIdAsesoria(Connection con) {
		Asesoria x = new Asesoria();
	
		
		try {
			PreparedStatement cl = con.prepareStatement(AsesoriasSQL.ConsultarID());
			ResultSet r = cl.executeQuery();
			while (r.next()) {
				x.setIdAsesoria(r.getString(1));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return x;

		} finally {
			try {
				con.close();
			} catch (Exception ex) {
			}

		}
		return x;
	}



	

	
}
	
	
	
	
	

