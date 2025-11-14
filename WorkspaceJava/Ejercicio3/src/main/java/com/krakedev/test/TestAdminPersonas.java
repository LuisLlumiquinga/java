package com.krakedev.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.entidades.EstadoCivil;
import com.krakedev.entidades.Personas;
import com.krakedev.servicios.AdminPersonas;
import com.krakedev.utils.Convertidor;

// System.out.println solo se va a poder usar en los test

public class TestAdminPersonas {

	public static void main(String[] args) {
		EstadoCivil ec = new EstadoCivil("U", "Union Libre");
		Personas p = new Personas("1111111111", "Joselyne", "Morales", ec);
		try {
			Date fechaNacimiento = Convertidor.convertirFecha("2020/12/23");
			Date horaNacimiento = Convertidor.convertirHora("15:23");
			p.setFechaNacimiento(fechaNacimiento);
			p.setHoraNacimiento(horaNacimiento);
			p.setCantidadAhorrada(new BigDecimal(1230.45));
			p.setNumeroHijos(3);
			AdminPersonas.insertar(p);
		} catch (Exception e) {
			System.out.println("Error en el sistema: "+e.getMessage());
		}
	}
}
