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

import co.poli.asesoriastyt.model.EncargadoBloque;

/**
 * @author natad_000
 *
 */
public class DAOEncargadosBloques {

	public int Crear(Connection c, EncargadoBloque EncBloque) {
		String sql = EncargadosBloquesSQL.Crear();
		int resultadoCrear = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, EncBloque.getIdEncargado());
			st.setString(2, EncBloque.getCorreoEncargado());
			resultadoCrear = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOEncargadosBloques.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOEncargadosBloques.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoCrear;
	}

	public int Modificar(Connection c, EncargadoBloque EncBloque) {
		String sql = EncargadosBloquesSQL.Modificar();
		int resultadoModificar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, EncBloque.getCorreoEncargado());
			st.setString(2, EncBloque.getIdEncargado());
			resultadoModificar = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOEncargadosBloques.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOEncargadosBloques.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoModificar;
	}

	public EncargadoBloque Buscar(Connection con, String IdEncargado) {
		EncargadoBloque c = new EncargadoBloque();
		try {
			PreparedStatement cl = con.prepareStatement(EncargadosBloquesSQL.Consultar(IdEncargado));
			ResultSet r = cl.executeQuery();
			while (r.next()) {
				c.setIdEncargado(r.getString(1));
				c.setCorreoEncargado(r.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return c;
		} finally {
			try {
				con.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOEncargadosBloques.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return c;
	}

	public int Eliminar(Connection c, EncargadoBloque EncBloque) {
		String sql = EncargadosBloquesSQL.Eliminar();
		int resultadoEliminar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, EncBloque.getIdEncargado());

			resultadoEliminar = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOEncargadosBloques.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOEncargadosBloques.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		return resultadoEliminar;
	}

	public List<EncargadoBloque> listarEncargadosBloques(Connection c) {
		List<EncargadoBloque> EncargadosBloques = new ArrayList<EncargadoBloque>();
		try {
			String sql = "SELECT Id_Encargado_Bloque, Correo_Encargado_Bloque FROM encargados_bloques";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EncargadoBloque EncB = new EncargadoBloque();
				EncB.setIdEncargado(rs.getString(1));
				EncB.setCorreoEncargado(rs.getString(2));
				EncargadosBloques.add(EncB);
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
		return EncargadosBloques;
	}
}
