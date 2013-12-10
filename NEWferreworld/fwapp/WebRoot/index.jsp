<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <title>Insert title here</title>
</head>

<body>
	<h1>Sistema de Información FERREWORLD C.A.</h1>
	<table width = "40%" border = "1" bfcolor = "gray" align = "center"
	cellpadding = "10">
	
		<tbody  >
			<tr> 
				<td bgcolor = "#9E8738"> <strong>Opcioness</strong></td>
			</tr>
		
			<tr> 
				<td> <a href = "#">Maestro Productos</a></td>
			</tr>
			<tr>  
				<td> <a href = "categ/opciones-cat.jsp">Maestro Categorias</a></td>
			</tr>
			<tr> 
				<td> <a href = "#">Maestro Clientes</a></td>
			</tr>
			<tr> 
				<td> <a href = "#">Maestro Proveedores</a></td>
			</tr>
			<tr> 
				<td> <a href = "#">Gestión de Pedidos</a></td>
			</tr>
			<tr> 
				<td> <a href = "#">Facturación</a></td>
			</tr>
			<tr> 
				<td> <a href = "#">Devoluciones</a></td>
			</tr>
			<tr> 
				<td> <a href = "#">Despacho</a></td>
			</tr>
			<tr> 
				<td> <a href = "#">Inventario</a></td>
			</tr>
		</tbody>
	</table>

</body>
</html>