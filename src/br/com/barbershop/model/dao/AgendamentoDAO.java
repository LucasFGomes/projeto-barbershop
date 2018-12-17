package br.com.barbershop.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.barbershop.connection.ConnectionFactory;
import br.com.barbershop.model.bean.Agendamento;
import br.com.barbershop.model.bean.Servico;

public class AgendamentoDAO {

	private Connection con = null;

	public boolean cadastrar(Agendamento agendamento) {

		this.con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO agendamentos (emailCliente, servico, profissional, data, horario, preco) VALUES (?,?,?,?,?,?)";

		try {
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, agendamento.getEmail());
			stmt.setString(2, agendamento.getServico());
			stmt.setString(3, agendamento.getProfissional());

			stmt.setString(4, agendamento.getData());
			stmt.setString(5, agendamento.getHorario());
			stmt.setDouble(6, agendamento.getPreco());
				
			stmt.executeUpdate();
				
			con.close();
			stmt.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return false;
	}
	
	public List<Agendamento> listar() {

		this.con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Agendamento> agendamentos = new ArrayList<>();
		String sql = "SELECT * FROM agendamentos";
		
		try {
			Servico servico = new Servico();
			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id"); 
				String email = rs.getString("emailCliente"); 
				servico.setNome(rs.getString("servico"));
				String nomeProfissional = rs.getString("profissional");
				String data = rs.getString("data");
				String horario = rs.getString("horario");
				servico.setPreco(rs.getDouble("preco"));
				
				Agendamento agendamento = new Agendamento(id, email, servico.getNome(), nomeProfissional, data, horario, servico.getPreco());

				agendamentos.add(agendamento);
			}
			
			con.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return agendamentos;
	}

	public boolean excluir(int id) {

		this.con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		String sql = "DELETE FROM agendamentos WHERE id = ?";

		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);

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
