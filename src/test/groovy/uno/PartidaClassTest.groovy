package uno


import model.jugadorModel.Usuario
import model.partidaModel.Sala
import spock.lang.*

class PartidaClassTest extends Specification{
    Usuario a;
    Usuario b;
    Sala sala;

    def setup() {
        a =  new Usuario()
        b =  new Usuario()
        a.cargarSaldo(200 as BigDecimal)
        b.cargarSaldo(100 as BigDecimal)

        sala = new Sala(50 as BigDecimal, 2, a)
    }

    void "puedo entrar"(){
        setup()
        expect:
        sala.unirse(b)
    }

    void "no puedo entrar por falta saldo"(){
        setup()
        var c = new Usuario()
        c.cargarSaldo(2 as BigDecimal)
        expect:
        !sala.unirse(c)
    }

    void "no puedo entrar si estoy lleno"() {
        setup()
        var c = new Usuario()
        c.cargarSaldo(110 as BigDecimal)
        sala.unirse(b)
        expect:
        !sala.unirse(c)
    }

    void "no puedo iniciar partida si no esta llena"() {
        setup()
        expect:
        sala.iniciarPartida() == null
    }

    void "puedo iniciar partida si la sala esta llena"() {
        setup()
        sala.unirse(b)
        expect:
        sala.iniciarPartida() != null
    }

    void "iniciar partida y tiro carta"() {
        setup()
        sala.unirse(b)
        expect:
        sala.iniciarPartida() != null
    }
}