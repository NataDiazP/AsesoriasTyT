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

import java.sql.Connection;

import sun.util.calendar.BaseCalendar.Date;
import co.poli.asesoriastyt.control.Docentes;
import co.poli.asesoriastyt.model.Asignatura;
import co.poli.asesoriastyt.model.Persona;
import co.poli.asesoriastyt.model.ProgAcademica;
import co.poli.asesoriastyt.negocio.NAsignatura;
import co.poli.asesoriastyt.negocio.NPersona;
import co.poli.asesoriastyt.negocio.NProgAcademica;


/**
 *  Class LeerExcel.
 *  @author Natalia Díaz , Natalia Velez , Paola Vargas
 */
public class LeerExcel 
{
	
	/**  lista errores docentes. */
	ArrayList<Persona> listaErroresDocentes= new ArrayList<Persona>();
	ArrayList<Persona> listaDocentes= new ArrayList<Persona>();
	XSSFSheet hojaProg =null;
	/**  lista errores estudiantes. */
	ArrayList<Persona> listaErroresEstudiantes= new ArrayList<Persona>();
	ArrayList<Persona> listaEstudiantes= new ArrayList<Persona>();

	ArrayList<Asignatura> listaErroresAsignaturas= new ArrayList<Asignatura>();
	ArrayList<Asignatura> listaAsignaturas= new ArrayList<Asignatura>();

	private ArrayList<ProgAcademica> listaErroresProgramacion= new ArrayList<ProgAcademica>();
	ArrayList<ProgAcademica> listaProgramacion= new ArrayList<ProgAcademica>();
	
	/**
	 *  main method.
	 *
	 * @param args  arguments
	 */
	public static void main(String[] args) 
	{
	}
	
	
	
	


	/**
	 * @return  hojaProg
	 */
	public XSSFSheet getHojaProg() {
		return hojaProg;
	}






	/**
	 * @param hojaProg  hojaProg to set
	 */
	public void setHojaProg(XSSFSheet hojaProg) {
		this.hojaProg = hojaProg;
	}






	/**
	 * @return  listaDocentes
	 */
	public ArrayList<Persona> getListaDocentes() {
		return listaDocentes;
	}


	/**
	 * @param listaDocentes  listaDocentes to set
	 */
	public void setListaDocentes(ArrayList<Persona> listaDocentes) {
		this.listaDocentes = listaDocentes;
	}


	/**
	 * @return  listaEstudiantes
	 */
	public ArrayList<Persona> getListaEstudiantes() {
		return listaEstudiantes;
	}


	/**
	 * @param listaEstudiantes  listaEstudiantes to set
	 */
	public void setListaEstudiantes(ArrayList<Persona> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}


