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
			st.setString(2, Asesorias.getDocente());
			st.setString(3, Asesorias.getAsignatura());
			st.setString(4, Asesorias.getFecha());
			st.setString(5, Asesorias.getHoraI());
			st.setString(6, Asesorias.getHoraF());
			st.setString(7, Asesorias.getLugar());
			st.setString(8, Asesorias.getCupos());
			st.setString(9, Asesorias.getCuposD());
			st.setString(10, Asesorias.getObservaciones());
			st.setString(11, Asesorias.getEstado());
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

			st.setString(11, Asesorias.getIdAsesoria());
			st.setString(10, Asesorias.getDocente());
			st.setString(9, Asesorias.getAsignatura());
			st.setString(8, Asesorias.getFecha());
			st.setString(7, Asesorias.getHoraI());
			st.setString(6, Asesorias.getHoraF());
			st.setString(5, Asesorias.getLugar());
			st.setString(4, Asesorias.getCupos());
			st.setString(3, Asesorias.getCuposD());
			st.setString(2, Asesorias.getObservaciones());
			st.setString(1, Asesorias.getEstado());
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
				c.setDocente(r.getString(2));
				c.setAsignatura(r.getString(3));
				c.setFecha(r.getString(4));
				c.setHoraI(r.getString(5));
				c.setHoraF(r.getString(6));
				c.setLugar(r.getString(7));
				c.setCupos(r.getString(8));
				c.setCuposD(r.getString(9));
				c.setObservaciones(r.getString(10));
				c.setEstado(r.getString(11));
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

	public int Eliminar(Connection c, Asesoria Asesorias) {
		String sql = AsesoriasSQL.Eliminar();
		int resultadoEliminar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, Asesorias.getIdAsesoria());

			resultadoEliminar = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOAsesorias.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOAsesorias.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		return resultadoEliminar;
	}

	public List<Asesoria> listarAsesorias(Connection c) {
		List<Asesoria> Asesorias = new ArrayList<Asesoria>();
		try {
			String sql = "SELECT Id_Asesoria, Docente_Asesoria, Asignatura_Asesoria, Fecha_Asesoria, HoraInicio_Asesoria, HoraFin_Asesoria, Lugar_Asesoria, Cupos_Asesoria, CuposDisp_Asesoria, Observaciones_Asesoria, Estado_Asesoria FROM asesorias";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				Asesoria Asesoria = new Asesoria();
				Asesoria.setIdAsesoria(r.getString(1));
				Asesoria.setDocente(r.getString(2));
				Asesoria.setAsignatura(r.getString(3));
				Asesoria.setFecha(r.getString(4));
				Asesoria.setHoraI(r.getString(5));
				Asesoria.setHoraF(r.getString(6));
				Asesoria.setLugar(r.getString(7));
				Asesoria.setCupos(r.getString(8));
				Asesoria.setCuposD(r.getString(9));
				Asesoria.setObservaciones(r.getString(10));
				Asesoria.setEstado(r.getString(11));
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
