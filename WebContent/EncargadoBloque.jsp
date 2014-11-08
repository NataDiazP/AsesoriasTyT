<%@page import="co.poli.asesoriastyt.dao.DAOEncargadosBloques"%>
<%@page import="co.poli.asesoriastyt.negocio.NEncargadoBloque"%>
<%@page import="co.poli.asesoriastyt.model.EncargadoBloque"%>
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
<%
	String mensaje = (String) request.getAttribute("mensaje");
	String IdEncargado = request.getParameter("IdEncargado");
	String CorreoEncargado = request.getParameter("CorreoEncargado");

	EncargadoBloque x = request.getAttribute("cli") != null ? (EncargadoBloque) request.getAttribute("cli") : null;
	//nombre del atributo cuando lo subo  // operador ternario condicional
	if (x != null) {
		IdEncargado = x.getIdEncargado();
		CorreoEncargado = x.getCorreoEncargado();
	}
%>
<script type="text/javascript" src="./js/validacion.js"></script>
<title>Gesti&oacute;n de Encagados de Bloque</title>

</head>
<body>
	<br>
	<br>
	<br>
	<div id="ruta">
		<h1>Gesti&oacute;n de Encagados de Bloque</h1>
		<br>
		<form name="inicio" action="./EncargadosBloques" method="post">
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
								<td class="label">C&oacute;digo Encargado(*):</td>
								<td><input type="text" name="IdEncargado" size="20"
									maxlength="5" onkeypress="return validar(event)"
									placeholder="Código"
									value="<%=IdEncargado != null ? IdEncargado : ""%>"></td>
								<td class="label">Correo Encargado(*):</td>
								<td><input type="text" name="CorreoEncargado" size="30"
									placeholder="Correo"
									value="<%=CorreoEncargado != null ? CorreoEncargado : ""%>"></td>
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
			NEncargadoBloque nEnc = new NEncargadoBloque();
			DAOEncargadosBloques dao = new DAOEncargadosBloques();
			List<EncargadoBloque> listaEncargadosBloques = nEnc.ListadoEncargadosBloques();
		%>
		<br> <br>
		<table width="85%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<thead>
				<tr>
					<td class="caja_02_01">&nbsp;</td>
					<td class="caja_02_top">Lista de Encargados</td>
					<td class="caja_02_02">&nbsp;</td>
				</tr>
				<tr>
					<td class="caja_01_bottom">&nbsp;</td>
					<td valign="top" class="caja_01_bottom"><table width="100%"
							align="center" id="rounded-corner">
							<thead>
								<tr>
									<th class="rounded" scope="col">Código Encargado</th>
									<th class="rounded" scope="col">Correo Encargado</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (EncargadoBloque enc : listaEncargadosBloques) {
								%>
								<tr align="center">
									<td><%=enc.getIdEncargado()%></td>
									<td><%=enc.getCorreoEncargado()%></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table></td>
				</tr>
		</table>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>