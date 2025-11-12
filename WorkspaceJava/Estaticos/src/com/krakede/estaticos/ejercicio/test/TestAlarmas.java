package com.krakede.estaticos.ejercicio.test;

import java.util.ArrayList;

import com.krakede.estaticos.ejercicio.entidades.Alarma;
import com.krakede.estaticos.ejercicio.logica.AdminAlarmas;
import com.krakede.estaticos.ejercicio.utils.DiasSemana;

public class TestAlarmas {

	public static void main(String[] args) {
		Alarma alarma1 = new Alarma(DiasSemana.LUNES, 15, 12);
		Alarma alarma2 = new Alarma(DiasSemana.MARTES, 11, 10);
		Alarma alarma3 = new Alarma(DiasSemana.MIERCOLES, 5, 20);
		Alarma alarma4 = new Alarma(DiasSemana.JUEVES, 7, 8);

		AdminAlarmas a1 = new AdminAlarmas();

		a1.agregarAlarma(alarma1);
		a1.agregarAlarma(alarma2);
		a1.agregarAlarma(alarma3);
		a1.agregarAlarma(alarma4);

		ArrayList<Alarma> alarmasActuales=a1.getAlarmas();
		
		System.out.println(alarmasActuales);
	}

}
