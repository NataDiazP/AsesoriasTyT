package co.poli.asesoriastyt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import sun.util.calendar.BaseCalendar.Date;
import co.poli.asesoriastyt.control.Docentes;
import co.poli.asesoriastyt.model.Persona;

public class LeerExcel 
{
	ArrayList<Persona> listaErroresDocentes= new ArrayList<Persona>();
	ArrayList<Persona> listaErroresEstudiantes= new ArrayList<Persona>();
	public static void main(String[] args) 
	{
	}
	
	
	/**
	 * @return the listaErroresEstudiantes
	 */
	public ArrayList<Persona> getListaErroresEstudiantes() {
		return listaErroresEstudiantes;
	}


	/**
	 * @param listaErroresEstudiantes the listaErroresEstudiantes to set
	 */
	public void setListaErroresEstudiantes(
			ArrayList<Persona> listaErroresEstudiantes) {
		this.listaErroresEstudiantes = listaErroresEstudiantes;
	}


	/**
	 * @return the listaErroresDocentes
	 */
	public ArrayList<Persona> getListaErroresDocentes() {
		return listaErroresDocentes;
	}

	/**
	 * @param listaErrores the listaErrores to set
	 */
	public void setListaErroresDocentes(ArrayList<Persona> listaErroresDocentes) {
		this.listaErroresDocentes = listaErroresDocentes;
	}

