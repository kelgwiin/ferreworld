<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"
+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Listar categoria</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body><body>
<h1>Lista de Categorias disponibles</h1>
	<table width = "230px" cellpadding = "10" border = "1">
	<tbody>
	<tr>
		<td>ID</td>
		<td>Nombre</td>
		<td>Activo</td>
	</tr>
		
	<c:forEach items="${lista}" var="obj">
		<tr> 
			<td> ${obj.id} </td>
			<td> ${obj.nombre} </td>
			<td> ${obj.activo} </td>
		</tr>
	</c:forEach>
	
	</tbody>
	
	</table>
	
	<a href = "/fwapp">Inicio</a>
	<a href = "/fwapp/opciones-cat.jsp">Atras</a>
	

</body>
</html>