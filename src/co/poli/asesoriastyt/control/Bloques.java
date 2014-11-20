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

import co.poli.asesoriastyt.model.Bloque;
import co.poli.asesoriastyt.negocio.NBloque;
import co.poli.asesoriastyt.util.Conexion;

/**
 * Servlet implementation class Bloques
 */
@WebServlet("/Bloques")
public class Bloques extends HttpServlet {
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
		Bloque Bloques = new Bloque();
		String id = request.getParameter("IdBloque");
		String enc = request.getParameter("EncargadoBloque");

		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, ingrese la identificación del bloque.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
			response.sendRedirect("Bloques.jsp");
		} else {
			Bloques.setIdBloque(request.getParameter("IdBloque"));
			Bloques.setEncargadoBloque(request.getParameter("EncargadoBloque"));

			if ("Crear".equals(request.getParameter("action"))) {
				try {
					ResultSet r = Connection.getConnection().prepareStatement("Select Id_Bloque from bloques").executeQuery();
					while (r.next()) {
						if (id.equals(r.getString(1))) {
							JOptionPane.showMessageDialog(null, "Este registro ya existe, por favor verifique la identificación del bloque", "Advertencia - AsesoriasTyT",
									JOptionPane.WARNING_MESSAGE);
							request.getRequestDispatcher("./Bloques.jsp").forward(request, response);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				if (enc.equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el encargado del bloque.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
					request.getRequestDispatcher("./Bloques.jsp").forward(request, response);
				} else {
					int resultado = new NBloque().Crear(Bloques);
					try {
						response.sendRedirect("Bloques.jsp");
						JOptionPane.showMessageDialog(null, "Se guardó correctamente.", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
						request.setAttribute("cli", resultado);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			if ("Modificar".equals(request.getParameter("action"))) {
				if (enc.equals("")) {
					JOptionPane.showMessageDialog(null, "Campos vacios, por favor llenarlos.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
					response.sendRedirect("Bloques.jsp");
				} else if (id != null) {
					try {
						ResultSet r = Connection.getConnection().prepareStatement("Select Id_Bloque from bloques").executeQuery();
						while (r.next()) {
							if (id.equals(r.getString(1))) {
								int confirma = JOptionPane.showConfirmDialog(null, "¿Desea actualizar la información de este bloque?");

								if (confirma == JOptionPane.YES_OPTION) {
									int resultadoModificar = new NBloque().Modificar(Bloques);
									request.setAttribute("cli", resultadoModificar);
									JOptionPane.showMessageDialog(null, "Se modificó correctamente", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
									response.sendRedirect("Bloques.jsp");
								} else if (confirma == JOptionPane.NO_OPTION) {
									request.getRequestDispatcher("./Bloques.jsp").forward(request, response);
								} else if (confirma == JOptionPane.CLOSED_OPTION) {
									request.getRequestDispatcher("./Bloques.jsp").forward(request, response);
								} else if (confirma == JOptionPane.CANCEL_OPTION) {
									request.getRequestDispatcher("./Bloques.jsp").forward(request, response);
								}
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				try {
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Bloque from bloques").executeQuery();
					while (r1.next()) {
						if (!id.equals(r1.getString(1)) && (!id.equals(""))) {
							request.getRequestDispatcher("./Bloques.jsp").forward(request, response);
							JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación del bloque", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if ("Consultar".equals(request.getParameter("action"))) {

				try {
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Bloque from bloques").executeQuery();
					while (r1.next()) {
						if (!id.equals(r1.getString(1)) && (!id.equals(""))) {
							response.sendRedirect("Bloques.jsp");
							JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación del bloque", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				NBloque negocioC = new NBloque();
				try {
					Bloque cli = negocioC.Buscar(id);
					request.setAttribute("cli", cli);
					request.setAttribute("mensaje", "El bloque fue encontrado con exito");
					request.getRequestDispatcher("./Bloques.jsp").forward(request, response);
				} catch (Exception ex) {
					Logger.getLogger(Bloques.class.getName()).log(Level.SEVERE, null, ex);
					request.setAttribute("mensaje", ex.getMessage());
				}
			}

			if ("Eliminar".equals(request.getParameter("action"))) {
				try {
					ResultSet r = Connection.getConnection().prepareStatement("Select Id_Bloque from bloques").executeQuery();
					while (r.next()) {
						if (id.equals(r.getString(1))) {

							int confirma = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la información de este bloque?");

							if (confirma == JOptionPane.YES_OPTION) {
								int resultadoEliminar = new NBloque().Eliminar(Bloques);
								request.setAttribute("cli", resultadoEliminar);
								JOptionPane.showMessageDialog(null, "Se eliminó correctamente.", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
								response.sendRedirect("Bloques.jsp");
							} else if (confirma == JOptionPane.NO_OPTION) {
								request.getRequestDispatcher("./Bloques.jsp").forward(request, response);
							} else if (confirma == JOptionPane.CLOSED_OPTION) {
								request.getRequestDispatcher("./Bloques.jsp").forward(request, response);
							} else if (confirma == JOptionPane.CANCEL_OPTION) {
								request.getRequestDispatcher("./Bloques.jsp").forward(request, response);
							}
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				try {
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Bloque from bloques").executeQuery();
					while (r1.next()) {
						if (!id.equals(r1.getString(1)) && (!id.equals(""))) {
							JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación del bloque", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
							request.getRequestDispatcher("./Bloques.jsp").forward(request, response);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}