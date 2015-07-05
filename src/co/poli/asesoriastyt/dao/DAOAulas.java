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

import co.poli.asesoriastyt.model.Aula;


/**
 *  Class DAOAulas.
 *
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class DAOAulas {

	/**
	 * Crear.
	 *
	 * @param c  c
	 * @param Aula  aula
	 * @return  int
	 */
	public int Crear(Connection c, Aula Aula) {
		String sql = AulasSQL.Crear();
		int resultadoCrear = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, Aula.getIdAula());
			st.setString(2, Aula.getIdBloque());
			resultadoCrear = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOAulas.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOAulas.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoCrear;
	}

	/**
	 * Modificar.
	 *
	 * @param c  c
	 * @param Aula  aula
	 * @return  int
	 */
	public int Modificar(Connection c, Aula Aula) {
		String sql = AulasSQL.Modificar();
		int resultadoModificar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, Aula.getIdBloque());
			st.setString(2, Aula.getIdAula());
			resultadoModificar = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOAulas.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOAulas.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoModificar;
	}

	/**
	 * Buscar.
	 *
	 * @param con  con
	 * @param IdAula  id aula
	 * @return  aula
	 */
	public Aula Buscar(Connection con, String IdAula) {
		Aula c = new Aula();
		try {
			PreparedStatement cl = con.prepareStatement(AulasSQL.Consultar(IdAula));
			ResultSet r = cl.executeQuery();
			while (r.next()) {
				c.setIdAula(r.getString(1));
				c.setIdBloque(r.getString(2));
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
	 * @param Aula  aula
	 * @return  int
	 */
	public int Eliminar(Connection c, Aula Aula) {
		String sql = AulasSQL.Eliminar();
		int resultadoEliminar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, Aula.getIdAula());
			st.setString(2, Aula.getIdBloque());

			resultadoEliminar = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOAulas.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOAulas.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		return resultadoEliminar;
	}

	/**
	 * Listar aula.
	 *
	 * @param c  c
	 * @return  list
	 */
	public List<Aula> listarAula(Connection c) {
		List<Aula> Aula = new ArrayList<Aula>();
		try {
			String sql = "SELECT Id_Aula, Id_Bloque_Aula FROM aulas";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Aula Bloq = new Aula();
				Bloq.setIdAula(rs.getString(1));
				Bloq.setIdBloque(rs.getString(2));
				Aula.add(Bloq);
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
		return Aula;
	}
}
