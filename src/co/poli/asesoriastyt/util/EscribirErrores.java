package co.poli.asesoriastyt.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import co.poli.asesoriastyt.model.Persona;


public class EscribirErrores 
{

	public boolean escribirExcelDocentes (ArrayList<Persona> listaErrores) 
	{
		boolean bandera=true;
		//Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		
		//Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Errores");
		 
		
		int rownum = 0;
		for (int i=0; i< listaErrores.size();i++ )
		{
		    Row row = sheet.createRow(rownum++);
		    Persona persona = listaErrores.get(i);
		    int cellnum = 0;
		    
		    Cell cell = row.createCell(cellnum++);
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
			//Write the workbook in file system
			
				 FileOutputStream out = new FileOutputStream(new File("C:\\Paola\\ErrorCargaDocentes.xlsx"));
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
	
	public boolean escribirExcelEstudiantes (ArrayList<Persona> listaErrores) 
	{
		boolean bandera=true;
		//Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		
		//Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Errores");
		 
		
		int rownum = 0;
		for (int i=0; i< listaErrores.size();i++ )
		{
		    Row row = sheet.createRow(rownum++);
		    Persona persona = listaErrores.get(i);
		    int cellnum = 0;
		    
		    Cell cell = row.createCell(cellnum++);
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
			//Write the workbook in file system
			
				 FileOutputStream out = new FileOutputStream(new File("C:\\Paola\\ErrorCargaEstudiantes.xlsx"));
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
	
	
}
