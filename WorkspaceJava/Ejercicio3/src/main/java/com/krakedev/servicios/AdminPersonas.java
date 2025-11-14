package com.krakedev.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Personas;
import com.krakedev.utils.ConexionBDD;

public class AdminPersonas {
	private static final Logger LOGGER = LogManager.getLogger(AdminPersonas.class);

	public static void insertar(Personas persona) throws Exception {
		Connection con = null;
		LOGGER.trace("Persona a insertar>>>" + persona);
		try {
			// abrir la conexion
			con = ConexionBDD.conectar();

			PreparedStatement ps;

			ps = con.prepareStatement(
					"insert into personas(cedula, nombre, apellido, estado_civil_codigo, numero_hijos, estatura, cantidad_ahorrada, fecha_nacimiento, hora_nacimiento)"
							+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, persona.getCedula());
			ps.setString(2, persona.getNombre());
			ps.setString(3, persona.getApellido());
			ps.setString(4, persona.getEstadoCivil().getCodigo());
			ps.setInt(5, persona.getNumeroHijos());
			ps.setDouble(6, persona.getEstatura());
			ps.setBigDecimal(7, persona.getCantidadAhorrada());
			ps.setDate(8, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			ps.setTime(9, new Time(persona.getHoraNacimiento().getTime()));

			ps.executeUpdate();
			LOGGER.trace("Persona agregada");
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

	public static void actualizar(Personas persona) throws Exception {
		Connection con = null;
		LOGGER.trace("Persona a buscar>>>" + persona);
		try {
			// abrir la conexion
			con = ConexionBDD.conectar();

			PreparedStatement ps;

			ps = con.prepareStatement(
					"update personas set "
					+ "nombre=?,"
					+ "apellido=?,"
					+ "estatura=?,"
					+ "fecha_nacimiento=?,"
					+ "hora_nacimiento=?,"
					+ "cantidad_ahorrada=?,"
					+ "numero_hijos=?,"
					+ "estado_civil_codigo=? "
					+ "where cedula=?");

			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellido());
			ps.setDouble(3, persona.getEstatura());
			ps.setDate(4, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			ps.setTime(5, new Time(persona.getHoraNacimiento().getTime()));
			ps.setBigDecimal(6, persona.getCantidadAhorrada());
			ps.setInt(7, persona.getNumeroHijos());
			ps.setString(8, persona.getEstadoCivil().getCodigo());
			ps.setString(9, persona.getCedula());
			ps.executeUpdate();

			LOGGER.trace("Persona actualizada");
		} catch (Exception e) {
			LOGGER.error("Error al modificar", e);
			throw new Exception("Error al modificar");
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
	
	public static void eliminar(String cedula) throws Exception {
		Connection con = null;
		LOGGER.trace("Persona a eliminar con cedula >>>" + cedula);
		try {
			// abrir la conexion
			con = ConexionBDD.conectar();

			PreparedStatement ps;

			ps = con.prepareStatement("delete from personas where cedula= ?");					
			ps.setString(1, cedula);
			ps.executeUpdate();

			LOGGER.trace("Persona eliminada");
		} catch (Exception e) {
			LOGGER.error("Error al eliminar", e);
			throw new Exception("Error al eliminar");
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
