package co.poli.asesoriastyt.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import co.poli.asesoriastyt.model.Asignatura;
import co.poli.asesoriastyt.model.Persona;
import co.poli.asesoriastyt.model.ProgAcademica;


/**
 *  Class EscribirErrores.
 * @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class EscribirErrores 
{

	/**
	 * Escribir excel docentes.
	 *
	 * @param listaErrores  lista errores
	 * @return true, if successful
	 */
	public boolean escribirExcelDocentes (ArrayList<Persona> listaErrores,String ruta) 
	{
		boolean bandera=true;
		//Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		
		//Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Errores");
		 
		
		int rownum = 0;
		Row row = sheet.createRow(rownum++);
		int cellnum = 0;
		Cell cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Documento");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Tipo Documento");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Nombre Completo");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Primer Apellido");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Segundo Apellido");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Genero");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Fecha de Nacimiento");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Dirección");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Teléfono");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Celular");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Correo");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Estado");
	 
		for (int i=0; i< listaErrores.size();i++ )
		{
		    row = sheet.createRow(rownum++);
		    Persona persona = listaErrores.get(i);
		    cellnum = 0;

			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getNumeroIdentificacion());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getTipoIdentificacion());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getNombreCompleto());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getPrimerApellido());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getSegundoApellido());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getGenero());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getFechaNacimiento());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getDireccion());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getTelefono());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getCelular());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getCorreoElectronico());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getEstado());
			   
		   
		    
		}
		try 
		{
			//Write  workbook in file system
			
				 FileOutputStream out = new FileOutputStream(new File(ruta+"\\ErrorCargaDocentes.xlsx"));
				 workbook.write(out);
				 
				 out.close();
		
		    
		    
		    System.out.println("ErrorCargaDocentes.xlsx se generó correctamente.");
		     
		} 
		catch (Exception e) 
		{
			bandera=false;
		    e.printStackTrace();
		}
		
		return bandera;
	}
	
	/**
	 * Escribir excel estudiantes.
	 *
	 * @param listaErrores  lista errores
	 * @return true, if successful
	 */
	public boolean escribirExcelEstudiantes (ArrayList<Persona> listaErrores,String ruta) 
	{
		boolean bandera=true;
		//Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		
		//Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Errores");
		 
		
		int rownum = 0;
		int cellnum = 0;
		Row row = sheet.createRow(rownum++);
		Cell cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Documento");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Tipo Documento");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Nombre Completo");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Primer Apellido");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Segundo Apellido");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Genero");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Fecha de Nacimiento");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Dirección");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Teléfono");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Celular");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Correo");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Plan de Estudio");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Semestre");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Estado");

		for (int i=0; i< listaErrores.size();i++ )
		{
		    row = sheet.createRow(rownum++);
		    Persona persona = listaErrores.get(i);
		    cellnum = 0;
		    
		    	cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getNumeroIdentificacion());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getTipoIdentificacion());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getNombreCompleto());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getPrimerApellido());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getSegundoApellido());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getGenero());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getFechaNacimiento());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getDireccion());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getTelefono());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getCelular());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getCorreoElectronico());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getPlanEstudios_Estudiante());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getSemestre_Estudiante());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)persona.getEstado());    
		}
		try 
		{
			//Write  workbook in file system
			
				 FileOutputStream out = new FileOutputStream(new File(ruta+"\\ErrorCargaEstudiantes.xlsx"));
				 workbook.write(out);
				 out.close();
		
		   
		    
		    
		    System.out.println("ErrorCargaEstudiantes.xlsx se generó correctamente.");
		     
		} 
		catch (Exception e) 
		{
			bandera=false;
		    e.printStackTrace();
		}
		
		return bandera;
	}

	/**
	 * @param listaErroresAsignaturas
	 * @return
	 */
	public boolean escribirExcelAsignaturas(ArrayList<Asignatura> listaErroresAsignaturas,String ruta) {
		boolean bandera=true;
		//Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		
		//Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Errores");
		 
		
		int rownum = 0;
		int cellnum = 0;
		Row row = sheet.createRow(rownum++);
		Cell cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Código Asignatura");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Nombre");
	    cell = row.createCell(cellnum++);
	    

		for (int i=0; i< listaErroresAsignaturas.size();i++ )
		{
		    row = sheet.createRow(rownum++);
		    Asignatura asignatura = listaErroresAsignaturas.get(i);
		    cellnum = 0;
		    
		    	cell = row.createCell(cellnum++);
			    cell.setCellValue((String)asignatura.getIdAsignatura());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)asignatura.getNombreAsignatura());
			  
		}
		try 
		{
			//Write  workbook in file system
			
				 FileOutputStream out = new FileOutputStream(new File(ruta+"\\ErrorCargaAsignaturas.xlsx"));
				 workbook.write(out);
				 out.close();
		
		   
		    
		    
		    System.out.println("ErrorCargaAsignaturas.xlsx se generó correctamente.");
		     
		} 
		catch (Exception e) 
		{
			bandera=false;
		    e.printStackTrace();
		}
		
		return bandera;
	}

	/**
	 * @param listaErroresProgAcademicas
	 * @return
	 */
	public boolean escribirExcelProgAcademicas (ArrayList<ProgAcademica> listaErrores,String ruta) 
	{
		boolean bandera=true;
		//Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		
		//Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Errores");
		 
		
		int rownum = 0;
		int cellnum = 0;
		Row row = sheet.createRow(rownum++);
		Cell cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Docente");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Asignatura");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Grupo");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Nro Estudiantes");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Días Asignatura");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Hora Inicio");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Hora Fin");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Aula");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Semestre");
	    cell = row.createCell(cellnum++);
	    cell.setCellValue((String)"Anio");
	    
		for (int i=0; i< listaErrores.size();i++ )
		{
		    row = sheet.createRow(rownum++);
		    ProgAcademica progAcademica = listaErrores.get(i);
		    cellnum = 0;
		    
		    	cell = row.createCell(cellnum++);
			    cell.setCellValue((String)progAcademica.getDocenteProgAcademica());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)progAcademica.getAsignaturaProgAcademica());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)progAcademica.getGrupoAsigProgAcademica());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)progAcademica.getNroEstAsigProgAcademica());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)progAcademica.getDiasAsigProgAcademica());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)progAcademica.getHoraIniAsigProgAcademica());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)progAcademica.getHoraFinAsigProgAcademica());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)progAcademica.getAulaClaseProgAcademica());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)progAcademica.getSemestreProgAcademica());
			    cell = row.createCell(cellnum++);
			    cell.setCellValue((String)progAcademica.getAnoProgAcademica());
			     
		}
		try 
		{
			//Write  workbook in file system
			
				 FileOutputStream out = new FileOutputStream(new File(ruta+"\\ErrorCargaProgramacion.xlsx"));
				 workbook.write(out);
				 out.close();
		
		   
		    
		    
		    System.out.println("ErrorCargaProgramacion.xlsx se generó correctamente.");
		     
		} 
		catch (Exception e) 
		{
			bandera=false;
		    e.printStackTrace();
		}
		
		return bandera;
	}	
	
	
}
