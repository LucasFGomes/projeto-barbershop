package br.com.barbershop.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.barbershop.connection.ConnectionFactory;
import br.com.barbershop.controller.ClienteController;
import br.com.barbershop.model.bean.Agendamento;
import br.com.barbershop.model.bean.Servico;

public class AgendamentoDAO {

	private Connection con = null;

	public boolean cadastrar(Agendamento agendamento) {

		this.con = new ConnectionFactory().getConnection();
		ClienteController cc = new ClienteController();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO agendamentos (data, horario, idCliente, idServico, idFuncionario) VALUES (?,?,?,?,?)";

		try {
			stmt = con.prepareStatement(sql);


			stmt.setString(1, agendamento.getData());
			stmt.setString(2, agendamento.getHorario());

			stmt.setInt(3, cc.verificaCliente(agendamento));
			stmt.setInt(4, ClienteController.verificaServico(agendamento));
			stmt.setInt(5, cc.verificaFuncionario(agendamento));

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
		String sql = "SELECT agendamentos.id, clientes.email AS emailCliente, servicos.nome AS servico, funcionarios.nome AS profissional, data, horario, servicos.preco  FROM agendamentos "
				+ "INNER JOIN clientes ON agendamentos.idCliente = clientes.id "
				+ "INNER JOIN servicos ON agendamentos.idServico = servicos.id "
				+ "INNER JOIN funcionarios ON agendamentos.idFuncionario = funcionarios.id";

		try {
			Servico servico = new Servico();
			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				String emailCliente = rs.getString("emailCliente");
				servico.setNome(rs.getString("servico"));
				String nomeProfissional = rs.getString("profissional");
				String data = rs.getString("data");
				String horario = rs.getString("horario");
				servico.setPreco(rs.getDouble("preco"));

				Agendamento agendamento = new Agendamento(id, emailCliente, servico, nomeProfissional, data, horario);

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
