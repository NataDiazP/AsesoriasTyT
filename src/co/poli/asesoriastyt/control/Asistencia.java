package co.poli.asesoriastyt.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import co.poli.asesoriastyt.model.Asesoria;
import co.poli.asesoriastyt.model.EstudianteAsesoria;
import co.poli.asesoriastyt.negocio.NAsesoria;

/**
 * Servlet implementation class Asistencia
 */
@WebServlet("/Asistencia")
public class Asistencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Asistencia() {
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
		// TODO Auto-generated method stub
		ArrayList<Asesoria> asistencia= new ArrayList<Asesoria>();
		List<FileItem> items;
		String fieldName=null;
		String fileName = null;
		List<EstudianteAsesoria> ListaAsistencia=(List<EstudianteAsesoria>) request.getSession().getAttribute("asistencias");
		String asesoria=ListaAsistencia.get(0).getIdAsesoria();
		int resultadoModificar=0;
		boolean continuar= true;
		
		try {
			items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

			for (FileItem item : items) 
			{
				if(item.getString().equals("Seleccione..."))
				{
					continuar= false;
					ListaAsistencia=new NAsesoria().ListadoAsistentes(asesoria);
					request.setAttribute("ListaAsistencia",ListaAsistencia);
					JOptionPane.showMessageDialog(null, "Debe seleccionar un valor válido para la asistencia", "AsesoriasTyT",
							JOptionPane.ERROR_MESSAGE);
					request.getRequestDispatcher("./AsistenciaAsesorias.jsp").forward(request, response);
					break;
				}
				if(!item.getString().equals("GuardarAsesoria"))
				{
					resultadoModificar = new NAsesoria().GuardarAsistencia(asesoria, item.getFieldName(), item.getString());
					System.out.println(item.getFieldName()+" "+item.getString()+" "+resultadoModificar);
				}
				
			}
		}
		catch (FileUploadException e1) {
			e1.printStackTrace();
		}
		if(continuar)
		{
				JOptionPane.showMessageDialog(null, "Se ha guardado correctamente la lista de asistencia.", "AsesoriasTyT",
						JOptionPane.INFORMATION_MESSAGE);
				response.sendRedirect("Asesorias.jsp");
		}
	}

}
