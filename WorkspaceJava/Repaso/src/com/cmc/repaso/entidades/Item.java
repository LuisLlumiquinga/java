package com.cmc.repaso.entidades;

public class Item {
	private String nombre;
	private int productosActuales;
	private int productosDevueltos;
	private int productosVendidos;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getProductosActuales() {
		return productosActuales;
	}

	public void setProductosActuales(int productosActuales) {
		this.productosActuales = productosActuales;
	}

	public int getProductosDevueltos() {
		return productosDevueltos;
	}

	public void setProductosDevueltos(int productosDevueltos) {
		this.productosDevueltos = productosDevueltos;
	}

	public int getProductosVendidos() {
		return productosVendidos;
	}

	public void setProductosVendidos(int productosVendidos) {
		this.productosVendidos = productosVendidos;
	}

	public void imprimir() {
		System.out.println("Nombre: "+nombre);
		System.out.println("Productos actuales: "+productosActuales);
		System.out.println("Productos devueltos: "+productosDevueltos);
		System.out.println("Productos vendidos: "+productosVendidos);
	}
	
	public void vender(int productosVendidos) {
		this.productosVendidos=productosVendidos;
		this.productosActuales-=1;
		this.productosVendidos+=1;
		
	}
	
	public void devolver(int productosVendidos) {
		this.productosVendidos=productosVendidos;
		this.productosActuales+=1;
		this.productosVendidos-=1;
		this.productosDevueltos+=1;
	}
}
