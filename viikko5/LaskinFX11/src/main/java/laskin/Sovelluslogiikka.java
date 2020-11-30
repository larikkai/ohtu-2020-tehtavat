package laskin;

public class Sovelluslogiikka {
 
    private int tulos;
    private Komentotehdas komennot;
    private IO io;
    
    public Sovelluslogiikka(IO io) {
        this.io = io;
        this.komennot = new Komentotehdas(io);
    }
    
    public void suorita() {
        while (true) {
            String komento = io.readString();
            komennot.hae(komento).suorita();
        }
    }
 
    /*public void plus(int luku) {
        tulos += luku;
    }
     
    public void miinus(int luku) {
        tulos -= luku;
    }
 
    public void nollaa() {
        tulos = 0;
    }
 
    public int tulos() {
        return tulos;
    }*/
}