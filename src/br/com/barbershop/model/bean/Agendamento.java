package br.com.barbershop.model.bean;

public class Agendamento {
	private int id;
	private String email;
	private String servico;
	private String profissional;
	private String data;
	private String horario;
	private double preco;
	
	public Agendamento() {
		
	}

	public Agendamento(String email, String servico, String profissional, String data, String horario, double preco) {
		this.email = email;
		this.servico = servico;
		this.profissional = profissional;
		this.data = data;
		this.horario = horario;
		this.preco = preco;
	}
	
	public Agendamento(int id, String email, String servico, String profissional, String data, String horario, double preco) {
		this.id = id;
		this.email = email;
		this.servico = servico;
		this.profissional = profissional;
		this.data = data;
		this.horario = horario;
		this.preco = preco;
	}
	
	public Agendamento(int id, String servico, String profissional, String data, String horario, double preco) {
		this.id = id;
		this.servico = servico;
		this.profissional = profissional;
		this.data = data;
		this.horario = horario;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}
	
	public String getProfissional() {
		return profissional;
	}

	public void setProfissional(String profissional) {
		this.profissional = profissional;
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
	
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
