package com.krakede.estaticos;

public class Calculos {
	private final double IVA=12;	//final declara CONSTANTES, y se escribe todo en MAYUSCULAS
	
	public double calcularIva(double monto) {
		return monto*IVA/100;
	}
	
	
}
