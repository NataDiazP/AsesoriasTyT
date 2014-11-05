<%@page import="co.poli.asesoriastyt.negocio.NPerfiles"%>
<%@page
	import="com.sun.corba.se.impl.presentation.rmi.DynamicAccessPermission"%>
<%@page import="java.util.List"%>
<%@page import="co.poli.asesoriastyt.dao.DAOPerfiles"%>
<%@page import="co.poli.asesoriastyt.model.Perfil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	String mensaje = (String) request.getAttribute("mensaje");
	String IdPerfil = request.getParameter("IdPerfil");
	String NombrePerfil = request.getParameter("NombrePerfil");

	Perfil x = request.getAttribute("cli") != null ? (Perfil) request.getAttribute("cli") : null;
	//nombre del atributo cuando lo subo  // operador ternario condicional
	if (x != null) {
		IdPerfil = Integer.toString(x.getIdPerfil());
		NombrePerfil = x.getNombrePerfil();
	}
%>
<script type="text/javascript" src="./js/validacion.js"></script>
<title>Gesti&oacute;n de perfiles</title>
</head>
<body>
	<form name="inicio" action="./Perfiles" method="post">
		<table width="700" border="0" style="padding: 15px;">
			<tr>
				<td align="left">Identificaci&oacute;n perfil:</td>
				<td align="left"><input type="text" name="IdPerfil" size="20"
					maxlength="5" onkeypress="return validar(event)"
					value="<%=IdPerfil != null ? IdPerfil : ""%>">*</td>
				<td align="left">Nombre Perfil:</td>
				<td align="left"><input type="text" name="NombrePerfil"
					size="30" onkeypress="return sololetras(event)"
					value="<%=NombrePerfil != null ? NombrePerfil : ""%>">*</td>
			<tr>
				<td colspan="4" align="center"><br>Los campos con * son
					obligatorios</td>
			<tr>
				<td align="center" colspan="4"><br>
					<hr width="510"> <br>
					<button name="action" value="Crear">Crear</button>
					<button name="action" value="Consultar">Consultar</button>
					<button name="action" value="Modificar">Modificar</button>
					<button name="action" value="Eliminar">Eliminar</button>
			</tr>
		</table>
	</form>

	<%
		NPerfiles nPerf = new NPerfiles();
		DAOPerfiles dao = new DAOPerfiles();
		List<Perfil> listaPerfiles = nPerf.ListadoPerfiles();
	%>

	<table width="100%" align="center" id="rounded-corner" border="1"
		style="font-family: 'Verdana';">
		<thead>
			<tr>
				<th>Id Perfil</th>
				<th>Nombre del perfil</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Perfil perf : listaPerfiles) {
			%>
			<tr align="center">
				<td><%=perf.getIdPerfil()%></td>
				<td><%=perf.getNombrePerfil()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>