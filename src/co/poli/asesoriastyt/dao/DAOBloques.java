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

import co.poli.asesoriastyt.model.Bloque;

/**
 * @author natad_000
 *
 */
public class DAOBloques {

	public int Crear(Connection c, Bloque Bloques) {
		String sql = BloquesSQL.Crear();
		int resultadoCrear = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, Bloques.getIdBloque());
			st.setString(2, Bloques.getEncargadoBloque());
			resultadoCrear = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOBloques.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOBloques.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoCrear;
	}

	public int Modificar(Connection c, Bloque Bloques) {
		String sql = BloquesSQL.Modificar();
		int resultadoModificar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, Bloques.getEncargadoBloque());
			st.setString(2, Bloques.getIdBloque());
			resultadoModificar = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOBloques.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOBloques.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoModificar;
	}

	public Bloque Buscar(Connection con, String IdBloque) {
		Bloque c = new Bloque();
		try {
			PreparedStatement cl = con.prepareStatement(BloquesSQL.Consultar(IdBloque));
			ResultSet r = cl.executeQuery();
			while (r.next()) {
				c.setIdBloque(r.getString(1));
				c.setEncargadoBloque(r.getString(2));
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

	public int Eliminar(Connection c, Bloque Bloques) {
		String sql = BloquesSQL.Eliminar();
		int resultadoEliminar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, Bloques.getIdBloque());

			resultadoEliminar = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOBloques.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOBloques.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		return resultadoEliminar;
	}
	
	public List<String> listarEnc(Connection c) {
		List<String> encargados = new ArrayList<String>();
		try {
			String sql = "SELECT Correo_Encargado_Bloque FROM encargados_bloques";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String encBloque;
				encBloque = rs.getString(1);
				encargados.add(encBloque);
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
		return encargados;
	}

	public List<Bloque> listarBloques(Connection c) {
		List<Bloque> Bloques = new ArrayList<Bloque>();
		try {
			String sql = "SELECT Id_Bloque, Encargado_Bloque FROM bloques";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bloque Bloq = new Bloque();
				Bloq.setIdBloque(rs.getString(1));
				Bloq.setEncargadoBloque(rs.getString(2));
				Bloques.add(Bloq);
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
		return Bloques;
	}
}
