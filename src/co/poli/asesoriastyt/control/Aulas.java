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
 * Servlet implementation class Aulas
 */
@WebServlet("/Aulas")
public class Aulas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Conexion Connection = new Conexion();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Aulas() {
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Aula Aulas = new Aula();
		String id = request.getParameter("IdAula");
		String enc = request.getParameter("IdBloque");

		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, ingrese la identificaci�n del Aula.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
			response.sendRedirect("Aulas.jsp");
		} else {
			Aulas.setIdAula(request.getParameter("IdAula"));
			Aulas.setIdBloque(request.getParameter("IdBloque"));

			if ("Crear".equals(request.getParameter("action"))) {
				try {
					ResultSet r = Connection.getConnection().prepareStatement("Select Id_Aula from aulas").executeQuery();
					while (r.next()) {
						if (id.equals(r.getString(1))) {
							JOptionPane.showMessageDialog(null, "Este registro ya existe, por favor verifique la identificación del bloque", "Advertencia - AsesoriasTyT",
									JOptionPane.WARNING_MESSAGE);
							request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				if (enc.equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el encargado del bloque.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
					request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
				} else {
					int resultado = new NAula().Crear(Aulas);
					try {
						response.sendRedirect("Aulas.jsp");
						JOptionPane.showMessageDialog(null, "Se guard� correctamente.", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
						request.setAttribute("cli", resultado);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			if ("Modificar".equals(request.getParameter("action"))) {
				if (enc.equals("")) {
					JOptionPane.showMessageDialog(null, "Campos vacios, por favor llenarlos.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
					response.sendRedirect("Aulas.jsp");
				} else if (id != null) {
					try {
						ResultSet r = Connection.getConnection().prepareStatement("Select Id_Aula from aulas").executeQuery();
						while (r.next()) {
							if (id.equals(r.getString(1))) {
								int confirma = JOptionPane.showConfirmDialog(null, "¿Desea actualizar la informaci�n de este bloque?");

								if (confirma == JOptionPane.YES_OPTION) {
									int resultadoModificar = new NAula().Modificar(Aulas);
									request.setAttribute("cli", resultadoModificar);
									JOptionPane.showMessageDialog(null, "Se modificó correctamente", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
									response.sendRedirect("Aulas.jsp");
								} else if (confirma == JOptionPane.NO_OPTION) {
									request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
								} else if (confirma == JOptionPane.CLOSED_OPTION) {
									request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
								} else if (confirma == JOptionPane.CANCEL_OPTION) {
									request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
								}
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

				try {
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Aula from aulas").executeQuery();
					while (r1.next()) {
						if (!id.equals(r1.getString(1)) && (!id.equals(""))) {
							request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
							JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificaci�n del bloque", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if ("Consultar".equals(request.getParameter("action"))) {

				try {
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Aula from aulas").executeQuery();
					while (r1.next()) {
						if (!id.equals(r1.getString(1)) && (!id.equals(""))) {
							response.sendRedirect("Aulas.jsp");
							JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación del bloque", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				NAula negocioC = new NAula();
				try {
					Aula cli = negocioC.Buscar(id);
					request.setAttribute("cli", cli);
					request.setAttribute("mensaje", "El bloque fue encontrado con exito");
					request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
				} catch (Exception ex) {
					Logger.getLogger(Aulas.class.getName()).log(Level.SEVERE, null, ex);
					request.setAttribute("mensaje", ex.getMessage());
				}
			}

			if ("Eliminar".equals(request.getParameter("action"))) {
				try {
					ResultSet r = Connection.getConnection().prepareStatement("Select Id_Aula from aulas").executeQuery();
					while (r.next()) {
						if (id.equals(r.getString(1))) {

							int confirma = JOptionPane.showConfirmDialog(null, "�Desea eliminar la información de este bloque?");

							if (confirma == JOptionPane.YES_OPTION) {
								int resultadoEliminar = new NAula().Eliminar(Aulas);
								request.setAttribute("cli", resultadoEliminar);
								JOptionPane.showMessageDialog(null, "Se elimin� correctamente.", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
								response.sendRedirect("Aulas.jsp");
							} else if (confirma == JOptionPane.NO_OPTION) {
								request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
							} else if (confirma == JOptionPane.CLOSED_OPTION) {
								request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
							} else if (confirma == JOptionPane.CANCEL_OPTION) {
								request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
							}
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				try {
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Aula from aulas").executeQuery();
					while (r1.next()) {
						if (!id.equals(r1.getString(1)) && (!id.equals(""))) {
							JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique el c�digo del Aula", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
							request.getRequestDispatcher("./Aulas.jsp").forward(request, response);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
