<%@page import="bbb.negocio.espetaculos.TipoEspetaculo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BBB Espet�culos</title>
</head>
<body>
	<h1 style="color: blue; font-size: 350%;">BBB</h1>
	<h2 style="color: white; background-color: black;">Entretenimento</h2>
	<h3 align="center">Consultar Programa��o</h3>
	<%
		List<TipoEspetaculo> tipos = (List<TipoEspetaculo>) session.getAttribute("TIPOS");
	%>
	<center>
	<form action="BuscarTitulosServlet" method="post">
		Tipo de Espet�culo:
		<select name="tipo" size="1">
			<%
				for (TipoEspetaculo tipo : tipos) {
			%>
				<option value="<%=tipo.name()%>"><%=tipo.toString() %></option>
			<%
				}
			%>
		</select>
		<input type="submit" value="Buscar T�tulos">
	</form>
	</center>
</body>
</html>