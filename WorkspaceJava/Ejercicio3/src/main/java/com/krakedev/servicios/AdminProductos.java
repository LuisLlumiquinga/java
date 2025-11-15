package com.krakedev.servicios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.entidades.Productos;
import com.krakedev.utils.ConexionBDD;

public class AdminProductos {
	private static final Logger LOGGER = LogManager.getLogger(AdminProductos.class);

	public static void insertar(Productos producto) throws Exception {
		Connection con = null;
		LOGGER.trace("Persona a insertar>>>" + producto);
		try {
			// abrir la conexion
			con = ConexionBDD.conectar();

			PreparedStatement ps;

			ps = con.prepareStatement(
					"insert into productos(codigo,nombre,descripcion,precio,stock) "
							+ "values(?, ?, ?, ?, ?)");

			ps.setInt(1, producto.getCodigo());
			ps.setString(2, producto.getNombre());
			ps.setString(3, producto.getDescripcion());
			ps.setBigDecimal(4, producto.getPrecio());
			ps.setInt(5, producto.getStock());
			
			ps.executeUpdate();
			LOGGER.trace("Producto agregado");
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

	public static void actualizar(Productos producto) throws Exception {
		Connection con = null;
		LOGGER.trace("Producto a buscar>>>" + producto);
		try {
			// abrir la conexion
			con = ConexionBDD.conectar();

			PreparedStatement ps;

			ps = con.prepareStatement(
					"update productos set "
					+ "nombre=?,"
					+ "descripcion=?,"
					+ "precio=?,"
					+ "stock=? "
					+ " where codigo=?");

			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getDescripcion());
			ps.setBigDecimal(3, producto.getPrecio());
			ps.setInt(4,producto.getStock());
			ps.setInt(5, producto.getCodigo());
			
			ps.executeUpdate();

			LOGGER.trace("Producto actualizado");
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
	
	public static void eliminar(int codigo) throws Exception {
		Connection con = null;
		LOGGER.trace("Persona a eliminar con cedula >>>" + codigo);
		try {
			// abrir la conexion
			con = ConexionBDD.conectar();

			PreparedStatement ps;

			ps = con.prepareStatement("delete from productos where codigo= ?");					
			ps.setInt(1, codigo);
			
			ps.executeUpdate();

			LOGGER.trace("Producto eliminada");
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
	
	public static ArrayList<Productos> buscarPorNombre(String nombreBusqueda) throws Exception{
		ArrayList<Productos> productos=new ArrayList<Productos>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con = ConexionBDD.conectar();
			ps=con.prepareStatement("select * from productos where nombre like ?");
			
			ps.setString(1, "%"+nombreBusqueda+"%");
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				int codigo=rs.getInt("codigo");
				String nombre=rs.getString("nombre");
				String descripcion=rs.getString("descripcion");
				String precioStr=rs.getString("precio");
				precioStr=precioStr.replaceAll("[^0-9.]", "");
				BigDecimal precio= new BigDecimal(precioStr).divide(new BigDecimal("100")).setScale(2, RoundingMode.HALF_UP);
				int stock=rs.getInt("stock");
				
				Productos p=new Productos();
				p.setCodigo(codigo);
				p.setNombre(nombre);
				p.setDescripcion(descripcion);
				p.setPrecio(precio);
				p.setStock(stock);
				productos.add(p);
			}
			
		} catch (Exception e) {
			LOGGER.error("Error al consultar por nombre", e);
			throw new Exception("Error al consultar por nombre");
		} finally {
			// cerrar la conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
			}
		}
		
		return productos;
	}
	
	public static Productos buscarPorClavePrimaria(int codigo) throws Exception{
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Productos p=new Productos();
		
		try {
			con = ConexionBDD.conectar();
			ps=con.prepareStatement("select * from productos where codigo = ?");
			
			ps.setInt(1, codigo);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				p.setCodigo(rs.getInt("codigo"));
				p.setNombre(rs.getString("nombre"));
				p.setDescripcion(rs.getString("descripcion"));
				String precioStr = rs.getString("precio");
				precioStr = precioStr.replaceAll("[^0-9.]", "");
				BigDecimal precioBD = new BigDecimal(precioStr).movePointLeft(2);
				p.setPrecio(precioBD);
				p.setStock(rs.getInt("stock"));	
			}
			
		} catch (Exception e) {
			LOGGER.error("Error al consultar por nombre", e);
			throw new Exception("Error al consultar por nombre");
		} finally {
			// cerrar la conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
			}
		}
		
		return p;
	}
}
