package co.poli.asesoriastyt.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;







import co.poli.asesoriastyt.model.Persona;
import co.poli.asesoriastyt.negocio.NPersona;
import co.poli.asesoriastyt.util.EscribirErrores;
import co.poli.asesoriastyt.util.LeerExcel;

/**
 * Servlet implementation class SubirArchivo
 */
@WebServlet("/CargarExcel")
public class CargarExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	LeerExcel excel= new LeerExcel();
	EscribirErrores write= new EscribirErrores();
	NPersona npersona= new NPersona();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargarExcel() {
        super();
       
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
	
		/*List<FileItem> items;
		try {
			items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			for (FileItem item : items) {
		           
                // Process form file field (input type="file").
            	
                String fieldName = item.getName();
                String fileName = FilenameUtils.getName(item.getName());
                InputStream fileContent = item.getInputStream();

            }
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}*/

		String tipo= request.getParameter("tipo");
		if(tipo.equals("Cargar Docentes"))
		{
			ArrayList<Persona> listaDocentes;
			ArrayList<Persona> listaErroresDocentes;
			boolean errores= true;
			 try 
			 {
				 listaDocentes=excel.leerArchivoDocentes();
				 listaErroresDocentes=excel.getListaErroresDocentes();
				 
				 if (listaErroresDocentes.size()>0)
				 {
					 
					 errores=write.escribirExcelDocentes(listaErroresDocentes);
					 
					 if(errores==true)
					 {
						 JOptionPane.showMessageDialog(null, "La carga de Docentes se generó con excepciones, puede validar los errores en el archivo", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
							request.getRequestDispatcher("./CargarExcel.jsp").forward(request, response);
					 }
				 }
				 
				/* if(listaDocentes.size()>0)
				 {
					npersona.CrearDocentes(listaDocentes);
				 }*/
			 }
			  catch (Exception e) 
			 {
			        
				  throw new ServletException("Cannot parse multipart request.", e);
			    
			 }
	
		}
		if(tipo.equals("Cargar Estudiantes"))
		{
			ArrayList<Persona> listaEstudiantes;
			ArrayList<Persona> listaErroresEstudiantes;
			boolean errores= true;
			 try 
			 {
				 listaEstudiantes=excel.leerArchivoEstudiantes();
				 listaErroresEstudiantes=excel.getListaErroresEstudiantes();
				 
				 if (listaErroresEstudiantes.size()>0)
				 {
					
					 errores=write.escribirExcelEstudiantes(listaErroresEstudiantes);
					 
					 if(errores==true)
					 {
						 JOptionPane.showMessageDialog(null, "La carga de Docentes se generó con excepciones, puede validar los errores en el archivo", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
							request.getRequestDispatcher("./CargarExcel.jsp").forward(request, response);
					 }
				 }
				 
	/*			 if(listaErroresEstudiantes.size()>0)
				 {
					npersona.CrearDocentes(listaEstudiantes);
				 }*/
			 }
			  catch (Exception e) 
			 {
			        
				  throw new ServletException("Cannot parse multipart request.", e);
			    
			 }
	
		}
	}
	
	
}
