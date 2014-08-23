package miina;

import java.util.ArrayList;
import java.util.Random;

public class koordinaatisto {

    private Random random;
    private ArrayList<ruutu> ruudut;

    public koordinaatisto() {
        this.ruudut = new ArrayList<ruutu>();
        int sisempisilmukkamuuttuja = 1;
        String kirjaimet = "ABCDEFGHIJ";
        int kirjaimenIndeksiluku = 0;
        int numero = 1;
        int meh = 1;  // meh on ulomman silmukan muuttuja

        while (meh <= 10) {
            while (sisempisilmukkamuuttuja <= 10) {
                String kirjain = "" + kirjaimet.charAt(kirjaimenIndeksiluku);
                this.ruudut.add(new ruutu(kirjain, numero));
                numero++;
                sisempisilmukkamuuttuja++;
            }
            numero = 1;
            sisempisilmukkamuuttuja = 1;
            kirjaimenIndeksiluku++;
            meh++;

        }

    }

    public ruutu haeRuutu(String kirjain, int numero) {
        int rivi = numero - 1;
        String kirjaimet = "ABCDEFGHIJ";
        int sarake =  kirjaimet.indexOf(kirjain);
        
        return this.ruudut.get(sarake*10+rivi);

    }
    
    public ruutu haeppasRuutu(int monesko){
        return this.ruudut.get(monesko);
    }

    public void tulosta() {

        int indeksiMuuttuja = 0;
        int ruutuListanKoko = this.ruudut.size();
        while (ruutuListanKoko > 0) {
            System.out.println(this.ruudut.get(indeksiMuuttuja));
            indeksiMuuttuja++;
            ruutuListanKoko--;
        }
    }

    public void MIINOITA(int maara) {

        int miinojenMaara = maara;

        this.random = new Random();
        int arvottuNumero = 0;
        int kirjainNumero = 0;

        while (miinojenMaara > 0) {
            arvottuNumero = random.nextInt(10) + 1;
            kirjainNumero = random.nextInt(11);
            String kirjaimet = "ABCDEFGHIJ";
            String kirjain = "" + kirjaimet.charAt(kirjainNumero);
            
            this.haeRuutu(kirjain, arvottuNumero).Miinoita();

            miinojenMaara--;
        }

    }

}
