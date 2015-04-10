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

import co.poli.asesoriastyt.model.EncargadoBloque;
import co.poli.asesoriastyt.negocio.NEncargadoBloque;
import co.poli.asesoriastyt.util.Conexion;

/**
 * Servlet implementation class EncargadosBloques
 */
@WebServlet("/EncargadosBloques")
public class EncargadosBloques extends HttpServlet {
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
		EncargadoBloque EncBloques = new EncargadoBloque();
		String id = request.getParameter("IdEncargado");
		String cor = request.getParameter("CorreoEncargado");

		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, ingrese la identificación del encargado.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
			response.sendRedirect("EncargadoBloque.jsp");
		} else {
			EncBloques.setIdEncargado(request.getParameter("IdEncargado"));
			EncBloques.setCorreoEncargado(request.getParameter("CorreoEncargado"));

			if ("Crear".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				try {
					ResultSet r = Connection.getConnection().prepareStatement("Select Id_Encargado_Bloque from encargados_bloques").executeQuery();
					while (r.next()) {
						if (id.equals(r.getString(1))) {
							registroExiste = true;
							JOptionPane.showMessageDialog(null, "Este registro ya existe, por favor verifique la identificación del encargado", "Advertencia - AsesoriasTyT",
									JOptionPane.WARNING_MESSAGE);
							request.getRequestDispatcher("./EncargadoBloque.jsp").forward(request, response);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				if (!registroExiste) {
					if (cor.equals("")) {
						JOptionPane.showMessageDialog(null, "Por favor, ingrese el correo del encargado.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
						request.getRequestDispatcher("./EncargadoBloque.jsp").forward(request, response);
					} else {
						boolean correoExiste = false;
						try {
							ResultSet r = Connection.getConnection().prepareStatement("Select Correo_Encargado_Bloque from encargados_bloques").executeQuery();
							while (r.next()) {
								if (cor.equals(r.getString(1))) {
									correoExiste = true;
								}
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}

						if (correoExiste) {
							JOptionPane.showMessageDialog(null, "Ya se ha ingresado un encargado con este correo electrónico, por favor verifique la información.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
							request.getRequestDispatcher("./EncargadoBloque.jsp").forward(request, response);
						} else if (correoExiste == false) {
							int resultado = new NEncargadoBloque().Crear(EncBloques);
							try {
								response.sendRedirect("EncargadoBloque.jsp");
								JOptionPane.showMessageDialog(null, "Se guardó correctamente.", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
								request.setAttribute("cli", resultado);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}

			if ("Modificar".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				int sw = 0;
				try {
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Encargado_Bloque from encargados_bloques").executeQuery();
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
					if (cor.equals("")) {
						JOptionPane.showMessageDialog(null, "Campos vacios, por favor llenarlos.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
						response.sendRedirect("EncargadoBloque.jsp");
					} else {
						boolean correoExiste = false;
						try {
							ResultSet r = Connection.getConnection().prepareStatement("Select Correo_Encargado_Bloque from encargados_bloques").executeQuery();
							while (r.next()) {
								if (cor.equals(r.getString(1))) {
									correoExiste = true;
								}
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						if (correoExiste) {
							JOptionPane.showMessageDialog(null, "Este correo electrónico ya existe, por favor verifiquelo.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
							request.getRequestDispatcher("./EncargadoBloque.jsp").forward(request, response);
						} else if (!correoExiste) {
							int confirma = JOptionPane.showConfirmDialog(null, "¿Desea actualizar la información de este encargado?");
							if (confirma == JOptionPane.YES_OPTION) {
								int resultadoModificar = new NEncargadoBloque().Modificar(EncBloques);
								request.setAttribute("cli", resultadoModificar);
								JOptionPane.showMessageDialog(null, "Se modificó correctamente", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
								response.sendRedirect("EncargadoBloque.jsp");
							} else if (confirma == JOptionPane.NO_OPTION) {
								request.getRequestDispatcher("./EncargadoBloque.jsp").forward(request, response);
							} else if (confirma == JOptionPane.CLOSED_OPTION) {
								request.getRequestDispatcher("./EncargadoBloque.jsp").forward(request, response);
							} else if (confirma == JOptionPane.CANCEL_OPTION) {
								request.getRequestDispatcher("./EncargadoBloque.jsp").forward(request, response);
							}
						}
					}
				} else if (!registroExiste) {
					request.getRequestDispatcher("./EncargadoBloque.jsp").forward(request, response);
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación del encargado", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
				}
			}

			if ("Consultar".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				int sw = 0;
				try {
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Encargado_Bloque from encargados_bloques").executeQuery();
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
				if (registroExiste == true) {
					NEncargadoBloque negocioC = new NEncargadoBloque();
					try {
						EncargadoBloque cli = negocioC.Buscar(id);
						request.setAttribute("cli", cli);
						request.setAttribute("mensaje", "El encargado fue encontrado con exito");
						request.getRequestDispatcher("./EncargadoBloque.jsp").forward(request, response);
					} catch (Exception ex) {
						Logger.getLogger(EncargadosBloques.class.getName()).log(Level.SEVERE, null, ex);
						request.setAttribute("mensaje", ex.getMessage());
					}
				} else if (!registroExiste) {
					response.sendRedirect("EncargadoBloque.jsp");
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación del encargado", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
				}
			}

			if ("Eliminar".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				int sw = 0;
				try {
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Encargado_Bloque from encargados_bloques").executeQuery();
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
				
				if (registroExiste == true) {
					int confirma = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la información de este encargado?");
					if (confirma == JOptionPane.YES_OPTION) {
						int resultadoEliminar = new NEncargadoBloque().Eliminar(EncBloques);
						request.setAttribute("cli", resultadoEliminar);
						JOptionPane.showMessageDialog(null, "Se eliminó correctamente.", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
						response.sendRedirect("EncargadoBloque.jsp");
					} else if (confirma == JOptionPane.NO_OPTION) {
						request.getRequestDispatcher("./EncargadoBloque.jsp").forward(request, response);
					} else if (confirma == JOptionPane.CLOSED_OPTION) {
						request.getRequestDispatcher("./EncargadoBloque.jsp").forward(request, response);
					} else if (confirma == JOptionPane.CANCEL_OPTION) {
						request.getRequestDispatcher("./EncargadoBloque.jsp").forward(request, response);
					}
				} else if (!registroExiste) {
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación del encargado", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
					request.getRequestDispatcher("./EncargadoBloque.jsp").forward(request, response);
				}
			}
		}
	}
}
