package com.krakedev.conexionbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConexion {

	public static void main(String[] args) {
		Connection connection=null;
		
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/ejercicios","postgres","4189");
			System.out.println("Conexion Exitosa");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
