<%@page import="co.poli.asesoriastyt.negocio.NPersona"%>
<%@page import="com.sun.corba.se.impl.presentation.rmi.DynamicAccessPermission"%>
<%@page import="java.util.List"%>
<%@page import="co.poli.asesoriastyt.dao.DAOPersonas"%>
<%@page import="co.poli.asesoriastyt.model.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="./css/generales.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	String mensaje = (String) request.getAttribute("mensaje");
	String documento = request.getParameter("documento");
	String tipo = request.getParameter("tipo");
	String nombre = request.getParameter("nombre");
	String apellido1 = request.getParameter("apellido1");
	String apellido2 = request.getParameter("apellido2");
	String genero = request.getParameter("genero");
	String fechaN = request.getParameter("fechaN");
	String direccion = request.getParameter("direccion");
	String telefono = request.getParameter("telefono");
	String celular = request.getParameter("celular");
	String correo = request.getParameter("correo");
	String plan = request.getParameter("plan");
	String semestre = request.getParameter("semestre");
	String estado = request.getParameter("estado");
	int  perfil = Integer.parseInt(request.getParameter("perfil"));

	Persona x = request.getAttribute("cli") != null ? (Persona) request.getAttribute("cli") : null;
	//nombre del atributo cuando lo subo  // operador ternario condicional
	if (x != null) {
		documento = x.getNumeroIdentificacion();
		tipo = x.getTipoIdentificacion();
		nombre=x.getNombreCompleto();
		apellido1=x.getPrimerApellido();
		apellido2=x.getSegundoApellido();
		genero= x.getGenero();
		fechaN=x.getFechaNacimiento();
		direccion=x.getDireccion();
		telefono=x.getTelefono();
		celular=x.getCelular();
		correo=x.getCorreoElectronico();
		plan=x.getPlanEstudios_Estudiante();
		semestre=x.getSemestre_Estudiante();
		estado=x.getEstado();
		perfil=x.getPerfil();
	}
%>
<script type="text/javascript" src="./js/validacion.js"></script>
<title>Gesti&oacute;n de Estudiantes</title>
</head>
<body>
<br>
<br>
<br>
<div id="ruta"> <h1> Gesti&oacute;n de Estudiantes</h1>
<br>
	<form name="inicio" action="./Perfiles" method="post">
	<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td class="caja_01_01">&nbsp;</td>
      <td class="caja_01_top" align="center" >Filtros de b�squeda</td>
      <td class="caja_01_02">&nbsp;</td>
    </tr>
     <tr>
      <td class="caja_01_bottom">&nbsp;</td>
      <td valign="top" class="caja_01_bottom">
      <table width="100%" border="0" cellspacing="4" cellpadding="4">
          <tr>
            <td class="label">Documento de Estudiante(*):</td>
            <td><input type="text" name="IdPerfil" size="20"maxlength="5" onkeypress="return validar(event)"  placeholder="Documento" value=""></td>
            <td class="label">Tipo de Documento(*):</td>
            <td><select name="genero" class="campo02" id="genero">
              <option>Seleccione...</option>
              <option>C�dula de Ciudadan�a</option>
              <option>C�dula de Extranjer�a</option>
              <option>Tarjeta de Identidad</option>
              </select></td>
          	<td class="label">Nombres(*):</td>
            <td><input type="text" name="IdPerfil" size="20"maxlength="5" onkeypress="return validar(event)"  placeholder="Nombres" value=""></td>
          </tr>
          <tr>
            <td class="label">Primer Apellido(*):</td>
            <td><input type="text" name="IdPerfil" size="20"maxlength="5" onkeypress="return validar(event)"  placeholder="Primer Apellido" value=""></td>
            <td class="label">Segundo Apellido(*):</td>
            <td><input type="text" name="NombrePerfil"size="30" onkeypress="return sololetras(event)" placeholder="Segundo Apellido" ></td>
          	<td class="label">Genero(*):</td>
            <td><select name="genero" class="campo02" id="genero">
              <option>Seleccione...</option>
              <option>Femenino</option>
              <option>Masculino</option>
              </select></td>
          </tr>
          <tr>
            <td class="label">Fecha de Nacimiento(*):</td>
            <td><input type="text" name="IdPerfil" size="20"maxlength="5" onkeypress="return validar(event)"  placeholder="Fecha Nacimiento" value=""></td>
            <td class="label">Direcci�n(*):</td>	
            <td><input type="text" name="NombrePerfil"size="30" onkeypress="return sololetras(event)" placeholder="Direcci�n" ></td>
          	<td class="label">Tel&eacute;no(*):</td>
          	<td><input type="text" name="NombrePerfil"size="30" onkeypress="return sololetras(event)" placeholder="Tel�fono" ></td>
          </tr>
          <tr>
            <td class="label">Celular(*):</td>
            <td><input type="text" name="IdPerfil" size="20"maxlength="5" onkeypress="return validar(event)"  placeholder="Celular" value=""></td>
            <td class="label">Correo(*):</td>	
            <td><input type="text" name="NombrePerfil"size="30" onkeypress="return sololetras(event)" placeholder="Correo" ></td>
          	<td class="label">Plan de Estudios(*):</td>
          	<td><input type="text" name="NombrePerfil"size="30" onkeypress="return sololetras(event)" placeholder="Plan Estudios" ></td>
          </tr>
          <tr>
            <td class="label">Semestre(*):</td>
            <td><input type="text" name="IdPerfil" size="20"maxlength="5" onkeypress="return validar(event)"  placeholder="Semestre" value=""></td>
            <td class="label">Estado (*):</td>	
            <td><select name="genero" class="campo02" id="genero">
              <option>Seleccione...</option>
              <option>Activo</option>
              <option>Inactivo</option>
              </select></td>
          </tr>
      </table>
      </td>
      <td class="caja_01_bottom">&nbsp;</td>
    </tr>
    <tr>
    <tr>
      <td class="caja_bottom_01"></td>
      <td class="caja_01_bottom"></td>
      <td class="caja_bottom_02"></td>
    </tr>			
  </table>  
