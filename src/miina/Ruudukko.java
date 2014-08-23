package miina;

import java.util.ArrayList;

public class Ruudukko {

    private koordinaatisto ruudut;

    public void AvaaRuutu(String kirjain, int numero) {
        ruutu kohta = ruudut.haeRuutu(kirjain, numero);
        if (kohta.OnkoAuki()) {
            System.out.println();
        } else {
            kohta.Aukaise();
            System.out.println();
        }
    }

    public void Tulostettava() {
        for (int silmukkamuuttuja = 0; silmukkamuuttuja < 100; silmukkamuuttuja++) {
            ruutu kohta = ruudut.haeppasRuutu(silmukkamuuttuja);
            if (kohta.OnkoAuki()) {
                System.out.println();
            }else {
                System.out.println("?");
            }
        }
    }
}
