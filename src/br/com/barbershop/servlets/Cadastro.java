package br.com.barbershop.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.barbershop.controller.ClienteController;
import br.com.barbershop.model.bean.Cliente;

@WebServlet("/Cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClienteController cc;

	public Cadastro() {
		super();
	}

	@Override
	public void init() throws ServletException {
		this.cc = new ClienteController();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String celular = request.getParameter("celular");

		Cliente cliente = new Cliente(nome, cpf, email, senha, celular);

		boolean resposta = cc.cadastraCliente(cliente);

		if (resposta) {
			response.sendRedirect("index.html");
		} else {
			response.sendRedirect("fazer-cadastro.html");
		}

	}

}
