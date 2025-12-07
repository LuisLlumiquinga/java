package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.ConexionBDD;

public class TestConexionBDD {

	public static void main(String[] args) {
		try {
			ConexionBDD.conectar();
		} catch (KrakeException e) {
			System.out.println(e.getMessage());
		}

	}

}
