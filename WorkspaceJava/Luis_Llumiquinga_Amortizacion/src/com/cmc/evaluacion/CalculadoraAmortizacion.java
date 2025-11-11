package com.cmc.evaluacion;

import com.cmc.entidades.Cuota;

public class CalculadoraAmortizacion {

	public static double calcularCuota(Prestamo prestamo) {
		double cuota = 0;
		double i = (prestamo.getInteres() / 12) / 100;

		cuota = (prestamo.getMonto() * i) / (1 - Math.pow((1 + i), -prestamo.getPlazo()));

		return cuota;
	}

	public static void generarTabla(Prestamo prestamo) {
		double valorCuota = calcularCuota(prestamo);

		Cuota[] cuota = prestamo.getCuota();

		for (int i = 0; i < cuota.length; i++) {
			cuota[i] = new Cuota(i + 1);
			cuota[i].setCuota(valorCuota);
		}

		cuota[0].setInicio(prestamo.getMonto());

		for (int i = 0; i < cuota.length; i++) {
			if (i < cuota.length - 1) {
				calcularValoresCuota(prestamo.getInteres(), cuota[i], cuota[i + 1]);
			} else {
				calcularValoresCuota(prestamo.getInteres(), cuota[i], null);
			}
		}
	}

	public static void calcularValoresCuota(double interes, Cuota cuotaActual, Cuota cuotaSiguiente) {
		double tasaMensual = interes / 12 / 100;
		double valorInteres = cuotaActual.getInicio() * tasaMensual;
		cuotaActual.setInteres(valorInteres);

		// Calcular el abono al capital
		double abonoCapital = cuotaActual.getCuota() - valorInteres;
		cuotaActual.setAbonoCapital(abonoCapital);

		// Calcular el saldo
		double saldo = cuotaActual.getInicio() - abonoCapital;

		// Paso 6: Ajustar última cuota si es necesario
		if (cuotaSiguiente == null) {
			// Es la última cuota, ajustar para que saldo sea 0
			abonoCapital = cuotaActual.getInicio(); // Todo el saldo restante
			cuotaActual.setAbonoCapital(abonoCapital);
			cuotaActual.setCuota(valorInteres + abonoCapital); // Ajustar cuota
			saldo = 0;
		}

		cuotaActual.setSaldo(saldo);

		// Establecer el saldo como inicio de la siguiente cuota
		if (cuotaSiguiente != null) {
			cuotaSiguiente.setInicio(saldo);
		}
	}

	public static void mostrarTabla(Prestamo prestamo) {
		System.out.println("TABLA DE AMORTIZACIÓN");
		System.out.println("=====================================================");
		System.out.println("Núm | Cuota   | Inicio   | Interés | Abono Cap | Saldo");
		System.out.println("-----|---------|----------|---------|-----------|----------");

		Cuota[] cuotas = prestamo.getCuota();

		for (int i = 0; i < cuotas.length; i++) {
			Cuota cuota = cuotas[i];
			cuota.mostrarPrestamo();
		}

		System.out.println("=====================================================");
	}
}
