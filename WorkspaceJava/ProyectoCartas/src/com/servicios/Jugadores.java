package com.servicios;

import java.util.ArrayList;

import com.entidades.Carta;

public class Jugadores {
	private ArrayList<String> jugador = new ArrayList<String>();

	public ArrayList<String> getJugador() {
		return jugador;
	}

	public void setJugador(ArrayList<String> jugador) {
		this.jugador = jugador;
	}

	public void jugar() {
		// 1. Crear ArrayList con 3 jugadores
		ArrayList<String> nombresJugadores = new ArrayList<String>();
		nombresJugadores.add("Jugador 1");
		nombresJugadores.add("Jugador 2");
		nombresJugadores.add("Jugador 3");

		// 2. Crear objeto Juego con los jugadores
		Juego juego = new Juego(nombresJugadores);

		// 3. Entregar 5 cartas a cada jugador
		juego.entregarCartas(5);

		// 4. Mostrar los resultados - recorrer jugadores y sus cartas
		System.out.println("===== CARTAS DE LOS JUGADORES =====\n");

		int totalGeneral = 0;

		for (int i = 0; i < juego.getCartasJugador().size(); i++) {
			System.out.println(nombresJugadores.get(i) + ":");

			ArrayList<Carta> cartasDelJugador = juego.getCartasJugador().get(i);
			int totalJugador = 0;

			// Mostrar cada carta y sumar el total
			for (Carta carta : cartasDelJugador) {
				carta.mostrarInformacion();
				totalJugador += carta.getNumero();
			}

			System.out.println("Total: " + totalJugador);
			System.out.println();

			totalGeneral += totalJugador;
		}

		System.out.println("Total general de todos los jugadores: " + totalGeneral);

		// 5. Determinar el ganador
		String ganador = determinarGanador(juego.getCartasJugador(), nombresJugadores);
		System.out.println("\n===== GANADOR =====");
		System.out.println("El ganador es: " + ganador);
	}

	public String determinarGanador(ArrayList<ArrayList<Carta>> cartasJugadores, ArrayList<String> nombresJugadores) {
		int mayorPuntaje = 0;
		String ganador = "";

		for (int i = 0; i < cartasJugadores.size(); i++) {
			int totalJugador = 0;

			// Sumar el puntaje del jugador
			for (Carta carta : cartasJugadores.get(i)) {
				totalJugador += carta.getNumero();
			}

			// Verificar si es el mayor puntaje
			if (totalJugador > mayorPuntaje) {
				mayorPuntaje = totalJugador;
				ganador = nombresJugadores.get(i);
			}
		}

		return ganador + " con " + mayorPuntaje + " puntos";
	}
}
