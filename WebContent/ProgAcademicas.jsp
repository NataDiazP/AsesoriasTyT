<%@page import="co.poli.asesoriastyt.model.Persona"%>
<%@page import="co.poli.asesoriastyt.dao.DAOPersonas"%>
<%@page import="co.poli.asesoriastyt.negocio.NPersona"%>
<%@page import="co.poli.asesoriastyt.model.Aula"%>
<%@page import="co.poli.asesoriastyt.dao.DAOAulas"%>
<%@page import="co.poli.asesoriastyt.negocio.NAula"%>
<%@page import="co.poli.asesoriastyt.model.Asignatura"%>
<%@page import="co.poli.asesoriastyt.dao.DAOAsignaturas"%>
<%@page import="co.poli.asesoriastyt.negocio.NAsignatura"%>
<%@page import="co.poli.asesoriastyt.dao.DAOProgAcademica"%>
<%@page import="co.poli.asesoriastyt.negocio.NProgAcademica"%>
<%@page import="co.poli.asesoriastyt.model.ProgAcademica"%>
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
	String IdProgAcademica = request.getParameter("IdProgAcademica");
	String docenteProgAcademica = request.getParameter("docenteProgAcademica");
	String asignaturaProgAcademica = request.getParameter("asignaturaProgAcademica");
	String grupoAsignatura = request.getParameter("grupoAsignatura");
	String nroEstAsignatura = request.getParameter("nroEstAsignatura");
	String diasAsignatura = request.getParameter("diasAsignatura");
	String horaInicialAsig = request.getParameter("horaInicialAsig");
	String horaFinAsig = request.getParameter("horaFinAsig");
	String aulaClaseProg = request.getParameter("aulaClaseProg");
	String semestreProgAcademica = request.getParameter("semestreProgAcademica");
	String anoProgAcademica = request.getParameter("anoProgAcademica");

	ProgAcademica x = request.getAttribute("cli") != null ? (ProgAcademica) request.getAttribute("cli") : null;
	//nombre del atributo cuando lo subo  // operador ternario condicional
	if (x != null) {
		IdProgAcademica = x.getIdProgAcademica();
		docenteProgAcademica = x.getDocenteProgAcademica();
		asignaturaProgAcademica = x.getAsignaturaProgAcademica();
		grupoAsignatura = x.getGrupoAsigProgAcademica();
		nroEstAsignatura = x.getNroEstAsigProgAcademica();
		diasAsignatura = x.getDiasAsigProgAcademica();
		horaInicialAsig = x.getHoraIniAsigProgAcademica();
		horaFinAsig = x.getHoraFinAsigProgAcademica();
		aulaClaseProg = x.getAulaClaseProgAcademica();
		semestreProgAcademica = x.getSemestreProgAcademica();
		anoProgAcademica = x.getAnoProgAcademica();
	}

	NAsignatura nAsig = new NAsignatura();
	DAOAsignaturas dao = new DAOAsignaturas();
	List<Asignatura> listaAsignatura = nAsig.ListadoAsignaturas();

	NAula nAula = new NAula();
	DAOAulas daoA = new DAOAulas();
	List<Aula> listaAula = nAula.ListadoAulas();

	NPersona nPers = new NPersona();
	DAOPersonas daoPer = new DAOPersonas();
	List<Persona> listaDocente = nPers.ListadoPersonasDocentes();
