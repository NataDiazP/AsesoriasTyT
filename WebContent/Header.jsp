<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Pragma" content="no-cache" />
<link href="./css/style1.css" rel="stylesheet" type="text/css" />

<%
	/*if (session.getAttribute("gyUser") != null && !session.getAttribute("gyUser").equals("")) 
	{
	} 	
	else 
	{
	 response.sendRedirect(request.getContextPath());
	}
	
	
	 */
%>

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
<body onload="borrarHistorial()">
	<div id="header_wrapper">
		<br /> <IMG SRC="./images/logo.png" width='15%' height='70%'
			style="margin: 5px 0px 5px 30px; float: left;"> <IMG
			SRC="./images/api.jpg" width='15%' height='80%' align="right"
			style="margin: 5px 30px 5px 5px; float: right;">
	</div>
	=======
	<%
		/*if (session.getAttribute("gyUser") != null && !session.getAttribute("gyUser").equals("")) 
		{
		} 	
		else 
		{
		 response.sendRedirect(request.getContextPath());
		}
		 */
	%>

	</head>
	<body onload="borrarHistorial()">
		<div id="header_wrapper">
			<br> <img src="./images/logo.png" width='15%' height='70%'
				style="margin: 5px 0px 5px 30px; float: left;"> <img
					src="./images/api.jpg" width='15%' height='80%' align="right"
					style="margin: 5px 30px 5px 5px; float: right;">
		</div>

	</body>
</html>