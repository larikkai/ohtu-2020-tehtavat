
package ohtu.kivipaperisakset.command;

import ohtu.kivipaperisakset.command.Command;
import ohtu.kivipaperisakset.game.GameFactory;
import ohtu.kivipaperisakset.game.GameFactory;

public class Unknown extends Command{

    @Override
    public void suorita(GameFactory gf) {
         System.exit(0);
    }
    
}
