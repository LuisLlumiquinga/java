package com.krakedev.test;

import com.krakedev.entidades.Productos;
import com.krakedev.servicios.AdminProductos;

public class TestConsultaProductos2 {

	public static void main(String[] args) {
		try {
			Productos productos=AdminProductos.buscarPorClavePrimaria(5);
			System.out.println(productos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
