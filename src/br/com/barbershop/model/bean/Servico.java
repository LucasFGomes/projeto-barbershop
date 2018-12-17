package br.com.barbershop.model.bean;

public class Servico {
	private int idServico;
	private String nome;
	private double preco;
	
	public Servico() {
		
	}

	public Servico(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public Servico(int idServico, String nome, double preco) {
		this.idServico = idServico;
		this.nome = nome;
		this.preco = preco;
	}

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
