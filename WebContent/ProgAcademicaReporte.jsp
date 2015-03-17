<%@page import="co.poli.asesoriastyt.model.Persona"%>
<%@page import="co.poli.asesoriastyt.dao.DAOPersonas"%>
<%@page import="co.poli.asesoriastyt.negocio.NPersona"%>
<%@page
	import="com.sun.corba.se.impl.presentation.rmi.DynamicAccessPermission"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/generales.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gesti&oacute;n de Programaci&oacute; Acad&eacute;mica</title>
</head>
<body>
	<br>
	<br>
	<br>
	<div id="ruta">
		<h1>Consultar Programaci&oacute;n Acad&eacute;mica</h1>
		<br>
		<form name="inicio" action="./ProgAcademicas" method="post">
			<table width="100%" border="0" cellspacing="4" cellpadding="4">
				<tr>
					<%
						NPersona nper = new NPersona();
						DAOPersonas dao = new DAOPersonas();
						List<Persona> listaPersonas = nper.ListadoPersonasDocentes();
					%>
					<td class="label">Seleccione un docente:</td>
					<td><select class="campo02" name="asignaturaProgAcademica">
							<option>...</option>
							<%
								for (Persona pers : listaPersonas) {
							%>
							<option>
								<%=pers.getNombreCompleto() + " " + pers.getPrimerApellido() + " " + pers.getSegundoApellido()%></option>
							<%
								}
							%>
					</select></td>
				</tr>
			</table>
			<br>

			<div style="margin: 5px auto; width: 25%">
				<button name="action" value="Aceptar" class="boton">Aceptar</button>
			</div>

		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>