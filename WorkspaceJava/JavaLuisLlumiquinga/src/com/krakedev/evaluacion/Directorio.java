package com.krakedev.evaluacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Directorio {
	private ArrayList<Contacto> contactos = new ArrayList<Contacto>();
	private Date fechaModificacion;
	private ArrayList<Contacto> correctos = new ArrayList<Contacto>();
	private ArrayList<Contacto> incorrectos = new ArrayList<Contacto>();

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}

	public ArrayList<Contacto> getCorrectos() {
		return correctos;
	}

	public void setCorrectos(ArrayList<Contacto> correctos) {
		this.correctos = correctos;
	}

	public ArrayList<Contacto> getIncorrectos() {
		return incorrectos;
	}

	public void setIncorrectos(ArrayList<Contacto> incorrectos) {
		this.incorrectos = incorrectos;
	}

	public boolean agregarContacto(Contacto contacto) {
		/*
		 * contactos.add(contacto); return true;
		 */

		Contacto contactoEncontrado;
		boolean agregado = false;

		contactoEncontrado = buscarPorCedula(contacto.getCedula());

		if (contactoEncontrado == null) {
			contactos.add(contacto);
			fechaModificacion = new Date();
			agregado = true;
		}

		return agregado;
	}

	public Contacto buscarPorCedula(String cedula) {
		Contacto elementoContacto;
		Contacto contactoEncontrado = null;

		for (int i = 0; i < contactos.size(); i++) {
			elementoContacto = contactos.get(i);

			if (cedula.equals(elementoContacto.getCedula())) {
				contactoEncontrado = elementoContacto;
			}
		}

		return contactoEncontrado;
	}

	public String consultarUltimaModificacion() {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
		return formato.format(fechaModificacion);
	}

	public int contarPerdidos() {
		Contacto elementoContacto;
		int contactoPerdido = 0;

		for (int i = 0; i < contactos.size(); i++) {
			elementoContacto = contactos.get(i);

			if (elementoContacto.getDireccion() == null) {
				contactoPerdido++;
			}
		}

		return contactoPerdido;
	}

	public int contarFijos() {
		Contacto elementoContacto;
		int contactoFijo = 0;

		for (int i = 0; i < contactos.size(); i++) {
			elementoContacto = contactos.get(i);

			if (elementoContacto.getTelefonos().get(0).getTipo() == "Convencional"
					&& elementoContacto.getTelefonos().get(0).getEstado() == "C") {
				contactoFijo++;
			}
		}

		return contactoFijo;
	}

	public void depurar() {
		Contacto elementoContacto;

		for (int i = 0; i < contactos.size(); i++) {
			elementoContacto = contactos.get(i);

			if (elementoContacto.getDireccion() == null) {
				incorrectos.add(elementoContacto);
			} else {
				correctos.add(elementoContacto);
			}
		}

		contactos.clear();
	}
}
