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

import co.poli.asesoriastyt.model.Asignatura;
import co.poli.asesoriastyt.model.PlanEstudio;

public class DAOAsignaturas {
	
	public int Crear(Connection c, Asignatura Asignaturas) {
		String sql = AsignaturasSQL.Crear();
		int resultadoCrear = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, Asignaturas.getIdAsignatura());
			st.setString(2, Asignaturas.getNombreAsignatura());
			resultadoCrear = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoCrear;
	}

	public int Modificar(Connection c, Asignatura Asignaturas) {
		String sql = AsignaturasSQL.Modificar();
		int resultadoModificar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, Asignaturas.getNombreAsignatura());
			st.setString(2, Asignaturas.getIdAsignatura());
			resultadoModificar = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoModificar;
	}

	public Asignatura Buscar(Connection con, int IdAsignatura) {
		Asignatura c = new Asignatura();
		try {
			PreparedStatement cl = con.prepareStatement(AsignaturasSQL.Consultar(IdAsignatura));
			ResultSet r = cl.executeQuery();
			while (r.next()) {
				c.setIdAsignatura(r.getString(1));
				c.setNombreAsignatura(r.getString(2));
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

	public int Eliminar(Connection c, Asignatura Asignaturas) {
		String sql = AsignaturasSQL.Eliminar();
		int resultadoEliminar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, Asignaturas.getIdAsignatura());

			resultadoEliminar = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOAsignaturas.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		return resultadoEliminar;
	}

	public List<Asignatura> listarAsignaturas(Connection c) {
		List<Asignatura> Asignaturas = new ArrayList<Asignatura>();
		try {
			String sql = "SELECT Codigo_Asignatura, Nombre_Asignatura, PlanEstudios_Asignatura FROM asignaturas";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Asignatura Asig = new Asignatura();
				Asig.setIdAsignatura(rs.getString(1));
				Asig.setNombreAsignatura(rs.getString(2));
				Asignaturas.add(Asig);
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
		return Asignaturas;
	}
}
