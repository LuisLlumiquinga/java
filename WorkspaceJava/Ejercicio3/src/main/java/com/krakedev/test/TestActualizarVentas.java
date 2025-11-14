package com.krakedev.test;

import java.util.Date;

import com.krakedev.entidades.Ventas;
import com.krakedev.servicios.AdminVentas;
import com.krakedev.utils.Convertidor;

public class TestActualizarVentas {

	public static void main(String[] args) {
		try {
			Date fechaVenta = Convertidor.convertirFecha("2025/12/22");
			Ventas v=new  Ventas(5,5,fechaVenta,100);
			AdminVentas.actualizar(v);
			
		} catch (Exception e) {
			System.out.println("Error en el sistema: "+e.getMessage());
		}

	}

}
