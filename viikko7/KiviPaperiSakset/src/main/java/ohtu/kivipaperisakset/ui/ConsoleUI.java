
package ohtu.kivipaperisakset.ui;

import ohtu.kivipaperisakset.command.CommandFactory;
import ohtu.kivipaperisakset.game.GameFactory;
import ohtu.kivipaperisakset.io.ConsoleIO;
import ohtu.kivipaperisakset.io.IO;

public class ConsoleUI {
    
    private final IO io;
    private final CommandFactory commands;
    private final GameFactory games;
    
    public ConsoleUI() {
        this.io = new ConsoleIO();
        this.commands = new CommandFactory(io);
        this.games = new GameFactory(io);
    }
    
    public void play() {
        while (true) {
            io.print("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = io.read();
            commands.hae(vastaus).suorita(games);
        }
    }
}
