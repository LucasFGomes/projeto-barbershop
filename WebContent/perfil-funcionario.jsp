<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList, br.com.barbershop.model.bean.*" %>
<%@ page import="br.com.barbershop.controller.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Perfil Funcionário - BarberShop</title>

<link rel="stylesheet" href="./css/estilo.css"/>
<link rel="stylesheet" href="./css/tabela.css"/>

</head>
<body>
	<%
		String email = (String) session.getAttribute("email");
	
		if (email == null) {
			response.sendRedirect("index.html");
		}
		
		FuncionarioController fc = new FuncionarioController();
		List<Agendamento> listagem = new ArrayList<>(fc.listaAgendamentosProfissionais(email));
	%>

<div id="interface">

	<header id="cabecalho"> 
		<a href="perfil-funcionario.jsp"> <img src="./imagens/logo-barbearia.png" id="imagem-logo" alt="Logo da barbearia" height="130" width="180" />
		</a> 
	</header>

	<div id=conteudo-principal>

	<h1>Serviços agendados</h1>
	
	<table class="agendamento">
	
		<tr>
			<th>ID</th>
			<th>Serviço</th>
			<th>Profissional</th>
			<th>Data</th>
			<th>Horário</th>
			<th>Preço</th>
			<th>Concluir Serviço</th>
		</tr>
		
		<% for(Agendamento agen : listagem) { %>
			<tr>
				<td><%= agen.getId() %></td>
				<td><%= agen.getServico().getNome() %></td>
				<td><%= agen.getNomeProfissional() %></td>
				<td><%= agen.getData() %></td>	
				<td><%= agen.getHorario() %></td>
				<td><%= agen.getServico().getPreco() %></td>
				<td>
					<form action="ExcluirAgendamento" method="post">
						<button type="submit" name="conclui" value="<%= agen.getId() %>">Concluir</button>
					</form>
				</td>
			</tr>
		<% } %>

	</table>
	
	<br> <br>
	
	<a href="deslogar.jsp"><input type="submit" name="sair" value="Sair"/></a>
	
	</div>
	
	<jsp:include page="jsp/rodape.jsp"></jsp:include>
</div>

</body>
</html>