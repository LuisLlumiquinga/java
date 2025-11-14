package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestActualizar {

	public static void main(String[] args) {
		EstadoCivil ec = new EstadoCivil("U", "Union Libre");
		Persona p = new Persona("1717154210", "Julio", "Jaramillo", ec);
		try {
			p.setEstatura(150);
			Date fechaNacimiento = Convertidor.convertirFecha("2020/12/23");
			Date horaNacimiento = Convertidor.convertirHora("19:23");
			p.setFechaNacimiento(fechaNacimiento);
			p.setHoraNacimiento(horaNacimiento);
			p.setCantidadAhorrada(new BigDecimal(1230.45));
			p.setNumeroHijos(0);

			AdminPersonas.actualizar(p);

		} catch (Exception e) {
			System.out.println("Error en el sistema: " + e.getMessage());
		}

	}

}
