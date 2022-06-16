package uno

import model.jugadorModel.Usuario
import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class UsuarioClassTest extends Specification{
    Usuario usuario;
    def setup(){
        this.usuario = new Usuario()
    }

    void "Usuario inicia con saldo en 0" () {
        expect:
        this.usuario.saldo == 0
    }
    void "Usuario al iniciar no esta baneado" (){
        expect:
        !this.usuario.estaBaneado()
    }

    void "El ban es aplicable si la fecha es posterior a la del dia"(){
        expect:
        this.usuario.banear(new LocalDateTime(new LocalDate(2023,7,15), new LocalTime(12,0,0,0)))
    }

    void "El ban no es aplicable si la fecha es inferior a la del dia"(){
        expect:
        !this.usuario.banear(new LocalDateTime(new LocalDate(2021,7,15), new LocalTime(12,0,0,0)))
    }

    void "Si la fecha del ban es mayor al del dia seguira baneado"(){
        this.usuario.banear(new LocalDateTime(new LocalDate(2023,7,15), new LocalTime(12,0,0,0)))
        expect:
        this.usuario.estaBaneado()
    }

}
