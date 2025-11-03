package com.cmc.directorio.entidades;

public class AdminTelefono {
	public void activarMensajeria(Telefono fono) {
		if(fono.getOperadora()=="movi") {
			fono.setTieneWhatsapp(true);
		}
	}
	
	public int contarMovi(Telefono fono1, Telefono fono2, Telefono fono3) {
		int cont=0;
		
		if(fono1.getOperadora().equals("movi")){
			cont++;
		}
		
		if(fono2.getOperadora().equals("movi")) {
			cont++;
		}
		
		if((fono3.getOperadora().equals("movi"))) {
			cont++;
		}
		
		return cont;
	}
	
	public int contarClaro(Telefono fono1, Telefono fono2, Telefono fono3, Telefono fono4) {
		int cont=0;
		
		if(fono1.getOperadora().equals("claro")){
			cont++;
		}
		
		if(fono2.getOperadora().equals("claro")) {
			cont++;
		}
		
		if((fono3.getOperadora().equals("claro"))) {
			cont++;
		}
		
		if((fono4.getOperadora().equals("claro"))) {
			cont++;
		}
		
		return cont;
	}
}
