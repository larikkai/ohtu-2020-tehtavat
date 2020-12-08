package ohtu.kivipaperisakset.game;

import ohtu.kivipaperisakset.domain.TekoalyParannettu;
import ohtu.kivipaperisakset.io.IO;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSakset {

    private final TekoalyParannettu tekoaly;
    
    public KPSParempiTekoaly(IO io) {
        super(io);
        this.tekoaly = new TekoalyParannettu(20);
    }

    @Override
    protected String toisenSiirto() {
        String tokanSiirto = tekoaly.annaSiirto();
        io.print("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }

    @Override
    protected void asetaSiirto(String ekanSiirto) {
        tekoaly.asetaSiirto(ekanSiirto);
    }
}
