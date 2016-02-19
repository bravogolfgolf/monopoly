package pkg.monopoly;

public class Go extends Space {

    public Go(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player) {
        player.changeCashBalanceBy(200);
    }

    @Override
    public void passBy(Player player) {
        landOn(player);
    }
}
