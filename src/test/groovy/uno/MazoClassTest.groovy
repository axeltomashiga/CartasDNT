package uno

import model.mazoModel.Mazo
import spock.lang.*

class MazoClassTest extends Specification{
    void "prueba de que mezclar los lo hace efectivamente"(){
        Mazo mazo = new Mazo()
        var aux = mazo.mazoCarta.clone()
        mazo.mezlarMazo()
        expect:
            aux != mazo.mazoCarta
    }
}