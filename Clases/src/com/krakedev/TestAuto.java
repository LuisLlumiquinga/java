package com.krakedev;

public class TestAuto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Auto auto1 = new Auto();
		Auto auto2 = new Auto();
		
		auto1.marca = "KIA";
		auto1.anio = 2025;
		auto1.precio = 16000;
		
		auto2.marca = "Toyota";
		auto2.anio = 1989;
		auto2.precio = 17000;
		
		System.out.println("Caracteristicas Auto 1");
		System.out.println("Marca: "+auto1.marca);
		System.out.println("Anio: "+auto1.anio);
		System.out.println("Precio: "+auto1.precio);
		
		System.out.println("--------------------------");
		System.out.println("Caracteristicas Auto 2");
		System.out.println("Marca: "+auto2.marca);
		System.out.println("Anio: "+auto2.anio);
		System.out.println("Precio: "+auto2.precio);
	}

}
