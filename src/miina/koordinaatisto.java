package miina;

import java.util.ArrayList;

public class koordinaatisto {

    private ArrayList ruudut;

    public koordinaatisto() {
        this.ruudut = new ArrayList();
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

    public void tulosta() {

        int as = 0;
        int ds = this.ruudut.size();
        while (ds > 0) {
            System.out.println(this.ruudut.get(as));
            as++;
            ds--;
        }
    }

}
