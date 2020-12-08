package ohtu.kivipaperisakset.game;

import ohtu.kivipaperisakset.io.IO;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {

    public KPSPelaajaVsPelaaja(IO io) {
        super(io);
    }

    @Override
    protected String toisenSiirto() {
        return io.readLine("Toisen pelaajan siirto: ");
    }

    @Override
    protected void asetaSiirto(String ekanSiirto) {
    }
}