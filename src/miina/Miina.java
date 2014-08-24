package miina;

import java.util.ArrayList;
import java.util.Scanner;

public class Miina {

    public static void main(String[] args) {

        Ruudukko foo = new Ruudukko();
        Scanner lukija = new Scanner(System.in);
        System.out.println("Montako miinaa? ");
        foo.ruudut.MIINOITA(Integer.parseInt(lukija.nextLine()));

        foo.ruudut.laskeArvot();

        while (true) {
            //ebin tää on infinite loop
            System.out.println("Anna vaaka- ja pystykoordinaatit (kirjain-numero, ilman välilyöntiä): ");
            String garr = lukija.nextLine();
            int syotteenPituus = garr.length();
            int indeksi = 0;
            garr = garr.toUpperCase();
            ArrayList<Integer> syote = new ArrayList<Integer>();
            while (syotteenPituus > 0) {

                syote.add((int) garr.charAt(indeksi));
                syotteenPituus--;
                indeksi++;
            }
            if (syote.size() < 2 || syote.size() > 3) {
                System.out.println("Ei kelpaa.");
                continue;
            } else if (syote.get(0) < 'A' || syote.get(0) > 'J') {
                System.out.println("Ei kelpaa.");
                continue;
            } else if (syote.size() == 2 && syote.get(1) < '1') {
                System.out.println("Ei kelpaa.");
                continue;
            } else if (syote.size() == 2 && syote.get(1) > '9') {
                System.out.println("Ei kelpaa.");
                continue;
            } else if (syote.size() == 3 && syote.get(1) != '1') {
                System.out.println("Ei kelpaa.");
                continue;
            } else if (syote.size() == 3 && syote.get(2) > '0') {
                System.out.println("Ei kelpaa.");
                continue;
            }
            String kirjain = "" + garr.charAt(0);
            int numero = Integer.parseInt("" + garr.substring(1));
            System.out.println("");

            //koordinaatisto meh = new koordinaatisto();
            //meh.laskeArvot();
            //meh.tulosta();
            foo.AvaaRuutu(kirjain, numero);
            foo.Tulostettava();
            System.out.println("");
            //System.out.println(meh.miinoitetutRuudut());

            if (foo.Havio()) {
                break;
            }
            if (foo.Voitto()) {
                System.out.println("Ebin! Voitit. :D");
                System.out.println("");
                break;
            }
        }
    }
}
