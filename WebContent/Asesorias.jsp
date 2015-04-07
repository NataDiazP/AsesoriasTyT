<%@page import="co.poli.asesoriastyt.model.Aula"%>
<%@page import="co.poli.asesoriastyt.negocio.NAula"%>
<%@page import="co.poli.asesoriastyt.negocio.NProgAcademica"%>
<%@page import="co.poli.asesoriastyt.model.Asignatura"%>
<%@page import="co.poli.asesoriastyt.negocio.NAsignatura"%>
<%@page import="co.poli.asesoriastyt.model.Persona"%>
<%@page import="co.poli.asesoriastyt.negocio.NPersona"%>
<%@page import="co.poli.asesoriastyt.dao.DAOPersonas"%>
<%@page import="co.poli.asesoriastyt.negocio.NAsesoria"%>
<%@page
	import="com.sun.corba.se.impl.presentation.rmi.DynamicAccessPermission"%>
<%@page import="java.util.List"%>
<%@page import="co.poli.asesoriastyt.dao.DAOAsesorias"%>
<%@page import="co.poli.asesoriastyt.model.Asesoria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="./css/generales.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	String mensaje = (String) request.getAttribute("mensaje");
	String id = request.getParameter("id");
	String nombreAsesoria = request.getParameter("nombreAsesoria");
	String docente = request.getParameter("docente");
	String asignatura = request.getParameter("asignatura");
	String fecha = request.getParameter("fecha");
	String horaI = request.getParameter("horaI");
	String horaF = request.getParameter("horaF");
	String lugar = request.getParameter("lugar");
	String cupos = request.getParameter("cupos");
	String cuposD = request.getParameter("cuposD");
	String recursosApoyo = request.getParameter("recursosApoyo");
	String observacion = request.getParameter("observacion");
	String estado = request.getParameter("estado");

	Asesoria x = request.getAttribute("cli") != null ? (Asesoria) request.getAttribute("cli") : null;
	//nombre del atributo cuando lo subo  // operador ternario condicional
	if (x != null) {
		id = x.getIdAsesoria();
		nombreAsesoria = x.getNombreAsesoria();
		docente = x.getDocente();
		asignatura = x.getAsignatura();
		docente = x.getDocente();
		fecha = x.getFecha();
		horaI = x.getHoraI();
		horaF = x.getHoraF();
		lugar = x.getLugar();
		cupos = x.getCupos();
		cuposD = x.getCuposD();
		recursosApoyo = x.getRecursosApoyo();
		observacion = x.getObservaciones();
		estado = x.getEstado();
	}

	NAsesoria nAsesoria = new NAsesoria();
	List<Asesoria> listaAsesorias = nAsesoria.ListadoAsesorias();

	NPersona nper = new NPersona();
	List<Persona> listaPersonas = nper.ListadoPersonasDocentes();

	NProgAcademica nProg = new NProgAcademica();
	List<Asignatura> asigDocente = nProg.AsignaturasDocente((String) request.getSession().getAttribute("idDocente"));

	NAsignatura nAsig = new NAsignatura();
	List<Asignatura> listaAsignaturas = nAsig.ListadoAsignaturas();

	NAula nAula = new NAula();
	List<Aula> listaAula = nAula.ListadoAulas();
