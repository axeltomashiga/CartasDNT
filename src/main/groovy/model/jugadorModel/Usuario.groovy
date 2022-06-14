package model.jugadorModel

class Usuario {
    BigDecimal saldo;
    String nombre;
    String contrasenia;
    Jugador jugador;

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

    Usuario(){
        this.saldo = 0
        this.nombre = "asd"
        this.contrasenia = "asd"

    }

}
