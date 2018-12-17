package br.com.barbershop.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.barbershop.controller.AdmController;
import br.com.barbershop.model.bean.Servico;

@WebServlet("/CadastroServico")
public class CadastroServico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdmController admc = null;
	
    public CadastroServico() {
        super();
        this.admc = new AdmController();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		double preco = Double.parseDouble(request.getParameter("preco"));
		
		Servico servico = new Servico(nome, preco);
		
		boolean resposta = admc.cadastraServico(servico);
		
		if (resposta) {
			response.sendRedirect("perfil-administrador.jsp");
		}
		
		
	}

}
