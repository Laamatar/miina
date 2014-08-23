package miina;

import java.util.ArrayList;

public class Ruudukko {

    private koordinaatisto ruudut;

    public void AvaaRuutu(String kirjain, int numero) {
        ruutu kohta = ruudut.haeRuutu(kirjain, numero);
        if (kohta.OnkoAuki()) {
            System.out.println(kohta.annaArvo());
        } else if (kohta.annaArvo() == 0) {
            kohta.Aukaise();
            avaaViereiset(kirjain, numero);
            System.out.println(kohta.annaArvo());
        } else {
            kohta.Aukaise();
            System.out.println(kohta.annaArvo());
        }
    }

    public void avaaViereiset(String kirjain, int numero) {
        
        int epanumero = numero - 2;
        
        for (int montako = 0; montako < 3; montako++) {
            int epakirjain = kirjain.charAt(0) - 1;
            epanumero++;

            for (int monesko = 0; monesko < 3; monesko++) {
                
                ruutu kohta = ruudut.haeRuutu(Integer.toString(epakirjain), epanumero);
                if (kohta.OnkoAuki() == false && voikoAvata(epakirjain, epanumero)) {
                    AvaaRuutu(Integer.toString(epakirjain), epanumero);
                }
                epakirjain++;
            }

        }
    }
    
    public boolean voikoAvata(int epakirjain, int epanumero){
        if (epakirjain < 0 || epakirjain > 10) {
            return false;
        }
        if (epanumero < 0 || epanumero > 10) {
            return false;
        }
            return true;
    }

    public void Tulostettava() {
        for (int silmukkamuuttuja = 0; silmukkamuuttuja < 100; silmukkamuuttuja++) {
            ruutu kohta = ruudut.haeppasRuutu(silmukkamuuttuja);
            if (kohta.OnkoAuki()) {
                System.out.println(kohta.annaArvo());
            } else {
                System.out.println("?");
            }
        }
    }
}
