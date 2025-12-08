package com.krakedev.moduloii.evaluacion2.test;

import com.krakedev.moduloii.evaluacion2.utils.ConexionBDD;

public class TestConexionBDD {

	public static void main(String[] args) {
		try {
			ConexionBDD.conectar();
			System.out.println("Conexion establecida a la base de datos");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
