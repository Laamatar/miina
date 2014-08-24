package miina;

import java.util.ArrayList;

public class Ruudukko {

    public koordinaatisto ruudut;

    Ruudukko() {

        ruudut = new koordinaatisto();

        //ruudut.laskeArvot();
    }

    public void AvaaRuutu(String kirjain, int numero) {
        ruutu kohta = ruudut.haeRuutu(kirjain, numero);
        if (kohta.OnkoAuki()) {
        } else if (kohta.annaArvo() == 0) {
            kohta.Aukaise();
            avaaViereiset(kirjain, numero);
        } else {
            kohta.Aukaise();
        }
    }

    public void avaaViereiset(String kirjain, int numero) {

        int epanumero = numero - 1;
        String taika = "ABCDEFGHIJKLMNOPQ";

        for (int montako = 0; montako < 3; montako++) {
            int epakirjain = taika.indexOf(kirjain); //kirjain.charAt(0) - 1;
            //epanumero++;

            for (int monesko = 0; monesko < 3; monesko++) {
                if (epakirjain + montako - 1 < 0) {
                    continue;
                }
                if (epakirjain + montako - 1 >= 10) {
                    continue;
                }
                if (epanumero + monesko - 1 < 0) {
                    continue;
                }
                if (epanumero + monesko - 1 >= 10) {
                    continue;
                }
                //System.out.println("!! " + (epakirjain+montako-1) + " " + (epanumero+monesko-1));
                ruutu kohta = ruudut.haeRuutu("" + taika.charAt(epakirjain + montako - 1), epanumero + monesko);
                if (kohta.OnkoAuki() == false && voikoAvata(epakirjain + montako - 1, epanumero + monesko)) {
                    AvaaRuutu("" + taika.charAt(epakirjain + montako - 1), epanumero + monesko);
                }
                //epakirjain++;
            }

        }
    }

    public boolean voikoAvata(int epakirjain, int epanumero) {
        if (epakirjain < 0 || epakirjain > 10) {
            return false;
        }
        if (epanumero < 0 || epanumero > 10) {
            return false;
        }
        return true;
    }

    public void Tulostettava() {

        int i = 9;

        while (true) {
            for (int x = i; x < 100; x += 10) {
                ruutu kohta = ruudut.haeppasRuutu(x);
                if (kohta.OnkoAuki()) {
                    System.out.print(kohta.annaArvo()+ " ");
                } else {
                    System.out.print("? ");
                }
            }
            i--;
            System.out.println("");
            
            if (i == - 1){
                break;
            }
        }
    }
}