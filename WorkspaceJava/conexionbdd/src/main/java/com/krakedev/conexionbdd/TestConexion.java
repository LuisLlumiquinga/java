package com.krakedev.conexionbdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestConexion {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "4189");
			System.out.println("Conexion Exitosa");

			ps = connection.prepareStatement(
					"insert into personas(cedula, nombre, apellido, estado_civil_codigo, numero_hijos, estatura, cantidad_ahorrada, fecha_nacimiento, hora_nacimiento)"
							+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, "1800893101");
			ps.setString(2, "Rosalia");
			ps.setString(3, "Romero");
			ps.setString(4, "U");
			ps.setInt(5, 2);
			ps.setDouble(6, 1.56);
			ps.setBigDecimal(7, new BigDecimal(1200.45));

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String fechasStr = "2020/03/22 10:05:04";

			try {
				Date fecha = sdf.parse(fechasStr);
				System.out.println(fecha);
				long fechaMilis = fecha.getTime();
				System.out.println(fechaMilis);
				// crea un java.sqlDate, partiendo de un java.util.Date
				java.sql.Date fechaSQL = new java.sql.Date(fechaMilis);
				System.out.println(fechaSQL);

				Time timeSql = new Time(fechaMilis);
				System.out.println(timeSql);

				ps.setDate(8, fechaSQL);
				ps.setTime(9, timeSql);

				ps.executeUpdate();
				System.out.println("ejecuta insert");
			} catch (ParseException e) {
				e.printStackTrace();
			}

			ps = connection.prepareStatement(
					"insert into productos(codigo,nombre,descripcion,precio,stock)" + "values(?, ?, ?, ?, ?)");

			ps.setInt(1, 2);
			ps.setString(2, "Shampoo");
			ps.setString(3, "Savital");
			ps.setBigDecimal(4, new BigDecimal(2.5));
			ps.setInt(5, 20);

			ps.executeUpdate();
			System.out.println("ejecuta insert");

			ps = connection.prepareStatement(
					"insert into ventas(id_ventas,codigo_producto, fecha_venta, cantidad)" + "values(?, ?, ?, ?)");

			ps.setInt(1, 4);
			ps.setInt(2, 2);

			ps.setInt(4, 10);

			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String fechasStr1 = "2025/11/11 13:11:04";

			try {
				Date fecha = sdf1.parse(fechasStr1);
				System.out.println(fecha);
				long fechaMilis = fecha.getTime();
				System.out.println(fechaMilis);
				// crea un java.sqlDate, partiendo de un java.util.Date
				java.sql.Date fechaSQL = new java.sql.Date(fechaMilis);
				System.out.println(fechaSQL);

				Time timeSql = new Time(fechaMilis);
				System.out.println(timeSql);

				ps.setDate(3, fechaSQL);

				ps.executeUpdate();
				System.out.println("ejecuta insert");
			} catch (ParseException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
