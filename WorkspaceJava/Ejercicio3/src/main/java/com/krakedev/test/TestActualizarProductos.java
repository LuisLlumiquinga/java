package com.krakedev.test;

import java.math.BigDecimal;

import com.krakedev.entidades.Productos;
import com.krakedev.servicios.AdminProductos;

public class TestActualizarProductos {

	public static void main(String[] args) {
		Productos p =new Productos(2,"Shampoo","Savital nuevo poder",new BigDecimal(5.50),200);
		try {
			
			AdminProductos.actualizar(p);
		} catch (Exception e) {
			System.out.println("Error en el sistema: "+e.getMessage());
		}

	}

}
