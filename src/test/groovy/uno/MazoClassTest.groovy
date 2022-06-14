package uno

import model.mazoModel.Mazo
import spock.lang.*

class MazoClassTest extends Specification{
    void "pruebaJugadaValida"(){
        Mazo mazo = new Mazo()
        var aux = mazo.mazoCarta.clone()
        mazo.mezlarMazo()
        expect:
            aux != mazo.mazoCarta
    }
}