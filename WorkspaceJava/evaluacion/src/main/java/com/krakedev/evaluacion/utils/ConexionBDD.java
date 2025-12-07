package com.krakedev.evaluacion.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.excepciones.KrakeException;

public class ConexionBDD {
	private final static String DRIVER="org.postgresql.Driver";
	private final static String URL="jdbc:postgresql://localhost:5432/repaso_prueba";
	private final static String USUARIO="postgres";
	private final static String CLAVE="4189";
	private static final Logger LOGGER=LogManager.getLogger(ConexionBDD.class);
	
	public static Connection conectar() throws KrakeException{
		Connection connection=null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USUARIO, CLAVE);
			LOGGER.debug("Obteniendo conexion...");
			LOGGER.debug("Conexion exitosa");
		} catch (ClassNotFoundException e) {
			LOGGER.error("Error en la infraestructura", e);
			throw new KrakeException("Error en la infraestructura");
		} catch (SQLException e) {
			LOGGER.error("Error al conectarse, revise usuario y clave", e);
			throw new KrakeException("Error al conectarse, revise usuario y clave");
		}
		return connection;
	}
}
