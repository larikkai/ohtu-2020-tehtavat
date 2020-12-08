package ohtu.kivipaperisakset.game;

import ohtu.kivipaperisakset.domain.Tekoaly;
import ohtu.kivipaperisakset.io.IO;


public class KPSTekoaly extends KiviPaperiSakset {
    
    private final Tekoaly tekoaly;
    
    public KPSTekoaly(IO io) {
        super(io);
        this.tekoaly = new Tekoaly();
    }

    @Override
    protected String toisenSiirto() {
        String tokanSiirto = tekoaly.annaSiirto();
        io.print("Tietokone valitsi: " + tokanSiirto);
        return tokanSiirto;
    }

    @Override
    protected void asetaSiirto(String ekanSiirto) {
    }

}