	public ArrayList<Persona> leerArchivoDocentes()
	{
		ArrayList<Persona> lista= new ArrayList<Persona>();
		ArrayList<Persona> listaErroresDocentes= new ArrayList<Persona>();
		try
		{
			FileInputStream file = new FileInputStream(new File("C:\\docentes.xlsx"));

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int contadorColumnas =0;
			int contadorFilas=0;
			boolean error= false;
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				contadorColumnas =0;
				error=false;
				Persona persona = new Persona();
				while ((cellIterator.hasNext())&& (contadorColumnas<12))
				{
					
					Cell cell = cellIterator.next();
					
					if(contadorFilas>0)//Check the cell type and format accordingly
					{
						switch (contadorColumnas) 
						{
							case 0:
								try
								{
									int doc= (int)cell.getNumericCellValue();
									persona.setNumeroIdentificacion(Integer.toString(doc));
									System.out.print(cell.getNumericCellValue() + "\t");
									
								}
								catch(Exception e) 
								{
									error=true;
									persona.setNumeroIdentificacion("Error");
								}
								break;
								
							case 1:
								try
								{
									persona.setTipoIdentificacion(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
									
								}
								catch(Exception e) 
								{
									error=true;
									persona.setTipoIdentificacion("Error");
								}
								break;
							case 2:
								try
								{
									persona.setNombreCompleto(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
									
								}
								catch(Exception e) 
								{
									error=true;
									persona.setNombreCompleto("Error");
								}
								break;
							case 3:
								try
								{
									persona.setPrimerApellido(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
									
								}
								catch(Exception e) 
								{
									error=true;
									persona.setPrimerApellido("Error");
								}
								break;
							case 4:
								try
								{
									persona.setSegundoApellido(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
								}
								catch(Exception e) 
								{
									error=true;
									persona.setSegundoApellido("Error");
								}
								
								break;
							case 5:
								try
								{
									persona.setGenero(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
								}
								catch(Exception e) 
								{
									error=true;
									persona.setGenero("Error");
								}
								break;
							case 6:
								try
								{
									String fecha="";
									SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
									try
									{  
										   fecha = formato.format(cell.getDateCellValue());  
									}
									catch(Exception exp)
									{  
										 
									}  
								
									persona.setFechaNacimiento(fecha);
									System.out.print(cell.getDateCellValue() + "\t");
								}
								catch(Exception e) 
								{
									error=true;
									persona.setFechaNacimiento("Error");
								}
								break;
							case 7:
								try
								{
									persona.setDireccion(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
								}
								catch(Exception e) 
								{
									error=true;
									persona.setDireccion("Error");
								}
								break;
							case 8:
								try
								{

									int tel= (int)cell.getNumericCellValue();
									persona.setTelefono(Integer.toString(tel));
									System.out.print(cell.getNumericCellValue() + "\t");
								}
								catch(Exception e) 
								{
									try
									{
										persona.setTelefono(cell.getStringCellValue());
										System.out.print(cell.getStringCellValue() + "\t");
									}
									catch(Exception ex) 
									{
										error=true;
										persona.setTelefono("Error");
									}
								}
								
								break;
							case 9:
								try
								{
									int cel= (int)cell.getNumericCellValue();
									persona.setCelular(Integer.toString(cel));
									System.out.print(cell.getNumericCellValue() + "\t");
								}
								catch(Exception e) 
								{
									try
									{
										persona.setCelular(cell.getStringCellValue());
										System.out.print(cell.getStringCellValue() + "\t");
									}
									catch(Exception ex) 
									{
										error=true;
										persona.setCelular("Error");
									}
								}
								
								break;
							case 10:
								try
								{
									boolean validar=validarCorreo(cell.getStringCellValue());
									if (validar!=false)
									{
										persona.setCorreoElectronico(cell.getStringCellValue());
										System.out.print(cell.getStringCellValue() + "\t");
									}
								}
								catch(Exception e) 
								{
									error=true;
									persona.setCorreoElectronico("Error");
								}
								break;
							case 11:
								try
								{
									persona.setEstado(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
								}
								catch(Exception e) 
								{
									error=true;
									persona.setEstado("Error");
								}
								break;
		
						}
					}
					contadorColumnas=contadorColumnas+1;
				}
				if(persona.getNumeroIdentificacion()!=null)
				{
					if(error==true)
					{
						persona.setPlanEstudios_Estudiante("N/A");
						persona.setSemestre_Estudiante("N/A");
						persona.setPerfil("2");
						listaErroresDocentes.add(persona);
						
					}
					else
					{
						persona.setPlanEstudios_Estudiante("N/A");
						persona.setSemestre_Estudiante("N/A");
						persona.setPerfil("2");
						lista.add(persona);
					}
				}
				System.out.println("");
				contadorFilas=contadorFilas+1;
			}
			file.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		this.listaErroresDocentes=listaErroresDocentes;
		return lista;

	}
	
	public boolean validarCorreo(String correo)
	{
		boolean bandera= true;
		int resultado = correo.indexOf("elpoli.edu.co");
		 
		if(resultado == -1) 
		{
			bandera= false;
		}
		return bandera;
	}

	/**
	 * @return
	 */
	public ArrayList<Persona> leerArchivoEstudiantes() {
	
		ArrayList<Persona> lista= new ArrayList<Persona>();
		ArrayList<Persona> listaErroresEstudiantes= new ArrayList<Persona>();
		try
		{
			FileInputStream file = new FileInputStream(new File("C:\\estudiantes.xlsx"));

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int contadorColumnas =0;
			int contadorFilas=0;
			boolean error= false;
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				contadorColumnas =0;
				error=false;
				Persona persona = new Persona();
				while ((cellIterator.hasNext())&& (contadorColumnas<14))
				{
					
					Cell cell = cellIterator.next();
					
					if(contadorFilas>0)//Check the cell type and format accordingly
					{
						switch (contadorColumnas) 
						{
							case 0:
								try
								{
									int doc= (int)cell.getNumericCellValue();
									persona.setNumeroIdentificacion(Integer.toString(doc));
									System.out.print(cell.getNumericCellValue() + "\t");
									
								}
								catch(Exception e) 
								{
									error=true;
									persona.setNumeroIdentificacion("Error");
								}
								break;
								
							case 1:
								try
								{
									persona.setTipoIdentificacion(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
									
								}
								catch(Exception e) 
								{
									error=true;
									persona.setTipoIdentificacion("Error");
								}
								break;
							case 2:
								try
								{
									persona.setNombreCompleto(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
									
								}
								catch(Exception e) 
								{
									error=true;
									persona.setNombreCompleto("Error");
								}
								break;
							case 3:
								try
								{
									persona.setPrimerApellido(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
									
								}
								catch(Exception e) 
								{
									error=true;
									persona.setPrimerApellido("Error");
								}
								break;
							case 4:
								try
								{
									persona.setSegundoApellido(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
								}
								catch(Exception e) 
								{
									error=true;
									persona.setSegundoApellido("Error");
								}
								
								break;
							case 5:
								try
								{
									persona.setGenero(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
								}
								catch(Exception e) 
								{
									error=true;
									persona.setGenero("Error");
								}
								break;
							case 6:
								try
								{
									String fecha="";
									SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
									try
									{  
										   fecha = formato.format(cell.getDateCellValue());  
									}
									catch(Exception exp)
									{  
										 
									}  
								
									persona.setFechaNacimiento(fecha);
									System.out.print(cell.getDateCellValue() + "\t");
								}
								catch(Exception e) 
								{
									error=true;
									persona.setFechaNacimiento("Error");
								}
								break;
							case 7:
								try
								{
									persona.setDireccion(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
								}
								catch(Exception e) 
								{
									error=true;
									persona.setDireccion("Error");
								}
								break;
							case 8:
								try
								{

									int tel= (int)cell.getNumericCellValue();
									persona.setTelefono(Integer.toString(tel));
									System.out.print(cell.getNumericCellValue() + "\t");
								}
								catch(Exception e) 
								{
									try
									{
										persona.setTelefono(cell.getStringCellValue());
										System.out.print(cell.getStringCellValue() + "\t");
									}
									catch(Exception ex) 
									{
										error=true;
										persona.setTelefono("Error");
									}
								}
								
								break;
							case 9:
								try
								{
									int cel= (int)cell.getNumericCellValue();
									persona.setCelular(Integer.toString(cel));
									System.out.print(cell.getNumericCellValue() + "\t");
								}
								catch(Exception e) 
								{
									try
									{
										persona.setCelular(cell.getStringCellValue());
										System.out.print(cell.getStringCellValue() + "\t");
									}
									catch(Exception ex) 
									{
										error=true;
										persona.setCelular("Error");
									}
								}
								
								break;
							case 10:
								try
								{
									boolean validar=validarCorreo(cell.getStringCellValue());
									if (validar!=false)
									{
										persona.setCorreoElectronico(cell.getStringCellValue());
										System.out.print(cell.getStringCellValue() + "\t");
									}
								}
								catch(Exception e) 
								{
									error=true;
									persona.setCorreoElectronico("Error");
								}
								break;
							case 11:
								try
								{
									persona.setPlanEstudios_Estudiante(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
								}
								catch(Exception e) 
								{
									error=true;
									persona.setPlanEstudios_Estudiante("Error");
								}
								break;
							case 12:
								try
								{
									int sem= (int)cell.getNumericCellValue();
									persona.setSemestre_Estudiante(Integer.toString(sem));
									System.out.print(cell.getNumericCellValue() + "\t");
								}
								catch(Exception e) 
								{
									error=true;
									persona.setSemestre_Estudiante("Error");
								}
								break;
							case 13:
								try
								{
									persona.setEstado(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
								}
								catch(Exception e) 
								{
									error=true;
									persona.setEstado("Error");
								}
								break;
		
						}
					}
					contadorColumnas=contadorColumnas+1;
				}
				if(persona.getNumeroIdentificacion()!=null)
				{
					if(error==true)
					{
						persona.setPerfil("3");
						listaErroresEstudiantes.add(persona);
						
					}
					else
					{
						persona.setPerfil("3");
						lista.add(persona);
					}
				}
				System.out.println("");
				contadorFilas=contadorFilas+1;
			}
			file.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		this.listaErroresEstudiantes=listaErroresEstudiantes;
		return lista;
	}
}
