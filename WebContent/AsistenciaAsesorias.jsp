<%@page import="java.util.List"%>
<%@page import="co.poli.asesoriastyt.model.EstudianteAsesoria"%>
<%@page import="co.poli.asesoriastyt.dao.DAOAsesorias"%>
<%@page import="co.poli.asesoriastyt.negocio.NAsesoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Asesorias TyT - Control de asistencia</title>
<link href="./css/partials.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form name="asistencia" action="./Asesorias" method="post">
		<table width="85%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<thead>
				<tr>
					<td class="caja_02_01">&nbsp;</td>
					<td class="caja_02_top">Asistencia de estudiantes inscritos</td>
					<td class="caja_02_02">&nbsp;</td>
				</tr>
				<tr>
					<td class="caja_01_bottom">&nbsp;</td>
					<td valign="top" class="caja_01_bottom">
						<table width="100%" align="center" id="rounded-corner">
							<thead>
								<tr>
									<th class="rounded" scope="col">Documento Estudiante</th>
									<th class="rounded" scope="col">Si</th>
									<th class="rounded" scope="col">No</th>
								</tr>
							</thead>
							<%
								NAsesoria nAsesoria = new NAsesoria();
								DAOAsesorias dao = new DAOAsesorias();
								List<EstudianteAsesoria> listaAsesoriasAsis = nAsesoria.ListadoAsistentes((String) request.getAttribute("idAsesoria"));
							%>
							<tbody>
								<%
									for (EstudianteAsesoria as : listaAsesoriasAsis) {
								%>
								<tr align="center">
									<td><%=as.getNumDocEstudiante()%></td>
									<td><input name="asistencia" type="radio"></td>
									<td><input name="asistencia" type="radio"></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
					</td>
				</tr>
		</table>
		<div
			style="margin-top: 8px; margin-right: 100px; width: auto; float: right;">
			<button value="GuardarAsesoria" class="botonGuardar">Guardar</button>
		</div>
	</form>
</body>
</html>