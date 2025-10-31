package com.krakedev;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Producto productoA;
		Producto productoB;
		Producto productoC;
		
		productoA = new Producto();
		productoB = new Producto();
		productoC = new Producto();
		
		productoA.nombre = "Paracetamol";
		productoA.descripcion = "Medicina";
		productoA.precio = 1.50;
		productoA.stockActual = 100;
		
		productoB.nombre = "Ibuprofeno";
		productoB.descripcion = "Medicina";
		productoB.precio = 2.50;
		productoB.stockActual = 50;
		
		productoC.nombre = "Aspirina";
		productoC.descripcion = "Medicina";
		productoC.precio = 3.2;
		productoC.stockActual = 500;
				
		System.out.println("PRODUCTO A");
		System.out.println("Nombre: "+productoA.nombre);
		System.out.println("Descripcion: "+productoA.descripcion);
		System.out.println("Precio: "+productoA.descripcion);
		System.out.println("Stock: "+productoA.stockActual);
		
		System.out.println("\nPRODUCTO B");
		System.out.println("Nombre: "+productoB.nombre);
		System.out.println("Descripcion: "+productoB.descripcion);
		System.out.println("Precio: "+productoB.descripcion);
		System.out.println("Stock: "+productoB.stockActual);
		
		System.out.println("\nPRODUCTO C");
		System.out.println("Nombre: "+productoC.nombre);
		System.out.println("Descripcion: "+productoC.descripcion);
		System.out.println("Precio: "+productoC.descripcion);
		System.out.println("Stock: "+productoC.stockActual);

	}

}
