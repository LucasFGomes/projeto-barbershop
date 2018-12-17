<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList, br.com.barbershop.model.bean.*" %>
<%@ page import="br.com.barbershop.controller.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seu perfil - Barber Shop</title>

<link rel="stylesheet" href="./css/estilo.css"/>
<link rel="stylesheet" href="./css/tabela.css"/>

</head>
<body>

	<%
		String email = (String) session.getAttribute("email");
	
		if (email == null) {
			response.sendRedirect("index.html");
		}
		
		ClienteController cc = new ClienteController();
		List<Agendamento> listagem = new ArrayList<>(cc.listaAgendamentosCliente(email));
	%>
	
<div id="interface">
	
	<jsp:include page="jsp/header.jsp"></jsp:include>
    
    <main id=conteudo-principal>

	<h1>Meus agendamentos</h1>
	
	<table class="agendamento">
	
		<tr>
			<th>ID</th>
			<th>Serviço</th>
			<th>Profissional</th>
			<th>Data</th>
			<th>Horário</th>
			<th>Preco</th>
		</tr>
		
		<% for(Agendamento agen : listagem) { %>
			<tr>
				<td><%= agen.getId() %></td>
				<td><%= agen.getServico() %></td>
				<td><%= agen.getProfissional() %></td>
				<td><%= agen.getData() %></td>	
				<td><%= agen.getHorario() %></td>
				<td><%= agen.getPreco() %></td>
			</tr>
		<% } %>

	</table>
	
	<br> <br>
	
	<a href="deslogar.jsp"><input type="submit" name="sair" value="Sair" /></a>
	
	</main>
	
	<jsp:include page="jsp/rodape.jsp"></jsp:include>
</div>
</body>
</html>