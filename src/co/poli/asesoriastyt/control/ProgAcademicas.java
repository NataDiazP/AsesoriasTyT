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

import co.poli.asesoriastyt.model.ProgAcademica;
import co.poli.asesoriastyt.negocio.NProgAcademica;
import co.poli.asesoriastyt.util.Conexion;


/**
 * Servlet implementation class ProgAcademicas.
 */
@WebServlet("/ProgAcademicas")
public class ProgAcademicas extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Connection. */
	Conexion Connection = new Conexion();

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
		ProgAcademica ProgAcademica = new ProgAcademica();
		String id = request.getParameter("IdProgAcademica");
		String docente = request.getParameter("docenteProgAcademica");
		String asignatura = request.getParameter("asignaturaProgAcademica");
		String grupo = request.getParameter("grupoAsignatura");
		String nroEst = request.getParameter("nroEstAsignatura");
		String diasAsig = request.getParameter("diasAsignatura");
		String horaIni = request.getParameter("horaInicialAsig");
		String horaFin = request.getParameter("horaFinAsig");
		String aulaClase = request.getParameter("aulaClaseProg");
		String semestreProgAcademica = request.getParameter("semestreProgAcademica");
		String anoProgAcademica = request.getParameter("anoProgAcademica");

		if ("Aceptar".equals(request.getParameter("action"))) {
			String liDocente = request.getParameter("liDocenteProgAcademica");
			String[] arrayDoc = liDocente.split("-"); 
			String idDocente = arrayDoc[0];
			NProgAcademica nProgacademica =  new NProgAcademica();
			try {
				List<ProgAcademica> ListaProgAcademica = nProgacademica.ListadoProgAcademicaDocente(idDocente);
				request.setAttribute("ListaProgAcademica", ListaProgAcademica);
				request.getRequestDispatcher("./ProgAcademicaReporte.jsp").forward(request, response);
			} catch (Exception ex) {
				Logger.getLogger(ProgAcademica.class.getName()).log(Level.SEVERE, null, ex);
				request.setAttribute("mensaje", ex.getMessage());
			}
		} else if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "Por favor, ingrese la identificación de la programación académica.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
			response.sendRedirect("ProgAcademicas.jsp");
		} else {
			ProgAcademica.setIdProgAcademica(id);
			ProgAcademica.setDocenteProgAcademica(docente);
			ProgAcademica.setAsignaturaProgAcademica(asignatura);
			ProgAcademica.setGrupoAsigProgAcademica(grupo);
			ProgAcademica.setNroEstAsigProgAcademica(nroEst);
			ProgAcademica.setDiasAsigProgAcademica(diasAsig);
			ProgAcademica.setHoraIniAsigProgAcademica(horaIni);
			ProgAcademica.setHoraFinAsigProgAcademica(horaFin);
			ProgAcademica.setAulaClaseProgAcademica(aulaClase);
			ProgAcademica.setSemestreProgAcademica(semestreProgAcademica);
			ProgAcademica.setAnoProgAcademica(anoProgAcademica);

			if ("Crear".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				try {
					ResultSet r = Connection.getConnection().prepareStatement("Select Id_ProgAcademica from programaciones_academicas").executeQuery();
					while (r.next()) {
						if (id.equals(r.getString(1))) {
							registroExiste = true;
							JOptionPane.showMessageDialog(null, "Este registro ya existe, por favor verifique la identificación de la programación académica", "Advertencia - AsesoriasTyT",
									JOptionPane.WARNING_MESSAGE);
							request.getRequestDispatcher("./ProgAcademicas.jsp").forward(request, response);
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				if (!registroExiste) {
					if (docente.equals("")) {
						JOptionPane.showMessageDialog(null, "Por favor, ingrese el docente de la programación académica.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
						request.getRequestDispatcher("./ProgAcademicas.jsp").forward(request, response);
					} else {
						int resultado = new NProgAcademica().Crear(ProgAcademica);
						try {
							response.sendRedirect("ProgAcademicas.jsp");
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
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_ProgAcademica from programaciones_academicas").executeQuery();
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
						JOptionPane.showMessageDialog(null, "Campos vacíos, por favor llenarlos.", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
						response.sendRedirect("ProgAcademicas.jsp");
					} else {
						int confirma = JOptionPane.showConfirmDialog(null, "¿Desea actualizar la información de esta programación académica?");
						if (confirma == JOptionPane.YES_OPTION) {
							int resultadoModificar = new NProgAcademica().Modificar(ProgAcademica);
							request.setAttribute("cli", resultadoModificar);
							JOptionPane.showMessageDialog(null, "Se modificó correctamente", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
							response.sendRedirect("ProgAcademicas.jsp");
						} else if (confirma == JOptionPane.NO_OPTION) {
							request.getRequestDispatcher("./ProgAcademicas.jsp").forward(request, response);
						} else if (confirma == JOptionPane.CLOSED_OPTION) {
							request.getRequestDispatcher("./ProgAcademicas.jsp").forward(request, response);
						} else if (confirma == JOptionPane.CANCEL_OPTION) {
							request.getRequestDispatcher("./ProgAcademicas.jsp").forward(request, response);
						}
					}
				} else if (!registroExiste) {
					request.getRequestDispatcher("./ProgAcademicas.jsp").forward(request, response);
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación de la programación académica", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
				}
			}

			if ("Consultar".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				int sw = 0;
				try {
					ResultSet r1 = Connection.getConnection().prepareStatement("Select Id_ProgAcademica from programaciones_academicas").executeQuery();
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
					NProgAcademica negocioC = new NProgAcademica();
					try {
						ProgAcademica cli = negocioC.Buscar(id);
						request.setAttribute("cli", cli);
						request.setAttribute("mensaje", "La programación académica fue encontrada con exito");
						request.getRequestDispatcher("./ProgAcademicas.jsp").forward(request, response);
					} catch (Exception ex) {
						Logger.getLogger(ProgAcademicas.class.getName()).log(Level.SEVERE, null, ex);
						request.setAttribute("mensaje", ex.getMessage());
					}
				} else if (!registroExiste) {
					response.sendRedirect("ProgAcademicas.jsp");
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación de la programación académica", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
				}
			}

			if ("Eliminar".equals(request.getParameter("action"))) {
				boolean registroExiste = false;
				int sw = 0;
				try {
					ResultSet r = Connection.getConnection().prepareStatement("Select Id_ProgAcademica from programaciones_academicas").executeQuery();
					while (r.next() && sw == 0) {
						if (!id.equals(r.getString(1)) && (!id.equals(""))) {
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
					int confirma = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la información de esta programación académica?");
					if (confirma == JOptionPane.YES_OPTION) {
						int resultadoEliminar = new NProgAcademica().Eliminar(ProgAcademica);
						request.setAttribute("cli", resultadoEliminar);
						JOptionPane.showMessageDialog(null, "Se eliminó correctamente", "AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
						response.sendRedirect("ProgAcademicas.jsp");
					} else if (confirma == JOptionPane.NO_OPTION) {
						request.getRequestDispatcher("./ProgAcademicas.jsp").forward(request, response);
					} else if (confirma == JOptionPane.CLOSED_OPTION) {
						request.getRequestDispatcher("./ProgAcademicas.jsp").forward(request, response);
					} else if (confirma == JOptionPane.CANCEL_OPTION) {
						request.getRequestDispatcher("./ProgAcademicas.jsp").forward(request, response);
					}
				} else if (!registroExiste) {
					JOptionPane.showMessageDialog(null, "Registro inexistente, por favor verifique la identificación de la programación académica", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
					request.getRequestDispatcher("./ProgAcademicas.jsp").forward(request, response);
				}
			}
		}
	}

}
