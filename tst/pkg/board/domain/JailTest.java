package pkg.board.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pkg.game.OwnershipMultiplier;
import pkg.game.Player;
import pkg.game.SourceOfMoveMultiplier;

import static org.junit.Assert.assertEquals;

public class JailTest {

    private Player player;
    private Jail jail;

    @Before
    public void setUp() {
        player = new Player("Cat");
        jail = new Jail("Jail");
    }

    @After
    public void teardown() {
        player = null;
        jail = null;
    }

    @Test
    public void testLandOn()  {
        int expectedEndingBalance = player.getCashBalance();
        jail.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }

    @Test
    public void testPassBy() {
        int expectedEndingBalance = player.getCashBalance();
        jail.passBy(player);
        assertEquals(expectedEndingBalance, player.getCashBalance());
    }
}
