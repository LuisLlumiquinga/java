package com.krakedev.test;

import com.krakedev.servicios.AdminProductos;

public class TestEliminarProductos {

	public static void main(String[] args) {
		try {
			AdminProductos.eliminar(2);
		} catch (Exception e) {
			System.out.println("Error en el sistema: " + e.getMessage());
		}

	}

}
