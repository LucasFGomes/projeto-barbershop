<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar - Barbershop</title>

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

	<h1>Lista de Funcionários</h1>
	
	<table class="agendamento">
	
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>CPF</th>
			<th>E-mail</th>
			<th>Senha</th>
			<th>Experiência</th>
			<th>Adm</th>
			
		</tr>
		
		<jsp:useBean id="daoFuncionario" class="br.com.barbershop.model.dao.FuncionarioDAO"></jsp:useBean>
		
		<c:forEach var="funcionario" items="${daoFuncionario.listar()}">
			<tr>
				<td>${funcionario.idFuncionario}</td>
				<td>${funcionario.nome}</td>
				<td>${funcionario.cpf}</td>
				<td>${funcionario.email}</td>
				<td>${funcionario.senha}</td>
				<td>${funcionario.experiencia}</td>
				<td>${funcionario.adm}</td>
			</tr>
		</c:forEach>
		
	</table>
	
	<h1>Lista de Serviços</h1>
	
	<table class="agendamento">
	
		<tr>
			<th>ID</th>
			<th>Descrição</th>
			<th>Preço</th>
		</tr>
		
		<jsp:useBean id="daoServico" class="br.com.barbershop.model.dao.ServicoDAO"></jsp:useBean>
		
		<c:forEach var="servico" items="${daoServico.listar()}">
			<tr>
				<td>${servico.idServico}</td>
				<td>${servico.nome}</td>
				<td>${servico.preco}</td>
			</tr>
		</c:forEach>
		
	</table>

	</main>
	
	<jsp:include page="jsp/rodape.jsp"></jsp:include>
</div>

</body>
</html>