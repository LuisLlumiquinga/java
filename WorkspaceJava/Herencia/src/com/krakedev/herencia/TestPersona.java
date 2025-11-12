package com.krakedev.herencia;

public class TestPersona {

	public static void main(String[] args) {
		Persona p = new Persona("1714616123", "Julian");

		System.out.println("hola ");
		System.out.println(p.toString()); // toString() esta demas se ejecuta automaticamente
		System.out.println(p); // p.toString se ejecuta implicitamente

		Persona q = new Persona("1715893101", "Joselyne");
		System.out.println(q);
	}

}
