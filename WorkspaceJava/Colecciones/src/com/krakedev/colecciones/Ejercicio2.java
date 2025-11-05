package com.krakedev.colecciones;

import java.util.ArrayList;

public class Ejercicio2 {

	public static void main(String[] args) {
		ArrayList<Persona> personas;
		
		personas=new ArrayList<Persona>();
		
		Persona p1=new Persona("xx", "yy");
		personas.add(p1);
		
		personas.add(new Persona("Leo", "Messi"));
		personas.add(new Persona("Cristiano", "Ronaldo"));
		personas.add(new Persona("Thiago", "Messi"));
		
		System.out.println(personas.size());
		
		Persona elementoPersona;
		
		for(int i=0; i<personas.size(); i++) {
			elementoPersona=personas.get(i);
			System.out.println(elementoPersona.getNombre()+"-"+elementoPersona.getApellido());
		}
		

	}

}
