package br.com.barbershop.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.barbershop.controller.AdmController;
import br.com.barbershop.controller.ClienteController;
import br.com.barbershop.model.bean.Cliente;
import br.com.barbershop.model.bean.Funcionario;

@WebServlet("/Cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClienteController cc;
	private AdmController admc;

    public Cadastro() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	 this.cc = new ClienteController();
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
		
		boolean resposta;
		
		if (experiencia == 0) {
			
			Cliente cliente = new Cliente(nome, cpf, email, senha, celular);
			
			resposta = cc.cadastraCliente(cliente);
			
			if (resposta) {
				response.sendRedirect("index.html");  
			} else {
				response.sendRedirect("fazer-cadastro.html");
			}
			
		} else if (experiencia > 0) {
			
			Funcionario func = new Funcionario(nome, cpf, email, senha, celular, experiencia, adm);
			
			resposta = admc.cadastraFuncionario(func);
			
			if (resposta) {
				response.sendRedirect("cadastrar.jsp");
			} 
			
		}
		

	}

}
