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

import co.poli.asesoriastyt.model.Perfil;

/**
 * @author natad_000
 *
 */
public class DAOPerfiles {
	
	public int consultarUsuario(Connection c,String correo)
	{
		int bandera=0;
	try {
			
		PreparedStatement preparedStatement = c.prepareStatement("select * from personas where Correo_Persona=?");
		preparedStatement.setString(1, correo);
		ResultSet rs = preparedStatement.executeQuery();
		
		if (rs.next()) {
			bandera=rs.getInt(15);
		
		}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bandera;
		
	}
	
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

			st.setString(1, Perfiles.getNombrePerfil());
			st.setInt(2, Perfiles.getIdPerfil());
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

	public List<Perfil> listarPerfiles(Connection c) {
		List<Perfil> Perfiles = new ArrayList<Perfil>();
		try {
			String sql = "SELECT Id_Perfil, Nombre_Perfil FROM perfiles";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Perfil Perf = new Perfil();
				Perf.setIdPerfil(rs.getInt(1));
				Perf.setNombrePerfil(rs.getString(2));
				Perfiles.add(Perf);
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
		return Perfiles;
	}
}
