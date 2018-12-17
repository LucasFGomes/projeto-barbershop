package br.com.barbershop.controller;

import br.com.barbershop.model.bean.Funcionario;
import br.com.barbershop.model.bean.Servico;
import br.com.barbershop.model.dao.FuncionarioDAO;
import br.com.barbershop.model.dao.ServicoDAO;

public class AdmController {
	
	private FuncionarioDAO daoFuncionario = null;
	private ServicoDAO daoServico = null;
	
	public AdmController() {
		this.daoServico = new ServicoDAO();
		this.daoFuncionario = new FuncionarioDAO();
	}

	public boolean cadastraFuncionario(Funcionario func) {
		return daoFuncionario.cadastrar(func);
	}
	
	public boolean cadastraServico(Servico servico) {		
		return daoServico.cadastrar(servico);
	}
	
}
