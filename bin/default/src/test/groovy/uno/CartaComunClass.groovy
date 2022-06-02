import grails.testing.gorm.DomainUnitTest

import model.cartaModel.CartaComun
import spock.lang.Specification

class CartaComunSpec extends Specification {

    void "pruebo test"(){
        carta1 = new CartaComun("rojo", "5")
        carta2 = new CartaComun("rojo", "8")
        expect:
        carta1.esJugadaValida(carta2)
    }
}