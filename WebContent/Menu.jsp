<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>::Asesor�as TyT ::</title>
<link href="./css/generales.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<base target="cont" />
<script type="text/javascript" src="./js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="./js/ddaccordion.js"></script>

<script type="text/javascript">
	ddaccordion.init({ //top level headers initialization
		headerclass : "expandable", //Shared CSS class name of headers group that are expandable
		contentclass : "categoryitems", //Shared CSS class name of contents group
		revealtype : "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
		mouseoverdelay : 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
		collapseprev : true, //Collapse previous content (so only one open at any time)? true/false 
		defaultexpanded : [], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
		onemustopen : false, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault : false, //Should contents open by default be animated into view?
		persiststate : true, //persist state of opened contents within browser session?
		toggleclass : [ "", "openheader" ], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml : [ "prefix", "", "" ], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed : "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
		oninit : function(headers, expandedindices) { //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose : function(header, index, state, isuseractivated) { //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})

	ddaccordion.init({ //2nd level headers initialization
		headerclass : "subexpandable", //Shared CSS class name of sub headers group that are expandable
		contentclass : "subcategoryitems", //Shared CSS class name of sub contents group
		revealtype : "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
		mouseoverdelay : 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
		collapseprev : true, //Collapse previous content (so only one open at any time)? true/false 
		defaultexpanded : [], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
		onemustopen : false, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault : false, //Should contents open by default be animated into view?
		persiststate : true, //persist state of opened contents within browser session?
		toggleclass : [ "opensubheader", "closedsubheader" ], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml : [ "none", "", "" ], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed : "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
		oninit : function(headers, expandedindices) { //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose : function(header, index, state, isuseractivated) { //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})

	ddaccordion.init({ //3nd level headers initialization
		headerclass : "sub2expandable", //Shared CSS class name of sub headers group that are expandable
		contentclass : "sub2categoryitems", //Shared CSS class name of sub contents group
		revealtype : "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
		mouseoverdelay : 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
		collapseprev : true, //Collapse previous content (so only one open at any time)? true/false 
		defaultexpanded : [], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
		onemustopen : false, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault : false, //Should contents open by default be animated into view?
		persiststate : true, //persist state of opened contents within browser session?
		toggleclass : [ "open2subheader", "closed2subheader" ], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml : [ "none", "", "" ], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed : "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
		oninit : function(headers, expandedindices) { //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose : function(header, index, state, isuseractivated) { //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})
</script>

</head>
<body>
	<div class="arrowlistmenu">
		<h3 class="menuheader Noexpandable">
			<a href="Bienvenida.jsp" target="datos">Inicio</a>
		</h3>
		<!--Inicio opci�n desplegable-->
		<h3 class="menuheader expandable">Configuraciones</h3>
		<ul class="categoryitems">
			<li><a href="EncargadoBloque.jsp" target="datos">Administrar
					Encargados de Bloques</a></li>
			<li><a href="Bloques.jsp" target="datos">Administrar Bloques</a></li>
			<li><a href="Aulas.jsp" target="datos">Administrar Aulas</a></li>
			<li><a href="Asignaturas.jsp" target="datos">Administrar
					Asignaturas</a></li>
		</ul>
		<!--Fin opci�n desplegable-->

		<h3 class="menuheader Noexpandable">
			<a href="CargarExcel.jsp" target="datos">Cargar Excel</a>
		</h3>
		<h3 class="menuheader Noexpandable">
			<a href="Docentes.jsp" target="datos">Docentes</a>
		</h3>
		<h3 class="menuheader Noexpandable">
			<a href="Estudiantes.jsp" target="datos">Estudiantes</a>
		</h3>
		<h3 class="menuheader Noexpandable">
			<a href="ProgAcademicas.jsp" target="datos">Programaci&oacute;n
				Acad&eacute;mica</a>
		</h3>
		<h3 class="menuheader Noexpandable">
			<a href="Asesorias.jsp" target="datos">Asesor&iacute;as</a>
		</h3>
		<h3 class="menuheader Noexpandable">
			<a href="http://asesoriastyt.foroweb.org/" target="_blank">Foro</a>
		</h3>
		<h3 class="menuheader Noexpandable">
			<a href="Reportes.jsp" target="datos">Reportes</a>
		</h3>
		<h3 class="menuheader Noexpandable">
			<a href="Acerca.jsp" target="datos">Acerca de</a>
		</h3>
		<h3 class="menuheader Noexpandable">
			<a href="Manual AsesoriasTyT/indexManual.html" target="_blank">Manual de Usuario</a>
		</h3>
		<h3 class="menuheader Noexpandable">
			<a href="logout">Salida Segura</a>
		</h3>
	</div>
</body>
</html>