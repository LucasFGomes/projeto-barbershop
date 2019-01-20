package br.com.barbershop.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.barbershop.connection.ConnectionFactory;
import br.com.barbershop.model.bean.Funcionario;

public class FuncionarioDAO {
	
	private Connection con = null;

	public boolean cadastrar(Funcionario func) {

		this.con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO funcionarios (nome, cpf, email, senha, celular, experiencia, adm) VALUES (?,?,?,?,?,?,?)";
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, func.getNome());
			stmt.setString(2, func.getCpf());
			stmt.setString(3, func.getEmail());
			stmt.setString(4, func.getSenha());
			stmt.setString(5, func.getCelular());
			stmt.setFloat(6, func.getExperiencia());
			stmt.setBoolean(7, func.getAdm());
			
			stmt.executeUpdate();
			
			con.close();
			stmt.close();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return false;
	}
	
	
	public List<Funcionario> listar() {

		this.con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Funcionario> funcionarios = new ArrayList<>();
		String sql = "SELECT * FROM funcionarios";
		
		try {
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				String celular = rs.getString("celular");
				float experiencia = rs.getFloat("experiencia");
				boolean adm = rs.getBoolean("adm");
				
				Funcionario func = new Funcionario(id, nome, cpf, email, senha, celular, experiencia, adm);
				
				funcionarios.add(func);
			}
			
			con.close();
			stmt.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return funcionarios;
	}
	
	public boolean excluir(Funcionario func) {

		this.con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		String sql = "DELETE FROM funcionarios WHERE = " + func.getIdFuncionario();
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.executeUpdate();
			
			con.close();
			stmt.close();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		
	}
}
