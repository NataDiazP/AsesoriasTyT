<%@page import="co.poli.asesoriastyt.negocio.NPersona"%>
<%@page import="co.poli.asesoriastyt.negocio.NPerfiles"%>
<%@page import="com.sun.corba.se.impl.presentation.rmi.DynamicAccessPermission"%>
<%@page import="java.util.List"%>
<%@page import="co.poli.asesoriastyt.dao.DAOPersonas"%>
<%@page import="co.poli.asesoriastyt.dao.DAOPerfiles"%>
<%@page import="co.poli.asesoriastyt.model.Persona"%>
<%@page import="co.poli.asesoriastyt.model.Perfil"%>
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
	String  perfil =request.getParameter("perfil");
	
	NPerfiles nperfil = new NPerfiles();
	DAOPerfiles daop = new DAOPerfiles();

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
		perfil=Integer.toString(x.getPerfil());
		
	}
	
	List<Perfil> listaPerf = nperfil.ListadoPerfiles();
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
	<form name="inicio" action="./Estudiantes" method="post">
	<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td class="caja_01_01">&nbsp;</td>
      <td class="caja_01_top" align="center" >Filtros de búsqueda</td>
      <td class="caja_01_02">&nbsp;</td>
    </tr>
     <tr>
      <td class="caja_01_bottom">&nbsp;</td>
      <td valign="top" class="caja_01_bottom">
      <table width="100%" border="0" cellspacing="4" cellpadding="4">
          <tr>
            <td class="label">Documento de Estudiante(*):</td>
            <td><input type="text" name="IdPersona" size="20"maxlength="5" onkeypress="return validar(event)"  placeholder="Documento" value="<%=documento != null ? documento : ""%>"></td>
            <td class="label">Tipo de Documento(*):</td>
            <td><select name="tipoDoc" class="campo02" id="genero">
              <option><%=tipo != null ? tipo : "Seleccione"%></option>
              <option>CC</option>
              <option>CE</option>
              <option>TI</option>
              </select></td>
          	<td class="label">Nombres(*):</td>
            <td><input type="text" name="NombrePersona" size="20"maxlength="5" onkeypress="return sololetras(event)" placeholder="Nombres" value="<%=nombre != null ? nombre : ""%>"></td>
          </tr>
          <tr>
            <td class="label">Primer Apellido(*):</td>
            <td><input type="text" name="apellido1" size="20"maxlength="5" onkeypress="return sololetras(event)"  placeholder="Primer Apellido" value="<%=apellido1 != null ? apellido1 : ""%>"></td>
            <td class="label">Segundo Apellido(*):</td>
            <td><input type="text" name="apellido2"size="30" onkeypress="return sololetras(event)" placeholder="Segundo Apellido" value="<%=apellido2 != null ? apellido2 : ""%>" ></td>
          	<td class="label">Genero(*):</td>
            <td><select name="genero" class="campo02" id="genero">
              <option><%=genero != null ? genero : "Seleccione"%></option>
              <option>F</option>
              <option>M</option>
              </select></td>
          </tr>
          <tr>
            <td class="label">Fecha de Nacimiento(*):</td>
            <td><input type="text" name="fechaN" size="20"maxlength="5" onkeypress="return validar(event)"  placeholder="Fecha Nacimiento" value="<%=fechaN != null ? fechaN : ""%>"></td>
            <td class="label">Dirección(*):</td>	
            <td><input type="text" name="direccion"size="30"  placeholder="Dirección" value="<%=direccion != null ? direccion : ""%>" ></td>
          	<td class="label">Tel&eacute;no(*):</td>
          	<td><input type="text" name="telefono"size="30" onkeypress="return validar(event)" placeholder="Teléfono" value="<%=telefono != null ? telefono : ""%>"></td>
          </tr>
          <tr>
            <td class="label">Celular(*):</td>
            <td><input type="text" name="celular" size="20"maxlength="5" onkeypress="return validar(event)"  placeholder="Celular" value="<%=celular != null ? celular : ""%>"></td>
            <td class="label">Correo(*):</td>	
            <td><input type="text" name="correo"size="30" placeholder="Correo" value="<%=correo != null ? correo : ""%>"></td>
          	<td class="label">Plan de Estudios(*):</td>
          	<td><select name="plan" class="plan" id="plan">
              <option><%=plan != null ? plan : "Seleccione"%></option>
              <option>Técnico Prof. en Prog. de Sistemas de Información</option>
              <option>Tecnología en Sistematización de Datos</option>
              </select></td>
          	</tr>
          <tr>
            <td class="label">Semestre(*):</td>
            <td><input type="text" name="semestre" size="20"maxlength="5" onkeypress="return validar(event)"  placeholder="Semestre" value="<%=semestre != null ? semestre : ""%>"></td>
            <td class="label">Estado (*):</td>	
            <td><select name="genero" class="estado" id="genero">
              <option><%=estado != null ? estado : "Seleccione"%></option>
              <option>Activo</option>
              <option>Inactivo</option>
              </select></td>
               <td class="label">Perfil(*):</td>
				<td><select type="text" class="campo02" name="perfil">
					<option><%=perfil != null ? perfil : "Seleccione"%></option>
					<%
					for (Perfil perf : listaPerf) {
					%>
					<%if (!(perf.getIdPerfil()+"-"+perf.getNombrePerfil()).equals(perfil)) {%>
					<option><%=perf.getIdPerfil()+"-"+perf.getNombrePerfil()%></option>
					<%
					}
					}
					%>
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
		List<Persona> listaPersonas = nper.ListadoPersonasEstudiantes();
	%>
<br>
<br>
 <table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
 <thead>
    <tr>
      <td class="caja_02_01">&nbsp;</td>
      <td class="caja_02_top">Lista de Asesorías</td>
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