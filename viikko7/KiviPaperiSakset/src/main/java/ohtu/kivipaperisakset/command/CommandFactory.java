
package ohtu.kivipaperisakset.command;

import java.util.HashMap;
import ohtu.kivipaperisakset.io.IO;

public class CommandFactory {
    
    private final HashMap<String, Command> commands;
    private final Command unknown;
    
    public CommandFactory(IO io) {
        commands = new HashMap<String, Command>();
        commands.put("a", new VSPlayer());
        commands.put("b", new VSTekoaly());
        commands.put("c", new VSParempiTekoAly());
        unknown = new Unknown();
    }
    
    public Command hae(String command) {
        return commands.getOrDefault(command, unknown);
    }
}
