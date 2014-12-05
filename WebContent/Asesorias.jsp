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
	String id = request.getParameter("IdAsesoria");
	String docente = request.getParameter("docente");
	String asignatura = request.getParameter("asignatura");
	String fecha = request.getParameter("fecha");
	String horaI = request.getParameter("horaI");
	String horaF = request.getParameter("docente");
	String lugar = request.getParameter("lugar");
	String cupos = request.getParameter("cupos");
	String cuposD = request.getParameter("cuposD");
	String observacion = request.getParameter("observacion");
	String estado = request.getParameter("estado");

	Asesoria x = request.getAttribute("cli") != null ? (Asesoria) request.getAttribute("cli") : null;
	//nombre del atributo cuando lo subo  // operador ternario condicional
	if (x != null) {
		id = x.getIdAsesoria();
		docente = x.getDocente();
		asignatura = x.getAsignatura();
		docente = x.getDocente();
		fecha = x.getFecha();
		horaI = x.getHoraI();
		horaF = x.getHoraF();
		lugar = x.getLugar();
		cupos = x.getCupos();
		cuposD = x.getCuposD();
		observacion = x.getObservaciones();
		estado = x.getEstado();
	}
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
		<form name="inicio" action="./Asesoriaes" method="post">
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
								<td class="label">C&oacute;digo de Asesor&iacute;as(*):</td>
								<td><input type="text" name="id" size="20" maxlength="5"
									onkeypress="return validar(event)" placeholder="código"
									value="<%=id != null ? id : ""%>"></td>
								<td class="label">Docente(*):</td>
								<td><input type="text" name="docente" size="30"
									onkeypress="return sololetras(event)" placeholder="Docente"
									value="<%=docente != null ? docente : ""%>"></td>
								<td class="label">Asignatura(*):</td>
								<td><input type="text" name="IdAsesoria" size="20"
									maxlength="5" onkeypress="return validar(event)"
									placeholder="Asignaturas"
									value="<%=asignatura != null ? asignatura : ""%>"></td>
							</tr>
							<tr>
								<td class="label">Fecha(*):</td>
								<td><input type="text" name="fecha" size="20" maxlength="5"
									onkeypress="return validar(event)" placeholder="Fecha"
									value="<%=docente != null ? docente : ""%>"></td>
								<td class="label">Hora Inicio(*):</td>
								<td><input type="text" name="horaI" size="30"
									onkeypress="return sololetras(event)" placeholder="Hora Inicio"></td>
								<td class="label">Hora Fin(*):</td>
								<td><input type="text" name="horaF" size="20" maxlength="5"
									onkeypress="return validar(event)" placeholder="Hora Fin"
									value="<%=asignatura != null ? asignatura : ""%>"></td>
							</tr>
							<tr>
								<td class="label">Lugar o Aula(*):</td>
								<td><input type="text" name="lugar" size="20" maxlength="5"
									onkeypress="return validar(event)" placeholder="código"
									value="<%=lugar != null ? lugar : ""%>"></td>
								<td class="label">Cupos(*):</td>
								<td><input type="text" name="cupos" size="30"
									onkeypress="return sololetras(event)" placeholder="nombre"
									value="<%=cupos != null ? cupos : ""%>"></td>
								<td class="label">Observaciones(*):</td>
								<td><textarea name="observacion"></textarea></td>
							</tr>
							<tr>
								<td class="label">Estado(*):</td>
								<td><select name="estado" class="campo02" id="genero">
										<option><%=estado != null ? estado : "Seleccione"%></option>
										<option>Pendiente</option>
										<option>Confirmada</option>
										<option>Cancelada</option>
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

			<div style="margin: 0 auto; width: 25%">
				<button name="action" value="Crear" class="boton">Crear</button>
				<button name="action" value="Consultar" class="boton">Consultar</button>
				<button name="action" value="Modificar" class="boton">Modificar</button>
				<button name="action" value="Eliminar" class="boton">Eliminar</button>
			</div>

		</form>

		<%
			NAsesoria nAsesoria = new NAsesoria();
			DAOAsesorias dao = new DAOAsesorias();
			List<Asesoria> listaAsesoriaes = nAsesoria.ListadoAsesorias();
		%>
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


							</tbody>
						</table></td>
				</tr>
		</table>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>