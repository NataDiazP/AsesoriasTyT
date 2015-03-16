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

import co.poli.asesoriastyt.model.ProgAcademica;

/**
 * @author nata_000
 *
 */
public class DAOProgAcademica {

	public int Crear(Connection c, ProgAcademica ProgAcademica) {
		String sql = ProgAcademicaSQL.Crear();
		int resultadoCrear = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, ProgAcademica.getIdProgAcademica());
			st.setString(2, ProgAcademica.getDocenteProgAcademica());
			st.setString(3, ProgAcademica.getAsignaturaProgAcademica());
			st.setString(4, ProgAcademica.getGrupoAsigProgAcademica());
			st.setString(5, ProgAcademica.getNroEstAsigProgAcademica());
			st.setString(6, ProgAcademica.getDiasAsigProgAcademica());
			st.setString(7, ProgAcademica.getHoraIniAsigProgAcademica());
			st.setString(8, ProgAcademica.getHoraFinAsigProgAcademica());
			st.setString(9, ProgAcademica.getAulaClaseProgAcademica());
			st.setString(10, ProgAcademica.getSemestreProgAcademica());
			st.setString(11, ProgAcademica.getAnoProgAcademica());
			resultadoCrear = st.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DAOProgAcademica.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOProgAcademica.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoCrear;
	}

	public int Modificar(Connection c, ProgAcademica ProgAcademica) {
		String sql = ProgAcademicaSQL.Modificar();
		int resultadoModificar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, ProgAcademica.getDocenteProgAcademica());
			st.setString(2, ProgAcademica.getAsignaturaProgAcademica());
			st.setString(3, ProgAcademica.getGrupoAsigProgAcademica());
			st.setString(4, ProgAcademica.getNroEstAsigProgAcademica());
			st.setString(5, ProgAcademica.getDiasAsigProgAcademica());
			st.setString(6, ProgAcademica.getHoraIniAsigProgAcademica());
			st.setString(7, ProgAcademica.getHoraFinAsigProgAcademica());
			st.setString(8, ProgAcademica.getAulaClaseProgAcademica());
			st.setString(9, ProgAcademica.getSemestreProgAcademica());
			st.setString(10, ProgAcademica.getAnoProgAcademica());
			st.setString(11, ProgAcademica.getIdProgAcademica());
			resultadoModificar = st.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DAOProgAcademica.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOProgAcademica.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoModificar;
	}

	public ProgAcademica Buscar(Connection con, String IdProgAcademica) {
		ProgAcademica c = new ProgAcademica();
		try {
			PreparedStatement cl = con.prepareStatement(ProgAcademicaSQL.Consultar(IdProgAcademica));
			ResultSet r = cl.executeQuery();
			while (r.next()) {
				c.setIdProgAcademica(r.getString(1));
				c.setDocenteProgAcademica(r.getString(2));
				c.setAsignaturaProgAcademica(r.getString(3));
				c.setGrupoAsigProgAcademica(r.getString(4));
				c.setNroEstAsigProgAcademica(r.getString(5));
				c.setDiasAsigProgAcademica(r.getString(6));
				c.setHoraIniAsigProgAcademica(r.getString(7));
				c.setHoraFinAsigProgAcademica(r.getString(8));
				c.setAulaClaseProgAcademica(r.getString(9));
				c.setSemestreProgAcademica(r.getString(10));
				c.setAnoProgAcademica(r.getString(11));
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

	public int Eliminar(Connection c, ProgAcademica ProgAcademica) {
		String sql = ProgAcademicaSQL.Eliminar();
		int resultadoEliminar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);
			resultadoEliminar = st.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(DAOProgAcademica.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOProgAcademica.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoEliminar;
	}

	public List<ProgAcademica> listarProgAcademica(Connection c) {
		List<ProgAcademica> progAcademica = new ArrayList<ProgAcademica>();
		try {
			String sql = "SELECT Id_ProgAcademica, Docente_ProgAcademica, Asignatura, Grupo_Asignatura, Nro_Estudiantes_Asignatura, Dias_Asignatura, HoraInicio_Asignatura, HoraFin_Asignatura, Aula_Clase FROM programaciones_academicas";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				ProgAcademica ProgAcademica = new ProgAcademica();
				ProgAcademica.setIdProgAcademica(r.getString(1));
				ProgAcademica.setDocenteProgAcademica(r.getString(2));
				ProgAcademica.setAsignaturaProgAcademica(r.getString(3));
				ProgAcademica.setGrupoAsigProgAcademica(r.getString(4));
				ProgAcademica.setNroEstAsigProgAcademica(r.getString(5));
				ProgAcademica.setDiasAsigProgAcademica(r.getString(6));
				ProgAcademica.setHoraIniAsigProgAcademica(r.getString(7));
				ProgAcademica.setHoraFinAsigProgAcademica(r.getString(8));
				ProgAcademica.setAulaClaseProgAcademica(r.getString(9));
				progAcademica.add(ProgAcademica);
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
		return progAcademica;
	}
}
