package laskin;

import java.util.HashMap;

public class Sovelluslogiikka {
 
    private HashMap<String, Komento> komennot;
    private Komento tuntemaaton;
    private Komento edellinen;
    
    public Sovelluslogiikka(IO io) {
        komennot = new HashMap<>();
        komennot.put("+", new Plus(io));
        komennot.put("-", new Miinus(io));
        komennot.put("Z", new Nollaa(io)); 
    }
 
    public Komento hae(String operaatio) {
        this.edellinen = komennot.getOrDefault(operaatio, tuntemaaton);
        komennot.put("undo", edellinen);
        //return komennot.getOrDefault(operaatio, tuntemaaton);
        return edellinen;
    }
}