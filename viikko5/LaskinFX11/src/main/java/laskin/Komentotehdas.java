
package laskin;

import java.util.HashMap;

public class Komentotehdas {
    private HashMap<String, Komento> komennot;
    private Komento tuntematon;

    public Komentotehdas(IO io) {
        komennot = new HashMap<String, Komento>();
        komennot.put("summa", new Summa(io));
        tuntematon = new Tuntematon(io);
    }

    public Komento hae(String operaatio) {
        return komennot.getOrDefault(operaatio, tuntematon);
    }
}