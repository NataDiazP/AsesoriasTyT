<%@page import="co.poli.asesoriastyt.negocio.NPerfiles"%>
<%@page import="com.sun.corba.se.impl.presentation.rmi.DynamicAccessPermission"%>
<%@page import="java.util.List"%>
<%@page import="co.poli.asesoriastyt.dao.DAOPerfiles"%>
<%@page import="co.poli.asesoriastyt.model.Perfil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
<html>
<head>
<link href="./css/generales.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
		function checkfile(sender) {
			var validExts = new Array(".xlsx", ".xls");
			var fileExt = sender.value;
			fileExt = fileExt.substring(fileExt.lastIndexOf('.'));

			if (validExts.indexOf(fileExt.toLowerCase()) < 0) {
				alert("Archivo no válido, los archivos válidos son:  "
						+ validExts.toString());
				$(sender).val("");
				return false;
			} else
				return true;
		}
	</script>
<script type="text/javascript" src="./js/validacion.js"></script>
<title>Cargar Archivo</title>
</head>
<body>
<br>
<br>
<br>
<div id="ruta">
		<h1>Cargar Excel</h1>
		<br>
</div>
		
	<form name="inicio" action="./CargarExcel" method="post">
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
							<td></td>
							<td></td>
							<td align="center" class="label">Tipo de Información:</td>
							<td><select name="tipo" class="campo02">
									<option>Seleccione...</option>
									<option>Cargar Docentes</option>
									<option>Cargar Estudiantes</option>
									<option>Cargar Programación Académica</option>
							</select></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
						<td class="caja_01_01">&nbsp;</td>
						<td class="caja_01_01">&nbsp;</td>
						<td class="caja_01_01">&nbsp;</td>
							<td>
							<input type="file" id="uploadFile" name="uploadFile" onchange="return checkfile(this);"
							title="Permite seleccionar un archivo">
							</td>
						</tr>
						</table>
						</td>
						</tr>
						</table>
						<br>
						<div style="margin: 0 auto; width: 25%" align="center">
						<button name="action" value="Cargar" class="boton">Cargar Archivo</button>
						</div>
						</form>
						

 <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>