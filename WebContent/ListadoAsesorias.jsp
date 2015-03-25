<%@page import="co.poli.asesoriastyt.control.CallbackServlet"%>
<%@page import="co.poli.asesoriastyt.model.EstudianteAsesoria"%>
<%@page import="co.poli.asesoriastyt.model.Asesoria"%>
<%@page import="java.util.List"%>
<%@page import="co.poli.asesoriastyt.dao.DAOAsesorias"%>
<%@page import="co.poli.asesoriastyt.negocio.NAsesoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./css/partials.css" rel="stylesheet" type="text/css" />
<title>Asesorias TyT - Inicio</title>
</head>
<body>
	<%
		NAsesoria nAsesoria = new NAsesoria();
		DAOAsesorias dao = new DAOAsesorias();
		List<Asesoria> listaAsesorias = nAsesoria.ListadoAsesorias();
		String mensajeNotif;
	%>

	<table width="85%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<thead>
			<tr>
				<td class="caja_02_01">&nbsp;</td>
				<td class="caja_02_top">Asesor&iacute;as disponibles</td>
				<td class="caja_02_02">&nbsp;</td>
			</tr>
			<tr>
				<td class="caja_01_bottom">&nbsp;</td>
				<td valign="top" class="caja_01_bottom">
					<table width="100%" align="center" id="rounded-corner">
						<thead>
							<tr>
								<th class="rounded" scope="col">Modulo</th>
								<th class="rounded" scope="col">Docente</th>
								<th class="rounded" scope="col">Fecha</th>
								<th class="rounded" scope="col">Hora</th>
								<th class="rounded" scope="col">Lugar</th>
								<th class="rounded" scope="col">Asistir</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (Asesoria as : listaAsesorias) {
							%>
							<tr align="center">
								<td><%=as.getAsignatura()%></td>
								<td><%=as.getDocente()%></td>
								<td><%=as.getFecha()%></td>
								<td><%=as.getHoraI()%></td>
								<td><%=as.getLugar()%></td>
								<%
									request.getSession().setAttribute("idAsesoria", as.getIdAsesoria());
								%>
								<td><form name="asistenciaAsesorias"
										action="./AsistenciaAsesorias" method="post">
										<button class="asistirButton" name="action" value="Asistir">
											<img src="./images/plus.png" alt="Asistir a asesoría"
												class="asistir" />
										</button>
									</form></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</td>
			</tr>
	</table>
</body>
</html>
