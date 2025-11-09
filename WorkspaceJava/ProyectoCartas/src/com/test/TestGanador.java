package com.test;

import java.util.ArrayList;

import com.servicios.Juego;
import com.servicios.Jugadores;

public class TestGanador {

    public static void main(String[] args) {

        Jugadores jugadores = new Jugadores();
        ArrayList<String> listaJugadores = new ArrayList<>();
        listaJugadores.add("jugador 1");
        listaJugadores.add("jugador 2");
        listaJugadores.add("jugador 3");
        jugadores.setJugador(listaJugadores);

        Juego juego = new Juego(jugadores.getJugador());
        juego.entregarCartas(5);

        for (int i = 0; i < jugadores.getJugador().size(); i++) {
            int total = juego.devolverTotal(i);
            System.out.println("Total del jugador " + (i + 1) + ": " + total);
        }

        String ganador = juego.determinarGanador();
        System.out.println("El ganador es: " + ganador);
    }
}
