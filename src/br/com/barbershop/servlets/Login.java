package br.com.barbershop.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.barbershop.controller.Controller;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Controller c;
	
    public Login() {
        super();
        this.c = new Controller();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String opcao = request.getParameter("opcao-selecionada");
		
		boolean verificacao = c.verificaLogin(email, senha, opcao);
		
		String emailSession = (String) session.getAttribute("email");

		emailSession = email;
		
		if (verificacao == true && opcao.equals("Cliente")) {
			session.setAttribute("email", emailSession);
			response.sendRedirect("perfil-cliente.jsp");
		} else if (verificacao == true && opcao.equals("Profissional")) {
			session.setAttribute("email", emailSession);
			response.sendRedirect("perfil-funcionario.jsp");
		} else if (verificacao == true && opcao.equals("Administrador")) {
			session.setAttribute("email", emailSession);
			response.sendRedirect("perfil-administrador.jsp");
		} else {
			response.sendRedirect("index.html");
		}
		
	}
}
