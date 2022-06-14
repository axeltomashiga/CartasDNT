package model.partidaModel

import model.cartaModel.Carta
import model.jugadorModel.Jugador
import model.mazoModel.Mazo

class Partida {
    ArrayList<Jugador> jugadores;
    int indiceJugadorActual;
    BigDecimal apuesta;
    Mazo mazo;
    ArrayList<Carta> pilaCarta;

    Partida(ArrayList<Jugador> jugadores, BigDecimal apuesta){
        this.jugadores = jugadores
        this.apuesta = apuesta
        this.mazo = new Mazo()
        this.pilaCarta = new ArrayList<Carta>()
    }

    void inicializarPartida(){
        this.mazo.mezlarMazo()
        this.pilaCarta.add( this.mazo.tomarCarta())
        this.jugadores.forEach(jugador -> {for (i in 0..8) {jugador.tomarCarta(this.mazo.tomarCarta())}})
        jugadores.shuffle()
        this.indiceJugadorActual = 0
    }

    void pasarTurno(){
        this.indiceJugadorActual += 1
        if (this.indiceJugadorActual == this.jugadores.size()){
            this.indiceJugadorActual = 0;
        }
    }

    void reversa(){
        this.jugadores = this.jugadores.reverse()
    }

    boolean jugada(Carta carta){
        if (carta.esJugadaValida(this.pilaCarta.last())) {
            this.pilaCarta.add(carta)
            pasarTurno()
            return true
        }

        return false
    }



}
