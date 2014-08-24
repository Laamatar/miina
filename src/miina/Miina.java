package miina;

import java.util.Scanner;

public class Miina {

    public static void main(String[] args) {
        Ruudukko foo = new Ruudukko();
        Scanner lukija = new Scanner(System.in);
        System.out.println("Montako miinaa? ");
        foo.ruudut.MIINOITA(Integer.parseInt(lukija.nextLine()));
        
        while(true){
        //ebin tää on infinite loop
        System.out.println("Anna vaaka- ja pystykoordinaatit (kirjain-numero, ilman välilyöntiä ja isolla): ");
        String garr = lukija.nextLine();
        String kirjain = "" + garr.charAt(0);
        int numero = Integer.parseInt(""+garr.charAt(1));
        
        

        //koordinaatisto meh = new koordinaatisto();
        //meh.laskeArvot();
        //meh.tulosta();

        foo.ruudut.laskeArvot();
        foo.AvaaRuutu(kirjain, numero);
        foo.Tulostettava();
        //System.out.println(meh.miinoitetutRuudut());
        }
    }
}
