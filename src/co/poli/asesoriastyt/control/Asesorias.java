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

import co.poli.asesoriastyt.model.Asesoria;
import co.poli.asesoriastyt.negocio.NAsesoria;
import co.poli.asesoriastyt.util.Conexion;

/**
 * Servlet implementation class Asesorias
 */
@WebServlet(description = "Controlador de maestro asesorias", urlPatterns = { "/Asesorias" })
public class Asesorias extends HttpServlet {
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
		Asesoria Asesorias = new Asesoria();
		String id = request.getParameter("IdAsesoria");
		String nombreAsesoria = request.getParameter("nombreAsesoria");
		String docente = request.getParameter("docente");
		String asignatura = request.getParameter("asignatura");
		String fecha = request.getParameter("fecha");
		String horaI = request.getParameter("horaI");
		String horaF = request.getParameter("docente");
		String lugar = request.getParameter("lugar");
		String cupos = request.getParameter("cupos");
		String cuposD = request.getParameter("cuposD");
		String recursosApoyo = request.getParameter("recursosApoyo");
		String observacion = request.getParameter("observacion");
		String estado = request.getParameter("estado");

		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, ingrese la identificación de la asesoría.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
			response.sendRedirect("Asesorias.jsp");
		} else {
			Asesorias.setIdAsesoria(id);
			Asesorias.setNombreAsesoria(nombreAsesoria);
			Asesorias.setDocente(docente);
			Asesorias.setAsignatura(asignatura);
			Asesorias.setFecha(fecha);
			Asesorias.setHoraI(horaI);
			Asesorias.setHoraF(horaF);
			Asesorias.setLugar(lugar);
			Asesorias.setCupos(cupos);
			Asesorias.setCuposD(cuposD);
			Asesorias.setRecursosApoyo(recursosApoyo);
			Asesorias.setObservaciones(observacion);
			Asesorias.setEstado(estado);

			if ("Crear".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				try {
					ResultSet r = Connection.getConnection().prepareStatement("Select Id_Asesoria from asesorias").executeQuery();
					while (r.next()) {
						if (id.equals(Integer.toString(r.getInt(1)))) {
							registroExiste = true;
							JOptionPane.showMessageDialog(null, "Este registro ya existe, por favor verifique la identificación de la asesor�a", "Advertencia - AsesoriasTyT",
									JOptionPane.WARNING_MESSAGE);
							request.getRequestDispatcher("./Asesorias.jsp").forward(request, response);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				if (!registroExiste) {
					if (docente.equals("")) {
						JOptionPane.showMessageDialog(null, "Por favor, ingrese el docente de la asesoría.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
						request.getRequestDispatcher("./Asesorias.jsp").forward(request, response);
					} else {
						int resultado = new NAsesoria().Crear(Asesorias);
						try {
							response.sendRedirect("Asesorias.jsp");
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
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Asesoria from asesorias").executeQuery();
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
					if (docente.equals("")) {
						JOptionPane.showMessageDialog(null, "Campos vacios, por favor llenarlos.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
						response.sendRedirect("Asesorias.jsp");
					} else {
						int confirma = JOptionPane.showConfirmDialog(null, "¿Desea actualizar la información de esta asesoria?");
						if (confirma == JOptionPane.YES_OPTION) {
							int resultadoModificar = new NAsesoria().Modificar(Asesorias);
							request.setAttribute("cli", resultadoModificar);
							JOptionPane.showMessageDialog(null, "Se modificó correctamente", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
							response.sendRedirect("Asesorias.jsp");
						} else if (confirma == JOptionPane.NO_OPTION) {
							request.getRequestDispatcher("./Asesorias.jsp").forward(request, response);
						} else if (confirma == JOptionPane.CLOSED_OPTION) {
							request.getRequestDispatcher("./Asesorias.jsp").forward(request, response);
						} else if (confirma == JOptionPane.CANCEL_OPTION) {
							request.getRequestDispatcher("./Asesorias.jsp").forward(request, response);
						}
					}
				} else if (!registroExiste) {
					request.getRequestDispatcher("./Asesorias.jsp").forward(request, response);
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación de la asesor�a", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
				}
			}

			if ("Consultar".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				int sw = 0;
				try {
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_Asesoria from asesorias").executeQuery();
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
					NAsesoria negocioC = new NAsesoria();
					try {
						Asesoria cli = negocioC.Buscar(id);
						request.setAttribute("cli", cli);
						request.setAttribute("mensaje", "El perfil fue encontrado con exito");
						request.getRequestDispatcher("./Asesorias.jsp").forward(request, response);
					} catch (Exception ex) {
						Logger.getLogger(Asesorias.class.getName()).log(Level.SEVERE, null, ex);
						request.setAttribute("mensaje", ex.getMessage());
					}
				} else if (!registroExiste) {
					response.sendRedirect("Asesorias.jsp");
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación de la asesor�a", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
				}
			}

			if ("Eliminar".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				int sw = 0;
				try {
					ResultSet r = Connection.getConnection().prepareStatement("Select Id_Asesoria from asesorias").executeQuery();
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
					int confirma = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la informaci�n de esta asesor�a?");
					if (confirma == JOptionPane.YES_OPTION) {
						int resultadoEliminar = new NAsesoria().Eliminar(Asesorias);
						request.setAttribute("cli", resultadoEliminar);
						JOptionPane.showMessageDialog(null, "Se elimin� correctamente", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
						response.sendRedirect("Asesorias.jsp");
					} else if (confirma == JOptionPane.NO_OPTION) {
						request.getRequestDispatcher("./Asesorias.jsp").forward(request, response);
					} else if (confirma == JOptionPane.CLOSED_OPTION) {
						request.getRequestDispatcher("./Asesorias.jsp").forward(request, response);
					} else if (confirma == JOptionPane.CANCEL_OPTION) {
						request.getRequestDispatcher("./Asesorias.jsp").forward(request, response);
					}
				} else if (!registroExiste) {
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificaci�n de la asesor�a", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
					request.getRequestDispatcher("./Asesorias.jsp").forward(request, response);
				}
			}
		}
	}
}
