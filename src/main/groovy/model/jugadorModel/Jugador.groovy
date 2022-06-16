package model.jugadorModel;

import model.cartaModel.Carta;

class Jugador {
    private ArrayList<Carta> mano;
    private UsuarioModel usuario;

    Jugador(UsuarioModel usuario){
        this.mano = new ArrayList<Carta>()
        this.usuario = usuario
    }

    ArrayList<Carta> verMano(){
        this.mano.clone() as ArrayList<Carta>
    }

    Carta tirarCarta(int indice){
        this.mano.remove(indice)
    }

    void tomarCarta(Carta carta){
        this.mano.add(carta)
    }

    boolean gano(){
        this.mano.isEmpty()
    }

    void darPremio(BigDecimal premio){
        this.usuario.cargarSaldo(premio);
    }

    BigDecimal verSaldo(){
        this.usuario.saldo as BigDecimal
    }
}
