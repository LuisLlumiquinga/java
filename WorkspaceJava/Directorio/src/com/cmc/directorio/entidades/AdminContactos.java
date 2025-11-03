package com.cmc.directorio.entidades;

public class AdminContactos {
	public Contacto buscarMasPesado(Contacto contacto1, Contacto contacto2) {
		if(contacto1.getPeso()>contacto2.getPeso()) {
			return contacto1;
		}else{
			return contacto2;
		}
	}
	
	public boolean compararOperadoras(Contacto contacto1, Contacto contacto2) {
		if(contacto1.getTelefono().getOperadora()==contacto2.getTelefono().getOperadora()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void activarUsuario(Contacto contacto1) {
		if(contacto1.getTelefono().isTieneWhatsapp()==true) {
			contacto1.setActivo(true);
		}
	}
	
	
}
