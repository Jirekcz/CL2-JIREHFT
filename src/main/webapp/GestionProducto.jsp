<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "java.util.List" %>
<%@page import = "model.TblProductocl2" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestionar Productos</title>
</head>
<body bgcolor = "#c5dec9">
<h1 align="center">Gestionar Productos</h1>
<form action = "ControladorServletCL2" method="post">
<table align = "center">

<tr>
<td>Nombre</td>
<td><input type = "text" name = "nombre"></td>
</tr>

<tr>
<td>Precio</td>
<td><input type = "number" name = "preciocomp"></td>
</tr>

<tr>
<td>PrecioVen</td>
<td><input type = "number" name = "precioven"></td>
</tr>

<tr>
<td>Estado</td>
<td><input type = "text" name = "estado"></td>
</tr>

<tr>
<td>Descripcion</td>
<td><input type = "text" name = "descrip"></td>
</tr>

<tr>
<td colspan = "2"> <input type = "submit" name = "Registrar producto"'> </td>
</tr>

</table>
</form>
<h1 align = "center">Listado de Productos</h1>
<table align = "center" border = "2">
<tr>
<th>Codigo</th>
<th>Nombre</th>
<th>Precio venta</th>
<th>Precio Comp</th>
<th>Estado</th>
<th>Descripcion</th>
</tr>
<%
List<TblProductocl2> ListadoProducto = (List<TblProductocl2>)request.getAttribute("listado");
if (ListadoProducto != null) {
	for (TblProductocl2 lis:ListadoProducto) {
%>
<tr>
<td>
<%=lis.getIdproductocl2() %>
</td>
<td>
<%=lis.getNombrecl2() %>
</td>
<td>
<%=lis.getPrecioventacl2() %>
</td>
<td>
<%=lis.getPreciocompcl2() %>
</td>
<td>
<%=lis.getEstadocl2() %>
</td>
<td>
<%=lis.getDescripcl2() %>
</td>
</tr>
<%
	}
}
%>
</table>
</body>
</html>