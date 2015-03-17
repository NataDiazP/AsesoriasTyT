<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./css/generales.css" rel="stylesheet" type="text/css" />
<script language="JavaScript">
	function Cancelar() {
		window.close();
	}
</script>
</head>
<body>
	<div id="ruta">
		<h1>Confirmación asesor&iacute;a</h1>
		<br></br>
		<form id="formperfil" action="./Asesorias" method="post">
			<div id="login" class="animate form">
				<table width="90%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td class="caja_03_01"></td>
						<td class="caja_03_top"></td>
						<td class="caja_03_02"></td>
					</tr>
					<tr>
						<td class="caja_01_bottom">&nbsp;</td>
						<td valign="top" class="caja_01_bottom">
							<table width="100%" border="0" cellspacing="4" cellpadding="4">
								<tr>
									<td>Asignatura:</td>
									<td></td>
								</tr>
								<tr>
									<td>Docente:</td>
									<td></td>
								</tr>
								<tr>
									<td>Hora:</td>
									<td></td>
								</tr>
								<tr>
									<td>Lugar:</td>
									<td></td>
								</tr>
								<tr>
									<td>Estudiante:</td>
									<td></td>
								</tr>
							</table>
						</td>
						<td class="caja_01_bottom">&nbsp;</td>
					</tr>
					<tr>
						<td class="caja_bottom_01"></td>
						<td class="caja_01_bottom"></td>
						<td class="caja_bottom_02"></td>
					</tr>
				</table>

				<div style="margin: 10px auto; width: 30%;">
					<button name="AceptarAsesoria" class="boton" id="button">Aceptar</button>
				</div>
			</div>
		</form>
		<button name="Cancelar" class="boton" id="cancelar"
			onClick="Cancelar()">Cancelar</button>
	</div>
</body>
</html>