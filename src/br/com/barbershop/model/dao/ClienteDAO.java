package br.com.barbershop.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.barbershop.connection.ConnectionFactory;
import br.com.barbershop.model.bean.Cliente;

public class ClienteDAO {
	
	private Connection con = null;

	public boolean cadastrar(Cliente cliente) {
		
		this.con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO clientes (nome, cpf, email, senha, celular) VALUES (?,?,?,?,?)";

		try {
			stmt = con.prepareStatement(sql);

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getSenha());
			stmt.setString(5, cliente.getCelular());

			stmt.executeUpdate();
			
			con.close();
			stmt.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;

	}
	
	public List<Cliente> listar() {

		this.con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT * FROM clientes";
		
		try {
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt("idCliente");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				String celular = rs.getString("celular");
				
				Cliente cliente = new Cliente(id, nome, cpf, email, senha, celular);
				
				clientes.add(cliente);
			}
			
			con.close();
			stmt.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return clientes;
	}

	public boolean excluir(String email, String senha) {
		
		this.con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		String sql = "DELETE FROM clientes WHERE email = ? AND senha = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, senha);
			
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
