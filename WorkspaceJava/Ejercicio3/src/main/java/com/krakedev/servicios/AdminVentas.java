package com.krakedev.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Ventas;
import com.krakedev.utils.ConexionBDD;

public class AdminVentas {
	private static final Logger LOGGER = LogManager.getLogger(AdminVentas.class);

	public static void insertar(Ventas venta) throws Exception {
		Connection con = null;
		LOGGER.trace("Ventas a a insertar>>>" + venta);
		try {
			// abrir la conexion
			con = ConexionBDD.conectar();

			PreparedStatement ps;

			ps = con.prepareStatement(
					"insert into ventas(id_ventas,codigo_producto, fecha_venta, cantidad) "
							+ "values(?, ?, ?, ?)");

			ps.setInt(1, venta.getId_ventas());
			ps.setInt(2, venta.getCodigoProducto());
			ps.setDate(3, new java.sql.Date(venta.getFechaVenta().getTime()));
			ps.setInt(4, venta.getCantidad());
					
			ps.executeUpdate();
			
			LOGGER.trace("Venta agregada");
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

	public static void actualizar(Ventas venta) throws Exception {
		Connection con = null;
		LOGGER.trace("Venta a buscar>>>" + venta);
		try {
			// abrir la conexion
			con = ConexionBDD.conectar();

			PreparedStatement ps;

			ps = con.prepareStatement(
					"update ventas set "
					+ "codigo_producto=?,"
					+ "fecha_venta=?,"
					+ "cantidad=?"
					+ " where id_ventas=?");

			ps.setInt(1, venta.getCodigoProducto());
			ps.setDate(2, new java.sql.Date(venta.getFechaVenta().getTime()));
			ps.setInt(3, venta.getCantidad());
			ps.setInt(4, venta.getId_ventas());
			
			ps.executeUpdate();

			LOGGER.trace("Venta actualizada");
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
	
	public static void eliminar(int idVenta) throws Exception {
		Connection con = null;
		LOGGER.trace("Venta a eliminar con el codigo >>>" + idVenta);
		try {
			// abrir la conexion
			con = ConexionBDD.conectar();

			PreparedStatement ps;

			ps = con.prepareStatement("delete from ventas where id_ventas= ?");					
			ps.setInt(1, idVenta);
			
			ps.executeUpdate();

			LOGGER.trace("Venta eliminada");
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
