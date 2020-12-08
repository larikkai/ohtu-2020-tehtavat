
package ohtu.kivipaperisakset.game;

import java.util.HashMap;
import ohtu.kivipaperisakset.io.IO;

public class GameFactory {
    
    private final HashMap<String, KiviPaperiSakset> games;
    private final IO io;
    
    public GameFactory(IO io) {
        this.io = io;
        games = new HashMap<String, KiviPaperiSakset>();
        games.put("PlayerVSPlayer", new KPSPelaajaVsPelaaja(io));
        games.put("VSTekoaly", new KPSTekoaly(io));
        games.put("VSParempiTekoAly", new KPSParempiTekoaly(io));
    }
    
    public KiviPaperiSakset hae(String game) {
        io.print("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        return games.get(game);
    }
    
}
