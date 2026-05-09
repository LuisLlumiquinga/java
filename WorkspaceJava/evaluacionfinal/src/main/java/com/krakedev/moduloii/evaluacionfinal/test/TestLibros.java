package com.krakedev.moduloii.evaluacionfinal.test;

import java.util.ArrayList;

import com.krakedev.moduloii.evaluacionfinal.entidades.Libro;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServiciosBiblioteca;

public class TestLibros {

	public static void main(String[] args) {
		try {
			ArrayList<Libro> lib=ServiciosBiblioteca.mostrarLibrosMayores(7);
			System.out.println(lib);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
