package com.cmc.directorio.test;

import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContacto1 {

	public static void main(String[] args) {
		Telefono telef = new Telefono("movi", "0983393311", 10);
		Contacto c = new Contacto("Daniela", "Morales", telef, 60.5);

		System.out.println("Informacion del contacto");
		System.out.println("Nombre: "+c.getNombre());
		System.out.println("Apellido: "+c.getApellido());
		System.out.println("Peso: "+c.getPeso());
		System.out.println("Operadora: "+telef.getOperadora());
		System.out.println("Numero: "+telef.getNumero());
	}

}
