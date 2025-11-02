package com.krakedev;

public class TestAuto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Auto auto1 = new Auto("KIA");
		Auto auto2 = new Auto("Toyota");
		
		//auto1.setMarca("KIA");
		auto1.setAnio(2025);
		auto1.setPrecio(16000);
		
		//auto2.setMarca("Toyota");
		auto2.setAnio(1989);
		auto2.setPrecio(15000);
		
		System.out.println("Caracteristicas Auto 1");
		System.out.println("Marca: "+auto1.getMarca());
		System.out.println("Anio: "+auto1.getAnio());
		System.out.println("Precio: "+auto1.getPrecio());
		
		System.out.println("--------------------------");
		System.out.println("Caracteristicas Auto 2");
		System.out.println("Marca: "+auto2.getMarca());
		System.out.println("Anio: "+auto2.getAnio());
		System.out.println("Precio: "+auto2.getPrecio());
	}

}
