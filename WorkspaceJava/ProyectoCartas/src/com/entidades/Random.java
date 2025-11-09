package com.entidades;

public class Random {
	public static int obtenerPosicion() {
		// Math.random() devuelve un valor entre 0.0 (incluido) y 1.0 (excluido)
		// Multiplicamos por 52 para obtener valores entre 0.0 y 51.999...
		// (int) convierte a entero, truncando los decimales
		// Resultado: números entre 0 y 51 incluidos

		return (int) (Math.random() * 52);
	}

}
