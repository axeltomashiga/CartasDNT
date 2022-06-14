package model.jugadorModel;

import model.cartaModel.Carta;

class Jugador {
    private ArrayList<Carta> mano;
    private Usuario usuario;

    Jugador(Usuario usuario){
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
}
