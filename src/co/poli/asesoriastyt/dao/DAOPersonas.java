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

import javax.swing.JOptionPane;

import co.poli.asesoriastyt.model.Persona;
import co.poli.asesoriastyt.util.Conexion;


/**
 * The Class DAOPersonas.
 *
 * @author pavargas
 */
public class DAOPersonas {

	/** The Connection. */
	Conexion Connection = new Conexion();

	/**
	 * Crear.
	 *
	 * @param c the c
	 * @param Personas the personas
	 * @return the int
	 */
	public int Crear(Connection c, Persona Personas) {
		String sql = PersonasSQL.Crear();
		int resultadoCrear = 0;
		int perfil = 0;

		try {
			ResultSet r = Connection.getConnection().prepareStatement("Select Id_Perfil from perfiles where Nombre_Perfil = '" + Personas.getPerfil() + "'")
					.executeQuery();
			while (r.next()) {
				perfil = r.getInt(1);
			}
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, Personas.getNumeroIdentificacion());
			st.setString(2, Personas.getTipoIdentificacion());
			st.setString(3, Personas.getNombreCompleto());
			st.setString(4, Personas.getPrimerApellido());
			st.setString(5, Personas.getSegundoApellido());
			st.setString(6, Personas.getGenero());
			st.setString(7, Personas.getFechaNacimiento());
			st.setString(8, Personas.getDireccion());
			st.setString(9, Personas.getTelefono());
			st.setString(10, Personas.getCelular());
			st.setString(11, Personas.getCorreoElectronico());
			st.setString(12, Personas.getPlanEstudios_Estudiante());
			st.setString(13, Personas.getSemestre_Estudiante());
			st.setString(14, Personas.getEstado());
			st.setInt(15, perfil);

			resultadoCrear = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOPersonas.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOPersonas.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoCrear;
	}
	
