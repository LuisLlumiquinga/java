package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContactos2 {

	public static void main(String[] args) {
		Telefono fono1 = new Telefono("claro", "0987412540", 10);
		Telefono fono2 = new Telefono("claro", "0945412540", 20);
		
		Contacto contacto1 = new Contacto("Daniela", "Morales", fono1, 68.2);
		Contacto contacto2 = new Contacto("Jenny", "Arreaga", fono2, 60);

		AdminContactos ac = new AdminContactos();
		
		Contacto masPesado;
		masPesado=ac.buscarMasPesado(contacto1, contacto2);
		
		System.out.println("Contacto mas pesado");
		System.out.println("Nombre: "+masPesado.getNombre());
		System.out.println("Apellido: "+masPesado.getApellido());
		System.out.println("Telefono: "+masPesado.getTelefono().getNumero());
		System.out.println("Peso: "+masPesado.getPeso());
		
		boolean compOperadoras=ac.compararOperadoras(contacto1, contacto2);
		
		if(compOperadoras==true) {
			System.out.println("\nSon operadoras iguales");
		}else {
			System.out.println("\nNo son operadoras iguales");
		}

	}

}
