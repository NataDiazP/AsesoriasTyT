package co.poli.asesoriastyt.control;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import co.poli.asesoriastyt.model.EstudianteAsesoria;
import co.poli.asesoriastyt.negocio.NAsesoria;
import co.poli.asesoriastyt.util.Conexion;

/**
 * Servlet implementation class AsistenciaAsesorias
 */
@WebServlet("/AsistenciaAsesorias")
public class AsistenciaAsesorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Conexion Connection = new Conexion();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AsistenciaAsesorias() {
		super();
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

		if ("Asistir".equals(request.getParameter("action"))) {
			EstudianteAsesoria estAse = new EstudianteAsesoria();
			String email = (String) request.getSession().getAttribute("emailUser");
			System.out.println(email);
			try {
				ResultSet r = Connection.getConnection().prepareStatement("Select NumDoc_Persona from personas where Correo_Persona = '" + email + "'").executeQuery();
				while (r.next()) {
					request.getSession().setAttribute("idUser", r.getString(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			int confirma = JOptionPane.showConfirmDialog(null, "¿Desea asistir a esta asesoría?");
			if (confirma == JOptionPane.YES_OPTION) {
				int resultadoAsistir = new NAsesoria().Asistir();
				request.setAttribute("cli", resultadoAsistir);
				JOptionPane.showMessageDialog(null, "Usted se ha inscrito exitosamente, se enviará un mensaje de confirmación a su correo electrónico.", "AsesoriasTyT",
						JOptionPane.INFORMATION_MESSAGE);
				response.sendRedirect("ListadoAsesorias.jsp");
			} else if (confirma == JOptionPane.NO_OPTION) {
				request.getRequestDispatcher("./ListadoAsesorias.jsp").forward(request, response);
			} else if (confirma == JOptionPane.CLOSED_OPTION) {
				request.getRequestDispatcher("./ListadoAsesorias.jsp").forward(request, response);
			} else if (confirma == JOptionPane.CANCEL_OPTION) {
				request.getRequestDispatcher("./ListadoAsesorias.jsp").forward(request, response);
			}
		}
	}

}
