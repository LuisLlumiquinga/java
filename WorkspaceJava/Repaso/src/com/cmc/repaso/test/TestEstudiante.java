package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Estudiante;

public class TestEstudiante {

	public static void main(String[] args) {
		Estudiante calificacion1 = new Estudiante("Pepe");
		
		calificacion1.calificar(8);
		System.out.println("Datos estudiante");
		System.out.println("Nombre: "+calificacion1.getNombre());
		System.out.println("Nota: "+calificacion1.getNota());
		System.out.println("Resultado: "+calificacion1.getResultado());
		
		calificacion1.calificar(7);
		System.out.println("\nDatos estudiante");
		System.out.println("Nombre: "+calificacion1.getNombre());
		System.out.println("Nota: "+calificacion1.getNota());
		System.out.println("Resultado: "+calificacion1.getResultado());
	}
}
