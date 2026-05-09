package com.krakedev.moduloii.evaluacion2.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.moduloii.evaluacion2.entidades.Libro;
import com.krakedev.moduloii.evaluacion2.utils.ConexionBDD;

public class ServiciosLibro {
	private static final Logger LOGGER = LogManager.getLogger(ServiciosBiblioteca.class);
	public static void insertarLibro(Libro libro) throws Exception {
		Connection con = null;
		LOGGER.trace("Libro a insertar>>>" + libro);
		try {
			// abrir la conexion
			con = ConexionBDD.conectar();

			PreparedStatement ps;

			ps = con.prepareStatement(
					"insert into libros(titulo, autor_id, genero_id, anio_publicacion, estado_disponible)"
							+ "values(?, ?, ?, ?, ?)");

			ps.setString(1, libro.getTitulo());
			ps.setInt(2, libro.getAutor_id());
			ps.setInt(3, libro.getGenero_id());
			ps.setInt(4, libro.getAnio_publicacion());
			ps.setBoolean(5, libro.isEstado_disponible());

			ps.executeUpdate();
			LOGGER.trace("Libro agregado");
		} catch (Exception e) {
			LOGGER.error("Error al insertar", e);
			throw new Exception("Error al insertar");
		} finally {
			// cerrar la conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
			}
		}
	}
}
