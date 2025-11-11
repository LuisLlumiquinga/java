package com.cmc.servicios;

import java.util.ArrayList;

import com.cmc.entidades.Cliente;
import com.cmc.evaluacion.Prestamo;

public class Banco {
	private ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public Cliente buscarCliente(String cedula) {
		Cliente elementoCliente;
		Cliente clienteEncontrado = null;

		for (int i = 0; i < clientes.size(); i++) {
			elementoCliente = clientes.get(i);

			if (elementoCliente.getCedula().equals(cedula)) {
				clienteEncontrado = elementoCliente;
			}
		}
		return clienteEncontrado;
	}

	public void registrarCliente(Cliente cliente) {
		Cliente clienteEncontrado;

		clienteEncontrado = buscarCliente(cliente.getCedula());

		if (clienteEncontrado == null) {
			clientes.add(cliente);
		} else {
			System.out.println("Cliente ya existe: " + cliente.getCedula());
		}
	}

	public void asignarPrestamo(String cedula, Prestamo prestamo) {
		Cliente clienteEncontrado;

		clienteEncontrado = buscarCliente(cedula);

		if (clienteEncontrado == null) {
			System.out.println("No es cliente del banco");
		} else {
			prestamos.add(prestamo);
			System.out.println("Prestamo asignado correctamente");
		}
	}

	public ArrayList<Prestamo> buscarPrestamos(String cedula) {
		ArrayList<Prestamo> prestamosCliente = new ArrayList<Prestamo>();

		// Recorrer todos los préstamos y filtrar por cédula
		for (int i = 0; i < prestamos.size(); i++) {
			if (prestamos.get(i).getCedula().equals(cedula)) {
				prestamosCliente.add(prestamos.get(i));
			}
		}

		// Si no encontró ninguno, retornar null
		if (prestamosCliente.isEmpty()) {
			return null;
		}

		return prestamosCliente;
	}

}
