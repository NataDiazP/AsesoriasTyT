package co.poli.asesoriastyt.control;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import co.poli.asesoriastyt.model.Asesoria;
import co.poli.asesoriastyt.model.EstudianteAsesoria;
import co.poli.asesoriastyt.model.Persona;
import co.poli.asesoriastyt.negocio.NAsesoria;
import co.poli.asesoriastyt.negocio.NPersona;
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
		String id = request.getParameter("id");
		String nombreAsesoria = request.getParameter("nombreAsesoria");
		String docente = request.getParameter("docente");
		String asignatura = request.getParameter("asignatura");
		String fecha = request.getParameter("fecha");
		String horaI = request.getParameter("horaI");
		String horaF = request.getParameter("horaF");
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

			if ("EstInscritos".equals(request.getParameter("action"))) {
				NAsesoria nAses = new NAsesoria();
				try {
					List<EstudianteAsesoria> ListaAsistencia = nAses.ListadoAsistentes(id);
					request.setAttribute("ListaAsistencia", ListaAsistencia);
					request.getRequestDispatcher("./AsistenciaAsesorias.jsp").forward(request, response);
				} catch (Exception ex) {
					Logger.getLogger(Asesorias.class.getName()).log(Level.SEVERE, null, ex);
					request.setAttribute("mensaje", ex.getMessage());
				}
			}

			if ("Crear".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				try {
					ResultSet r = Connection.getConnection().prepareStatement("Select Id_Asesoria from asesorias").executeQuery();
					while (r.next()) {
						if (id.equals(Integer.toString(r.getInt(1)))) {
							registroExiste = true;
							JOptionPane.showMessageDialog(null, "Este registro ya existe, por favor verifique la identificación de la asesoría", "Advertencia - AsesoriasTyT",
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
						int confirma = 0;
						if (estado.equals("Confirmada")) {
							confirma = JOptionPane.showConfirmDialog(null, "¿Desea actualizar la información de esta asesoría?");
						} else if (estado.equals("Pendiente")) {
							confirma = JOptionPane.showConfirmDialog(null, "¿Desea actualizar la información de esta asesoría y pasarla a estado Pendiente?");
						} else if (estado.equals("Cancelada")) {
							confirma = JOptionPane.showConfirmDialog(null, "¿Desea cancelar esta asesoría?");
						}
						if (confirma == JOptionPane.YES_OPTION) {
							int resultadoModificar = new NAsesoria().Modificar(Asesorias);
							request.setAttribute("cli", resultadoModificar);
							JOptionPane.showMessageDialog(null, "Se modificó correctamente la asesoría.\n Se notificará a los estudiantes inscritos.", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);

							NPersona negocioP = new NPersona();
							Persona nombreDocente = negocioP.Buscar(Asesorias.getDocente());
							List<EstudianteAsesoria> ListaAsistencia = new NAsesoria().ListadoAsistentes(id);
							String destinatarios = "";
							StringBuilder stringBuilder = new StringBuilder();
							String mensaje = "", asunto = "";

							if (ListaAsistencia.size() > 0) {
								if (estado.equals("Confirmada") || estado.equals("Pendiente")) {
									asunto = "Actualización en asesoría";
									stringBuilder.append("Hola <br/> <br/>");
									stringBuilder.append("Se han realizado actualizaciones en la asesoría a la que se encuentra"
											+ " inscrito con el docente " + nombreDocente.getNombreCompleto() + " " + nombreDocente.getPrimerApellido() + ":");
									stringBuilder.append("<br/> <br/> Asignatura: ");
									stringBuilder.append(Asesorias.getAsignatura());
									stringBuilder.append("<br/> Fecha: ");
									stringBuilder.append(Asesorias.getFecha());
									stringBuilder.append("<br/> Hora: ");
									stringBuilder.append(Asesorias.getHoraI());
									stringBuilder.append("<br/> Lugar: ");
									stringBuilder.append(Asesorias.getLugar());
									stringBuilder.append("<br/> Observaciones: ");
									stringBuilder.append(Asesorias.getObservaciones());
									stringBuilder.append("<br/> Estado: ");
									stringBuilder.append(Asesorias.getEstado());
									stringBuilder.append("<br/> <br/> <i>En caso de alguna eventualidad se le informará oportunamente por este mismo medio. <i/>");
								} else if (estado.equals("Cancelada")) {
									asunto = "Cancelación asesoría";
									stringBuilder.append("Hola <br/> <br/> Se ha cancelado la asesoría con el docente " + nombreDocente.getNombreCompleto()
											+ " " + nombreDocente.getPrimerApellido() + " a la que usted estaba inscrito.");
								}

								mensaje = stringBuilder.toString();
								for (EstudianteAsesoria estudianteAsesoria : ListaAsistencia) {
									destinatarios = destinatarios + estudianteAsesoria.getEmailEstudiante() + ",";
								}

								SMTPConfig.sendMail(asunto, mensaje, destinatarios);
							}
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
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación de la asesoría", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación de la asesoría", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
}
