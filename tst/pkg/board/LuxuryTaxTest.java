package pkg.board;

import org.junit.Test;
import pkg.monopoly.OwnershipMultiplier;
import pkg.monopoly.Player;
import pkg.monopoly.SourceOfMoveMultiplier;

import static org.junit.Assert.assertEquals;

public class LuxuryTaxTest {


    @Test
    public void testLandOnLuxuryTaxAndCashDecreasesBy75(){
    final int AFTER_TAX_BALANCE = 1425;
        LuxuryTax luxuryTax = (LuxuryTax) SpaceFactory.create("LuxuryTax","Luxury Tax");
        Player player = new Player("Cat");
        luxuryTax.landOn(player, new SourceOfMoveMultiplier(), new OwnershipMultiplier());
        assertEquals(AFTER_TAX_BALANCE, player.getCashBalance());
    }
}
