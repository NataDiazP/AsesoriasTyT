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

import co.poli.asesoriastyt.model.Perfil;
import co.poli.asesoriastyt.negocio.NPerfiles;
import co.poli.asesoriastyt.util.Conexion;


/**
 * Servlet implementation class Perfiles.
 */
@WebServlet(description = "Controlador de maestro perfiles", urlPatterns = { "/Perfiles" })
public class Perfiles extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Connection. */
	Conexion Connection = new Conexion();

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Perfil Perfiles = new Perfil();
		String id = request.getParameter("IdPerfil");
		String nom = request.getParameter("NombrePerfil");

		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, ingrese la identificación del perfil.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
			response.sendRedirect("Perfiles.jsp");
		} else {
			Perfiles.setIdPerfil(Integer.parseInt(request.getParameter("IdPerfil")));
			Perfiles.setNombrePerfil(request.getParameter("NombrePerfil"));

			if ("Crear".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				try {
					ResultSet r = Connection.getConnection().prepareStatement("Select Id_Perfil from perfiles").executeQuery();
					while (r.next()) {
						if (id.equals(Integer.toString(r.getInt(1)))) {
							registroExiste = true;
							JOptionPane.showMessageDialog(null, "Este registro ya existe, por favor verifique la identificación del perfil", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
							request.getRequestDispatcher("./Perfiles.jsp").forward(request, response);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				if (!registroExiste) {
					if (nom.equals("")) {
						JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del perfil.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
						request.getRequestDispatcher("./Perfiles.jsp").forward(request, response);
					} else {
						int resultado = new NPerfiles().Crear(Perfiles);
						try {
							response.sendRedirect("Perfiles.jsp");
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
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Perfil from perfiles").executeQuery();
					while (r1.next() && sw == 0) {
						if (!id.equals(r1.getString(1)) && (!id.equals(""))) {
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
					if (nom.equals("")) {
						JOptionPane.showMessageDialog(null, "Campos vacios, por favor llenarlos.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
						response.sendRedirect("Perfiles.jsp");
					} else {
						int confirma = JOptionPane.showConfirmDialog(null, "¿Desea actualizar la información de este perfil?");
						if (confirma == JOptionPane.YES_OPTION) {
							int resultadoModificar = new NPerfiles().Modificar(Perfiles);
							request.setAttribute("cli", resultadoModificar);
							JOptionPane.showMessageDialog(null, "Se modificó correctamente", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
							response.sendRedirect("Perfiles.jsp");
						} else if (confirma == JOptionPane.NO_OPTION) {
							request.getRequestDispatcher("./Perfiles.jsp").forward(request, response);
						} else if (confirma == JOptionPane.CLOSED_OPTION) {
							request.getRequestDispatcher("./Perfiles.jsp").forward(request, response);
						} else if (confirma == JOptionPane.CANCEL_OPTION) {
							request.getRequestDispatcher("./Perfiles.jsp").forward(request, response);
						}
					}
				} else if (!registroExiste) {
					request.getRequestDispatcher("./Perfiles.jsp").forward(request, response);
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación del perfil", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
				}
			}

			if ("Consultar".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				int sw = 0;
				try {
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Perfil from perfiles").executeQuery();
					while (r1.next() && sw == 0) {
						if (!id.equals(Integer.toString(r1.getInt(1))) && (!id.equals(""))) {
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
					NPerfiles negocioC = new NPerfiles();
					try {
						Perfil cli = negocioC.Buscar(Integer.parseInt(id));
						request.setAttribute("cli", cli);
						request.setAttribute("mensaje", "El perfil fue encontrado con exito");
						request.getRequestDispatcher("./Perfiles.jsp").forward(request, response);
					} catch (Exception ex) {
						Logger.getLogger(Perfiles.class.getName()).log(Level.SEVERE, null, ex);
						request.setAttribute("mensaje", ex.getMessage());
					}
				} else if (!registroExiste) {
					response.sendRedirect("Perfiles.jsp");
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación del perfil", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
				}
			}

			if ("Eliminar".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				int sw = 0;
				try {
					ResultSet r = Connection.getConnection().prepareStatement("Select Id_Perfil from perfiles").executeQuery();
					while (r.next() && sw == 0) {
						if (!id.equals(Integer.toString(r.getInt(1))) && (!id.equals(""))) {
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
						int resultadoEliminar = new NPerfiles().Eliminar(Perfiles);
						request.setAttribute("cli", resultadoEliminar);
						JOptionPane.showMessageDialog(null, "Se eliminó correctamente", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
						response.sendRedirect("Perfiles.jsp");
					} else if (confirma == JOptionPane.NO_OPTION) {
						request.getRequestDispatcher("./Perfiles.jsp").forward(request, response);
					} else if (confirma == JOptionPane.CLOSED_OPTION) {
						request.getRequestDispatcher("./Perfiles.jsp").forward(request, response);
					} else if (confirma == JOptionPane.CANCEL_OPTION) {
						request.getRequestDispatcher("./Perfiles.jsp").forward(request, response);
					}
				} else if (!registroExiste) {
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación del perfil", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
					request.getRequestDispatcher("./Perfiles.jsp").forward(request, response);
				}
			}
		}
	}
}
