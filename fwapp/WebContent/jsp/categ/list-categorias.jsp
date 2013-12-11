<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basepath = request.getScheme()+"://"+request.getServerName()+":"+
request.getServerPort()+path+"/";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Categorias</title>
</head>
<body>
<h1>Listar Categorias</h1>
	<table>
	<tbody>
		<th>ID</th>
		<th>Nombre</th>
		<th>Activo</th>
	</tbody>
	<c:forEach items="${lista}" var="obj">
		<tr> 
			<td> ${obj}.id </td>
			<td> ${obj}.nombre </td>
			<td> ${obj}.activo </td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>