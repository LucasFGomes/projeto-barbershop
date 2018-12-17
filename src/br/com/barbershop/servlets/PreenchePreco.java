package br.com.barbershop.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.barbershop.model.bean.Servico;
import br.com.barbershop.model.dao.ServicoDAO;

@WebServlet("/PreenchePreco")
public class PreenchePreco extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServicoDAO daoServico = null;
	
    public PreenchePreco() {
        super();
        this.daoServico = new ServicoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String servico = request.getParameter("servico");
		
		List<Servico> servicos = daoServico.listar();
		
		for (Servico s : servicos) {
			if (s.getNome().equals(servico)) {
				response.getWriter().println(s.getPreco());
			}
		}
	}
}
