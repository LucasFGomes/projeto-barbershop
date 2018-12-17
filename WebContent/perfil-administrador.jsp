<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList, br.com.barbershop.model.bean.*" %>
<%@ page import="br.com.barbershop.controller.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Perfil Administrador - BarberShop</title>

<link rel="stylesheet" href="./css/estilo.css"/>
<link rel="stylesheet" href="./css/tabela.css"/>

</head>
<body>

	<%
		String email = (String) session.getAttribute("email");
	
		if (email == null) {
			response.sendRedirect("index.html");
		}

	%>
	
<div id="interface">

	<jsp:include page="jsp/headerAdm.jsp"></jsp:include>

	<main id=conteudo-principal>

	<h1>Agendamentos da Barbershop</h1>
	
	<table class="agendamento">
	
		<tr>
			<th>ID</th>
			<th>E-mail do Cliente</th>
			<th>Serviço</th>
			<th>Profissional</th>
			<th>Data</th>
			<th>Horário</th>
			<th>Preço</th>
			
		</tr>
		
		<jsp:useBean id="dao" class="br.com.barbershop.model.dao.AgendamentoDAO"></jsp:useBean>
		
		<c:forEach var="agendamento" items="${dao.listar()}">
			<tr>
				<td>${agendamento.id}</td>
				<td>${agendamento.email}</td>
				<td>${agendamento.servico}</td>
				<td>${agendamento.profissional}</td>
				<td>${agendamento.data}</td>
				<td>${agendamento.horario}</td>
				<td>${agendamento.preco}</td>
			</tr>
		</c:forEach>
		
	</table>
	
	<br> <br>
	
	<a href="deslogar.jsp"><input type="submit" name="sair" value="Sair"/></a>
	
	</main>
	
	<jsp:include page="jsp/rodape.jsp"></jsp:include>
</div>

</body>
</html>