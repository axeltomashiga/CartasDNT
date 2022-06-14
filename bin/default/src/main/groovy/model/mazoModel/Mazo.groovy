package model.mazoModel

import model.cartaModel.*

class Mazo {
    ArrayList<Carta> mazoCarta;

    Mazo(){
        this.mazoCarta = new ArrayList<Carta>();
        for(int i = 0; i < 10; i++){
            this.mazoCarta.add(new CartaComun("rojo", ""+i));
        }
    }

    Carta tomarCarta(){
        this.mazoCarta.get(0)
    }
    void mezlarMazo(){
        this.mazoCarta.shuffle()
    }

}
