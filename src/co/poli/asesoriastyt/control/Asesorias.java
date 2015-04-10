package co.poli.asesoriastyt.control;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
		Date fechaActual = null;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

//		String[] horaIArray = horaI.split(":");
//		String[] horaFArray = horaF.split(":");
//		int horaIni = Integer.parseInt(horaIArray[0]);
//		int minutIni = Integer.parseInt(horaIArray[1]);
//		int horaFin = Integer.parseInt(horaFArray[0]);
//		int minutFin = Integer.parseInt(horaFArray[1]);

		String[] arrayLugar = lugar.split(" - ");
		String bloque = "";
		if (arrayLugar.length > 1) {
			bloque = arrayLugar[0];
		}

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
					Calendar c1 = Calendar.getInstance();
					fechaActual = c1.getTime();

					Date fechaAsesoria = null;
					try {
						fechaAsesoria = formato.parse(fecha);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}

					if (fechaActual.after(fechaAsesoria))
					{
						JOptionPane.showMessageDialog(null, "La fecha de la asesoría no debe ser menor a la fecha actual.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
						request.getRequestDispatcher("./Asesorias.jsp").forward(request, response);
					} 
//					else if (horaFin < horaIni) {
//						JOptionPane.showMessageDialog(null, "La hora de fin de la asesoría no debe ser menor a la hora inicial.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
//						request.getRequestDispatcher("./Asesorias.jsp").forward(request, response);
//					} 
					else if (docente.equals("")) {
						JOptionPane.showMessageDialog(null, "Por favor, ingrese el docente de la asesoría.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
						request.getRequestDispatcher("./Asesorias.jsp").forward(request, response);
					} else {
						int resultado = new NAsesoria().Crear(Asesorias);
						try {
							response.sendRedirect("Asesorias.jsp");
							JOptionPane.showMessageDialog(null, "Se guardó correctamente.", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
							if (!("Biblioteca").equals(Asesorias.getLugar()) && !("Otro").equals(Asesorias.getLugar()) && !("Palmeras").equals(Asesorias.getLugar())  && 
									!("Almendros").equals(Asesorias.getLugar()) && !("Seleccione...").equals(Asesorias.getLugar())) {
								String emailEncargado = "";
								try {
									ResultSet r = Connection
											.getConnection()
											.prepareStatement(
													"Select eb.Correo_Encargado_Bloque from encargados_bloques eb, bloques b WHERE b.Id_Bloque = '" + bloque
															+ "' AND eb.Id_Encargado_Bloque = b.Encargado_Bloque").executeQuery();
									while (r.next()) {
										emailEncargado = r.getString(1);
									}
								} catch (SQLException e) {
									e.printStackTrace();
								}

								NPersona negocioP = new NPersona();
								Persona nombreDocente = negocioP.Buscar(Asesorias.getDocente());
								StringBuilder stringBuilder = new StringBuilder();
								String mensaje = "";

								stringBuilder.append("Cordial saludo, <br/> <br/>");
								stringBuilder.append("El docente ");
								stringBuilder.append(nombreDocente.getNombreCompleto() + " " + nombreDocente.getPrimerApellido() + " ");
								stringBuilder.append("con documento de identidad número " + nombreDocente.getNumeroIdentificacion());
								stringBuilder.append(" solicita el aula " + Asesorias.getLugar());
								stringBuilder.append(" para el día " + Asesorias.getFecha() + " a las " + Asesorias.getHoraI());
								stringBuilder.append(" con el fin de dictar una asesoría académica a sus estudiantes.");
								stringBuilder.append(" Por favor confirmar la reserva al correo del docente: ");
								stringBuilder.append(nombreDocente.getCorreoElectronico());
								stringBuilder
										.append("<br/> <br/> <i>Este correo fue enviado automáticamente desde un sistema programado. Para información en general comuníquese con el docente que solicita la reserva.<i/>");
								mensaje = stringBuilder.toString();

								SMTPConfig.sendMail("Solicitud reserva de aula", mensaje, emailEncargado);
							}
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
						if (estado.equals("Confirmada") || estado.equals("Ejecutada")) {
							confirma = JOptionPane.showConfirmDialog(null, "¿Desea actualizar la información de esta asesoría?");
						} else if (estado.equals("Pendiente")) {
							confirma = JOptionPane.showConfirmDialog(null, "¿Desea actualizar la información de esta asesoría y pasarla a estado Pendiente?");
						} else if (estado.equals("Cancelada")) {
							confirma = JOptionPane.showConfirmDialog(null, "¿Desea cancelar esta asesoría?");
						}
						if (confirma == JOptionPane.YES_OPTION) {
							int resultadoModificar = new NAsesoria().Modificar(Asesorias);
							request.setAttribute("cli", resultadoModificar);
							JOptionPane.showMessageDialog(null, "Se modificó correctamente la asesoría.\nSe notificará a los estudiantes inscritos.", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);

							NPersona negocioP = new NPersona();
							Persona nombreDocente = negocioP.Buscar(Asesorias.getDocente());
							List<EstudianteAsesoria> ListaAsistencia = new NAsesoria().ListadoAsistentes(id);
							String destinatarios = "";
							StringBuilder stringBuilder = new StringBuilder();
							String mensaje = "", asunto = "";

							if (ListaAsistencia.size() > 0 && !estado.equals("Ejecutada")) {
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
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación de la asesoría.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
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

