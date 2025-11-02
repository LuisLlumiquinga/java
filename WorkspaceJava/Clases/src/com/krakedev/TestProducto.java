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
		
		productoA.setNombre("Paracetamol");
		productoA.setDescripcion("Medicina");
		productoA.setPrecio(1.50);
		productoA.setStockActual(100);
		
		productoB.setNombre("Ibuprofeno");
		productoB.setDescripcion("Medicina");
		productoB.setPrecio(2.50);
		productoB.setStockActual(50);
		
		productoC.setNombre("Aspirina");
		productoC.setDescripcion("Medicina");
		productoC.setPrecio(3.2);
		productoC.setStockActual(500);
				
		System.out.println("PRODUCTO A");
		System.out.println("Nombre: "+productoA.getNombre());
		System.out.println("Descripcion: "+productoA.getDescripcion());
		System.out.println("Precio: "+productoA.getPrecio());
		System.out.println("Stock: "+productoA.getStockActual());
		
		System.out.println("\nPRODUCTO B");
		System.out.println("Nombre: "+productoB.getNombre());
		System.out.println("Descripcion: "+productoB.getDescripcion());
		System.out.println("Precio: "+productoB.getPrecio());
		System.out.println("Stock: "+productoB.getStockActual());
		
		System.out.println("\nPRODUCTO C");
		System.out.println("Nombre: "+productoC.getNombre());
		System.out.println("Descripcion: "+productoC.getDescripcion());
		System.out.println("Precio: "+productoC.getPrecio());
		System.out.println("Stock: "+productoC.getStockActual());

	}

}
