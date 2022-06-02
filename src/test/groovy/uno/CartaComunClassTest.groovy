package uno

import model.cartaModel.CartaComun
import spock.lang.*
class CartaComunClassTest extends Specification {
    void "pruebaJugadaValida"(){
        CartaComun carta1 = new CartaComun("rojo", "4")
        CartaComun carta2 = new CartaComun("rojo", "6")
        expect:
        carta1.esJugadaValida(carta2)
    }
    void "pruebaJugadaNoValida"(){
        CartaComun carta1 = new CartaComun("rojo", "4")
        CartaComun carta2 = new CartaComun("verde", "6")
        def aux = !carta1.esJugadaValida(carta2)
        expect:
        aux
    }
}
