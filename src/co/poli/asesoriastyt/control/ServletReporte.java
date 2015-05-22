
package co.poli.asesoriastyt.control;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import sun.util.calendar.BaseCalendar.Date;
import co.poli.asesoriastyt.model.ReporteAsistencia;
import co.poli.asesoriastyt.model.ReporteMaterialAsesoria;
import co.poli.asesoriastyt.model.ReporteNumAsistencia;
import co.poli.asesoriastyt.negocio.NAsesoria;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;



/**
 * The Class ServletReporte.
 */
@WebServlet(description = "Controlador de Reportes", urlPatterns = { "/ServletReporte" })
public class ServletReporte extends HttpServlet
{
    
    /**
     * Process request.
     *
     * @param request the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       
       
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /* (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	
    	String fechaInicio = "";
        String fechaFin = "";
        String reporte = "";
        String asesoria = "";
        String urlReporte="";
        
        fechaInicio = request.getParameter("fechaI");
        fechaFin = request.getParameter("fechaF");
        reporte = request.getParameter("reporte");
        asesoria = request.getParameter("asesoria");
        boolean respuesta= true;
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-MM-dd");
       
        NAsesoria dao= new NAsesoria();
        
        if ("Limpiar".equals(request.getParameter("action")))
        {
        	request.getRequestDispatcher("./Reportes.jsp").forward(request, response);
        }
         
        if ("Cargar".equals(request.getParameter("action")))
        {
        
	        if(reporte.equals("Seleccione..."))
	        {
	        	JOptionPane.showMessageDialog(null, "Debe seleccionar el tipo de Reporte", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
				request.getRequestDispatcher("./Reportes.jsp").forward(request, response);
	        }
	        
	        if(((fechaInicio=="")&&(fechaFin!="")))
	        {
	        	JOptionPane.showMessageDialog(null, "Debe seleccionar un rango de fechas válido", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
	        	request.getRequestDispatcher("./Reportes.jsp").forward(request, response);
	        	respuesta=false;
	        }
	        
	        if (((fechaFin=="")&&(fechaInicio!="")))
	        {
	        	Calendar c1 = Calendar.getInstance();
	        	fechaFin= formato.format(c1.getTime());
	        }
	        
	        if(((fechaFin!="")&&(fechaInicio!="")))
	        {
		        java.util.Date fechaI = null;
				try {
					fechaI = formato.parse(fechaInicio);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        java.util.Date fechaF = null;
				try {
					fechaF = formato.parse(fechaFin);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				 
		        if(fechaI.after(fechaF))
		        {
		        	JOptionPane.showMessageDialog(null, "La fecha Inicio debe ser menor a la fecha final", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
		        	respuesta=false;
		        	request.getRequestDispatcher("./Reportes.jsp").forward(request, response);
		        }
	        }
	        	
	       
	        if(respuesta==true)
	        {
		        if(reporte.equals("Asistencia por Asesoría"))
		        {
		        	urlReporte="WEB-INF/Reportes/AsistenciaAsesoria.jasper";
		        	List<ReporteAsistencia> listaDatos= null;
			        if((fechaInicio != "")&&(fechaFin!=""))
			        {
			        	listaDatos = dao.AsistenciaAsesoriaFecha(fechaInicio, fechaFin);
			        }
			        else
			        	if(!asesoria.equals("Seleccione..."))
			        	{
			        		listaDatos = dao.AsistenciaAsesoriaAsesoria(asesoria);
			        	}
			        	else
			        	{
			        		listaDatos = dao.AsistenciaAsesoria();
			        	}
			        if(listaDatos.size()>0)
			        {
				        try
				        {
				        	
				        	JRBeanCollectionDataSource datasource= new JRBeanCollectionDataSource(listaDatos);
				            JasperReport ireporte = (JasperReport) JRLoader.loadObjectFromFile(getServletContext().getRealPath(urlReporte));
				            JasperPrint jasperPrint = JasperFillManager.fillReport(ireporte, null,datasource);
				            request.setAttribute(asesoria, "Seleccione...");
				            response.reset();
				            response.setContentType("WEB-INF/Reportes");
				            response.addHeader("Content-disposition","inline; filename=AsistenciaAsesoria.pdf");
				            ServletOutputStream servletOutputStream=(ServletOutputStream)response.getOutputStream();
				            JasperExportManager.exportReportToPdfStream(jasperPrint,servletOutputStream);
				        }
				        catch (Exception e)
				        {
				            e.printStackTrace();
				        }
			        }
			        else
			        {
			        	JOptionPane.showMessageDialog(null, "No se encontró información según los filtros ingresados", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
			        	request.getRequestDispatcher("./Reportes.jsp").forward(request, response);
			        }
		        }
		        if(reporte.equals("Materiales por Asesoría"))
		        {
		        	List<ReporteMaterialAsesoria> listaDatos= null;
		        	urlReporte="WEB-INF/Reportes/MaterialAsesoria.jasper";
			        if((fechaInicio != "")&&(fechaFin!=""))
			        {
			        	
			        	listaDatos = dao.MaterialAsesoriasFechas(fechaInicio,fechaFin);
			        	
			        }
			        if(!asesoria.equals("Seleccione..."))
			        {
			        	listaDatos = dao.MaterialAsesoriasAsesoria(asesoria);	
			        }
			        if((fechaInicio == "")&&(fechaFin=="")&&(asesoria.equals("Seleccione...")))
			        {
	
			        	  listaDatos = dao.MaterialAsesorias();
			        }
			        
			        if(listaDatos.size()>0)
			        {
				        try
				        {
				        	
				        	JRBeanCollectionDataSource datasource= new JRBeanCollectionDataSource(listaDatos);
				            JasperReport ireporte = (JasperReport) JRLoader.loadObjectFromFile(getServletContext().getRealPath(urlReporte));
				            JasperPrint jasperPrint = JasperFillManager.fillReport(ireporte, null,datasource);
				            request.setAttribute(asesoria, "Seleccione...");
				            response.reset();
				            response.setContentType("WEB-INF/Reportes");
				            response.addHeader("Content-disposition","inline; filename=MaterialxAsesoria.pdf");
				            ServletOutputStream servletOutputStream=(ServletOutputStream)response.getOutputStream();
				            JasperExportManager.exportReportToPdfStream(jasperPrint,servletOutputStream);
				        }
				        catch (Exception e)
				        {
				            e.printStackTrace();
				        }
			        }
			        else
			        {
			        	JOptionPane.showMessageDialog(null, "No se encontró información según los filtros ingresados", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
			        	request.getRequestDispatcher("./Reportes.jsp").forward(request, response);
			        }
		
		        }
		        if(reporte.equals("Cantidad Estudiantes por Asesoría"))
		        {
		        	
		        	urlReporte="WEB-INF/Reportes/CantidadAsistenciaAsesoria.jasper";
		        	List<ReporteNumAsistencia> listaDatos= null;
			        if((fechaInicio != "")&&(fechaFin!=""))
			        {
			        	 listaDatos = dao.CantidadAsitenciaAsesoriaFecha(fechaInicio, fechaFin);
			        }
			        else
			        	if(!asesoria.equals("Seleccione..."))
			        	{
			        		listaDatos = dao.CantidadAsitenciaAsesoriaAsesoria(asesoria);
			        		
			        	}	
			        	else
			        	{
	
			        		 listaDatos = dao.CantidadAsitenciaAsesoria();
			        	}
			        if(listaDatos.size()>0)
			        {

				        try
				        {
				        	
				        	JRBeanCollectionDataSource datasource= new JRBeanCollectionDataSource(listaDatos);
				            JasperReport ireporte = (JasperReport) JRLoader.loadObjectFromFile(getServletContext().getRealPath(urlReporte));
				            JasperPrint jasperPrint = JasperFillManager.fillReport(ireporte, null,datasource);
				            response.reset();
				            response.setContentType("WEB-INF/Reportes");
				            response.addHeader("Content-disposition","inline; filename=CantidadAsistenciaAsesoria.pdf");
				            ServletOutputStream servletOutputStream=(ServletOutputStream)response.getOutputStream();
				            JasperExportManager.exportReportToPdfStream(jasperPrint,servletOutputStream);
				        }
				        catch (Exception e)
				        {
				            e.printStackTrace();
				        }
			        }
			        else
			        {
			        	JOptionPane.showMessageDialog(null, "No se encontró información según los filtros ingresados", "Advertencia - AsesoriasTyT", JOptionPane.WARNING_MESSAGE);
			        	request.getRequestDispatcher("./Reportes.jsp").forward(request, response);
			        }
		        }
	        }
		        
		        
		        
	       
        }
    }

    /* 
     * @see javax.servlet.GenericServlet#getServletInfo()
     */
    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#getServletInfo()
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}
