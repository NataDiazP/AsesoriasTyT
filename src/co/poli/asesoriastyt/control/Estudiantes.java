package co.poli.asesoriastyt.control;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import co.poli.asesoriastyt.model.Persona;
import co.poli.asesoriastyt.negocio.NPersona;
import co.poli.asesoriastyt.util.Conexion;

/**
 * Servlet implementation class Estudiantes
 */
@WebServlet(description = "Controlador de maestro Estudiantes", urlPatterns = { "/Estudiantes" })
public class Estudiantes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Conexion Connection = new Conexion();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona Personas = new Persona();
		String documento = request.getParameter("IdPersona");
		String tipoDoc = request.getParameter("tipo");
		String nombre = request.getParameter("nombre");
		String apelldocumento1 = request.getParameter("apellido1");
		String apelldocumento2 = request.getParameter("apellido2");
		String genero = request.getParameter("genero");
		String fechaN = request.getParameter("fechaN");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String celular = request.getParameter("celular");
		String correo = request.getParameter("correo");
		String planEstudio = request.getParameter("plan");
		String semestre = request.getParameter("semestre");
		String estado = request.getParameter("estado");
		String perfil = request.getParameter("perfil");
		
		if (documento.equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, ingrese la documentoentificaci�n de la persona.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
			response.sendRedirect("Estudiantes.jsp");
		} else {
			Personas.setNumeroIdentificacion(documento);
			Personas.setTipoIdentificacion(tipoDoc);
			Personas.setNombreCompleto(nombre);
			Personas.setPrimerApellido(apelldocumento1);
			Personas.setSegundoApellido(apelldocumento2);
			Personas.setGenero(genero);
			Personas.setFechaNacimiento(fechaN);
			Personas.setDireccion(direccion);
			Personas.setTelefono(telefono);
			Personas.setCelular(celular);
			Personas.setCorreoElectronico(correo);
			Personas.setPlanEstudios_Estudiante(planEstudio);
			Personas.setSemestre_Estudiante(semestre);
			Personas.setEstado(estado);
			if (!perfil.equals("Seleccione"))
			{
				Personas.setPerfil(perfil);

				if ("Crear".equals(request.getParameter("action"))) {
					boolean registroExiste = false;
					try {
						ResultSet r = Connection.getConnection().prepareStatement("Select NumDoc_Persona from personas").executeQuery();
						while (r.next()) {
							if (documento.equals(r.getInt(1))) {
								registroExiste = true;
								JOptionPane.showMessageDialog(null, "Este registro ya existe, por favor verifique la documentoentificaci�n de la persona", "Advertencia - AsesoriasTyT",
										JOptionPane.WARNING_MESSAGE);
								request.getRequestDispatcher("./Estudiantes.jsp").forward(request, response);
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

					if (!registroExiste) {
						if (documento.equals("")) {
							JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de la persona.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
							request.getRequestDispatcher("./Estudiantes.jsp").forward(request, response);
						} else {
							int resultado = new NPersona().Crear(Personas);
							try {
								response.sendRedirect("Estudiantes.jsp");
								JOptionPane.showMessageDialog(null, "Se guardó correctamente.", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
								request.setAttribute("cli", resultado);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}

				if ("Modificar".equals(request.getParameter("action"))) {
					boolean registroExiste = false;
					int sw = 0;
					try {
						ResultSet r1 = Connection.getConnection().prepareStatement("Select NumDoc_Persona from personas").executeQuery();
						while (r1.next() && sw == 0) {
							if (!documento.equals(r1.getString(1)) && (!documento.equals(""))) {
								registroExiste = false;
							} else {
								registroExiste = true;
								sw = 1;
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

					if (registroExiste) {
						if (nombre.equals("")) {
							JOptionPane.showMessageDialog(null, "Campos vacios, por favor llenarlos.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
							response.sendRedirect("Estudiantes.jsp");
						} else {
							int confirma = JOptionPane.showConfirmDialog(null, "�Desea actualizar la informaci�n de esta persona?");
							if (confirma == JOptionPane.YES_OPTION) {
								int resultadoModificar = new NPersona().Modificar(Personas);
								request.setAttribute("cli", resultadoModificar);
								JOptionPane.showMessageDialog(null, "Se modificó correctamente", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
								response.sendRedirect("Estudiantes.jsp");
							} else if (confirma == JOptionPane.NO_OPTION) {
								request.getRequestDispatcher("./Estudiantes.jsp").forward(request, response);
							} else if (confirma == JOptionPane.CLOSED_OPTION) {
								request.getRequestDispatcher("./Estudiantes.jsp").forward(request, response);
							} else if (confirma == JOptionPane.CANCEL_OPTION) {
								request.getRequestDispatcher("./Estudiantes.jsp").forward(request, response);
							}
						}
					} else if (!registroExiste) {
						request.getRequestDispatcher("./Estudiantes.jsp").forward(request, response);
						JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la documentoentificación de la persona", "Advertencia - AsesoriasTyT",
								JOptionPane.WARNING_MESSAGE);
					}
				}

				if ("Consultar".equals(request.getParameter("action"))) {
					boolean registroExiste = false;
					int sw = 0;
					try {
						ResultSet r1 = Connection.getConnection().prepareStatement("Select NumDoc_Persona from personas").executeQuery();
						while (r1.next() && sw == 0) {
							if (!documento.equals(Integer.toString(r1.getInt(1))) && (!documento.equals(""))) {
								registroExiste = false;
							} else {
								registroExiste = true;
								sw = 1;
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

					if (registroExiste == true) {
						NPersona negocioC = new NPersona();
						try {
							Persona cli = negocioC.Buscar(documento);
							request.setAttribute("cli", cli);
							request.setAttribute("mensaje", "La persona fue encontrado con exito");
							request.getRequestDispatcher("./Estudiantes.jsp").forward(request, response);
						} catch (Exception ex) {
							Logger.getLogger(Estudiantes.class.getName()).log(Level.SEVERE, null, ex);
							request.setAttribute("mensaje", ex.getMessage());
						}
					} else if (!registroExiste) {
						response.sendRedirect("Estudiantes.jsp");
						JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la documentoentificación de la persona", "Advertencia - AsesoriasTyT",
								JOptionPane.WARNING_MESSAGE);
					}
				}

				if ("Eliminar".equals(request.getParameter("action"))) {
					boolean registroExiste = false;
					int sw = 0;
					try {
						ResultSet r = Connection.getConnection().prepareStatement("Select NumDoc_Persona from personas").executeQuery();
						while (r.next() && sw == 0) {
							if (!documento.equals(Integer.toString(r.getInt(1))) && (!documento.equals(""))) {
								registroExiste = false;
							} else {
								registroExiste = true;
								sw = 1;
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					if (registroExiste == true) {
						int confirma = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la información de este perfil?");
						if (confirma == JOptionPane.YES_OPTION) {
							int resultadoEliminar = new NPersona().Eliminar(Personas);
							request.setAttribute("cli", resultadoEliminar);
							JOptionPane.showMessageDialog(null, "Se eliminó correctamente", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
							response.sendRedirect("Estudiantes.jsp");
						} else if (confirma == JOptionPane.NO_OPTION) {
							request.getRequestDispatcher("./Estudiantes.jsp").forward(request, response);
						} else if (confirma == JOptionPane.CLOSED_OPTION) {
							request.getRequestDispatcher("./Estudiantes.jsp").forward(request, response);
						} else if (confirma == JOptionPane.CANCEL_OPTION) {
							request.getRequestDispatcher("./Estudiantes.jsp").forward(request, response);
						}
					} else if (!registroExiste) {
						JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la documentoentificaci�n de la persona", "Advertencia - AsesoriasTyT",
								JOptionPane.WARNING_MESSAGE);
						request.getRequestDispatcher("./Estudiantes.jsp").forward(request, response);
					}
				}
			}
		}
	}
}
