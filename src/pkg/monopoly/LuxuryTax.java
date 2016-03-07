package pkg.monopoly;

public class LuxuryTax extends Space {

    public LuxuryTax(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player, String sourceOfMove, SourceOfMoveMultiplier sourceOfMoveMultiplier) {
        final int LUXURY_TAX_AMOUNT = -75;
        player.transaction(LUXURY_TAX_AMOUNT, "Cash");
    }
}
