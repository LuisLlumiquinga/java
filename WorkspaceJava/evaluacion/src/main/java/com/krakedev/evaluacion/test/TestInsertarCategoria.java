package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestInsertarCategoria {

	public static void main(String[] args) {
		Categoria cat = new Categoria("C004", "Utiles");

		try {
			ServiciosCategoria.insertar(cat);
			System.out.println("Categoría insertada exitosamente");
		} catch (KrakeException e) {
			System.out.println(e.getMessage());
		}

	}

}
