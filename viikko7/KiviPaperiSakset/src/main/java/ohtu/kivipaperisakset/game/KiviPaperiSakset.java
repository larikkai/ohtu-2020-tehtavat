package ohtu.kivipaperisakset.game;

import ohtu.kivipaperisakset.domain.Tuomari;
import static ohtu.kivipaperisakset.game.KPSPelaajaVsPelaaja.onkoOkSiirto;
import ohtu.kivipaperisakset.io.IO;

public abstract class KiviPaperiSakset {
    
    final IO io;
    
    public KiviPaperiSakset(IO io) {
        this.io = io;
    }
    
    public void pelaa() {
        
        Tuomari tuomari = new Tuomari();
        String ekanSiirto = ensimmaisenSiirto();
        String tokanSiirto = toisenSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            io.print(tuomari.toString());
            io.print("");
            ekanSiirto = ensimmaisenSiirto();
            tokanSiirto = toisenSiirto();
            asetaSiirto(ekanSiirto);
        }

        io.print("");
        io.print("Kiitos!");
        io.print(tuomari.toString());
    }
    
    protected String ensimmaisenSiirto() {
        return io.readLine("Ensimm√§isen pelaajan siirto: ");
    }

    // t‰m‰ on abstrakti metodi sill‰ sen toteutus vaihtelee eri pelityypeiss‰
    abstract protected String toisenSiirto();
    
    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    abstract protected void asetaSiirto(String ekanSiirto);
}
