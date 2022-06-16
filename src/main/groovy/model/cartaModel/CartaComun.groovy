package model.cartaModel

class CartaComun implements Carta{

    public String numero
    public String color

    CartaComun(String color, String numero) {
        this.color = color
        this.numero = numero
    }

    boolean esJugadaValida(CartaComun otraCarta) {
        return(this.numero == otraCarta.numero || this.color == otraCarta.color)
    }

    boolean esJugadaValida(Carta otraCarta){
        true
    }

}
