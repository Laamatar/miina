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
        int sarake = kirjaimet.indexOf(kirjain);

        return this.ruudut.get(sarake * 10 + rivi);

    }

    public ruutu haeppasRuutu(int monesko) {
        return this.ruudut.get(monesko);
    }

    public void miina() {
        this.ruudut.get(49).Miinoita();
        this.ruudut.get(59).Miinoita();
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
            kirjainNumero = random.nextInt(10);
            String kirjaimet = "ABCDEFGHIJ";
            String kirjain = "" + kirjaimet.charAt(kirjainNumero);

            this.haeRuutu(kirjain, arvottuNumero).Miinoita();

            miinojenMaara--;
        }

    }

    public ArrayList<ruutu> miinoitetutRuudut() {
        ArrayList<ruutu> miinoitetutruudut = new ArrayList<ruutu>();
        int muuttuja = 0;
        int ruutuListanKoko = this.ruudut.size();
        while (ruutuListanKoko > 0) {
            if (this.ruudut.get(muuttuja).OnkoMiina()) {
                miinoitetutruudut.add(this.ruudut.get(muuttuja));
            } else {
            }
            muuttuja++;
            ruutuListanKoko--;
        }
        return miinoitetutruudut;
    }

    public boolean Havio() {

        int muuttuja = 0;
        int ruutuListanKoko = this.ruudut.size();
        while (ruutuListanKoko > 0) {
            if (this.ruudut.get(muuttuja).OnkoMiina() && this.ruudut.get(muuttuja).OnkoAuki()) {
                return true;
            }
            muuttuja++;
            ruutuListanKoko--;
        }
        return false;

    }

    public boolean Voitto() {
        ArrayList<ruutu> miinoitetutruudut = new ArrayList<ruutu>();
        int muuttuja = 0;
        int ruutuListanKoko = this.ruudut.size();
        while (ruutuListanKoko > 0) {
            if (this.ruudut.get(muuttuja).OnkoAuki() == false) {
                if (!this.ruudut.get(muuttuja).OnkoMiina()) {
                    return false;
                } else {
                    miinoitetutruudut.add(this.ruudut.get(muuttuja));
                }
            }
            muuttuja++;
            ruutuListanKoko--;
        }
        if (miinoitetutruudut.size() == this.miinoitetutRuudut().size()){
            return true;
        }
        return false;
    }

    public void laskeArvot() {

        int indeksiluku = 0;
        int miinojenMaara = this.miinoitetutRuudut().size();

        while (miinojenMaara > 0) {

            int ylaraja = this.miinoitetutRuudut().get(indeksiluku).Sarake() * 10 + 10;
            int alaraja = this.miinoitetutRuudut().get(indeksiluku).Sarake() * 10;

            boolean oikealla = false;
            boolean vasemmalla = false;

            int miinanIndeksi = this.miinoitetutRuudut().get(indeksiluku).ruudunIndeksi();

            if (miinanIndeksi + 1 >= ylaraja) {
            } else {
                this.ruudut.get(miinanIndeksi + 1).lisaaArvo();
            }
            if (miinanIndeksi + 1 + 10 >= ylaraja + 10) {
            } else {
                if (miinanIndeksi + 11 <= 99) {
                    this.ruudut.get(miinanIndeksi + 1 + 10).lisaaArvo();
                }
            }
            if (miinanIndeksi + 1 - 10 >= ylaraja - 10) {
            } else {
                if (miinanIndeksi + 1 - 10 >= 0) {
                    this.ruudut.get(miinanIndeksi + 1 - 10).lisaaArvo();
                }
            }
            if (miinanIndeksi - 1 - 10 >= alaraja - 10 || miinanIndeksi == 91) {
                if (miinanIndeksi - 10 - 1 >= 0) {
                    this.ruudut.get(miinanIndeksi - 1 - 10).lisaaArvo();
                }
            } else {

            }
            if (miinanIndeksi - 1 >= alaraja || miinanIndeksi == 1) {
                this.ruudut.get(miinanIndeksi - 1).lisaaArvo();
            } else {
            }
            if (miinanIndeksi - 1 + 10 < alaraja + 10) {
            } else {
                if (miinanIndeksi + 10 - 1 <= 99) {
                    this.ruudut.get(miinanIndeksi - 1 + 10).lisaaArvo();
                }
            }
            if (miinanIndeksi + 10 <= 99) {
                this.ruudut.get(miinanIndeksi + 10).lisaaArvo();
            }
            if (miinanIndeksi - 10 >= 0) {
                this.ruudut.get(miinanIndeksi - 10).lisaaArvo();
            }

            indeksiluku++;
            miinojenMaara--;
        }

    }

}
