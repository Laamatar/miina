package miina;

import java.util.Scanner;

public class Miina {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Anna vaakakoordinaatti: ");
        String kirjain = lukija.nextLine();
        System.out.println("Anna pystykoordinaatti: ");
        int numero = Integer.parseInt(lukija.nextLine());

        koordinaatisto meh = new koordinaatisto();
        meh.laskeArvot();
        meh.tulosta();
        System.out.println(meh.miinoitetutRuudut());

    }
}