<br>

  <div style="margin: 0 auto; width:25%">
    <button name="action" value="Crear" class="boton">Crear</button>
	<button name="action" value="Consultar" class="boton">Consultar</button>
	<button name="action" value="Modificar" class="boton">Modificar</button>
	<button name="action" value="Eliminar" class="boton">Eliminar</button>
 </div>
		
	</form>

	<%
		NPersona nper = new NPersona();
		DAOPersonas dao = new DAOPersonas();
		List<Persona> listaPersonas = nper.ListadoPersonas();
	%>
<br>
<br>
 <table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
 <thead>
    <tr>
      <td class="caja_02_01">&nbsp;</td>
      <td class="caja_02_top">Lista de Asesor�as</td>
      <td class="caja_02_02">&nbsp;</td>
    </tr>
    <tr>
      <td class="caja_01_bottom">&nbsp;</td>
      <td valign="top" class="caja_01_bottom"><table width="100%" align="center" id="rounded-corner">
          <thead>
            <tr>
              <th class="rounded" scope="col">Documento</th>
              <th class="rounded" scope="col">Tipo Documento</th>
              <th class="rounded" scope="col">Nombres</th>
              <th class="rounded" scope="col">Primer Apellido</th>
              <th class="rounded" scope="col">Segundo Apellido</th>
              <th class="rounded" scope="col">G&eacute;nero</th>
              <th class="rounded" scope="col">Fecha Nacimiento</th>
              <th class="rounded" scope="col">Direcci&oacute;n</th>
              <th class="rounded" scope="col">Tel&eacute;fono</th>
              <th class="rounded" scope="col">Celular</th>
              <th class="rounded" scope="col">Correo</th>
              <th class="rounded" scope="col">Semestre</th>
              <th class="rounded" scope="col">Estado</th>
              <th class="rounded" scope="col">Perfil</th>
            </tr>
    </thead>
	<tbody>
	<%
		for (Persona per : listaPersonas) {
		%>
		<tr align="center">
		<td><%=per.getNumeroIdentificacion()%></td>
		<td><%=per.getTipoIdentificacion()%></td>
		<td><%=per.getNombreCompleto()%></td>
		<td><%=per.getPrimerApellido()%></td>
		<td><%=per.getSegundoApellido()%></td>
		<td><%=per.getGenero()%></td>
		<td><%=per.getFechaNacimiento()%></td>
		<td><%=per.getDireccion()%></td>
		<td><%=per.getTelefono()%></td>
		<td><%=per.getCelular()%></td>
		<td><%=per.getCorreoElectronico()%></td>
		<td><%=per.getSemestre_Estudiante()%></td>
		<td><%=per.getEstado()%></td>
		<td><%=per.getPerfil()%></td>
		</tr>
		<%
		}
		%>
		
			
	</tbody>
	</table>
	</td>
    </tr>
    </table>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>