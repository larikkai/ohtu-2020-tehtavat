
package ohtu.kivipaperisakset.command;

import ohtu.kivipaperisakset.game.GameFactory;

public class VSParempiTekoAly extends Command {

    @Override
    public void suorita(GameFactory gf) {
        gf.hae("VSParempiTekoAly").pelaa();
    }
    
}
