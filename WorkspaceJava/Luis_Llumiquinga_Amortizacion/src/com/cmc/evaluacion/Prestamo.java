package com.cmc.evaluacion;

import com.cmc.entidades.Cuota;

public class Prestamo {
	private double monto;
	private double interes;
	private int plazo;
	private Cuota[] cuota;
	private String cedula;

	public Prestamo(String cedula, double monto, double interes, int plazo) {
		this.cedula = cedula;
		this.monto = monto;
		this.interes = interes;
		this.plazo = plazo;
		this.cuota = new Cuota[plazo];
	}
	
	public Prestamo(double monto, double interes, int plazo) {
		this.monto = monto;
		this.interes = interes;
		this.plazo = plazo;
		this.cuota = new Cuota[plazo];
	}

	public Cuota[] getCuota() {
		return cuota;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public void mostrarPrestamo() {
	    System.out.println("[monto=" + monto + ", interes=" + interes + ", plazo=" + plazo + "]");
	}
	

}
