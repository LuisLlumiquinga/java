package com.krakedev.test;

import java.math.BigDecimal;

import com.krakedev.entidades.Productos;
import com.krakedev.servicios.AdminProductos;

// System.out.println solo se va a poder usar en los test

public class TestAdminProductos {

	public static void main(String[] args) {
		Productos p =new Productos(2,"Shampoo","Savital",new BigDecimal(2.50),20);
		try {
			
			AdminProductos.insertar(p);
		} catch (Exception e) {
			System.out.println("Error en el sistema: "+e.getMessage());
		}
	}
}
