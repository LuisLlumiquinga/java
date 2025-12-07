package com.krakedev.evaluacion.test;

import java.util.ArrayList;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestRecuperarCategorias {

	public static void main(String[] args) {
		try {
			ArrayList<Categoria> categoria=ServiciosCategoria.recuperarTodos();
			System.out.println(categoria);
		} catch (KrakeException e) {
			System.out.println("Error: "+e.getMessage());
		}
		

	}

}
