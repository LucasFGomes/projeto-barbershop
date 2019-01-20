package br.com.barbershop.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.barbershop.model.bean.Agendamento;
import br.com.barbershop.model.bean.Cliente;
import br.com.barbershop.model.bean.Funcionario;
import br.com.barbershop.model.bean.Servico;
import br.com.barbershop.model.dao.AgendamentoDAO;
import br.com.barbershop.model.dao.ClienteDAO;
import br.com.barbershop.model.dao.FuncionarioDAO;
import br.com.barbershop.model.dao.ServicoDAO;
import br.com.barbershop.util.Agenda;

public class ClienteController {

	private ClienteDAO daoCliente;
	private AgendamentoDAO daoAgendamento;
	private FuncionarioDAO daoFuncionario;
	private static ServicoDAO daoServico;

	public ClienteController() {
		this.daoCliente = new ClienteDAO();
		this.daoAgendamento = new AgendamentoDAO();
		this.daoFuncionario = new FuncionarioDAO();
		ClienteController.daoServico = new ServicoDAO();
	}

	public boolean cadastraCliente(Cliente c) {

		List<Cliente> listaClientes = daoCliente.listar();

		for (Cliente cliente : listaClientes) {
			if (cliente.getEmail() != c.getEmail() && cliente.getSenha() != c.getSenha()) {
				return daoCliente.cadastrar(c);
			}
		}

		return false;

	}

	public boolean excluiCliente(String email, String senha) {
		
		List<Agendamento> listaAgendamentos = daoAgendamento.listar();
		
		for (Agendamento agendamento : listaAgendamentos) {
			if (agendamento.getEmailCliente().equals(email)) {
				daoAgendamento.excluir(agendamento.getId());
			}
		}
		
		return daoCliente.excluir(email, senha);
	}

	public boolean cadastraAgendamento(Agendamento agendamento) {
		return daoAgendamento.cadastrar(agendamento);
	}
	
	public int verificaCliente(Agendamento agendamento){
		List<Cliente> listaClientes = daoCliente.listar();
		
		for (Cliente cliente : listaClientes) {
			if (cliente.getEmail().equals(agendamento.getEmailCliente())) {
				return cliente.getIdCliente();
			}
		}
		return 0;
	}
	
	public static int verificaServico(Agendamento agendamento) {
		List<Servico> listaServicos = daoServico.listar();
		
		for (Servico servico : listaServicos) {
			if (servico.getNome().equals(agendamento.getServico().getNome())) {
				return servico.getIdServico();
			}
		}
		return 0;
	}
	
	public int verificaFuncionario(Agendamento agendamento) {
		List<Funcionario> listaFuncionarios = daoFuncionario.listar();
		
		for (Funcionario funcionario : listaFuncionarios) {
			if (funcionario.getNome().equals(agendamento.getNomeProfissional())) {
				return funcionario.getIdFuncionario();
			}
		}
		return 0;
	}
	
	public List<String> getProfissionais() {

		List<Funcionario> funcionarios;
		List<String> nomeFuncionarios = new ArrayList<>();

		funcionarios = daoFuncionario.listar();
		for (Funcionario funcionario : funcionarios) {
			nomeFuncionarios.add(funcionario.getNome());
		}

		return nomeFuncionarios;
	}

	public List<String> getDatas() {
		List<String> listaDatas = Agenda.getDatas();

		Calendar c = Calendar.getInstance();
		int hora = c.get(Calendar.HOUR_OF_DAY);

		if (hora >= 19) {
			listaDatas.remove(0);
		}

		return listaDatas;
	}

	public List<String> getHorarios() {
		return Agenda.getHorarios();
	}

	public List<Agendamento> listaAgendamentosCliente(String email) {

		List<Agendamento> listagem = new ArrayList<>();

		for (Agendamento a : daoAgendamento.listar()) {
			if (a.getEmailCliente().equals(email)) {
				listagem.add(a);
			}
		}

		return listagem;
	}

//	public List<String> verificaProfissionaisDisponiveis(String servicoEscolhido) {
//
//		List<Servico> servicos = daoServico.listar();
//		List<Funcionario> funcionarios;
//		List<String> nomeFuncionarios = new ArrayList<>();
//
//		for (Servico servico : servicos) {
//			if (servico.getNome().equals(servicoEscolhido)) {
//				funcionarios = daoFuncionario.listar();
//				for (Funcionario funcionario : funcionarios) {
//					nomeFuncionarios.add(funcionario.getNome());
//				}
//			}
//		}
//		return nomeFuncionarios;
//	}

