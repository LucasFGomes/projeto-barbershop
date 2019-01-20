<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Excluir cadastro - Barbershop</title>

<link rel="stylesheet" href="./css/estilo.css"/>
<link rel="stylesheet" href="./css/form.css"/>

</head>
<body>

	<%
		String email = (String) session.getAttribute("email");
	
		if (email == null) {
			response.sendRedirect("index.html");
		}
	%>

<div id="interface">

	<jsp:include page="jsp/header.jsp"></jsp:include>
    
    <div id=conteudo-principal>

	<h1>Excluir Cadastro</h1>

	<fieldset id="caixa-login">

		<form id="form-login" action="ExcluirCliente" method="post" onsubmit="">

			<label for="email"> E-mail </label> <input type="text" id="email"
				name="email" /> <br> <br>
			<label for="senha"> Senha </label> 
			<input type="password" id="senha" name="senha" maxlength="15" /> <br>

			<div id="oculto"></div>
			<br> <input type="submit" value="Confirmar"/>

		</form>
	</fieldset>
	
	</div>

	<jsp:include page="jsp/rodape.jsp"></jsp:include>
	
	</div>

</body>
</html>