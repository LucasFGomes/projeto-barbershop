package br.com.barbershop.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.barbershop.controller.ClienteController;

@WebServlet("/ExcluirCliente")
public class ExcluirCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClienteController cc;
	
    public ExcluirCliente() {
        this.cc = new ClienteController();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		boolean resposta = cc.excluiCliente(email, senha);
		
		if (resposta) {
			response.sendRedirect("index.html");
		} else {
			response.sendRedirect("excluir-cliente.jsp");
		}

	}

}
