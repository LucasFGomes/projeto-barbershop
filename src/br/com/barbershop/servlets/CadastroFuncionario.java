package br.com.barbershop.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.barbershop.controller.AdmController;
import br.com.barbershop.model.bean.Funcionario;

@WebServlet("/CadastroFuncionario")
public class CadastroFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdmController admc;
       
    public CadastroFuncionario() {
        super();
        this.admc = new AdmController();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String celular = request.getParameter("celular");
		float experiencia = Float.parseFloat(request.getParameter("experiencia"));
		boolean adm = Boolean.parseBoolean(request.getParameter("adm"));
		
		Funcionario funcionario = new Funcionario(nome, cpf, email, senha, celular, experiencia, adm);
		
		boolean resposta = admc.cadastraFuncionario(funcionario);
		
		if (resposta) {
			response.sendRedirect("cadastrar.jsp");
		} 
	}

}
