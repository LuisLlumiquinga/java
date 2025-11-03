package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono4 {

	public static void main(String[] args) {
		Telefono fono1 = new Telefono("movi", "0981245785", 10);
		Telefono fono2 = new Telefono("claro", "0784578521", 15);
		Telefono fono3 = new Telefono("claro", "0245879654", 12);
		Telefono fono4 = new Telefono("claro", "0245879654", 12);

		AdminTelefono telf1 = new AdminTelefono();

		int total = telf1.contarClaro(fono1, fono2, fono3, fono4);

		System.out.println("Total operadora claro: " + total);
	}

}
