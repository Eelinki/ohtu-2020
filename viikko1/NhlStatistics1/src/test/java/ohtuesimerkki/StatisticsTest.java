package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

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
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchPlayerReturnsCorrectPlayer() {
        assertEquals("Gretzky", stats.search("Gretzky").getName());
    }

    @Test
    public void invalidSearchReturnsNull() {
        assertNull(stats.search("Jauzaa"));
    }

    @Test
    public void correctPlayersInTeam() {
        List<Player> team = stats.team("EDM");

        assertEquals(3, team.size());
        assertEquals("Semenko", team.get(0).getName());
        assertEquals("Kurri", team.get(1).getName());
        assertEquals("Gretzky", team.get(2).getName());
    }

    @Test
    public void correctTopScorers() {
        List<Player> topScorers = stats.topScorers(1);

        assertEquals(2, topScorers.size());
        assertEquals("Gretzky", topScorers.get(0).getName());
        assertEquals("Lemieux", topScorers.get(1).getName());
    }
}