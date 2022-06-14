package model.cartaModel

class CartaComun {

    public String numero
    public String color

    CartaComun(String color, String numero) {
        this.color = color
        this.numero = numero
    }

    String getSimbolo() {
        return simbolo
    }

    boolean esJugadaValida(CartaComun otraCarta) {
        return(this.numero == otraCarta.numero || this.color == otraCarta.color)
    }

    // public void devolverAlMazo(){
    //     this.estadoCarta = new Desactivada();
    //     this.mazo.vuelveAlMazo(this);
    //     this.boxCarta.volviAlMazo();
    // }

    // public void asociarAlMazo(Mazo unMazo){
    //     this.mazo = unMazo;
    // }

    // @Override
    // public boolean equals(Object otro){
    //     if(this == otro) return true;
    //     else if(otro == null  otro.getClass() != Carta.class) return false;
    //     Carta otraCarta = (Carta) otro;
    //     return this.pais.equals(otraCarta.pais) && this.simbolo.equals(otraCarta.simbolo);
    // }

}
