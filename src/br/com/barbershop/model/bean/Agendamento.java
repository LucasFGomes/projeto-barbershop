package br.com.barbershop.model.bean;

public class Agendamento {
	private int id;
	private String emailCliente;
	private Servico servico;
	private String nomeProfissional;
	private String data;
	private String horario;
	
	public Agendamento() {
		
	}

	public Agendamento(String emailCliente, Servico servico, String nomeProfissional, String data, String horario) {
		this.emailCliente = emailCliente;
		this.servico = servico;
		this.nomeProfissional = nomeProfissional;
		this.data = data;
		this.horario = horario;
	}
	
	public Agendamento(int id, String emailCliente, Servico servico, String nomeProfissional, String data, String horario) {
		this.id = id;
		this.emailCliente = emailCliente;
		this.servico = servico;
		this.nomeProfissional = nomeProfissional;
		this.data = data;
		this.horario = horario;
	}
	
	public Agendamento(int id, Servico servico, String nomeProfissional, String data, String horario) {
		this.id = id;
		this.servico = servico;
		this.nomeProfissional = nomeProfissional;
		this.data = data;
		this.horario = horario;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	public String getNomeProfissional() {
		return nomeProfissional;
	}

	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}	
}
