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










import co.poli.asesoriastyt.model.Asignatura;
import co.poli.asesoriastyt.model.Persona;
import co.poli.asesoriastyt.model.ProgAcademica;
import co.poli.asesoriastyt.negocio.NAsignatura;
import co.poli.asesoriastyt.negocio.NPerfiles;
import co.poli.asesoriastyt.negocio.NPersona;
import co.poli.asesoriastyt.negocio.NProgAcademica;
import co.poli.asesoriastyt.util.Conexion;
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

			for (FileItem item : items) 
			{

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
		
		if(continuar==true)
		{
			boolean resultadoperparar=npersona.prepararCarga();
			if(resultadoperparar==true)
			{
				 	excel.leerArchivo(fileContent);
				 	ArrayList<Persona> listaEstudiantes;
					ArrayList<Persona> listaErroresEstudiantes;
				
					ArrayList<Persona> listaDocentes;
					ArrayList<Persona> listaErroresDocentes;
					
					ArrayList<Asignatura> listaAsignaturas;
					ArrayList<Asignatura> listaErroresAsignaturas;
					
					ArrayList<ProgAcademica> listaProgAcademicas;
					ArrayList<ProgAcademica> listaErroresProgAcademicas;
					boolean errores= true;
					 try 
					 { 
						 
						 listaDocentes=excel.getListaDocentes();
						 listaErroresDocentes=excel.getListaErroresDocentes();
						 
						 listaEstudiantes=excel.getListaEstudiantes();
						 listaErroresEstudiantes=excel.getListaErroresEstudiantes();
						 
						 listaAsignaturas=excel.getListaAsignaturas();
						 listaErroresAsignaturas=excel.getListaErroresAsignaturas();
						 
						 if(((listaDocentes.size()==0)&&(listaErroresDocentes.size()==0))||((listaEstudiantes.size()==0)&&(listaErroresEstudiantes.size()==0))||((listaAsignaturas.size()==0)&&(listaErroresAsignaturas.size()==0)))
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
							 for(int i=0; i<listaDocentes.size();i++)
								{
									System.out.println(listaDocentes.get(i).getNumeroIdentificacion().toString());
									int resultado = new NPersona().CrearDocentes(listaDocentes.get(i));
								}
							 for(int i=0; i<listaAsignaturas.size();i++)
								{
									System.out.println(listaAsignaturas.get(i).getIdAsignatura().toString());
									int resultado = new NAsignatura().Crear(listaAsignaturas.get(i));
								}
						 }
						 
						 excel.leerArchivoProgramacion();
						 
						 listaProgAcademicas=excel.getListaProgramacion();
						 listaErroresProgAcademicas=excel.getListaErroresProgramacion();
						 
					
							 if((listaProgAcademicas.size()==0)&&(listaErroresProgAcademicas.size()==0))
							 {
								 JOptionPane.showMessageDialog(null, "Por favor valide la estructura de la pestaña de programación académica del archivo que seleccionó, ya que no es la adecuada", "Información - AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
									request.getRequestDispatcher("./CargarExcel.jsp").forward(request, response);
							 }
							 else
							 {
								 for(int i=0; i<listaProgAcademicas.size();i++)
									{
										System.out.println(listaProgAcademicas.get(i).getAsignaturaProgAcademica().toString());
										int resultado = new NProgAcademica().Crear(listaProgAcademicas.get(i));
									}
								 String mensaje="";
								 int sumadocentes= listaDocentes.size() + listaErroresDocentes.size();
								 int sumaestudiantes= listaEstudiantes.size() + listaErroresEstudiantes.size();
								 int sumaasignaturas= listaAsignaturas.size() + listaErroresAsignaturas.size();
								 int sumaprogramacion= listaProgAcademicas.size() + listaErroresProgAcademicas.size();
								 
								 if (listaErroresDocentes.size()>0)
								 {
									
									 errores=write.escribirExcelDocentes(listaErroresDocentes);
									 
									 
									 if(errores==true)
									 {
										 mensaje= mensaje+" \n La carga de docentes se generó con excepciones \n Puede validar los errores en el archivo ErrorCargaDocentes.xlsx \n Docentes insertados: " +listaDocentes.size()+ 
												 							" \n Registros con errores: " + listaErroresDocentes.size() + "\n Total Registros: "+ sumadocentes;
											
									 }
								 }
								 else
								 {
									 mensaje= mensaje + "\n La carga de docentes se generó correctamente con "+listaDocentes.size()+" cargados";
										
								 }
								 if (listaErroresEstudiantes.size()>0)
								 {
									
									 errores=write.escribirExcelEstudiantes(listaErroresEstudiantes);
									 
									 
									 if(errores==true)
									 {
										 mensaje= mensaje + "\n La carga de Estudiantes se generó con excepciones \n Puede validar los errores en el archivo ErrorCargaEstudiantes.xlsx \n Estudiantes insertados: " +listaEstudiantes.size()+ 
												 							" \n Registros con errores: " + listaErroresEstudiantes.size() + "\n Total Registros: "+ sumaestudiantes;
											
									 }
								 }
								 else
								 {
									 mensaje= mensaje + "\n La carga de Estudiantes se generó correctamente con "+listaEstudiantes.size()+" cargados";
										
								 }
								
								 if (listaErroresAsignaturas.size()>0)
								 {
									
									 errores=write.escribirExcelAsignaturas(listaErroresAsignaturas);
									 
									 
									 if(errores==true)
									 {
										 mensaje= mensaje +"\n La carga de Asignaturas se generó con excepciones \n Puede validar los errores en el archivo ErrorCargaAsignaturas.xlsx \n Asignaturas insertados: " +listaAsignaturas.size()+ 
												 							" \n Registros con errores: " + listaErroresAsignaturas.size() + "\n Total Registros: "+ sumaasignaturas;
									 }
								 }
								 else
								 {
									 mensaje= mensaje +"\n La carga de Asignaturas se generó correctamente con "+listaAsignaturas.size()+" cargadas";
										
								 }
								 
								 if (listaErroresProgAcademicas.size()>0)
								 {
									
									 errores=write.escribirExcelProgAcademicas(listaErroresProgAcademicas);
									 
									 
									 if(errores==true)
									 {
										 mensaje= mensaje + "\n La carga de Programación Académica se generó con excepciones \n Puede validar los errores en el archivo ErrorCargaProgAcademicas.xlsx \n Programación Académica insertada: " +listaProgAcademicas.size()+ 
												 							" \n Registros con errores: " + listaErroresProgAcademicas.size() + "\n Total Registros: "+ sumaprogramacion;
											
									 }
								 }
								 else
								 {
									 mensaje= mensaje + "\n La carga de Programación Académica se generó correctamente con "+listaProgAcademicas.size()+" cargadas";
								 }
								 
								 JOptionPane.showMessageDialog(null, mensaje, "Información - AsesoriasTyT", JOptionPane.INFORMATION_MESSAGE);
									request.getRequestDispatcher("./CargarExcel.jsp").forward(request, response);
							
								  
							 }
							 
						 
								 
					}
					  catch (Exception e) 
					 {
					        
						  throw new ServletException("Cannot parse multipart request.", e);
					    
					 }
				}
			else
			{
				JOptionPane.showMessageDialog(null, "Ocurrió un error durante la preparación de la carga de archivos", "Error - AsesoriasTyT", JOptionPane.ERROR_MESSAGE);
				request.getRequestDispatcher("./CargarExcel.jsp").forward(request, response);
				
			}
		}
	
		}
		
	
	
	
}
