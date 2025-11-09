package com.entidades;

import java.util.ArrayList;

public class Naipe {
	private ArrayList<Numero> numerosPosibles = new ArrayList<Numero>();
	private ArrayList<Carta> cartas = new ArrayList<Carta>();
	private Palos palos = new Palos();

	public ArrayList<Carta> getCarta() {
		return cartas;
	}

	public Naipe() {
		numerosPosibles.add(new Numero("A", 11));
		numerosPosibles.add(new Numero("2", 2));
		numerosPosibles.add(new Numero("3", 3));
		numerosPosibles.add(new Numero("4", 4));
		numerosPosibles.add(new Numero("5", 5));
		numerosPosibles.add(new Numero("6", 6));
		numerosPosibles.add(new Numero("7", 7));
		numerosPosibles.add(new Numero("8", 8));
		numerosPosibles.add(new Numero("9", 9));
		numerosPosibles.add(new Numero("10", 10));
		numerosPosibles.add(new Numero("J", 10));
		numerosPosibles.add(new Numero("Q", 10));
		numerosPosibles.add(new Numero("K", 10));

		Numero numero;

		for (int i = 0; i < numerosPosibles.size(); i++) {
			numero = numerosPosibles.get(i);

			cartas.add(new Carta(numero.getValor(), palos.getCorazonRojo()));
			cartas.add(new Carta(numero.getValor(), palos.getCorazonNegro()));
			cartas.add(new Carta(numero.getValor(), palos.getDiamante()));
			cartas.add(new Carta(numero.getValor(), palos.getTrebol()));
		}
	}
	
	public ArrayList<Carta> barajar() {
		ArrayList<Carta> auxiliar=new ArrayList<Carta>();
		
		for(int i=1; i<=100; i++) {
			int posicion=Random.obtenerPosicion();
			
			Carta elementoCarta=cartas.get(posicion);
			
			if(elementoCarta.getEstado().equals("N")) {
				auxiliar.add(elementoCarta);
				elementoCarta.setEstado("C");
			}
		}
		
		for(int i=0; i<cartas.size(); i++) {			
			Carta elementoCarta=cartas.get(i);
			
			if(elementoCarta.getEstado().equals("N")) {
				auxiliar.add(elementoCarta);
				elementoCarta.setEstado("C");
			}
		}
		
		return auxiliar;
		
	}
}
