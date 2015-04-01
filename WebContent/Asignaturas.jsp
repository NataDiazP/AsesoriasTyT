<%@page import="co.poli.asesoriastyt.model.PlanEstudio"%>
<%@page import="co.poli.asesoriastyt.negocio.NAsignatura"%>
<%@page import="co.poli.asesoriastyt.negocio.NPerfiles"%>
<%@page
	import="com.sun.corba.se.impl.presentation.rmi.DynamicAccessPermission"%>
<%@page import="java.util.List"%>
<%@page import="co.poli.asesoriastyt.dao.DAOAsignaturas"%>
<%@page import="co.poli.asesoriastyt.model.Asignatura"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/generales.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	String mensaje = (String) request.getAttribute("mensaje");
	String idAsignatura = request.getParameter("codigo");
	String nombreAsignatura = request.getParameter("nombre");

	Asignatura x = request.getAttribute("cli") != null ? (Asignatura) request.getAttribute("cli") : null;
	//nombre del atributo cuando lo subo  // operador ternario condicional
	if (x != null) {
		idAsignatura = x.getIdAsignatura();
		nombreAsignatura = x.getNombreAsignatura();
	}

	NAsignatura nAsig = new NAsignatura();
%>
<script type="text/javascript" src="./js/validacion.js"></script>
<title>Gesti&oacute;n de Asignaturas</title>
</head>
<body>
	<br>
	<br>
	<br>
	<div id="ruta">
		<h1>Gesti&oacute;n de Asignaturas</h1>
		<br>
		<form name="inicio" action="./Asignaturas" method="post">
			<table width="85%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td class="caja_01_01">&nbsp;</td>
					<td class="caja_01_top" align="center">Filtros de búsqueda</td>
					<td class="caja_01_02">&nbsp;</td>
				</tr>
				<tr>
					<td class="caja_01_bottom">&nbsp;</td>
					<td valign="top" class="caja_01_bottom">
						<table width="100%" border="0" cellspacing="4" cellpadding="4">
							<tr>
								<td class="label">C&oacute;digo de Asignatura(*):</td>
								<td><input type="text" name="codigo" size="20"
									maxlength="10" placeholder="Código"
									value="<%=idAsignatura != null ? idAsignatura : ""%>"></td>
								<td class="label">Nombre Asignatura(*):</td>
								<td><input type="text" name="nombre" size="30"
									placeholder="Nombre"
									value="<%=nombreAsignatura != null ? nombreAsignatura : ""%>"></td>
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

			<div style="margin: 0 auto; width: 25%">
				<button name="action" value="Crear" class="boton">Crear</button>
				<button name="action" value="Consultar" class="boton">Consultar</button>
				<button name="action" value="Modificar" class="boton">Modificar</button>
				<button name="action" value="Eliminar" class="boton">Eliminar</button>
			</div>

		</form>

		<%
			List<Asignatura> listaAsignaturas = nAsig.ListadoAsignaturas();
		%>
		<br> <br>
		<table width="85%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<thead>
				<tr>
					<td class="caja_02_01">&nbsp;</td>
					<td class="caja_02_top">Lista de Asignaturas</td>
					<td class="caja_02_02">&nbsp;</td>
				</tr>
				<tr>
					<td class="caja_01_bottom">&nbsp;</td>
					<td valign="top" class="caja_01_bottom"><table width="100%"
							align="center" id="rounded-corner">
							<thead>
								<tr>
									<th class="rounded" scope="col">Código</th>
									<th class="rounded" scope="col">Nombre Asignatura</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (Asignatura asig : listaAsignaturas)
									{
								%>
								<tr align="center">
									<td><%=asig.getIdAsignatura()%></td>
									<td><%=asig.getNombreAsignatura()%></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table></td>
				</tr>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
