
package ohtu.kivipaperisakset.command;

import ohtu.kivipaperisakset.command.Command;
import ohtu.kivipaperisakset.game.GameFactory;

public class VSPlayer extends Command {

    @Override
    public void suorita(GameFactory gf) {
        gf.hae("PlayerVSPlayer").pelaa();
    }
    
}
