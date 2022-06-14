package uno

import model.cartaModel.CartaComun
import model.mazoModel.Mazo
import spock.lang.*
class MazoClassTest extends Specification{
    void "prueba mezclar mazo"(){
        Mazo mazo = new Mazo();
        var aux = mazo.mazoCarta.clone();
        expect:
            aux != mazo.mazoCarta
    }
}
