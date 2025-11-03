package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Producto;

public class TestProduto {

	public static void main(String[] args) {
		Producto producto1 = new Producto("Parlantes", 12.5);

		producto1.setPrecio(-10);
		
		System.out.println("Producto");
		System.out.println("Nombre: "+producto1.getNombre());
		System.out.println("Precio: "+producto1.getPrecio());
		System.out.println("Precio con descuento: "+producto1.calcularPrecioPromo(15));
	}

}
