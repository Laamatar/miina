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

    public String toString() {
        return this.kirjain + this.numero + " Miina:" + this.OnkoMiina() + " Arvo:" + this.arvo;

    }

    public void Aukaise() {
        this.auki = true;
    }

    public boolean OnkoAuki() {
        return this.auki;
    }

    public int ruudunIndeksi() {
        int rivi = this.numero - 1;
        String kirjaimet = "ABCDEFGHIJ";
        int sarake = kirjaimet.indexOf(this.kirjain);

        return sarake * 10 + rivi;
    }

    public int Sarake() {
        String kirjaimet = "ABCDEFGHIJ";
        int sarake = kirjaimet.indexOf(this.kirjain);

        return sarake;
    }

    public int Rivi() {
        return this.numero - 1;
    }

    public void lisaaArvo() {
        this.arvo++;
    }
    
    public int annaArvo() {
        return this.arvo;
    }

}
