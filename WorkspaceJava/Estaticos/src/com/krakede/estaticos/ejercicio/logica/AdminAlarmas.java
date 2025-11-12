package com.krakede.estaticos.ejercicio.logica;

import java.util.ArrayList;

import com.krakede.estaticos.ejercicio.entidades.Alarma;

public class AdminAlarmas {
	private ArrayList<Alarma> alarmas = new ArrayList<Alarma>();

	public void agregarAlarma(Alarma alarma) {
		alarmas.add(alarma);
	}

	public ArrayList<Alarma> getAlarmas() {
		return alarmas;
	}

}
