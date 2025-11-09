package com.servicios;

import java.util.ArrayList;

import com.entidades.Carta;
import com.entidades.Naipe;

public class Juego {
	private Naipe naipe;
	private ArrayList<ArrayList<Carta>> cartasJugador = new ArrayList<ArrayList<Carta>>();
	private ArrayList<Carta> naipeBarajado = new ArrayList<Carta>();
	private ArrayList<String> idsJugadores;
	
	public Juego() {
		naipeBarajado = naipe.barajar();

	}

	public Juego(ArrayList<String> idsJugadores) {
		// Inicializar el naipe
		this.naipe = new Naipe();
		this.naipeBarajado = this.naipe.barajar();
		this.idsJugadores=idsJugadores;
		

		// Por cada jugador, crear un ArrayList de Carta
		for (int i = 0; i < idsJugadores.size(); i++) {
			ArrayList<Carta> cartasDeJugador = new ArrayList<Carta>();
			cartasJugador.add(cartasDeJugador);
		}
	}

	public Naipe getNaipe() {
		return naipe;
	}

	public void setNaipe(Naipe naipe) {
		this.naipe = naipe;
	}

	public ArrayList<ArrayList<Carta>> getCartasJugador() {
		return cartasJugador;
	}

	public void setCartasJugador(ArrayList<ArrayList<Carta>> cartasJugador) {
		this.cartasJugador = cartasJugador;
	}

	public void entregarCartas(int cartasPorJugador) {
		int indice = 0;
		for (int i = 0; i < cartasPorJugador; i++) {
			for (int j = 0; j < cartasJugador.size(); j++) {
				Carta carta = naipeBarajado.get(indice);
				cartasJugador.get(j).add(carta);
				indice++;
			}
		}
	}
	
	public String determinarGanador() {
	    // Variables auxiliares
	    int idGanador = 0; // índice del primer jugador
	    int sumaGanador = devolverTotal(0); // suma del primer jugador
	    
	    // Recorrer todos los demás jugadores
	    for (int i = 1; i < cartasJugador.size(); i++) {
	        int sumaActual = devolverTotal(i);
	        
	        // Si encontramos alguien con mayor o igual puntaje
	        if (sumaActual >= sumaGanador) {
	            idGanador = i;
	            sumaGanador = sumaActual;
	        }
	    }
	    
	    // Retornar el ID (String) del jugador ganador
	    return idsJugadores.get(idGanador);
	}

	public int devolverTotal(int idJugador) {
	    int total = 0;
	    ArrayList<Carta> cartas = cartasJugador.get(idJugador);
	    
	    for (int i = 0; i < cartas.size(); i++) {
	        total += cartas.get(i).getNumero();
	    }
	    
	    return total;
	}
}
