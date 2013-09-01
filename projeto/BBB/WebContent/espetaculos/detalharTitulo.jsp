<%@page import="bbb.apresentacao.dto.SessaoDTO"%>
<%@page import="bbb.apresentacao.dto.ConsultarProgramacaoDTO"%>
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
		String tituloEscolhido = (String) session.getAttribute("TITULO");
		ConsultarProgramacaoDTO dto = (ConsultarProgramacaoDTO) session.getAttribute("SESSOES");
	%>
	<center>
	Tipo de Espetáculo:<%=tipoEscolhido%>
	Título:<%=tituloEscolhido %>
	<br> Comentários:<%=dto.getComentarios() %>
	<P>
	<h3>Sessões</h3>
	<table align="center">
		<tr>
			<td>Data</td><td>Início</td><td>Duração</td><td>Valor Inteira</td><td>Valor Meia</td><td>Local</td>
		</tr>
		<% for (SessaoDTO sessao : dto.getListaSessoes()) { %>
		<tr>
			<td><%=sessao.getDataSessao() %></td>
			<td><%=sessao.getInicio() %></td>
			<td><%=sessao.getDuracao() %></td>
			<td><%=sessao.getValorInteira() %></td>
			<td><%=sessao.getValorMeia() %></td>
			<td><%=sessao.getNomeLocal() %></td>
		</tr>
		<%} %>
	</table>
	</center>

</body>
</html>