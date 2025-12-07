package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestActualizarCategoria {

	public static void main(String[] args) {
		Categoria cat=new Categoria("C004", "Utiles nuevos");
		
		try {
			ServiciosCategoria.actualizar(cat);
			System.out.println("Categoria modificada");
		} catch (KrakeException e) {
			System.out.println("Error: "+e.getMessage());
		}

	}

}
