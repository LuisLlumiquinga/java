package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestBuscarCategoria {

	public static void main(String[] args) {
		try {
			Categoria cat = ServiciosCategoria.buscarPorId("C004");
			if(cat!=null) {
			System.out.println(cat);
			}else {
				System.out.println("No existe la categoria buscada");
			}
		} catch (KrakeException e) {
			System.out.println("Error: "+e.getMessage());
		}

	}

}
