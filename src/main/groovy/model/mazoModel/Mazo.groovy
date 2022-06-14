package model.mazoModel

import model.cartaModel.*

class Mazo {
    ArrayList<Carta> mazoCarta;

    Mazo(){
        this.mazoCarta = new ArrayList<Carta>();
        for(int i = 0; i < 100; i++){
            this.mazoCarta.add(new CartaComun("rojo", ""+i));
        }
    }

    Carta tomarCarta(){
        this.mazoCarta.removeLast()
    }
    void guardar_carta(Carta carta){
        this.mazoCarta.add(carta)
    }
    void mezlarMazo(){
        this.mazoCarta.shuffle()
    }

}
