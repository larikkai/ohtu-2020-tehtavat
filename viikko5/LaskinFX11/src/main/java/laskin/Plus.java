
package laskin;

public class Plus extends Komento {
    
    int edellinenTulos;
    int nykyinenTulos;
    
    public Plus(IO io) {
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
