package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka k‰ytt‰‰ "stubia"
        stats = new Statistics(readerStub);
    }
    @Test
    public void pelaajalistaltaLoytyyLuotuPelaaja() {
        Player p = new Player("Semenko", "EDM", 4, 12);
        assertEquals(0, stats.search("Semenko").compareTo(p));
    }
    
    @Test
    public void palauttaaNullJosPelaajaaEiLoydy() {
        assertEquals(null, stats.search("Selanne"));
    }
    
    @Test
    public void kontruktorissaLuodaanPelaajaListaJossaKolmeEdmonttonista() {
        assertEquals(3, stats.team("EDM").size());
    }
    
    @Test
    public void enitenPisteitaPelaajalla () {
        assertEquals("Gretzky", stats.topScorers(0).get(0).getName());
    }
}
