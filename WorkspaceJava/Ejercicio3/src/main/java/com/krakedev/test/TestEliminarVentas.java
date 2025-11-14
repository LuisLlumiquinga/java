package com.krakedev.test;

import com.krakedev.servicios.AdminVentas;

public class TestEliminarVentas {

	public static void main(String[] args) {
		try {
			AdminVentas.eliminar(4);
		} catch (Exception e) {
			System.out.println("Error en el sistema: " + e.getMessage());
		}

	}

}
