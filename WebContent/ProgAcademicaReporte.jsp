<%@page import="co.poli.asesoriastyt.model.ProgAcademica"%>
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
<%
	String mensaje = (String) request.getAttribute("mensaje");
	String docenteProgAcademica = request.getParameter("liDocenteProgAcademica");

	ProgAcademica x = request.getAttribute("cli") != null ? (ProgAcademica) request.getAttribute("cli") : null;
	//nombre del atributo cuando lo subo  // operador ternario condicional
	if (x != null) {
		docenteProgAcademica = x.getDocenteProgAcademica();
	}

	List<ProgAcademica> LU = request.getAttribute("ListaProgAcademica") != null ? (List<ProgAcademica>) request.getAttribute("ListaProgAcademica") : null;
%>
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
					<td><select class="campo02" name="liDocenteProgAcademica">
							<option>Seleccione...</option>
							<%
								for (Persona pers : listaPersonas) {
							%>
							<option>
								<%=pers.getNumeroIdentificacion() + "-" + pers.getNombreCompleto() + " " + pers.getPrimerApellido() + " " + pers.getSegundoApellido()%></option>
							<%
								}
							%>
					</select></td>
				</tr>
			</table>
			<br>
			<div style="margin: 5px auto; width: 25%">
				<button name="action" value="Aceptar" class="boton">Consultar</button>
			</div>
		</form>
		<form action="./ProgAcademicas" method="post">
			<%if (LU == null) {%>
			<h4>No hay datos para mostrar</h4>
			<%} else {%>
			<br>
			<table width="85%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<thead>
					<tr>
						<td class="caja_02_01">&nbsp;</td>
						<td class="caja_02_top">Programaci&oacute;n acad&eacute;mica</td>
						<td class="caja_02_02">&nbsp;</td>
					</tr>
					<tr>
						<td class="caja_01_bottom">&nbsp;</td>
						<td valign="top" class="caja_01_bottom">
							<table width="100%" align="center" id="rounded-corner">
								<thead>
									<tr>
										<th class="rounded" scope="col">Código</th>
										<th class="rounded" scope="col">Docente</th>
										<th class="rounded" scope="col">Asignatura</th>
										<th class="rounded" scope="col">Grupo</th>
										<th class="rounded" scope="col">N&uacute;mero<br>Estudiantes
										</th>
										<th class="rounded" scope="col">Dias</th>
										<th class="rounded" scope="col">Hora Inicio</th>
										<th class="rounded" scope="col">Hora Fin</th>
										<th class="rounded" scope="col">Aula</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (ProgAcademica prog : LU) {
									%>
									<tr align="center">
										<td><%=prog.getIdProgAcademica()%></td>
										<td><%=prog.getDocenteProgAcademica()%></td>
										<td><%=prog.getAsignaturaProgAcademica()%></td>
										<td><%=prog.getGrupoAsigProgAcademica()%></td>
										<td><%=prog.getNroEstAsigProgAcademica()%></td>
										<td><%=prog.getDiasAsigProgAcademica()%></td>
										<td><%=prog.getHoraIniAsigProgAcademica()%></td>
										<td><%=prog.getHoraFinAsigProgAcademica()%></td>
										<td><%=prog.getAulaClaseProgAcademica()%></td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
						</td>
					</tr>
			</table>
			<% } %>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>