package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Item;

public class TestItem {

	public static void main(String[] args) {
		Item item1 = new Item();
		
		item1.setProductosActuales(20);
		item1.setNombre("Mochila");
		item1.imprimir();
		
		System.out.println("Valores modificados producto 1");
		
		item1.vender(10);
		item1.imprimir();
		item1.devolver(4);
		item1.imprimir();
		
		Item item2 = new Item();
		
		item2.setProductosActuales(5);
		item2.setNombre("Mouse");
		item2.imprimir();
		
		System.out.println("Valores modificados producto 2");
		
		item2.vender(5);
		item2.imprimir();
		item2.devolver(2);
		item2.imprimir();
	}

}
