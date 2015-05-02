/**
 * 
 */
package co.poli.asesoriastyt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.poli.asesoriastyt.model.Asignatura;


/**
 * The Class DAOAsignaturas.
 */
public class DAOAsignaturas {
	
	/**
	 * Crear.
	 *
	 * @param c the c
	 * @param Asignaturas the asignaturas
	 * @return the int
	 */
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

	/**
	 * Modificar.
	 *
	 * @param c the c
	 * @param Asignaturas the asignaturas
	 * @return the int
	 */
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

	/**
	 * Buscar.
	 *
	 * @param con the con
	 * @param IdAsignatura the id asignatura
	 * @return the asignatura
	 */
	public Asignatura Buscar(Connection con, String IdAsignatura) {
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

	/**
	 * Eliminar.
	 *
	 * @param c the c
	 * @param Asignaturas the asignaturas
	 * @return the int
	 */
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

	/**
	 * Listar asignaturas.
	 *
	 * @param c the c
	 * @return the list
	 */
	public List<Asignatura> listarAsignaturas(Connection c) {
		List<Asignatura> Asignaturas = new ArrayList<Asignatura>();
		try {
			String sql = "SELECT Codigo_Asignatura, Nombre_Asignatura FROM asignaturas";
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

	/**
	 * @param c
	 * @param string
	 * @return
	 */
	public boolean validarExistenciaAsignatura(Connection c, String string) {
		boolean validar= false;
		Statement stmt = null;
        ResultSet r = null;
		
		try {
			stmt = c.createStatement();
	        r = stmt.executeQuery("Select Codigo_Asignatura from asignaturas where Codigo_Asignatura='"+string+"'");
			
			while (r.next()) {
				validar=true;
				break;
			}
			try
			{
				r.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
                if(r != null) r.close();
                if(stmt != null) stmt.close();
                if(c != null) c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
		}
		return validar;
	}
}
