package uno

import model.jugadorModel.Jugador
import model.jugadorModel.Usuario
import model.partidaModel.Partida
import spock.lang.Specification

class PartidaClassTest extends Specification{
    Partida partida;

    def setup() {
        Usuario usuario1 = new Usuario()
        Usuario usuario2 = new Usuario()
        usuario1.cargarSaldo(new BigDecimal(1000))
        usuario2.cargarSaldo(new BigDecimal(1000))
        ArrayList<Jugador> lista = [new Jugador(usuario1),new Jugador(usuario2)]
        this.partida = new Partida(lista, new BigDecimal(50))
        this.partida.inicializarPartida()
    }

    void "partida no null"() {
        expect:"fix me"
        this.partida != null
    }

    void "paso el primer turno y cambia el jugador"(){
        Jugador jugadorAct = this.partida.jugadorActual;
        this.partida.pasarTurno()
        expect:
        this.partida.jugadorActual != jugadorAct;
    }

    void "paso el dos turnos en una partida de dos jugadores y vuelve al mismo jugador"(){
        Jugador jugadorAct = this.partida.jugadorActual;
        this.partida.pasarTurno()
        this.partida.pasarTurno()
        expect:
        this.partida.jugadorActual == jugadorAct;
    }

    void "gana un jugador"(){
        Jugador jugadorAct = this.partida.jugadorActual;
        for (i in 0..8) {
            jugadorAct.tirarCarta(0)
        }
        expect:
        this.partida.ganoJugadorActual()
    }
}
