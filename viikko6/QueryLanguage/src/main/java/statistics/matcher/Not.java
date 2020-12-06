
package statistics.matcher;

import statistics.Player;

public class Not implements Matcher {
    
    private final Matcher matcher;
    
    public Not(Matcher matcher) {
        this.matcher = matcher;
    }
    
    public boolean matches(Player p) {
        return !this.matcher.matches(p);
    }
    
}
