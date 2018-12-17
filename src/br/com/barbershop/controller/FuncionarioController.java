package br.com.barbershop.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.barbershop.model.bean.Agendamento;
import br.com.barbershop.model.bean.Funcionario;
import br.com.barbershop.model.dao.AgendamentoDAO;
import br.com.barbershop.model.dao.FuncionarioDAO;

public class FuncionarioController {
	
	private FuncionarioDAO daoFuncionario = null;
	private AgendamentoDAO daoAgendamento = null;
	
	public FuncionarioController() {
		this.daoFuncionario = new FuncionarioDAO();
		this.daoAgendamento = new AgendamentoDAO();
	}

	public List<Agendamento> listaAgendamentosProfissionais(String email) {
		
		List<Agendamento> listagem = new ArrayList<>();
		
		List<Funcionario> listaFuncionario = daoFuncionario.listar();
		List<Agendamento> listaAgendamentos = daoAgendamento.listar();
		
		for (Funcionario funcionario : listaFuncionario) {
			if (funcionario.getEmail().equals(email)) {
				for (Agendamento a : listaAgendamentos) {
					if (a.getProfissional().equals(funcionario.getNome())) {
						listagem.add(a);
					}
				}
			}
		}
		
		return listagem;
	}
	
	public boolean excluiAgendamento(int id) {
		return daoAgendamento.excluir(id);
	}
	
}
