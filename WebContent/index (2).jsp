<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="co.poli.asesoriastyt.control.GYLoginServlet"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.lang.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
<!-- Include one of jTable styles. -->
<link href="css/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />

<link href="css\bootstrap\bootstrap-theme.css" rel="stylesheet" type="text/css" />
<link href="css\bootstrap\bootstrap.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js\bootstrap.js" type="text/javascript"></script>

<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>

</head>
<body>

 <jsp:include page="Header.jsp"></jsp:include>
<nav class="navbar navbar-default" role="navigation">
			<ul class="nav navbar-nav">
        		<li><a href="index.jsp">Inicio</a></li>
        		<li class="dropdown">
          			<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						Configuraciones <b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
	            		<li><a href="Perfiles.jsp">Perfiles</a></li>
	            		<li><a href="TipoIdentificacion.jsp">Tipo Identificaci&oacute;n</a></li>
			            <li><a href="Aulas.jsp">Aulas</a></li>
			            <li><a href="Bloques.jsp">Bloques</a></li>
			            <li><a href="EncargadoBloques">Encargados Bloques</a></li>
			            <li><a href="Asignaturas.jsp">Asignaturas</a></li>
			        </ul>
        		</li>
		        <li><a href="Docentes.jsp">Docentes</a></li>
		        <li><a href="Estudiantes.jsp">Estudiantes</a></li>
		        <li><a href="Perfiles.jsp">Programaciones Acad&eacute;micas</a></li>
		        <li><a href="#">Asesor&iacute;as</a></li>
		        <li><a href="#">Foro</a></li>
		        <li><a href="gylogin?op=logout"onclick="javascript:'window.open("https://www.google.com/accounts/Logout");'><IMG SRC="./images/salir.png" width='10%' height='10%'  > Cerrar Sesi&oacute;n</a></li>
   			</ul>
    	</nav>
    	
 	<div id="auth-info">
			<h3>Bienvenid@ ${gyUser.email}</h3>
		</div>
<br>	
<div style="width:60%;margin-right:20%;margin-left:5%;text-align:justify ;">
<h4>Ante las deficiencias detectadas y analizadas debidamente, se proyectara como soluci&oacute;n este programa de f&aacute;cil y libre acceso con el objetivo claro de acercar  y ayudar m&aacute;s al alumno en un proceso de apoyo hacia su aprendizaje por medio de las asesor&iacute;as y con la finalidad de que su aprendizaje sea mejor, mediante esta herramienta. </h4>



</div>	

	
 
</body>

</html>