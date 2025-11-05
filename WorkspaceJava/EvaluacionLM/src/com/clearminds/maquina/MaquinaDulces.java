package com.clearminds.maquina;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private Celda celda1;
	private Celda celda2;
	private Celda celda3;
	private Celda celda4;
	private double saldo;

	public void configurarMaquina(String codigo1, String codigo2, String codigo3, String codigo4) {
		celda1 = new Celda(codigo1);
		celda2 = new Celda(codigo2);
		celda3 = new Celda(codigo3);
		celda4 = new Celda(codigo4);
	}

	public void mostrarConfiguracion() {
		System.out.println("Codigo celda 1: " + celda1.getCodigo());
		System.out.println("Codigo celda 2: " + celda2.getCodigo());
		System.out.println("Codigo celda 3: " + celda3.getCodigo());
		System.out.println("Codigo celda 4: " + celda4.getCodigo());
	}

	public Celda buscarCelda(String codigo) {
		if (celda1.getCodigo() == codigo) {
			return celda1;
		} else if (celda2.getCodigo() == codigo) {
			return celda2;
		} else if (celda3.getCodigo() == codigo) {
			return celda3;
		} else if (celda4.getCodigo() == codigo) {
			return celda4;
		} else {
			return null;
		}
	}

	public void cargarProducto(Producto producto, String codigo, int stock) {
		Celda celdaRecuperada = buscarCelda(codigo);

		celdaRecuperada.ingresarProducto(producto, stock);
	}

	public void mostrarProductos() {
		System.out.println("***********CELDA " + celda1.getCodigo());
		System.out.println("Stock: " + celda1.getStock());
		if (celda1.getProducto() == null) {
			System.out.println("La celda no tiene producto!!!");
		} else {
			System.out.println("Nombre Producto: " + celda1.getProducto().getNombre());
			System.out.println("Precio Producto: " + celda1.getProducto().getPrecio());
			System.out.println("Codigo Producto: " + celda1.getProducto().getCodigo());
		}

		System.out.println("***********CELDA " + celda2.getCodigo());
		System.out.println("Stock: " + celda2.getStock());
		if (celda2.getProducto() == null) {
			System.out.println("La celda no tiene producto!!!");
		} else {
			System.out.println("Nombre Producto: " + celda2.getProducto().getNombre());
			System.out.println("Precio Producto: " + celda2.getProducto().getPrecio());
			System.out.println("Codigo Producto: " + celda2.getProducto().getCodigo());
		}

		System.out.println("***********CELDA " + celda3.getCodigo());
		System.out.println("Stock: " + celda3.getStock());
		if (celda3.getProducto() == null) {
			System.out.println("La celda no tiene producto!!!");
		} else {
			System.out.println("Nombre Producto: " + celda3.getProducto().getNombre());
			System.out.println("Precio Producto: " + celda3.getProducto().getPrecio());
			System.out.println("Codigo Producto: " + celda3.getProducto().getCodigo());
		}

		System.out.println("***********CELDA " + celda4.getCodigo());
		System.out.println("Stock: " + celda4.getStock());
		if (celda4.getProducto() == null) {
			System.out.println("La celda no tiene producto!!!");
		} else {
			System.out.println("Nombre Producto: " + celda4.getProducto().getNombre());
			System.out.println("Precio Producto: " + celda4.getProducto().getPrecio());
			System.out.println("Codigo Producto: " + celda4.getProducto().getCodigo());
		}

		System.out.println("\nSaldo: " + saldo);
	}

	public Producto buscarProductoEnCelda(String codigo) {
		if (celda1.getCodigo() == codigo) {
			return celda1.getProducto();
		} else if (celda2.getCodigo() == codigo) {
			return celda2.getProducto();
		} else if (celda3.getCodigo() == codigo) {
			return celda3.getProducto();
		} else if (celda4.getCodigo() == codigo) {
			return celda4.getProducto();
		} else {
			return null;
		}
	}

	public double consultarPrecio(String codigo) {
		if (celda1.getCodigo() == codigo) {
			return celda1.getProducto().getPrecio();
		} else if (celda2.getCodigo() == codigo) {
			return celda2.getProducto().getPrecio();
		} else if (celda3.getCodigo() == codigo) {
			return celda3.getProducto().getPrecio();
		} else if (celda4.getCodigo() == codigo) {
			return celda4.getProducto().getPrecio();
		} else {
			return 0;
		}
	}

	public Celda buscarCeldaProducto(String codigo) {
		if (celda1.getProducto() != null && celda1.getProducto().getCodigo() == codigo) {
			return celda1;
		} else if (celda2.getProducto() != null && celda2.getProducto().getCodigo() == codigo) {
			return celda2;
		} else if (celda3.getProducto() != null && celda3.getProducto().getCodigo() == codigo) {
			return celda3;
		} else if (celda4.getProducto() != null && celda4.getProducto().getCodigo() == codigo) {
			return celda4;
		} else {
			return null;
		}
	}

	public void incrementarProductos(String codigo, int cantidad) {
		Celda celdaEncontrada = buscarCeldaProducto(codigo);

		celdaEncontrada.setStock(celdaEncontrada.getStock() + cantidad);
	}

	public void vender(String codigo) {
		Producto productoEncontrado = buscarProductoEnCelda(codigo);

		if (celda1.getProducto() != null && (celda1.getProducto().getNombre() == productoEncontrado.getNombre())) {
			celda1.setStock(celda1.getStock() - 1);
			saldo += productoEncontrado.getPrecio();
		}

		if (celda2.getProducto() != null && (celda2.getProducto().getNombre() == productoEncontrado.getNombre())) {
			celda2.setStock(celda2.getStock() - 1);
			saldo += productoEncontrado.getPrecio();
		}

		if (celda3.getProducto() != null && (celda3.getProducto().getNombre() == productoEncontrado.getNombre())) {
			celda3.setStock(celda3.getStock() - 1);
			saldo += productoEncontrado.getPrecio();
		}

		if (celda4.getProducto() != null && (celda4.getProducto().getNombre() == productoEncontrado.getNombre())) {
			celda4.setStock(celda4.getStock() - 1);
			saldo += productoEncontrado.getPrecio();
		}

		mostrarProductos();
	}

	public double venderConCambio(String codigo, int valor) {
		if (celda1.getProducto() != null && celda1.getCodigo() == codigo) {
			celda1.setStock(celda1.getStock() - 1);
			saldo-= celda1.getProducto().getPrecio();
		} else if (celda2.getProducto() != null && celda2.getCodigo() == codigo) {
			celda2.setStock(celda2.getStock() - 1);
			saldo-= celda2.getProducto().getPrecio();
		} else if (celda3.getProducto() != null && celda3.getCodigo() == codigo) {
			celda3.setStock(celda3.getStock() - 1);
			saldo-= celda3.getProducto().getPrecio();
		} else if (celda4.getProducto() != null && celda4.getCodigo() == codigo) {
			celda4.setStock(celda4.getStock() - 1);
			saldo-= celda4.getProducto().getPrecio();
		} else {
			return saldo;
		}
		
		
		
		
		return saldo;
		// FALTA SALDO
	}

	public Celda getCelda1() {
		return celda1;
	}

	public void setCelda1(Celda celda1) {
		this.celda1 = celda1;
	}

	public Celda getCelda2() {
		return celda2;
	}

	public void setCelda2(Celda celda2) {
		this.celda2 = celda2;
	}

	public Celda getCelda3() {
		return celda3;
	}

	public void setCelda3(Celda celda3) {
		this.celda3 = celda3;
	}

	public Celda getCelda4() {
		return celda4;
	}

	public void setCelda4(Celda celda4) {
		this.celda4 = celda4;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
