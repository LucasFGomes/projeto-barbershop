package br.com.barbershop.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.barbershop.connection.ConnectionFactory;
import br.com.barbershop.model.bean.Servico;

public class ServicoDAO {
	
	private Connection con = null;

	public boolean cadastrar(Servico servico) {

		this.con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO servicos (nome, preco) VALUES (?,?)";

		try {
			stmt = con.prepareStatement(sql);

			stmt.setString(1, servico.getNome());
			stmt.setDouble(2, servico.getPreco());

			stmt.executeUpdate();
			
			con.close();
			stmt.close();
			
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return false;
	}
	
//	public boolean consultar(String nome) {
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		String sql = "SELECT idServico FROM servicos WHERE nome = ?";
//		
//		try {
//			stmt = con.prepareStatement(sql);
//			
//			stmt.setString(1, nome);
//			
//			rs = stmt.executeQuery();
//
//			rs.getInt("idServico");
//			
//			con.close();
//			stmt.close();
//			rs.close();
//			
//			return true;
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return false;
//	}

	public List<Servico> listar() {

		this.con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Servico> servicos = new ArrayList<>();
		String sql = "SELECT * FROM servicos";
		
		try {
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				double preco = rs.getDouble("preco");
				
				Servico servico = new Servico(id, nome, preco);
				
				servicos.add(servico);
			}
			
			con.close();
			stmt.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return servicos;
		
	}
	
	public void alterar(Servico servico) {
		
		this.con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		String sql = "UPDATE servicos SET preco = ? WHERE idServico = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setDouble(1, servico.getPreco());
			stmt.setInt(2, servico.getIdServico());
			
			stmt.executeUpdate();
			
			con.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
	}

	public boolean excluir(Servico servico) {
		
		this.con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		String sql = "DELETE FROM servicos WHERE idServico = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, servico.getIdServico());
			
			stmt.executeUpdate();
			
			con.close();
			stmt.close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return false;
	}
	
}