	// public List<String> verificaDatasDisponiveis(String profissionalEscolhido) {
	//
	// List<Funcionario> funcionarios = daoFuncionario.listar();
	// List<String> listaDatas = Agenda.getDatas();
	// List<Agendamento> agendamentos = daoAgendamento.listar();
	//
	// for (Funcionario funcionario : funcionarios) {
	//
	// if (funcionario.getNome().equals(profissionalEscolhido)) {
	//
	// Calendar c = Calendar.getInstance();
	// int hora = c.get(Calendar.HOUR_OF_DAY);
	//
	// if (hora >= 19) {
	// listaDatas.remove(0);
	// }
	//
	// return verificaDataLotada(listaDatas, agendamentos, profissionalEscolhido);
	// // Verifica se a data est�
	// // lotada
	// }
	// }
	// return null;
	// }

//	private List<String> verificaDataLotada(List<String> listaDatas, List<Agendamento> agendamentos,
//			String profissionalEscolhido) {
//		int contador = 0;
//		int diaSemana = 0;
//		try {
//			for (String data : listaDatas) {
//				for (Agendamento agendamento : agendamentos) {
//					String dataAgendada = Util.formatarData(agendamento);
//					if (data.equals(dataAgendada)) {
//						contador++;
//					}
//				}
//
//				java.util.Date dataAtual = new SimpleDateFormat("dd-MM-yyyy").parse(data);
//				Calendar c = Calendar.getInstance();
//				c.setTime(dataAtual);
//				diaSemana = c.get(Calendar.DAY_OF_WEEK);
//
//				if (contador == (Agenda.getHorarios().size() / 2) && diaSemana == 1) {
//					listaDatas.remove(data);
//				} else if (contador == Agenda.getHorarios().size()) {
//					listaDatas.remove(data);
//				}
//			}
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		return listaDatas;
//	}
	
//	public List<String> verificaData(List<String> listaDatas, List<Agendamento> agendamentos) {
//		
//		List<String> listaAtual = new ArrayList<String>();
//		
//		
//		for (int i = 0; i < listaDatas.size(); i++) {
//			
//			int quant = daoAgendamento.quantData(listaDatas.get(i));
//			
//			if (quant < (Agenda.getHorarios().size() * 5)) {
//				listaAtual.add(listaDatas.get(i));
//			}
//			
//		}
//		
//		return listaAtual;
//		
//	}

	// public List<String> verificaHorasDisponiveis(String dataEscolhida, String
	// profissionalEscolhido) {
	//
	// List<String> horarios = Agenda.getHorarios();
	// List<String> horariosDisponiveis = new ArrayList<>();
	// List<Agendamento> agendamentos = daoAgendamento.listar();
	//
	// int diaSemana = 0;
	// try {
	//
	// java.util.Date data = new
	// SimpleDateFormat("dd-MM-yyyy").parse(dataEscolhida);
	// Calendar c = Calendar.getInstance();
	// c.setTime(data);
	// diaSemana = c.get(Calendar.DAY_OF_WEEK);
	//
	// if (diaSemana == 1) {
	// for (String horario : horarios) {
	// for (Agendamento agendamento : agendamentos) {
	// String dataAgendada = Util.formatarData(agendamento);
	//
	// if (dataEscolhida.equals(dataAgendada)
	// && agendamento.getProfissional().equals(profissionalEscolhido)) {
	// String horaAgendada = Util.formatarHorario(agendamento);
	//
	// if (!(horario.equals(horaAgendada))) {
	// horariosDisponiveis.add(horario);
	// }
	// }
	// }
	// }
	// } else {
	// for (String horario : horarios) {
	// for (Agendamento agendamento : agendamentos) {
	// String dataAgendada = Util.formatarData(agendamento);
	//
	// if (dataEscolhida.equals(dataAgendada)
	// && agendamento.getProfissional().equals(profissionalEscolhido)) {
	// String horaAgendada = Util.formatarHorario(agendamento);
	//
	// if (!(horario.equals(horaAgendada))) {
	// horariosDisponiveis.add(horario);
	// }
	// }
	// }
	// }
	// }
	//
	// } catch (ParseException e) {
	// e.printStackTrace();
	// }
	//
	// return horariosDisponiveis;
	// }
}
