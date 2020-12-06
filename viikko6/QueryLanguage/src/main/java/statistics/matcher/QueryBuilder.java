
package statistics.matcher;

import java.util.ArrayList;

public class QueryBuilder {
    
    private And and;
    private final ArrayList<Matcher> matcherList;
    
    public QueryBuilder() {
        matcherList = new ArrayList<Matcher>();
        matcherList.add(new All());
    }
    
    public QueryBuilder playsIn(String teamName) {
        this.matcherList.add(new PlaysIn(teamName));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcherList.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcherList.add(new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.matcherList.add(new Or(m1, m2));
        return this;
    }
    
    public And build() {
        Matcher[] matchers = new Matcher[matcherList.size()];
        matchers = matcherList.toArray(matchers);
        this.and = new And(matchers);
        matcherList.clear();
        return this.and;
    }
}
