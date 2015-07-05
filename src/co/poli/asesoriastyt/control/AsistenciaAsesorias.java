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
import co.poli.asesoriastyt.model.Persona;
import co.poli.asesoriastyt.negocio.NAsesoria;
import co.poli.asesoriastyt.negocio.NPersona;
import co.poli.asesoriastyt.util.Conexion;


/**
 * Servlet implementation class AsistenciaAsesorias.
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
@WebServlet("/AsistenciaAsesorias")
public class AsistenciaAsesorias extends HttpServlet {
	
	/**  Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  Connection. */
	Conexion Connection = new Conexion();

	/**
	 * Instantiates a new asistencia asesorias.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public AsistenciaAsesorias() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Do get.
	 *
	 * @param request  request
	 * @param response  response
	 * @throws ServletException  servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * Do post.
	 *
	 * @param request  request
	 * @param response  response
	 * @throws ServletException  servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		String[] actionArray = action.split("_");
		action = actionArray[0];
		String idAsesoria = "";
		if (actionArray.length > 1)
		{
			idAsesoria = actionArray[1];
		}

		if ("Asistir".equals(action)) {
			String email = (String) request.getSession().getAttribute("emailUser");
			boolean registroExiste = false;
			try {
				ResultSet r = Connection.getConnection().prepareStatement("Select NumDoc_Persona from personas where Correo_Persona = '" + email + "'").executeQuery();
				while (r.next()) {
					request.getSession().setAttribute("idUser", r.getString(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				ResultSet r = Connection.getConnection().prepareStatement("Select Id_Estudiante, Id_Asesoria from estudiantes_asesoria").executeQuery();
				while (r.next()) {
					if (((String) request.getSession().getAttribute("idUser")).equals(r.getString(1)) && idAsesoria.equals(Integer.toString(r.getInt(2)))) {
						registroExiste = true;
						JOptionPane.showMessageDialog(null, "Usted ya se ha inscrito a esta asesoría", "Advertencia - AsesoriasTyT",
								JOptionPane.WARNING_MESSAGE);
						request.getRequestDispatcher("./ListadoAsesorias.jsp").forward(request, response);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if (!registroExiste) {
				int confirma = JOptionPane.showConfirmDialog(null, "¿Desea asistir a esta asesoría?");
				if (confirma == JOptionPane.YES_OPTION) {
					int resultadoAsistir = new NAsesoria().Asistir((String) request.getSession().getAttribute("idUser"), idAsesoria);
					request.setAttribute("cli", resultadoAsistir);
					JOptionPane.showMessageDialog(null, "Usted se ha inscrito exitosamente, se enviará un mensaje de confirmación a su correo electrónico.", "AsesoriasTyT",
							JOptionPane.INFORMATION_MESSAGE);

					NAsesoria negocioC = new NAsesoria();
					NPersona negocioP = new NPersona();
					Asesoria infoAsesoria = negocioC.Buscar(idAsesoria);
					Persona nombreDocente = negocioP.Buscar(infoAsesoria.getDocente());

					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append("Hola <br/> <br/> Los datos de la asesoría a la que se ha inscrito son: <br/> Asignatura: ");
					stringBuilder.append(infoAsesoria.getAsignatura());
					stringBuilder.append("<br/> Docente: ");
					stringBuilder.append(nombreDocente.getNombreCompleto() + " " + nombreDocente.getPrimerApellido());
					stringBuilder.append("<br/> Fecha: ");
					stringBuilder.append(infoAsesoria.getFecha());
					stringBuilder.append("<br/> Hora: ");
					stringBuilder.append(infoAsesoria.getHoraI());
					stringBuilder.append("<br/> Lugar: ");
					stringBuilder.append(infoAsesoria.getLugar());
					stringBuilder.append("<br/> Observaciones: ");
					stringBuilder.append(infoAsesoria.getObservaciones());
					stringBuilder.append("<br/> Estudiante: ");
					stringBuilder.append(email);
					stringBuilder.append("<br/> <br/> <i>En caso de alguna eventualidad se le informará oportunamente por este mismo medio. <i/>");
					String mensaje = stringBuilder.toString();

					SMTPConfig.sendMail("Confirmación asesoría", mensaje, email);
					response.sendRedirect("./ListadoAsesorias.jsp");
				} else if (confirma == JOptionPane.NO_OPTION) {
					request.getRequestDispatcher("./ListadoAsesorias.jsp").forward(request, response);
				} else if (confirma == JOptionPane.CLOSED_OPTION) {
					request.getRequestDispatcher("./ListadoAsesorias.jsp").forward(request, response);
				} else if (confirma == JOptionPane.CANCEL_OPTION) {
					request.getRequestDispatcher("./ListadoAsesorias.jsp").forward(request, response);
				}
			}
		}

		if ("GuardarAsesoria".equals(action)) {
			int resultadoModificar = new NAsesoria().GuardarAsistencia("1", "1214719040", "Si");
			JOptionPane.showMessageDialog(null, "Se ha guardado correctamente la lista de asistencia.", "AsesoriasTyT",
					JOptionPane.INFORMATION_MESSAGE);
			request.setAttribute("cli", resultadoModificar);
			response.sendRedirect("Asesorias.jsp");
		}
	}
}
