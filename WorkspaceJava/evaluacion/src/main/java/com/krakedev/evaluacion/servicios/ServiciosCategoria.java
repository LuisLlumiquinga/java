package com.krakedev.evaluacion.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.ConexionBDD;

public class ServiciosCategoria {
	private static final Logger LOGGER = LogManager.getLogger(ServiciosCategoria.class);

	public static void insertar(Categoria categoria) throws KrakeException {
		Connection con = null;
		LOGGER.trace("Categoria a insertar>>>" + categoria);
		try {
			// abrir la conexion
			con = ConexionBDD.conectar();

			PreparedStatement ps;

			ps = con.prepareStatement("insert into categorias(id, nombre)" + "values(?, ?)");

			ps.setString(1, categoria.getId());
			ps.setString(2, categoria.getNombre());

			ps.executeUpdate();

			LOGGER.trace("Categoria agregada");
		} catch (KrakeException e) {
			LOGGER.error("Error al insertar", e);
			throw e;
		} catch (Exception e) {
			LOGGER.error("Error al insertar", e);
			throw new KrakeException("Error al insertar");
		} finally {
			// cerrar la conexion
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					LOGGER.error("Error al cerrar la conexión", e);
					throw new KrakeException("Error con la base de datos");
				}
			}
		}
	}

	public static void actualizar(Categoria categoria) throws KrakeException {
		Connection con = null;
		LOGGER.trace("Categoria a actualizar>>>" + categoria);
		try {
			// abrir la conexion
			con = ConexionBDD.conectar();

			PreparedStatement ps;

			ps = con.prepareStatement("update categorias set nombre=? where id=? ");

			ps.setString(1, categoria.getNombre());
			ps.setString(2, categoria.getId());

			ps.executeUpdate();

			LOGGER.trace("Categoria modificada");
		} catch (KrakeException e) {
			LOGGER.error("Error al modificar", e);
			throw e;
		} catch (Exception e) {
			LOGGER.error("Error al modificar", e);
			throw new KrakeException("Error al modificar");
		} finally {
			// cerrar la conexion
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					LOGGER.error("Error al cerrar la conexión", e);
					throw new KrakeException("Error con la base de datos");
				}
			}
		}
	}

	public static Categoria buscarPorId(String id) throws KrakeException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Categoria cat = null;

		LOGGER.trace("Buscando categoria con id: " + id);

		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("select * from categorias where id=?");

			ps.setString(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {
				String codigo = rs.getString("id");
				String nombre = rs.getString("nombre");

				cat = new Categoria(codigo, nombre);
				LOGGER.trace("Categoria encontrada: " + cat);
			} else {
				LOGGER.trace("No se encontró categoria con id: " + id);
			}
		} catch (KrakeException e) {
			LOGGER.error("Error al conectarse con la BDD, categoria", e);
			throw e;
		} catch (Exception e) {
			LOGGER.error("Error al buscar categoria", e);
			throw new KrakeException("Error al buscar categoria");
		} finally {
			// cerrar la conexion
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					LOGGER.error("Error al cerrar la conexión", e);
					throw new KrakeException("Error con la base de datos");
				}
			}
		}

		return cat;
	}
	
	public static ArrayList<Categoria> recuperarTodos() throws KrakeException{
		ArrayList<Categoria> categoria=new ArrayList<Categoria>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con = ConexionBDD.conectar();
			ps=con.prepareStatement("select * from categorias");
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String codigo=rs.getString("id");
				String nombre=rs.getString("nombre");				
				
				Categoria cat=new Categoria();
				cat.setId(codigo);
				cat.setNombre(nombre);
				categoria.add(cat);
			}
			
		} catch (KrakeException e) {
			LOGGER.error("Error al conectarse con la BDD, categoria", e);
			throw e;
		} catch (Exception e) {
			LOGGER.error("Error al buscar categoria", e);
			throw new KrakeException("Error al buscar categoria");
		} finally {
			// cerrar la conexion
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					LOGGER.error("Error al cerrar la conexión", e);
					throw new KrakeException("Error con la base de datos");
				}
			}
		}

		return categoria;
	}
}
