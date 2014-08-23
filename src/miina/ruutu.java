package miina;

public class ruutu {

    private String kirjain;
    private int numero;
    private boolean miina;
    private int arvo;

    public ruutu(String kirjain, int numero) {
        this.kirjain = kirjain;
        this.numero = numero;
        this.miina = false;
    }

    public void Miinoita() {
        this.miina = true;
    }

    public boolean OnkoMiina() {
        return this.miina;
    }
    
    
    

}
