<%@page import="java.util.List"%>
<%@page import="bbb.negocio.espetaculos.TipoEspetaculo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BBB Espetáculos</title>
</head>
<body>
	<h1 style="color: blue; font-size: 350%;">BBB</h1>
	<h2 style="color: white; background-color: black;">Entretenimento</h2>
	<h3 align="center">Consultar Programação</h3>
	<%
		List<TipoEspetaculo> tipos = (List<TipoEspetaculo>) session.getAttribute("TIPOS");
		String tipoEscolhido = (String) session.getAttribute("TIPO_ESCOLHIDO");
		List<String> titulos = (List<String>) session.getAttribute("TITULOS");
	%>
	<center>
	<form action="ConsultarProgramacaoServlet" method="post">
		Tipo de Espetáculo:	<%=tipoEscolhido%>
		<select name="titulo" size="1">
			<%
				for (String titulo : titulos) {
			%>
			<option value="<%=titulo%>"><%=titulo%></option>
			<%
				}
			%>
		</select> <input type="submit" value="Buscar Detalhes do Título">
	</form>
	</center>
</body>
</html>