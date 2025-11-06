package com.clearminds.test;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarMenores {

	public static void main(String[] args) {
		MaquinaDulces maquina = new MaquinaDulces();
		maquina.agregarCelda(new Celda("A1"));
		maquina.agregarCelda(new Celda("A2"));
		maquina.agregarCelda(new Celda("B1"));
		maquina.agregarCelda(new Celda("B2"));
		maquina.agregarCelda(new Celda("C1"));
		maquina.agregarCelda(new Celda("C2"));

		Producto producto1 = new Producto("D456", "Doritos", 0.70);
		maquina.cargarProducto(producto1, "A1", 6);

		Producto producto2 = new Producto("D789", "De todito", 1.70);
		maquina.cargarProducto(producto2, "A2", 6);

		Producto producto3 = new Producto("KE34", "Papitas", 0.85);
		maquina.cargarProducto(producto3, "B1", 4);

		Producto producto4 = new Producto("D011", "Coca Cola", 1.30);
		maquina.cargarProducto(producto4, "B2", 6);

		Producto producto5 = new Producto("D154", "Cachitos", 0.55);
		maquina.cargarProducto(producto5, "C1", 6);

		Producto producto6 = new Producto("KE32", "Chupete", 1.2);
		maquina.cargarProducto(producto6, "C2", 6);

		ArrayList<Producto> menores = new ArrayList<Producto>();
		
		menores=maquina.buscarMenores(1);
		
		Producto elementoProducto;
		
		System.out.println("Productos Menores: "+menores.size());
		
		for (int i = 0; i < menores.size(); i++) {
			elementoProducto = menores.get(i);
			System.out.println("Nombre: "+elementoProducto.getNombre() + " Precio: " + elementoProducto.getPrecio());
		}
	}

}
