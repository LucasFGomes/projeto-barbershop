package br.com.barbershop.model.bean;

public class Cliente extends Pessoa {
	private int idCliente;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String cpf, String email, String senha, String celular) {
		super(nome, cpf, email, senha, celular);
	}
	
	public Cliente(int idCliente, String nome, String cpf, String email, String senha, String celular) {
		super(nome, cpf, email, senha, celular);
		this.idCliente = idCliente;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

}