	/**
	 * Crear docentes.
	 *
	 * @param c the c
	 * @param listaDocentes the lista docentes
	 */
	public void CrearDocentes(Connection c, ArrayList<Persona> listaDocentes) {
		String sql = PersonasSQL.Crear();

		try {
			for(int i=0; i<listaDocentes.size();i++)
			{
				Persona persona= listaDocentes.get(i);
				
				PreparedStatement st = c.prepareStatement(sql);
	
				st.setString(1, persona.getNumeroIdentificacion());
				st.setString(2, persona.getTipoIdentificacion());
				st.setString(3, persona.getNombreCompleto());
				st.setString(4, persona.getPrimerApellido());
				st.setString(5, persona.getSegundoApellido());
				st.setString(6, persona.getGenero());
				st.setString(7, persona.getFechaNacimiento());
				st.setString(8, persona.getDireccion());
				st.setString(9, persona.getTelefono());
				st.setString(10, persona.getCelular());
				st.setString(11, persona.getCorreoElectronico());
				st.setString(12, persona.getPlanEstudios_Estudiante());
				st.setString(13, persona.getSemestre_Estudiante());
				st.setString(14, persona.getEstado());
				st.setString(15, persona.getPerfil());
				st.executeUpdate();
			}
				

		} catch (SQLException ex) {
			Logger.getLogger(DAOPersonas.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOPersonas.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	/**
	 * Modificar.
	 *
	 * @param c the c
	 * @param Personas the personas
	 * @return the int
	 */
	public int Modificar(Connection c, Persona Personas) {
		String sql = PersonasSQL.Modificar();
		int resultadoModificar = 0;
		int perfil = 0;

		try {
			ResultSet r = Connection.getConnection().prepareStatement("Select Id_Perfil from perfiles where Nombre_Perfil = '" + Personas.getPerfil() + "'")
					.executeQuery();
			while (r.next()) {
				perfil = r.getInt(1);
			}
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(15, Personas.getNumeroIdentificacion());
			st.setString(14, Personas.getTipoIdentificacion());
			st.setString(13, Personas.getNombreCompleto());
			st.setString(12, Personas.getPrimerApellido());
			st.setString(11, Personas.getSegundoApellido());
			st.setString(10, Personas.getGenero());
			st.setString(9, Personas.getFechaNacimiento());
			st.setString(8, Personas.getDireccion());
			st.setString(7, Personas.getTelefono());
			st.setString(6, Personas.getCelular());
			st.setString(5, Personas.getCorreoElectronico());
			st.setString(4, Personas.getPlanEstudios_Estudiante());
			st.setString(3, Personas.getSemestre_Estudiante());
			st.setString(2, Personas.getEstado());
			st.setInt(1, perfil);

			resultadoModificar = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOPersonas.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOPersonas.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return resultadoModificar;
	}

	/**
	 * Buscar docente.
	 *
	 * @param con the con
	 * @param Email the email
	 * @return the string
	 */
	public String BuscarDocente(Connection con, String Email) {
		String idDocente = null;
		try {
			PreparedStatement cl = con.prepareStatement("Select NumDoc_Persona from personas where Correo_Persona ='" + Email + "'");
			ResultSet r = cl.executeQuery();
			while (r.next()) {
				idDocente = r.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return idDocente;
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
			}

		}
		return idDocente;
	}

	/**
	 * Buscar.
	 *
	 * @param con the con
	 * @param IdPersona the id persona
	 * @return the persona
	 */
	public Persona Buscar(Connection con, String IdPersona) {
		Persona c = new Persona();
		try {
			PreparedStatement cl = con.prepareStatement(PersonasSQL.Consultar(IdPersona));
			ResultSet r = cl.executeQuery();
			while (r.next()) {
				c.setNumeroIdentificacion(r.getString(1));
				c.setTipoIdentificacion(r.getString(2));
				c.setNombreCompleto(r.getString(3));
				c.setPrimerApellido(r.getString(4));
				c.setSegundoApellido(r.getString(5));
				c.setGenero(r.getString(6));
				c.setFechaNacimiento(r.getString(7));
				c.setDireccion(r.getString(8));
				c.setTelefono(r.getString(9));
				c.setCelular(r.getString(10));
				c.setCorreoElectronico(r.getString(11));
				c.setPlanEstudios_Estudiante(r.getString(12));
				c.setSemestre_Estudiante(r.getString(13));
				c.setEstado(r.getString(14));
				c.setPerfil(r.getString(15));

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
	 * @param Personas the personas
	 * @return the int
	 */
	public int Eliminar(Connection c, Persona Personas) {
		String sql = PersonasSQL.Eliminar();
		int resultadoEliminar = 0;
		try {
			PreparedStatement st = c.prepareStatement(sql);

			st.setString(1, Personas.getNumeroIdentificacion());

			resultadoEliminar = st.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(DAOPersonas.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			try {
				c.close();
			} catch (SQLException ex) {
				Logger.getLogger(DAOPersonas.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		return resultadoEliminar;
	}

	/**
	 * Listar personas.
	 *
	 * @param c the c
	 * @return the list
	 */
	public List<Persona> listarPersonas(Connection c) {
		List<Persona> Personas = new ArrayList<Persona>();
		try {
			String sql = "SELECT * FROM personas";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				Persona Per = new Persona();
				Per.setNumeroIdentificacion(r.getString(1));
				Per.setTipoIdentificacion(r.getString(2));
				Per.setNombreCompleto(r.getString(3));
				Per.setPrimerApellido(r.getString(4));
				Per.setSegundoApellido(r.getString(5));
				Per.setGenero(r.getString(6));
				Per.setFechaNacimiento(r.getString(7));
				Per.setDireccion(r.getString(8));
				Per.setTelefono(r.getString(9));
				Per.setCelular(r.getString(10));
				Per.setCorreoElectronico(r.getString(11));
				Per.setPlanEstudios_Estudiante(r.getString(12));
				Per.setSemestre_Estudiante(r.getString(13));
				Per.setEstado(r.getString(14));
				Per.setPerfil(r.getString(15));
				Personas.add(Per);
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
		return Personas;
	}

	/**
	 * Listar personas docentes.
	 *
	 * @param c the c
	 * @return the list
	 */
	public List<Persona> listarPersonasDocentes(Connection c) {
		List<Persona> Personas = new ArrayList<Persona>();
		try {
			String sql = "SELECT * FROM personas  where Perfil_Persona ='2'";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				Persona Per = new Persona();
				Per.setNumeroIdentificacion(r.getString(1));
				Per.setTipoIdentificacion(r.getString(2));
				Per.setNombreCompleto(r.getString(3));
				Per.setPrimerApellido(r.getString(4));
				Per.setSegundoApellido(r.getString(5));
				Per.setGenero(r.getString(6));
				Per.setFechaNacimiento(r.getString(7));
				Per.setDireccion(r.getString(8));
				Per.setTelefono(r.getString(9));
				Per.setCelular(r.getString(10));
				Per.setCorreoElectronico(r.getString(11));
				Per.setPlanEstudios_Estudiante(r.getString(12));
				Per.setSemestre_Estudiante(r.getString(13));
				Per.setEstado(r.getString(14));
				Per.setPerfil(r.getString(15));
				Personas.add(Per);
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
		return Personas;
	}

	/**
	 * Listar personas estudiantes.
	 *
	 * @param c the c
	 * @return the list
	 */
	public List<Persona> listarPersonasEstudiantes(Connection c) {
		List<Persona> Personas = new ArrayList<Persona>();
		try {
			String sql = "SELECT * FROM personas where Perfil_Persona ='3'";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				Persona Per = new Persona();
				Per.setNumeroIdentificacion(r.getString(1));
				Per.setTipoIdentificacion(r.getString(2));
				Per.setNombreCompleto(r.getString(3));
				Per.setPrimerApellido(r.getString(4));
				Per.setSegundoApellido(r.getString(5));
				Per.setGenero(r.getString(6));
				Per.setFechaNacimiento(r.getString(7));
				Per.setDireccion(r.getString(8));
				Per.setTelefono(r.getString(9));
				Per.setCelular(r.getString(10));
				Per.setCorreoElectronico(r.getString(11));
				Per.setPlanEstudios_Estudiante(r.getString(12));
				Per.setSemestre_Estudiante(r.getString(13));
				Per.setEstado(r.getString(14));
				Per.setPerfil(r.getString(15));
				Personas.add(Per);
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
		return Personas;
	}

	/**
	 * Validar existencia persona.
	 *
	 * @param c the c
	 * @param documento the documento
	 * @return true, if successful
	 */
	public boolean validarExistenciaPersona(Connection c,String documento) {
		
		boolean validar= false;
		try {
			ResultSet r = Connection.getConnection().prepareStatement("Select NumDoc_Persona from personas where NumDoc_Persona='"+documento+"'").executeQuery();
			while (r.next()) {
				validar=true;
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return validar;
	}

	/**
	 * Validar existencia correo.
	 *
	 * @param c the c
	 * @param correo the correo
	 * @return true, if successful
	 */
	public boolean validarExistenciaCorreo(Connection c, String correo) {
		boolean validar= false;
		try {
			ResultSet r = Connection.getConnection().prepareStatement("Select Correo_Persona from personas where Correo_Persona='"+correo+"'").executeQuery();
			while (r.next()) {
				validar=true;
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return validar;
	}
}
