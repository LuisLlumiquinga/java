package com.krakede.estaticos.ejercicio.utils;

public class Util {
	public static String formatearHora(int hora) {
		String valor;
		if (hora > 9) {
			 valor= hora + "";			
		}else {
			valor="0"+hora;
		}
		return valor;
	}

	public static String formatearMinuto(int minuto) {
		String valor;
		if (minuto > 9) {
			 valor= minuto + "";			
		}else {
			valor="0"+minuto;
		}
		return valor;
	}


	public static String formatearDia(int dia) {
		if (dia == 0) {
			return "Lunes";
		} else if (dia == 1) {
			return "Martes";
		} else if (dia == 2) {
			return "Miercoles";
		} else if (dia == 3) {
			return "Jueves";
		} else if (dia == 4) {
			return "Viernes";
		} else if (dia == 5) {
			return "Sabado";
		} else if (dia == 6) {
			return "Domingo";
		} else {
			return "Numero fuera de rango";
		}
	}

}
