package br.com.barbershop.controller;

import java.util.List;

import br.com.barbershop.model.bean.Cliente;
import br.com.barbershop.model.bean.Funcionario;
import br.com.barbershop.model.dao.ClienteDAO;
import br.com.barbershop.model.dao.FuncionarioDAO;

public class Controller {

	private ClienteDAO daoCliente;
	private FuncionarioDAO daoFuncionario;

	public Controller() {
		this.daoCliente = new ClienteDAO();
		this.daoFuncionario = new FuncionarioDAO();
	}

	public boolean verificaLogin(String email, String senha, String opcao) {

		if (opcao.equals("Cliente")) {

			List<Cliente> clientes = daoCliente.listar();

			if (!(clientes.isEmpty())) {

				for (Cliente cliente : clientes) {
					if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
						return true;
					}
				}

			}
			return false;

		} else if (opcao.equals("Profissional")) {

			List<Funcionario> funcionarios = daoFuncionario.listar();

			if (!(funcionarios.isEmpty())) {

				for (Funcionario funcionario : funcionarios) {
					if (funcionario.getEmail().equals(email) && funcionario.getSenha().equals(senha)) {
						return true;
					}
				}
			}

			return false;

		} else if (opcao.equals("Administrador")) {

			List<Funcionario> administradores = daoFuncionario.listar();

			if (!(administradores.isEmpty())) {

				for (Funcionario f : administradores) {
					if (f.getAdm() == true && f.getEmail().equals(email) && f.getSenha().equals(senha)) {
						return true;
					}
				}
			}
		
			return false;

		}
		return false;
	}
}
