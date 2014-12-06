<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Asesorías TyT</title>

<link rel="shortcut icon" type="image/x-icon" href="../images/favicon.ico" />
<link rel="icon" type="image/png" href="../images/favicon.png" />
<link href="./css/contenedor.css" rel="stylesheet" type="text/css" />



<script language="JavaScript">
//Ajusta el tamaño de un iframe al de su contenido interior para evitar scroll
function autofitIframe(id){
if (!window.opera && document.all && document.getElementById){
id.style.height=id.contentWindow.document.body.scrollHeight;
} else if(document.getElementById) {
id.style.height=id.contentDocument.body.scrollHeight+"px";
}
}
</script>


</head>

<body>
<div id="contenedor">
<div id="cabezote">
        <iframe id="header" frameborder="no" scrolling="no" height="150" width="100%" marginheight=0 marginwidth=0 noResize src="Header.jsp" style="background: transparent" allowtransparency="true"> </iframe></div>

<div id="menu">
		<iframe id="menu" frameborder="no" scrolling="auto" height="100%" width="200" marginheight=0 marginwidth=0 noResize src="Menu3.jsp" style="position:absolute; left:1px; top:120px; z-index:5"> </iframe> </div>

<div id="contenido">
		<iframe id="datos" name="datos"  frameborder="0" scrolling="auto" height="0" width="100%" marginheight=80 marginwidth=0  onload="autofitIframe(this);" noResize src="Bienvenida.jsp" style="background: transparent" allowtransparency="true"></iframe></div>
</div>
</body>
</html>
