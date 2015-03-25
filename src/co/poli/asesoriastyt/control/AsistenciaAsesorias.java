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

import co.poli.asesoriastyt.model.Asesoria;
import co.poli.asesoriastyt.negocio.NAsesoria;
import co.poli.asesoriastyt.util.Conexion;
import co.poli.asesoriastyt.util.SendEmail;

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
				int resultadoAsistir = new NAsesoria().Asistir((String) request.getSession().getAttribute("idUser"), (String) request.getSession().getAttribute("idAsesoria"));
				request.setAttribute("cli", resultadoAsistir);
				JOptionPane.showMessageDialog(null, "Usted se ha inscrito exitosamente, se enviará un mensaje de confirmación a su correo electrónico.", "AsesoriasTyT",
						JOptionPane.INFORMATION_MESSAGE);

				NAsesoria negocioC = new NAsesoria();
				Asesoria infoAsesoria = negocioC.Buscar((String) request.getSession().getAttribute("idAsesoria"));

				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("Hola \n Los datos de su asesoría son: \n Asignatura: ");
				stringBuilder.append(infoAsesoria.getAsignatura());
				stringBuilder.append("\n Docente: ");
				stringBuilder.append(infoAsesoria.getDocente());
				stringBuilder.append("\n Fecha: ");
				stringBuilder.append(infoAsesoria.getFecha());
				stringBuilder.append("\n Hora: ");
				stringBuilder.append(infoAsesoria.getHoraI());
				stringBuilder.append("\n Lugar: ");
				stringBuilder.append(infoAsesoria.getLugar());
				stringBuilder.append("\n Estudiante: ");
				stringBuilder.append(email);
				stringBuilder.append("\n En caso de alguna eventualidad se le informará oportunamente por este mismo medio. ");
				String mensaje = stringBuilder.toString();

				SendEmail.sendNotification(email, mensaje);
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
