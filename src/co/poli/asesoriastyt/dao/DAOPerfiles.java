/**
 * 
 */
package co.poli.asesoriastyt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.poli.asesoriastyt.model.Perfil;

/**
 * @author natad_000
 *
 */
public class DAOPerfiles {

	public int Crear(Connection c, Perfil Perfiles) {
		String sql = PerfilesSQL.Crear();
		int resultadoCrear = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setInt(1, Perfiles.getIdPerfil());
			st.setString(2, Perfiles.getNombrePerfil());
			resultadoCrear = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOPerfiles.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOPerfiles.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoCrear;
	}

	public int Modificar(Connection c, Perfil Perfiles) {
		String sql = PerfilesSQL.Modificar();
		int resultadoModificar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setInt(1, Perfiles.getIdPerfil());
			st.setString(2, Perfiles.getNombrePerfil());
			resultadoModificar = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOPerfiles.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOPerfiles.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoModificar;
	}

	public Perfil Buscar(Connection con, int IdPerfil) {
		Perfil c = new Perfil();
		try {
			PreparedStatement cl = con.prepareStatement(PerfilesSQL.Consultar(IdPerfil));
			ResultSet r = cl.executeQuery();
			while (r.next()) {
				c.setIdPerfil(r.getInt(1));
				c.setNombrePerfil(r.getString(2));
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

	public int Eliminar(Connection c, Perfil Perfiles) {
		String sql = PerfilesSQL.Eliminar();
		int resultadoEliminar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setInt(1, Perfiles.getIdPerfil());

			resultadoEliminar = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOPerfiles.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOPerfiles.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		return resultadoEliminar;
	}
}
