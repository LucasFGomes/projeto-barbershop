package br.com.barbershop.model.bean;

public class Funcionario extends Pessoa {
	private int idFuncionario;
	private float experiencia;
	private boolean adm;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome, String cpf, String email, String senha, String celular, float experiencia, boolean adm) {
		super(nome, cpf, email, senha, celular);
		this.experiencia = experiencia;
		this.adm = adm;
	}
	
	public Funcionario(int idFuncionario, String nome, String cpf, String email, String senha, String celular, float experiencia, boolean adm) {
		super(nome, cpf, email, senha, celular);
		this.idFuncionario = idFuncionario;
		this.experiencia = experiencia;
		this.adm = adm;
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public float getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(float experiencia) {
		this.experiencia = experiencia;
	}
	public boolean getAdm() {
		return adm;
	}
	public void setAdm(boolean adm) {
		this.adm = adm;
	}
}
