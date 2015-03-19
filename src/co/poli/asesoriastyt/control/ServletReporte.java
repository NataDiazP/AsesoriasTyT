
package co.poli.asesoriastyt.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.poli.asesoriastyt.dao.DAOPersonas;
import co.poli.asesoriastyt.model.Persona;
import co.poli.asesoriastyt.negocio.NPersona;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;


public class ServletReporte extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setHeader("Content-Disposition", "attachment; filename=\"reporte.pdf\";");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        
        response.setContentType("application/pdf");
        NPersona dao= new NPersona();

        ServletOutputStream out = response.getOutputStream();

        List<Persona> listaPersonas = dao.ListadoPersonasEstudiantes();


        try
        {
            /*JasperReport reporte = (JasperReport) JRLoader.loadObject(getServletContext().getRealPath("WEB-INF/reporte2.jasper"));

            Map parametros = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(listaPariticipantes));
*/
        	JasperPrint print = JasperFillManager.fillReport(report, parameters, conn);
        	JasperReport report = JasperCompileManager.compileReport("WEB-INF\\Reportes\\report1.jrxml");
        	JasperExportManager.exportReportToPdfFile(print,"WEB-INF\\Reportes\\reporte.pdf");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}
