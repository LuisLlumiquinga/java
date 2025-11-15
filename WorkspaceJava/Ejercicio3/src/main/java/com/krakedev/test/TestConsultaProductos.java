package com.krakedev.test;

import java.util.ArrayList;

import com.krakedev.entidades.Productos;
import com.krakedev.servicios.AdminProductos;

public class TestConsultaProductos {

	public static void main(String[] args) {
		try {
			ArrayList<Productos> productos=AdminProductos.buscarPorNombre("n");
			System.out.println(productos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
