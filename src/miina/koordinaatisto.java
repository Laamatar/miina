package miina;

import java.util.ArrayList;
import java.util.Random;

public class koordinaatisto {

    private Random random;
    private ArrayList<ruutu> ruudut;

    public koordinaatisto() {
        this.ruudut = new ArrayList<ruutu>();
        int a = 1;
        String kirjaimet = "ABCDEFGHIJ";
        int luku = 0;
        int numero = 1;
        int meh = 1;

        while (meh <= 10) {
            while (a <= 10) {
                String kirjain = "" + kirjaimet.charAt(luku);
                this.ruudut.add(new ruutu(kirjain, numero));
                numero++;
                a++;
            }
            numero = 1;
            a = 1;
            luku++;
            meh++;

        }

    }

    public ruutu haeRuutu(String kirjain, int numero) {
        int rivi = numero - 1;
        String kirjaimet = "ABCDEFGHIJ";
        int sarake =  kirjaimet.indexOf(kirjain);
        
        return this.ruudut.get(sarake*10+rivi);

    }

    public void tulosta() {

        int as = 0;
        int ds = this.ruudut.size();
        while (ds > 0) {
            System.out.println(this.ruudut.get(as));
            as++;
            ds--;
        }
    }

    public void MIINOITA(int maara) {

        int aefs = maara;

        this.random = new Random();
        int asd = 0;
        int kirjainnumero = 0;

        while (aefs > 0) {
            asd = random.nextInt(10) + 1;
            kirjainnumero = random.nextInt(11);
            String kirjaimet = "ABCDEFGHIJ";
            String kirjain = "" + kirjaimet.charAt(kirjainnumero);
            
            this.haeRuutu(kirjain, asd);

            aefs--;
        }

    }

}