%>
<script type="text/javascript" src="./js/validacion.js"></script>
<title>Gesti&oacute;n de Programaci&oacute; Acad&eacute;mica</title>
</head>
<body>
	<br>
	<br>
	<br>
	<div id="ruta">
		<h1>Gesti&oacute;n de Programaci&oacute;n Acad&eacute;mica</h1>
		<br>
		<form name="inicio" action="./ProgAcademicas" method="post">
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
								<td class="label">C&oacute;digo de Programaci&oacute;n (*):</td>
								<td><input type="text" name="IdProgAcademica" size="20"
									maxlength="5" placeholder="Código"
									onkeypress="return validar(event)"
									value="<%=IdProgAcademica != null ? IdProgAcademica : ""%>"></td>
								<td class="label">Docente(*):</td>
								<td><select class="campo02" name="docenteProgAcademica">
										<option>Seleccione...</option>
										<%
											for (Persona pers : listaDocente) {
										%>
										<option
											<%if ((pers.getNumeroIdentificacion()).equals(docenteProgAcademica)) {%>
											selected <%}%>><%=pers.getNumeroIdentificacion()%></option>
										<%
											}
										%>
								</select></td>
								<td class="label">Asignatura(*):</td>
								<td><input type="text" name="asignaturaProgAcademica"
									size="20" placeholder="Código Asignatura"
									value="<%=asignaturaProgAcademica != null ? asignaturaProgAcademica : ""%>"></td>
							</tr>
							<tr>
								<td class="label">Grupo(*):</td>
								<td><input type="text" name="grupoAsignatura" size="20"
									maxlength="5" onkeypress="return validar(event)"
									placeholder="Grupo"
									value="<%=grupoAsignatura != null ? grupoAsignatura : ""%>"></td>
								<td class="label">Número de estudiantes (*):</td>
								<td><input type="text" name="nroEstAsignatura" size="20"
									placeholder="Estudiantes Asignatura"
									value="<%=nroEstAsignatura != null ? nroEstAsignatura : ""%>"></td>
								<td class="label">Días (*):</td>
								<td><input type="text" name="diasAsignatura" size="20"
									maxlength="5" placeholder="Días Asignatura"
									value="<%=diasAsignatura != null ? diasAsignatura : ""%>"></td>
							</tr>
							<tr>
								<td class="label">Hora Inicio(*):</td>
								<td><input name="horaInicialAsig" size="20"
									placeholder="Hora Inicio Asignatura"
									value="<%=horaInicialAsig != null ? horaInicialAsig : ""%>"></td>
								<td class="label">Hora Fin(*):</td>
								<td><input name="horaFinAsig" size=20
									"
									maxlength="5" placeholder="Hora Fin Asignatura"
									value="<%=horaFinAsig != null ? horaFinAsig : ""%>"></td>
								<td class="label">Aula (*):</td>
								<td><input type="text" name="aulaClaseProg" size="20"
									placeholder="Aula Clase"
									value="<%=aulaClaseProg != null ? aulaClaseProg : ""%>"></td>
								</td>
							</tr>
							<tr>
								<td class="label">Semestre (*):</td>
								<td><input type="text" name="semestreProgAcademica"
									size="20" maxlength="2" onkeypress="return validar(event)"
									placeholder="Semestre Programación Académica"
									value="<%=semestreProgAcademica != null ? semestreProgAcademica : ""%>"></td>
								<td class="label">Año (*):</td>
								<td><input type="text" name="anoProgAcademica" size="20"
									maxlength="4" onkeypress="return validar(event)"
									placeholder="Año Programación Académica"
									value="<%=anoProgAcademica != null ? anoProgAcademica : ""%>"></td>
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

			<div style="margin: 0 auto; width: 10%">
				<!-- 				<button name="action" value="Crear" class="boton">Crear</button> -->
				<button name="action" value="Consultar" class="boton">Consultar</button>
				<!-- 				<button name="action" value="Modificar" class="boton">Modificar</button> -->
				<!-- 				<button name="action" value="Eliminar" class="boton">Eliminar</button> -->
			</div>

		</form>

		<%
			NProgAcademica nProgA = new NProgAcademica();
			DAOProgAcademica daoP = new DAOProgAcademica();
			List<ProgAcademica> listaProgAcademica = nProgA.ListadoProgAcademica();
		%>
		<br> <br>
		<table width="85%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<thead>
				<tr>
					<td class="caja_02_01">&nbsp;</td>
					<td class="caja_02_top">Lista de Programaciones
						Acad&eacute;micas</td>
					<td class="caja_02_02">&nbsp;</td>
				</tr>
				<tr>
					<td class="caja_01_bottom">&nbsp;</td>
					<td valign="top" class="caja_01_bottom"><table width="100%"
							align="center" id="rounded-corner">
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
									for (ProgAcademica prog : listaProgAcademica) {
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
						</table></td>
				</tr>
		</table>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>