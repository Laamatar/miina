package miina;

public class ruutu {

    private String kirjain;
    private int numero;
    private boolean miina;
    private int arvo;
    private boolean auki;

    public ruutu(String kirjain, int numero) {
        this.kirjain = kirjain;
        this.numero = numero;
        this.miina = false;
        this.auki = false;
    }

    public void Miinoita() {
        this.miina = true;
    }

    public boolean OnkoMiina() {
        return this.miina;
    }
    
    public String toString(){
        return this.kirjain + this.numero;
        
    }
    public void Aukaise(){
        this.auki = true;
    }
    
    public boolean OnkoAuki(){
        return this.auki;
    }
    

}
