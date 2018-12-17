<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar - Barbershop</title>

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

	<jsp:include page="jsp/headerAdm.jsp"></jsp:include>
	
	<main id=conteudo-principal>

		<h2>Cadastrar Funcionário</h2>
	
		<form action="Cadastro" method="post">

			<fieldset id="dados-pessoais">
				<legend> Dados do funcionário </legend>
				<label for="idNome"> Nome </label> <br/>
				<input type="text" id="idNome" name="nome" placeholder="João da Silva" size="30" required> <br/> <br/>

				<label for="idCpf"> CPF </label> <br/>
				<input type="text" id="idCpf" name="cpf" placeholder="000.000.000-00" maxlength="11"/> <br/> <br/>

				<label for="idEmail"> E-mail </label> <br/>
				<input type="email" id="idEmail" name="email" placeholder="exemplo@gmail.com" required/> <br/> <br/>

				<label for="idSenha"> Senha </label> <br/>
				<input type="password" id="idSenha" name="senha" placeholder="**********" maxlength="15" required> <br/> <br/>

				<label for="idCelular"> Celular </label> <br/>
				<input type="text" id="idCelular" name="celular" placeholder="(00) 00000-0000" required/> <br/> <br/>
				
				<label for="idExperiencia"> Experiência </label> <br/>
				<input type="number" id="idExperiencia" name="experiencia" min="1" size="2" required/> <br/> <br/>
			
				<input type="checkbox" id="idAdm" name="adm"/><label for="idAdm">Administrador</label>
			</fieldset>
			
			<input type="reset" id="botao-redefinir"/>
			<input type="submit" id="botao-enviar" value="Cadastrar"/>
		</form>
		
	<h2>Cadastrar Serviço</h2>
	
		<form action="CadastroServico" method="post">
		
			<fieldset id="dados-serviço">
				<legend>Dados do serviço</legend>
				
				<label for="idNome"> Nome </label> <br/>
				<input type="text" id="idNome" name="nome" placeholder="Corte" size="30" required> <br/> <br/>

				<label for="idPreco"> Preço </label> <br/>
				<input type="number" id="idPreco" name="preco" placeholder="16"/> <br/> <br/>
				
			</fieldset>
			
			<input type="reset" id="botao-redefinir"/>
			<input type="submit" id="botao-enviar" value="Cadastrar"/>
	
		</form>

	</main>
	
	<jsp:include page="jsp/rodape.jsp"></jsp:include>
	
</div>

</body>
</html>