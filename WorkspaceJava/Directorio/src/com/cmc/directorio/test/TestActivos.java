package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestActivos {

	public static void main(String[] args) {
		Telefono fono1 = new Telefono("claro", "0982393311", 10);
		Contacto contacto1 = new Contacto("Daniela", "Morales", fono1, 58.5);

		System.out.println("Datos Originales");
		System.out.println("Nombre: " + contacto1.getNombre());
		System.out.println("Apellido: " + contacto1.getApellido());
		System.out.println("Operadora: " + contacto1.getTelefono().getOperadora());
		System.out.println("Numero: " + contacto1.getTelefono().getNumero());
		System.out.println("Codigo: " + contacto1.getTelefono().getCodigo());
		System.out.println("Activo: " + contacto1.isActivo());
		if (contacto1.getTelefono().isTieneWhatsapp() == true) {
			System.out.println("Si tiene whatsapp");
		} else {
			System.out.println("No tiene whatsapp");
		}
		
		AdminContactos ac1 = new AdminContactos();
		
		ac1.activarUsuario(contacto1);
		
		System.out.println("\nDatos modificados");
		System.out.println("Nombre: " + contacto1.getNombre());
		System.out.println("Apellido: " + contacto1.getApellido());
		System.out.println("Operadora: " + contacto1.getTelefono().getOperadora());
		System.out.println("Numero: " + contacto1.getTelefono().getNumero());
		System.out.println("Codigo: " + contacto1.getTelefono().getCodigo());
		System.out.println("Activo: " + contacto1.isActivo());
		if (contacto1.getTelefono().isTieneWhatsapp() == true) {
			System.out.println("Si tiene whatsapp");
		} else {
			System.out.println("No tiene whatsapp");
		}
	}

}