	/**
	 * @return  listaAsignaturas
	 */
	public ArrayList<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}


	/**
	 * @param listaAsignaturas  listaAsignaturas to set
	 */
	public void setListaAsignaturas(ArrayList<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}


	/**
	 * @return  listaProgramacion
	 */
	public ArrayList<ProgAcademica> getListaProgramacion() {
		return listaProgramacion;
	}


	/**
	 * @param listaProgramacion  listaProgramacion to set
	 */
	public void setListaProgramacion(ArrayList<ProgAcademica> listaProgramacion) {
		this.listaProgramacion = listaProgramacion;
	}


	/**
	 * @return  listaErroresProgramacion
	 */
	public ArrayList<ProgAcademica> getListaErroresProgramacion() {
		return listaErroresProgramacion;
	}


	/**
	 * @param listaErroresProgramacion  listaErroresProgramacion to set
	 */
	public void setListaErroresProgramacion(
			ArrayList<ProgAcademica> listaErroresProgramacion) {
		this.listaErroresProgramacion = listaErroresProgramacion;
	}


	/**
	 * @return  listaErroresAsignaturas
	 */
	public ArrayList<Asignatura> getListaErroresAsignaturas() {
		return listaErroresAsignaturas;
	}


	/**
	 * @param listaErroresAsignaturas  listaErroresAsignaturas to set
	 */
	public void setListaErroresAsignaturas(
			ArrayList<Asignatura> listaErroresAsignaturas) {
		this.listaErroresAsignaturas = listaErroresAsignaturas;
	}


	/**
	 * Gets  lista errores estudiantes.
	 *
	 * @return  listaErroresEstudiantes
	 */
	public ArrayList<Persona> getListaErroresEstudiantes() {
		return listaErroresEstudiantes;
	}


	/**
	 * Sets  lista errores estudiantes.
	 *
	 * @param listaErroresEstudiantes  listaErroresEstudiantes to set
	 */
	public void setListaErroresEstudiantes(
			ArrayList<Persona> listaErroresEstudiantes) {
		this.listaErroresEstudiantes = listaErroresEstudiantes;
	}


	/**
	 * Gets  lista errores docentes.
	 *
	 * @return  listaErroresDocentes
	 */
	public ArrayList<Persona> getListaErroresDocentes() {
		return listaErroresDocentes;
	}

	/**
	 * Sets  lista errores docentes.
	 *
	 * @param listaErroresDocentes  new lista errores docentes
	 */
	public void setListaErroresDocentes(ArrayList<Persona> listaErroresDocentes) {
		this.listaErroresDocentes = listaErroresDocentes;
	}
	
	

	/**
	 * Leer archivo docentes.
	 *
	 * @param filecontent  filecontent
	 * @return  array list
	 */
	public ArrayList<Persona> leerArchivoDocentes(InputStream filecontent)
	{
		
		
		NPersona npersona= new NPersona();
		ArrayList<Persona> lista= new ArrayList<Persona>();
		ArrayList<Persona> listaErroresDocentes= new ArrayList<Persona>();
		try
		{
		

			
			XSSFWorkbook workbook = new XSSFWorkbook(filecontent);
			XSSFSheet sheet = workbook.getSheetAt(0);
			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int contadorColumnas =0;
			int contadorFilas=0;
			boolean error= false;
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				//For each row, iterate through all  columns
				Iterator<Cell> cellIterator = row.cellIterator();
				if((contadorColumnas!=12)&&(contadorFilas==1))
				{
					return lista;
				}
				contadorColumnas =0;
				error=false;
				Persona persona = new Persona();
				while ((cellIterator.hasNext())&& (contadorColumnas<12))
				{
					
					Cell cell = cellIterator.next();
					
					if(contadorFilas>0)//Check  cell type and format accordingly
					{
						switch (contadorColumnas) 
						{
							case 0:
								try
								{
									int doc= (int)cell.getNumericCellValue();
									boolean validar= npersona.validarExistenciaPersona(""+doc);
									if(validar)
									{
										error=true;
										persona.setNumeroIdentificacion("ID "+doc+" existente");
									}
									else
									{
										persona.setNumeroIdentificacion(Integer.toString(doc));
										System.out.print(cell.getNumericCellValue() + "\t");
									}
									
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
									SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
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
									boolean validar2=npersona.validarExistenciaCorreo(cell.getStringCellValue());
									if ((validar!=false)&&(validar2==false))
									{
										persona.setCorreoElectronico(cell.getStringCellValue());
										System.out.print(cell.getStringCellValue() + "\t");
									}
									else
									{
										error=true;
										persona.setCorreoElectronico("Error");
										
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
						persona.setSemestre_Estudiante("N");
						persona.setPerfil("2");
						lista.add(persona);
					}
				}
				System.out.println("");
				contadorFilas=contadorFilas+1;
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		this.listaDocentes=lista;
		this.listaErroresDocentes=listaErroresDocentes;
		return lista;

	}
	
	/**
	 * Validar correo.
	 *
	 * @param correo  correo
	 * @return true, if successful
	 */
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
	 * Leer archivo estudiantes.
	 *
	 * @param filecontent  filecontent
	 * @return  array list
	 */
	public ArrayList<Persona> leerArchivoEstudiantes(InputStream filecontent) {
		
		NPersona npersona= new NPersona();
		ArrayList<Persona> lista= new ArrayList<Persona>();
		ArrayList<Persona> listaErroresEstudiantes= new ArrayList<Persona>();
		
		try
		{

			XSSFWorkbook workbook = new XSSFWorkbook(filecontent);
			XSSFSheet sheet = workbook.getSheetAt(0);
			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int contadorColumnas =0;
			int contadorFilas=0;
			boolean error= false;
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				//For each row, iterate through all  columns
				Iterator<Cell> cellIterator = row.cellIterator();
				if((contadorColumnas!=14)&&(contadorFilas==1))
				{
					return lista;
				}
					
				contadorColumnas =0;
				error=false;
				Persona persona = new Persona();
				while ((cellIterator.hasNext())&& (contadorColumnas<14))
				{
					
					Cell cell = cellIterator.next();
					
					if(contadorFilas>0)//Check  cell type and format accordingly
					{
						switch (contadorColumnas) 
						{
							case 0:
								try
								{
									int doc= (int)cell.getNumericCellValue();
									boolean validar= npersona.validarExistenciaPersona(""+doc);
									if(validar)
									{
										error=true;
										persona.setNumeroIdentificacion("ID "+doc+" existente");
									}
									else
									{
										persona.setNumeroIdentificacion(Integer.toString(doc));
										System.out.print(cell.getNumericCellValue() + "\t");
									}
									
									
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
									SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
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
									boolean validar2=npersona.validarExistenciaCorreo(cell.getStringCellValue());
									if ((validar!=false)&&(validar2==false))
									{
										persona.setCorreoElectronico(cell.getStringCellValue());
										System.out.print(cell.getStringCellValue() + "\t");
									}
									else
									{
										error=true;
										persona.setCorreoElectronico("Error");
										
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
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		this.listaEstudiantes=lista;
		this.listaErroresEstudiantes=listaErroresEstudiantes;
		return lista;
	}


	
	
	/**
	 * Leer archivo Asignaturas.
	 *
	 * @param filecontent  filecontent
	 * @return  array list
	 */
	
public ArrayList<Asignatura> leerArchivoAsignaturas(InputStream filecontent) {
		
		NAsignatura nasignatura= new NAsignatura();
		ArrayList<Asignatura> lista= new ArrayList<Asignatura>();
		ArrayList<Asignatura> listaErroresAsignaturas= new ArrayList<Asignatura>();
		
		try
		{
			XSSFWorkbook workbook = new XSSFWorkbook(filecontent);
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int contadorColumnas =0;
			int contadorFilas=0;
			boolean error= false;
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				//For each row, iterate through all  columns
				Iterator<Cell> cellIterator = row.cellIterator();
				if((contadorColumnas!=2)&&(contadorFilas==1))
				{
					return lista;
				}
					
				contadorColumnas =0;
				error=false;
				Asignatura asignatura = new Asignatura();
				while ((cellIterator.hasNext())&& (contadorColumnas<2))
				{
					
					Cell cell = cellIterator.next();
					
					if(contadorFilas>0)//Check  cell type and format accordingly
					{
						switch (contadorColumnas) 
						{
							case 0:
								try
								{
									String cod= cell.getStringCellValue();
									boolean validar= nasignatura.validarExistenciaAsignatura(""+cod);
									if(validar)
									{
										error=true;
										asignatura.setIdAsignatura("ID "+cod+" existente");
									}
									else
									{
										asignatura.setIdAsignatura(cod);
										System.out.print(cell.getStringCellValue() + "\t");
									}
									
									
								}
								catch(Exception e) 
								{
									error=true;
									asignatura.setIdAsignatura("Error");
								}
								break;
								
							case 1:
								try
								{
									asignatura.setNombreAsignatura(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
									
								}
								catch(Exception e) 
								{
									error=true;
									asignatura.setNombreAsignatura("Error");
								}
								break;
							
		
						}
					}
					contadorColumnas=contadorColumnas+1;
				}
				if(asignatura.getIdAsignatura()!=null)
				{
					if(error==true)
					{
						listaErroresAsignaturas.add(asignatura);
						
					}
					else
					{
						lista.add(asignatura);
					}
				}
				
				System.out.println("");
				contadorFilas=contadorFilas+1;
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		this.listaAsignaturas=lista;
		this.listaErroresAsignaturas=listaErroresAsignaturas;
		return lista;
	}
	
	public ArrayList<ProgAcademica> leerArchivoProgramacion( InputStream filecontent)
	{
		NPersona npersonas= new NPersona();
		NAsignatura nasignatura= new NAsignatura();
		ArrayList<ProgAcademica> lista= new ArrayList<ProgAcademica>();
		ArrayList<ProgAcademica> listaErroresProgramacion= new ArrayList<ProgAcademica>();
		try
		{
			XSSFWorkbook workbook = new XSSFWorkbook(filecontent);
			XSSFSheet sheet = workbook.getSheetAt(0);
			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int contadorColumnas =0;
			int contadorFilas=0;
			boolean error= false;
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				//For each row, iterate through all  columns
				Iterator<Cell> cellIterator = row.cellIterator();
				if((contadorColumnas!=10)&&(contadorFilas==1))
				{
					return lista;
				}
				contadorColumnas =0;
				error=false;
				ProgAcademica programacion = new ProgAcademica();
				while ((cellIterator.hasNext())&& (contadorColumnas<10))
				{
					
					Cell cell = cellIterator.next();
					
					if(contadorFilas>0)//Check  cell type and format accordingly
					{
						switch (contadorColumnas) 
						{
							case 0:
								try
								{
									int doc= (int)cell.getNumericCellValue();
									boolean validar= npersonas.validarExistenciaDocente(""+doc);
									if(!validar)
									{
										error=true;
										programacion.setDocenteProgAcademica("ID "+doc+"  no existe");
									}
									else
									{
										programacion.setDocenteProgAcademica(Integer.toString(doc));
										System.out.print(cell.getNumericCellValue() + "\t");
									}
									
								}
								catch(Exception e) 
								{
									error=true;
									programacion.setDocenteProgAcademica("Error");
								}
								break;
							case 1:
								try
								{
									String asignatura= cell.getStringCellValue();
									boolean validar= nasignatura.validarExistenciaAsignatura(asignatura);
									if(!validar)
									{
										error=true;
										programacion.setAsignaturaProgAcademica("ID "+asignatura+" no existe");
									}
									else
									{
										programacion.setAsignaturaProgAcademica(asignatura);
										System.out.print(cell.getStringCellValue() + "\t");
									}
									
								}
								catch(Exception e) 
								{
									error=true;
									programacion.setAsignaturaProgAcademica("Error");
								}
								break;
							case 2:
								try
								{
									int grupo= (int) cell.getNumericCellValue(); 
									programacion.setGrupoAsigProgAcademica(""+grupo);
									System.out.print(cell.getNumericCellValue() + "\t");
									
								}
								catch(Exception e) 
								{
									error=true;
									programacion.setGrupoAsigProgAcademica("Error");
								}
								break;
							case 3:
								try
								{
									int numero=(int) cell.getNumericCellValue();
									programacion.setNroEstAsigProgAcademica(""+numero);
									System.out.print(cell.getNumericCellValue() + "\t");
									
								}
								catch(Exception e) 
								{
									error=true;
									programacion.setNroEstAsigProgAcademica("Error");
								}
								break;
							case 4:
								try
								{
									int dias=(int) cell.getNumericCellValue();
									programacion.setDiasAsigProgAcademica(""+dias);
									System.out.print(cell.getNumericCellValue() + "\t");
									
								}
								catch(Exception e) 
								{
									error=true;
									programacion.setDiasAsigProgAcademica("Error");
								}
								break;
							case 5:
								try
								{
									programacion.setHoraIniAsigProgAcademica(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
								}
								catch(Exception e) 
								{
									error=true;
									programacion.setHoraIniAsigProgAcademica("Error");
								}
								
								break;
							case 6:
								try
								{
									programacion.setHoraFinAsigProgAcademica(cell.getStringCellValue());
									System.out.print(cell.getStringCellValue() + "\t");
								}
								catch(Exception e) 
								{
									error=true;
									programacion.setHoraFinAsigProgAcademica("Error");
								}
								break;
							case 7:
								try
								{
									String aula=cell.getStringCellValue();
									programacion.setAulaClaseProgAcademica(aula);
									System.out.print(cell.getStringCellValue() + "\t");
									
								}
								catch(Exception e) 
								{
									error=true;
									programacion.setAulaClaseProgAcademica("Error");
								}
								break;
							case 8:
								try
								{
									int semestre= (int) cell.getNumericCellValue();
									programacion.setSemestreProgAcademica(""+semestre);
									System.out.print(cell.getNumericCellValue() + "\t");
									
								}
								catch(Exception e) 
								{
									error=true;
									programacion.setSemestreProgAcademica("Error");
								}
							break;
							case 9:
								try
								{
									int anio=(int) cell.getNumericCellValue();
									programacion.setAnoProgAcademica(""+anio);
									System.out.print(cell.getNumericCellValue() + "\t");
										
								}
									catch(Exception e) 
									{
										error=true;
										programacion.setAnoProgAcademica("Error");
									}
									break;
		
						}
					}
					contadorColumnas=contadorColumnas+1;
				}
				if(programacion.getDocenteProgAcademica()!=null)
				{
					if(error==true)
					{
					
						listaErroresProgramacion.add(programacion);
						
					}
					else
					{
				
						lista.add(programacion);
					}
				}
				System.out.println("");
				contadorFilas=contadorFilas+1;
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		this.listaProgramacion=lista;
		this.listaErroresProgramacion=listaErroresProgramacion;
		return lista;
	
	}

	
}
