package br.com.barbershop.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/barbershop?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static final String USUARIO = "root";
	private static final String SENHA = "";

	public Connection getConnection() {

		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USUARIO, SENHA);

		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("Erro na conexão: " + e);
		}

	}

}
