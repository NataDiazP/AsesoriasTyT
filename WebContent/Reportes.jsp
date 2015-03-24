<%@page import="co.poli.asesoriastyt.negocio.NAsesoria"%>
<%@page import="co.poli.asesoriastyt.model.Asesoria"%>
<%@page import="co.poli.asesoriastyt.dao.DAOAsesorias"%>
<%@page
	import="com.sun.corba.se.impl.presentation.rmi.DynamicAccessPermission"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
			NAsesoria nAsesoria = new NAsesoria();
			DAOAsesorias dao = new DAOAsesorias();
			List<Asesoria> listaAsesorias = nAsesoria.ListadoAsesorias();
		%>
<html>
<head>
<link href="./css/generales.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="./js/validacion.js"></script>
<title>Reportes</title>
</head>
<body>
	<br>
	<br>
	<br>
	<div id="ruta">
		<h1>Reportes</h1>
	</div>
		<br>
		<form name="inicio" action="./ServletReporte" method="post">
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
								<td>
								</td>
								<td>
								</td>
								<td align="center" class="label">Tipo de Reporte:</td>
								<td><select name="reporte" class="campo02">
										<option>Seleccione...</option>
										<option>Asistencia por Asesoría</option>
										<option>Materiales por Asesoría</option>
										<option>Cantidad Estudiantes por Asesoría</option>
								</select></td>
								<td>
								</td>
								<td>
								</td>
							</tr>
							<tr>
								<td class="label">Fecha Inicio:</td>
								<td><input type="date" name="fechaI" size="20"
									placeholder="Fecha Inicio"
									value=""></td>
								<td class="label">Fecha Fin:</td>
								<td><input type="date" name="fechaF" size="20"
									placeholder="Fecha Fin"
									value=""></td>
								<td class="label">Asesoría</td>
								<td><select type="text" class="campo02" name="asesoria">
										<option>Seleccione...</option>
										<%
										for (Asesoria as : listaAsesorias) {
										%>
										<option><%=as.getIdAsesoria()%></option>
										<%
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

			<div  style="margin: 0 auto; width: 25%" align="center">
				<button name="action" value="Cargar" class="boton">Generar Reporte</button>
				<button name="action" value="Limpiar" class="boton">Limpiar</button>
				
			</div>
			<br>
		</form>

	

	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>