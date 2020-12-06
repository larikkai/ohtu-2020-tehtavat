
package statistics.matcher;

import statistics.Player;

public class Or implements Matcher {
    
    private Matcher[] matchers;
    
    public Or(Matcher... matcher) {
        this.matchers = matcher;
    }

    public boolean matches(Player p) {
        for(Matcher matcher : matchers) {
            if(matcher.matches(p))return true;
        }
        return false;
    }
    
}