%>
<script type="text/javascript" src="./js/validacion.js"></script>
<title>Gesti&oacute;n de Asesor&iacute;as</title>
</head>
<body>
	<br>
	<br>
	<br>
	<div id="ruta">
		<h1>Gesti&oacute;n de Asesor&iacute;as</h1>
		<br>
		<form name="inicio" action="./Asesorias" method="post">
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
								<td class="label">C&oacute;digo de <br>
									Asesor&iacute;a (*):
								</td>
								<td><input type="text" name="id" size="20" maxlength="5"
									onkeypress="return validar(event)" placeholder="Código"
									value="<%=id != null ? id : ""%>"></td>
								<td class="label">Nombre (*):</td>
								<td><input type="text" name="nombreAsesoria" size="20"
									maxlength="50" placeholder="Nombre Asesoría"
									value="<%=nombreAsesoria != null ? nombreAsesoria : ""%>"></td>
								<td class="label">Docente (*):</td>
								<%
									if (((String) request.getSession().getAttribute("Perfil")).equals("2")) {
								%>
								<td><input type="text" name="docente" size="25"
									value="<%=(String) request.getSession().getAttribute("idDocente")%>"></td>
								<%
									} else {
								%>
								<td><select class="campo02" name="docente">
										<option>Seleccione...</option>
										<%
											for (Persona doc : listaPersonas) {
										%>
										<option
											<%if ((doc.getNumeroIdentificacion()).equals(docente)) {%>
											selected <%}%>><%=doc.getNumeroIdentificacion()%></option>
										<%
											}
										%>
								</select></td>
								<%
									}
								%>
							</tr>
							<tr>
								<td class="label">Asignatura (*):</td>
								<%
									if (((String) request.getSession().getAttribute("Perfil")).equals("2")) {
								%>
								<td><select class="campo02" name="asignatura">
										<option>Seleccione...</option>
										<%
											for (Asignatura asig : asigDocente) {
										%>
										<option <%if ((asig.getIdAsignatura()).equals(asignatura)) {%>
											selected <%}%>><%=asig.getIdAsignatura()%></option>
										<%
											}
										%>
								</select></td>
								<%
									} else {
								%>
								<td><select class="campo02" name="asignatura">
										<option>Seleccione...</option>
										<%
											for (Asignatura asig : listaAsignaturas) {
										%>
										<option <%if ((asig.getIdAsignatura()).equals(asignatura)) {%>
											selected <%}%>><%=asig.getIdAsignatura()%></option>
										<%
											}
										%>
								</select></td>
								<%
									}
								%>
								<td class="label">Fecha (*):</td>
								<td><input type="date" name="fecha" size="20"
									placeholder="Fecha" value="<%=fecha != null ? fecha : ""%>"></td>
								<td class="label">Hora Inicio (*):</td>
								<td><input type="time" name="horaI" size="20"
									placeholder="Hora Inicio"
									value="<%=horaI != null ? horaI : ""%>"></td>
							</tr>
							<tr>
								<td class="label">Hora Fin (*):</td>
								<td><input type="time" name="horaF" size="20"
									placeholder="Hora Fin" value="<%=horaF != null ? horaF : ""%>"></td>
								<td class="label">Lugar o Aula (*):</td>
								<td><select class="campo02" name="lugar">
										<option>Seleccione...</option>
										<option <%if ("Otro".equals(lugar)) {%> selected <%}%>>Otro</option>
										<%
											for (Aula aul : listaAula) {
										%>
										<option
											<%if ((aul.getIdBloque() + " - " + aul.getIdAula()).equals(lugar)) {%>
											selected <%}%>><%=aul.getIdBloque() + " - " + aul.getIdAula()%></option>
										<%
											}
										%>
								</select></td>
								<td class="label">Cupos:</td>
								<td><input type="text" name="cupos" size="20"
									onkeypress="return validar(event)" placeholder="Cupos"
									value="<%=cupos != null ? cupos : ""%>"></td>
							</tr>
							<tr>
								<td class="label">Cupos Disponibles:</td>
								<td><input type="text" name="cuposD" size="20"
									placeholder="Cupos Disponibles"
									onkeypress="return validar(event)"
									value="<%=cuposD != null ? cuposD : ""%>"></td>
								<td class="label">Recursos de Apoyo:</td>
								<td><textarea name="recursosApoyo" size="30"
										class="campo02" placeholder="Recursos de apoyo"
										value="<%=recursosApoyo != null ? recursosApoyo : ""%>"></textarea></td>
								<td class="label">Observaciones:</td>
								<td><textarea name="observacion" size="30"
										placeholder="Observaciones Asesoría" class="campo02"
										value="<%=observacion != null ? observacion : ""%>"></textarea></td>
							</tr>
							<tr>
								<td class="label">Estado (*):</td>
								<td><select name="estado" class="campo02" id="genero">
										<option>Seleccione...</option>
										<option <%if ("Pendiente".equals(estado)) {%> selected <%}%>>Pendiente</option>
										<option <%if ("Confirmada".equals(estado)) {%> selected <%}%>>Confirmada</option>
										<option <%if ("Cancelada".equals(estado)) {%> selected <%}%>>Cancelada</option>
								</select></td>
								<td colspan="4" align="right" class="label">
									<button name="action" value="EstInscritos" class="boton">Estudiantes
										inscritos</button>
								</td>
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
			</div>

		</form>

		<br> <br>
		<table width="85%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<thead>
				<tr>
					<td class="caja_02_01">&nbsp;</td>
					<td class="caja_02_top">Lista de Asesorías</td>
					<td class="caja_02_02">&nbsp;</td>
				</tr>
				<tr>
					<td class="caja_01_bottom">&nbsp;</td>
					<td valign="top" class="caja_01_bottom"><table width="100%"
							align="center" id="rounded-corner">
							<thead>
								<tr>
									<th class="rounded" scope="col">Código</th>
									<th class="rounded" scope="col">Nombre</th>
									<th class="rounded" scope="col">Docente</th>
									<th class="rounded" scope="col">Asignatura</th>
									<th class="rounded" scope="col">Fecha</th>
									<th class="rounded" scope="col">Hora Inicio</th>
									<th class="rounded" scope="col">Hora Fin</th>
									<th class="rounded" scope="col">Lugar</th>
									<th class="rounded" scope="col">Cupos</th>
									<th class="rounded" scope="col">Observaciones</th>
									<th class="rounded" scope="col">Estado</th>
								</tr>
							</thead>
							<tbody>
								<%
									for (Asesoria as : listaAsesorias) {
								%>
								<tr align="center">
									<td><%=as.getIdAsesoria()%></td>
									<td><%=as.getNombreAsesoria()%></td>
									<td><%=as.getDocente()%></td>
									<td><%=as.getAsignatura()%></td>
									<td><%=as.getFecha()%></td>
									<td><%=as.getHoraI()%></td>
									<td><%=as.getHoraF()%></td>
									<td><%=as.getLugar()%></td>
									<td><%=as.getCupos()%></td>
									<td><%=as.getObservaciones()%></td>
									<td><%=as.getEstado()%></td>
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