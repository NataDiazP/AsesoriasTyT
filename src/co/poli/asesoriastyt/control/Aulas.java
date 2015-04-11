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

import co.poli.asesoriastyt.model.Aula;
import co.poli.asesoriastyt.negocio.NAula;
import co.poli.asesoriastyt.util.Conexion;


/**
 * Servlet implementation class Aulas.
 */
@WebServlet("/Aulas")
public class Aulas extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Connection. */
	Conexion Connection = new Conexion();

	/**
	 * Instantiates a new aulas.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public Aulas() {

		// TODO Auto-generated constructor stub
	}

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
		// TODO Auto-generated method stub
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

		Aula Aulas = new Aula();
		String id = request.getParameter("IdAula");
		String enc = request.getParameter("IdBloque");

		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, ingrese la identificación del aula.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
			response.sendRedirect("Aulas.jsp");
		} else if (enc.equals("Seleccione") || enc.equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, ingrese el encargado del bloque.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
			request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
		} else {
			Aulas.setIdAula(request.getParameter("IdAula"));
			Aulas.setIdBloque(request.getParameter("IdBloque"));

			if ("Crear".equals(request.getParameter("action"))) {
				try {
					ResultSet r = Connection.getConnection().prepareStatement("Select Id_Aula, Id_Bloque_Aula from aulas").executeQuery();
					while (r.next()) {
						if (id.equals(r.getString(1)) && enc.equals(r.getString(2))) {
							JOptionPane.showMessageDialog(null, "Este registro ya existe, por favor verifique la identificación del bloque", "Advertencia - AsesoriasTyT",
									JOptionPane.WARNING_MESSAGE);
							request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				int resultado = new NAula().Crear(Aulas);
				try {
					response.sendRedirect("Aulas.jsp");
					JOptionPane.showMessageDialog(null, "Se guardó correctamente.", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
					request.setAttribute("cli", resultado);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if ("Modificar".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				int sw = 0;
				try {
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Aula, Id_Bloque_Aula from aulas").executeQuery();
					while (r1.next() && sw == 0) {
						if (!id.equals(r1.getString(1)) && (!id.equals("")) && !enc.equals(r1.getString(2)) && (!enc.equals(""))) {
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
					int confirma = JOptionPane.showConfirmDialog(null, "¿Desea actualizar la información de este bloque?");
					if (confirma == JOptionPane.YES_OPTION) {
						int resultadoModificar = new NAula().Modificar(Aulas);
						request.setAttribute("cli", resultadoModificar);
						JOptionPane.showMessageDialog(null, "Se modificó correctamente.", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
						response.sendRedirect("Aulas.jsp");
					} else if (confirma == JOptionPane.NO_OPTION) {
						request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
					} else if (confirma == JOptionPane.CLOSED_OPTION) {
						request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
					} else if (confirma == JOptionPane.CANCEL_OPTION) {
						request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
					}
				} else if (!registroExiste) {
					request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación del aula", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
				}
			}

			if ("Consultar".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				int sw = 0;
				try {
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Aula, Id_Bloque_Aula from aulas").executeQuery();
					while (r1.next() && sw == 0) {
						if (!id.equals(r1.getString(1)) && (!id.equals("")) && !enc.equals(r1.getString(2)) && (!enc.equals(""))) {
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
					NAula negocioC = new NAula();
					try {
						Aula cli = negocioC.Buscar(id);
						request.setAttribute("cli", cli);
						request.setAttribute("mensaje", "El aula fue encontrada con exito");
						request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
					} catch (Exception ex) {
						Logger.getLogger(Aulas.class.getName()).log(Level.SEVERE, null, ex);
						request.setAttribute("mensaje", ex.getMessage());
					}
				} else if (!registroExiste) {
					response.sendRedirect("Aulas.jsp");
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación del aula", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
				}
			}

			if ("Eliminar".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				int sw = 0;
				try {
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Aula, Id_Bloque_Aula from aulas").executeQuery();
					while (r1.next() && sw == 0) {
						if (!id.equals(r1.getString(1)) && (!id.equals("")) && !enc.equals(r1.getString(2)) && (!enc.equals(""))) {
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
					int confirma = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la información de esta aula?");
					if (confirma == JOptionPane.YES_OPTION) {
						int resultadoEliminar = new NAula().Eliminar(Aulas);
						request.setAttribute("cli", resultadoEliminar);
						JOptionPane.showMessageDialog(null, "Se eliminó correctamente.", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
						response.sendRedirect("Aulas.jsp");
					} else if (confirma == JOptionPane.NO_OPTION) {
						request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
					} else if (confirma == JOptionPane.CLOSED_OPTION) {
						request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
					} else if (confirma == JOptionPane.CANCEL_OPTION) {
						request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
					}
				} else if (!registroExiste) {
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación del aula", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
					request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
				}
			}
		}

	}

}
