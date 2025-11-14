package com.krakedev.entidades;

import java.util.Date;

public class Ventas {
	private int id_ventas;
	private int codigoProducto;
	private Date fechaVenta;
	private int cantidad;

	public int getId_ventas() {
		return id_ventas;
	}

	public void setId_ventas(int id_ventas) {
		this.id_ventas = id_ventas;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Ventas(int id_ventas, int codigoProducto, Date fechaVenta, int cantidad) {
		super();
		this.id_ventas = id_ventas;
		this.codigoProducto = codigoProducto;
		this.fechaVenta = fechaVenta;
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Ventas [id_ventas=" + id_ventas + ", producto=" + codigoProducto + ", fechaVenta=" + fechaVenta
				+ ", cantidad=" + cantidad + "]";
	}
}
