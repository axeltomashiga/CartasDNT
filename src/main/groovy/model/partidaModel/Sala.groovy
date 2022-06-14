package model.partidaModel

import io.micronaut.core.value.ValueException
import model.jugadorModel.Usuario

class Sala {
    ArrayList<Usuario> usuarios;
    BigDecimal apuesta;
    Integer cantidadJugadoresMaximo;

    Sala(BigDecimal apuesta, Integer cantidadJugadoresMaximo , Usuario usuario){
        if(usuario.getSaldo() < apuesta){
            ValueException
        }
        this.usuarios = new ArrayList<Usuario>()
        this.usuarios.add(usuario)
        this.apuesta = apuesta
        this.cantidadJugadoresMaximo = cantidadJugadoresMaximo
    }

    boolean unirse(Usuario usuario){
        if((usuario.getSaldo() < apuesta) || (this.cantidadJugadoresMaximo == this.usuarios.size())) {
            return false;
        } else {
            this.usuarios.add(usuario)
            return true
        }
    }

    Partida iniciarPartida(){
        if (this.usuarios.size() == this.cantidadJugadoresMaximo){
            var aux = this.usuarios.forEach( usuario -> usuario.generarJugador())
            return new Partida(aux, this.apuesta)
        }
    }
}
