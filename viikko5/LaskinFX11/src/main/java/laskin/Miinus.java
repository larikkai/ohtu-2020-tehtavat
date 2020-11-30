
package laskin;

public class Miinus extends Komento {
    
    int edellinenTulos;
    int nykyinenTulos;
    
    public Miinus(IO io) {
        super(io);
    }

    @Override
    public void suorita() {
        this.edellinenTulos = io.getResult();
        try {
            nykyinenTulos = edellinenTulos+Integer.parseInt(io.readString());
        } catch (Exception e) {
        }
        io.setResult(nykyinenTulos);
    }  

    @Override
    public void peru() {
        io.setResult(edellinenTulos);
    }
}