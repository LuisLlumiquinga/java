package com.krakedev.test;

import java.util.Date;

import com.krakedev.entidades.Ventas;
import com.krakedev.servicios.AdminVentas;
import com.krakedev.utils.Convertidor;

public class TestAdminVentas {

	public static void main(String[] args) {
		
		try {
			Date fechaVenta = Convertidor.convertirFecha("2025/11/11");
			Ventas v=new Ventas(4,2,fechaVenta,1);
			AdminVentas.insertar(v);

		} catch (Exception e) {
			System.out.println("Error en el sistema: " + e.getMessage());
		}
		
	}

}
