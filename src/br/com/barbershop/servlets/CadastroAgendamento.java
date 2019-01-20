package br.com.barbershop.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.barbershop.controller.ClienteController;
import br.com.barbershop.model.bean.Agendamento;
import br.com.barbershop.model.bean.Servico;

@WebServlet("/CadastroAgendamento")
public class CadastroAgendamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClienteController cc;
	
    public CadastroAgendamento() {
        super();
        this.cc = new ClienteController();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Servico servico = new Servico();
		
		String email = (String) session.getAttribute("email");
		servico.setNome(request.getParameter("servico"));
		String profissional = request.getParameter("profissional");
		String data = request.getParameter("data");
		String horario = request.getParameter("horario");
		servico.setPreco(Double.parseDouble(request.getParameter("preco")));
		
		Agendamento agendamento = new Agendamento(email, servico, profissional, data, horario);
		
		boolean resposta = cc.cadastraAgendamento(agendamento);

		if (resposta) {
			response.sendRedirect("agendar.jsp");
		}
	}

}
