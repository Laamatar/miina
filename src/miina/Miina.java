package miina;

import java.util.Scanner;

public class Miina {
    
    public static void main(String[] args) {
        
        koordinaatisto meh = new koordinaatisto();
        meh.MIINOITA(10);
        meh.laskeArvot();
        
        meh.tulosta();
        System.out.println(meh.miinoitetutRuudut());    
        }
    }

