<%@ page import="br.com.barbershop.controller.AdmController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="br.com.barbershop.controller.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="./css/estilo.css"/>
<link rel="stylesheet" href="./css/form.css"/>

<title>Agendar - Barbershop</title>
</head>
<body>
	<%
		String email = (String) session.getAttribute("email");
	
		if (email == null) {
			response.sendRedirect("index.html");
		}
		
		ClienteController cc = new ClienteController();
		List<String> listaProfissionais = cc.getProfissionais();
		List<String> listaDatas = cc.getDatas();
		List<String> listaHorarios = cc.getHorarios();
	%>

<div id="interface">
	<jsp:include page="jsp/header.jsp"></jsp:include>
	
	<div id=conteudo-principal>

		<h1>Agendar Serviços</h1>
		
		<jsp:useBean id="daoServico" class="br.com.barbershop.model.dao.ServicoDAO"/>
		
		<fieldset id="tela-agendamento">
		<form action="CadastroAgendamento" method="post">
			<label>Serviço</label> <br>
			<select id="idServico" name="servico">
				<option>Escolha o serviço</option>
								
					<c:forEach var="servico" items="${daoServico.listar()}">
						<option>${servico.nome}</option>
					</c:forEach>
					
			</select> <br> <br>

			<label>Profissional</label> <br>
			<select id="idProfissional" name="profissional">
				<option>Escolha o profissional</option>	
				
					<% for(String profissional : listaProfissionais) { %>
						<option> <%= profissional %> </option>
					<% } %>
	
			</select> <br> <br>
			
			<label>Data</label> <br>
			<select id="idData" name="data">
				<option>Escolha a data</option>
				
					<% for(String data : listaDatas) { %>
						<option> <%= data %> </option>
					<% } %>
				
			</select>  <br> <br>
			
			<label>Horário</label> <br>
			<select id="idHorario" name="horario">
				<option>Escolha o horario</option>
				
					<% for(String horario : listaHorarios) { %>
						<option> <%= horario %> </option>
					<% } %>
				
			</select> <br> <br>

			<label>Total a pagar R$ </label><input type="text" id="total-pagar" name="preco" size="3" value="" readonly/> <br> <br>
			<input type="submit" id="botao-agendar" value="Agendar"/> 
		</form>
		</fieldset>
		
	</div>

	<jsp:include page="jsp/rodape.jsp"></jsp:include>

</div>
	<script type="text/javascript" src="js/ajax.js"></script>
</body>
</html>