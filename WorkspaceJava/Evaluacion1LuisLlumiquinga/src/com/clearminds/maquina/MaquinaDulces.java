package com.clearminds.maquina;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private ArrayList<Celda> celdas;
	private double saldo;

	public MaquinaDulces() {
		celdas = new ArrayList<Celda>();
	}

	public void agregarCelda(Celda codigo) {
		celdas.add(codigo);
	}

	public void mostrarConfiguracion() {
		Celda elementoCelda = null;

		for (int i = 0, j = 1; i < celdas.size(); i++, j++) {
			elementoCelda = celdas.get(i);
			System.out.println("Celda" + j + ": " + elementoCelda.getCodigo());
		}
	}

	public Celda buscarCelda(String codigo) {
		Celda elementoCelda = null;
		Celda celdaEncontrada = null;

		for (int i = 0; i < celdas.size(); i++) {
			elementoCelda = celdas.get(i);

			if (codigo.equals(elementoCelda.getCodigo())) {
				celdaEncontrada = elementoCelda;
			}
		}

		return celdaEncontrada;
	}

	public void cargarProducto(Producto producto, String codigo, int stock) {
		Celda celdaRecuperada = buscarCelda(codigo);

		celdaRecuperada.ingresarProducto(producto, stock);
	}

	public void mostrarProductos() {
		Celda elementoCelda = null;

		for (int i = 0; i < celdas.size(); i++) {
			elementoCelda = celdas.get(i);

			if (elementoCelda.getProducto() != null) {
				System.out.println("\nCodigo:" + elementoCelda.getCodigo() + " Stock:" + elementoCelda.getStock()
						+ " Producto:" + elementoCelda.getProducto().getNombre() + " Precio:"
						+ elementoCelda.getProducto().getPrecio());
			} else {
				System.out.println("Codigo:" + elementoCelda.getCodigo() + " Stock:" + elementoCelda.getStock()
						+ " Sin producto asinado");
			}
		}
		System.out.println("\nSaldo: "+saldo);
	}
	
	public Producto buscarProductoEnCelda(String codigo) {
		Celda elementoCelda;
		Producto productoEncontrado=null;
		
		for(int i=0; i<celdas.size(); i++) {
			elementoCelda=celdas.get(i);
			
			if(codigo.equals(elementoCelda.getCodigo())) {
				productoEncontrado=elementoCelda.getProducto();
			}
		}
		return productoEncontrado;
	}
	
	public double consultarPrecio(String codigo) {
		Celda elementoCelda;
		double precioEncontrado=0;
		
		for(int i=0; i<celdas.size(); i++) {
			elementoCelda=celdas.get(i);
			
			if(codigo.equals(elementoCelda.getCodigo())) {
				precioEncontrado=elementoCelda.getProducto().getPrecio();
			}
		}
		
		return precioEncontrado;
	}
	
	public Celda buscarCeldaProducto(String codigo) {
		Celda elementoCelda;
		Celda celdaEncontrada=null;
		
		for(int i=0; i<celdas.size(); i++) {
			elementoCelda=celdas.get(i);
			
			if(elementoCelda.getProducto()!=null && codigo.equals(elementoCelda.getProducto().getCodigo())) {
				celdaEncontrada=elementoCelda;
			}
		}
		return celdaEncontrada;
	}
	
	public void incrementarProductos(String codigo, int cantidad) {
		Celda celdaEncontrada=buscarCeldaProducto(codigo);
		
		celdaEncontrada.setStock(celdaEncontrada.getStock()+cantidad);
	}
	
	public void vender(String codigo) {
		Celda elementoCelda;
		
		for(int i=0; i<celdas.size(); i++) {
			elementoCelda=celdas.get(i);
			
			if(elementoCelda.getProducto()!=null && codigo.equals(elementoCelda.getCodigo())) {
				elementoCelda.setStock(elementoCelda.getStock()-1);
				
				saldo+=elementoCelda.getProducto().getPrecio();
			}
		}
	}

	public double venderConCambio(String codigo, int valor) {
		Celda elementoCelda;
		double vuelto=0;
		
		for(int i=0; i<celdas.size(); i++) {
			elementoCelda=celdas.get(i);
			
			if(elementoCelda.getProducto()!=null && codigo.equals(elementoCelda.getCodigo())) {				
				elementoCelda.setStock(elementoCelda.getStock()-1);
				vuelto=valor-elementoCelda.getProducto().getPrecio();
				saldo+=elementoCelda.getProducto().getPrecio();				
			}
		}		
		return vuelto;
	}
	
	public ArrayList<Producto> buscarMenores(double limite) {
		ArrayList<Producto> menores=new ArrayList<Producto>();
		Producto elementoProducto=null;
		
		for(int i=0; i<celdas.size(); i++) {
			elementoProducto=celdas.get(i).getProducto();
			
			if(elementoProducto.getPrecio()<=limite) {
				menores.add(elementoProducto);
			}
		}
		
		return menores;
		
	}
	
	public ArrayList<Celda> getCeldas() {
		return celdas;
	}

	public void setCeldas(ArrayList<Celda> celdas) {
		this.celdas = celdas;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
