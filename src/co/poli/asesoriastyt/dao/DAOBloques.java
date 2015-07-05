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
import co.poli.asesoriastyt.util.Conexion;


/**
 *  Class DAOBloques.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class DAOBloques {

	/**  Connection. */
	Conexion Connection = new Conexion();

	/**
	 * Crear.
	 *
	 * @param c  c
	 * @param Bloques  bloques
	 * @return  int
	 */
	public int Crear(Connection c, Bloque Bloques) {
		String sql = BloquesSQL.Crear();
		int resultadoCrear = 0;
		String id_Enc = null;

		try {
			ResultSet r = Connection.getConnection().prepareStatement("Select Id_Encargado_Bloque from encargados_bloques where Correo_Encargado_Bloque = '" + Bloques.getEncargadoBloque() + "'")
					.executeQuery();
			while (r.next()) {
				id_Enc = r.getString(1);
			}
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, Bloques.getIdBloque());
			st.setString(2, id_Enc);
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

	/**
	 * Modificar.
	 *
	 * @param c  c
	 * @param Bloques  bloques
	 * @return  int
	 */
	public int Modificar(Connection c, Bloque Bloques) {
		String sql = BloquesSQL.Modificar();
		int resultadoModificar = 0;
		String id_Enc = null;
		try {
			ResultSet r = Connection.getConnection().prepareStatement("Select Id_Encargado_Bloque from encargados_bloques where Correo_Encargado_Bloque = '" + Bloques.getEncargadoBloque() + "'")
					.executeQuery();
			while (r.next()) {
				id_Enc = r.getString(1);
			}
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, id_Enc);
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

	/**
	 * Buscar.
	 *
	 * @param con  con
	 * @param IdBloque  id bloque
	 * @return  bloque
	 */
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

	/**
	 * Eliminar.
	 *
	 * @param c  c
	 * @param Bloques  bloques
	 * @return  int
	 */
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

	/**
	 * Listar bloques.
	 *
	 * @param c  c
	 * @return  list
	 */
	public List<Bloque> listarBloques(Connection c) {
		List<Bloque> Bloques = new ArrayList<Bloque>();
		try {
			String sql = "SELECT bloques.Id_Bloque, encargados_bloques.Correo_Encargado_Bloque " +
					"FROM bloques, encargados_bloques WHERE bloques.Encargado_Bloque = encargados_bloques.Id_Encargado_Bloque;";
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
