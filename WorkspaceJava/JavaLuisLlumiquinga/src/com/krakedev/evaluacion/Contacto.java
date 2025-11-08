package com.krakedev.evaluacion;

import java.util.ArrayList;

public class Contacto {
	private String cedula;
	private String nombre;
	private String apellido;
	private String tipo;
	private Direccion direccion;
	private ArrayList<Telefono> telefonos = new ArrayList<Telefono>();

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Contacto(String cedula, String nombre, String apellido) {
		
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public void imprimir() {
		System.out.println("Informacion del Contacto:");
		System.out.println("Cedula: "+cedula);
		System.out.println("Nombre: " + nombre + " " + apellido);
		if (direccion != null) {
			System.out.println("Direccion: ");
			System.out.println("  Calle Principal: "+ direccion.getCallePrincipal());
			System.out.println("  Calle Secundaria: "+ direccion.getCalleSecundaria());
		} else {
			System.out.println("No tiene asociada una direccion");
		}
		
		/*
		System.out.println("***" + nombre + " " + apellido + "****");
		if (direccion != null) {
			System.out.println("Direccion: " + direccion.getCallePrincipal() + " y " + direccion.getCalleSecundaria());
		} else {
			System.out.println("No tiene asociada una direccion");
		}
		*/
	}
	
	public void agregarTelefono(Telefono telefono) {
		telefonos.add(telefono);
	}
	
	public void mostrarTelefonos() {
		Telefono elementoTelefono;
		
		System.out.println("Telefonos con estado 'C'");
		
		for(int i=0; i<telefonos.size(); i++) {
			elementoTelefono=telefonos.get(i);
			
			if(elementoTelefono.getEstado().equals("C")) {
				System.out.println("Numero: "+elementoTelefono.getNumero()+", Tipo: "+elementoTelefono.getTipo());
			}
		}	
	}
	
	public ArrayList<Telefono> recuperarIncorrectos() {
		Telefono elementoTelefono;
		ArrayList<Telefono> fono = new ArrayList<Telefono>();
		
		for(int i=0; i<telefonos.size(); i++) {
			elementoTelefono=telefonos.get(i);
			
			if(elementoTelefono.getEstado().equals("E")) {
				fono.add(elementoTelefono);
			}
		}
		
		return fono;
	}
}
