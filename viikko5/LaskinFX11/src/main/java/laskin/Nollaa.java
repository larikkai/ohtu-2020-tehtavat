
package laskin;

public class Nollaa extends Komento {
    
    int edellinenTulos;
    
    public Nollaa(IO io) {
        super(io);
    }

    @Override
    public void suorita() {
        this.edellinenTulos = io.getResult();
        io.setResult(0);
    }
    
    @Override
    public void peru() {
        io.setResult(edellinenTulos);
    }
}