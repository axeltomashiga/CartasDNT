package uno

import model.jugadorModel.Jugador
import model.jugadorModel.Usuario
import model.partidaModel.Partida
import model.partidaModel.Sala
import spock.lang.Specification

class IntegracionTest extends Specification {
    Usuario a;
    Usuario b;
    Partida partida;

    def setup() {
        a =  new Usuario()
        b =  new Usuario()
        a.cargarSaldo(1000 as BigDecimal)
        b.cargarSaldo(1000 as BigDecimal)
        Sala sala = new Sala(50 as BigDecimal, 2, a)
        sala.unirse(b)
        this.partida = sala.iniciarPartida()
        this.partida.inicializarPartida()
    }

    void "gana un jugador y se reparte el premio"(){
        Jugador jugadorAct = this.partida.jugadorActual;
        for (i in 0..8) {
            jugadorAct.tirarCarta(0)
        }
        this.partida.repartirPremio()
        expect:
        this.partida.jugadorActual.verSaldo() == 1050
    }
}
