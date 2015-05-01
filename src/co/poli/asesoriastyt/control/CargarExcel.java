package co.poli.asesoriastyt.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;






import co.poli.asesoriastyt.model.Persona;
import co.poli.asesoriastyt.negocio.NPerfiles;
import co.poli.asesoriastyt.negocio.NPersona;
import co.poli.asesoriastyt.util.Conexion;
import co.poli.asesoriastyt.util.DataSourceTest;
import co.poli.asesoriastyt.util.EscribirErrores;
import co.poli.asesoriastyt.util.LeerExcel;


/**
 * Servlet implementation class SubirArchivo.
 */
@WebServlet("/CargarExcel")
public class CargarExcel extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
	/** The excel. */
	LeerExcel excel= new LeerExcel();
	
	/** The write. */
	EscribirErrores write= new EscribirErrores();
	
	/** The npersona. */
	NPersona npersona= new NPersona();
	Connection c=new Conexion().getConnection();
    
    /**
     * Instantiates a new cargar excel.
     *
     * @see HttpServlet#HttpServlet()
     */
    public CargarExcel() {
        super();
       
    }

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
	
		List<FileItem> items;
		String tipo="";
		boolean continuar= true;
		InputStream fileContent=null;
	
		try {
			items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

			for (FileItem item : items) {
		           
				if(item.getFieldName().equals("tipo"))
            	{

		               tipo = item.getString();
		               if(tipo.equals("Seleccione..."))
		               {
		            	   continuar= false;
		            	   JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo de archivo que va a cargar", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
				 			request.getRequestDispatcher("./CargarExcel.jsp").forward(request, response);
		            	   
		               }

            	}
            	if(item.getFieldName().equals("uploadFile"))
            	{
	                String fieldName = item.getName();
	                String fileName = FilenameUtils.getName(item.getName());
	                if((fieldName.equals(""))&&(continuar==true))
	                {
	                	continuar=false;
	                	 JOptionPane.showMessageDialog(null, "Debe seleccionar el archivo a cargar", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
						 			request.getRequestDispatcher("./CargarExcel.jsp").forward(request, response);
	                }
	                else
	                {
	                	
	                	int resultado = fieldName.indexOf("xlsx");
	           		 
	            		if((resultado == -1) &&(continuar==true))
	            		{
	            			continuar=false;
	                    	JOptionPane.showMessageDialog(null, "Debe seleccionar una extensión válida (xlsx)", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
				 			request.getRequestDispatcher("./CargarExcel.jsp").forward(request, response);
	            		}
	                    else
	                    {
	                    	fileContent = item.getInputStream();
	                    	
	                    }
	                	
	                }
	                
	                
	               
            	}
            	            	

            }
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}

		
		if((tipo.equals("Cargar Docentes"))&&(continuar==true))
		{
			ArrayList<Persona> listaDocentes;
			ArrayList<Persona> listaErroresDocentes;
			boolean errores= true;
			 try 
			 { 
				 
				 listaDocentes=excel.leerArchivoDocentes(fileContent);
				 listaErroresDocentes=excel.getListaErroresDocentes();
					 if((listaDocentes.size()==0)&&(listaErroresDocentes.size()==0))
					 {
						 JOptionPane.showMessageDialog(null, "Por favor valide la estructura del archivo que seleccionó, ya que no es la adecuada", "Información - AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
							request.getRequestDispatcher("./CargarExcel.jsp").forward(request, response);
					 }
					 else
					 {
						 
						 int suma= listaDocentes.size() + listaErroresDocentes.size();
						 
						 if (listaErroresDocentes.size()>0)
						 {
							
							 errores=write.escribirExcelDocentes(listaErroresDocentes);
							 
							 
							 if(errores==true)
							 {
								 JOptionPane.showMessageDialog(null, "La carga de docentes se generó con excepciones \n Puede validar los errores en el archivo ErrorCargaEstudiantes.xlsx \n Estudiantes insertados: " +listaDocentes.size()+ 
										 							" \n Registros con errores: " + listaErroresDocentes.size() + "\n Total Registros: "+ suma, "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
									request.getRequestDispatcher("./CargarExcel.jsp").forward(request, response);
							 }
						 }
						 else
						 {
							 JOptionPane.showMessageDialog(null, "La carga de docentes se generó correctamente con "+listaDocentes.size()+" cargados", "Información - AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
								request.getRequestDispatcher("./CargarExcel.jsp").forward(request, response);
						 }
						 
						 
					//		npersona.CrearDocentes(listaDocentes);
						  
					 }
					 
				 
						 
			}
			  catch (Exception e) 
			 {
			        
				  throw new ServletException("Cannot parse multipart request.", e);
			    
			 }
	
		}
		if((tipo.equals("Cargar Estudiantes"))&&(continuar==true))
		{
			ArrayList<Persona> listaEstudiantes;
			ArrayList<Persona> listaErroresEstudiantes;
			boolean errores= true;
			 try 
			 {
				 listaEstudiantes=excel.leerArchivoEstudiantes(fileContent);
				 listaErroresEstudiantes=excel.getListaErroresEstudiantes();
				 if((listaEstudiantes.size()==0)&&(listaErroresEstudiantes.size()==0))
				 {
					 JOptionPane.showMessageDialog(null, "Por favor valide la estructura del archivo que seleccionó, ya que no es la adecuada", "Información - AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
						request.getRequestDispatcher("./CargarExcel.jsp").forward(request, response);
				 }
				 else
				 {
					
					 for(int i=0; i<listaEstudiantes.size();i++)
						{
							System.out.println(listaEstudiantes.get(i).getNumeroIdentificacion().toString());
							int resultado = new NPersona().CrearDocentes(listaEstudiantes.get(i));
						}
					 //int resultado=new NPersona().CrearDocentes(listaEstudiantes);
					 int suma= listaEstudiantes.size() + listaErroresEstudiantes.size();
					
					 if (listaErroresEstudiantes.size()>0)
					 {
						
						 errores=write.escribirExcelEstudiantes(listaErroresEstudiantes);
						 
						 
						 if(errores==true)
						 {
							 JOptionPane.showMessageDialog(null, "La carga de Estudiantes se generó con excepciones \n Puede validar los errores en el archivo ErrorCargaEstudiantes.xlsx \n Estudiantes insertados: " +listaEstudiantes.size()+ 
									 							" \n Registros con errores: " + listaErroresEstudiantes.size() + "\n Total Registros: "+ suma, "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
								request.getRequestDispatcher("./CargarExcel.jsp").forward(request, response);
						 }
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(null, "La carga de Estudiantes se generó correctamente con "+listaEstudiantes.size()+" cargados", "Información - AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
							request.getRequestDispatcher("./CargarExcel.jsp").forward(request, response);
					 }
	  
				 }
				 
			 }
			  catch (Exception e) 
			 {
			        
				  throw new ServletException("Cannot parse multipart request.", e);
			    
			 }
	
		}
	}
	
	
}
