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
<%
	List<EstudianteAsesoria> LU = request.getAttribute("ListaAsistencia") != null ? (List<EstudianteAsesoria>) request.getAttribute("ListaAsistencia") : null;
%>
</head>
<body>
	<form name="asistencia" action="./AsistenciaAsesorias" method="post">
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
						<table width="100%" align="center" id="asistencia">
							<thead>
								<tr>
									<th class="rounded" scope="col" rowspan=2>Documento
										Estudiante</th>
									<th class="rounded" scope="col" colspan=2>Asistencia</th>
								</tr>
								<tr>
									<th class="rounded" scope="col">Si</th>
									<th class="rounded" scope="col">No</th>
								</tr>
							</thead>
							<tbody>
								<%
									if (LU == null) {
								%>
								<tr>
									<td colspan="3">No hay estudiantes inscritos a esta
										asesor&iacute;a</td>
								</tr>
								<%
									} else {
										for (EstudianteAsesoria asis : LU) {
											if ("No".equals(asis.getAsistenciaAsesoria())) {
								%>
								<tr align="center" style="background-color: #FFACBC">
									<%
										} else if ("Si".equals(asis.getAsistenciaAsesoria())) {
									%>
								<tr align="center" style="background-color: #BBFFBB">
									<%
										} else {
									%>
								<tr align="center">
									<%
										}
									%>
									<td><%=asis.getNumDocEstudiante()%></td>
									<td><button class="asistirButton" name="action"
											value="Asistencia_Si_<%=asis.getIdAsesoria()%>_<%=asis.getNumDocEstudiante()%>">
											<img src="./images/check.png" alt="Asistir a asesoría"
												class="asistir" />
										</button></td>
									<td><button class="asistirButton" name="action"
											value="Asistencia_No_<%=asis.getIdAsesoria()%>_<%=asis.getNumDocEstudiante()%>">
											<img src="./images/cancel.png" alt="Asistir a asesoría"
												class="asistir" />
										</button></td>
								</tr>
								<%
									}
									}
								%>
							</tbody>
						</table>
					</td>
				</tr>
		</table>
	</form>
</body>
</html>