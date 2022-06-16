package model.jugadorModel

import java.time.LocalDateTime

class Usuario {
    BigDecimal saldo;
    String nombre;
    String contrasenia;
    Jugador jugador;
    LocalDateTime ban;

    Usuario(){
        this.saldo = 0
        this.nombre = "asd"
        this.contrasenia = "asd"
        this.ban = null
    }

    void cargarSaldo(BigDecimal saldo){
        this.saldo += saldo
    }
    void retirarSaldo(BigDecimal saldo){
        this.saldo -= saldo
    }

    Jugador generarJugador(){
       this.jugador = new Jugador(this)
       this.jugador
    }

    boolean banear(LocalDateTime ban){
        if (ban > LocalDateTime.now()){
            this.ban = ban
            return true
        }
        false
    }

    boolean estaBaneado() {
        if (this.ban != null && this.ban.isAfter(LocalDateTime.now())){
            return true
        }
        false
    }
}
