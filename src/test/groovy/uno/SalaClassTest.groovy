package uno


import model.jugadorModel.UsuarioModel
import model.partidaModel.Sala
import spock.lang.*

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class SalaClassTest extends Specification{
    UsuarioModel a;
    UsuarioModel b;
    Sala sala;

    def setup() {
        a =  new UsuarioModel()
        b =  new UsuarioModel()
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
        var c = new UsuarioModel()
        c.cargarSaldo(2 as BigDecimal)
        expect:
        !sala.unirse(c)
    }

    void "no puedo entrar si estoy lleno"() {
        setup()
        var c = new UsuarioModel()
        c.cargarSaldo(110 as BigDecimal)
        sala.unirse(b)
        expect:
        !sala.unirse(c)
    }

    void "no puedo entrar si estoy baneado"(){
        b.banear(new LocalDateTime(new LocalDate(2023,7,15), new LocalTime(12,0,0,0)))
        expect:
        !sala.unirse(b)
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

    void "me uno y se me resta el saldo"() {
        setup()
        sala.unirse(b)
        expect:
        b.saldo == 50 as BigDecimal
    }
}