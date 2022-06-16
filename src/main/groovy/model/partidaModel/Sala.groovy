package model.partidaModel

import io.micronaut.core.value.ValueException
import model.jugadorModel.Jugador
import model.jugadorModel.UsuarioModel

class Sala {
    ArrayList<UsuarioModel> usuarios;
    BigDecimal apuesta;
    Integer cantidadJugadoresMaximo;

    Sala(BigDecimal apuesta, Integer cantidadJugadoresMaximo, UsuarioModel usuario){
        if(usuario.getSaldo() < apuesta){
            ValueException
        }
        this.usuarios = new ArrayList<UsuarioModel>()
        this.usuarios.add(usuario)
        this.apuesta = apuesta
        this.cantidadJugadoresMaximo = cantidadJugadoresMaximo
    }

    boolean unirse(UsuarioModel usuario){
        if((usuario.getSaldo() < apuesta) || (this.cantidadJugadoresMaximo == this.usuarios.size()) || usuario.estaBaneado()) {
            return false;
        } else {
            this.usuarios.add(usuario)
            return true
        }
    }

    Partida iniciarPartida(){
        if (this.usuarios.size() == this.cantidadJugadoresMaximo){
            ArrayList<Jugador> listaJuagdores = new ArrayList<>()
            this.usuarios.forEach( usuario -> {
                usuario.retirarSaldo(this.apuesta)
                listaJuagdores.add(usuario.generarJugador())
            })
            return new Partida(listaJuagdores , this.apuesta)
        }
    }
}
