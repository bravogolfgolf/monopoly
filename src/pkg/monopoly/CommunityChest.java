package pkg.monopoly;

public class CommunityChest extends Space {
    public CommunityChest(String description) {
        setDescription(description);
    }

    @Override
    public void landOn(Player player) throws GoToJail.GoToJailException {
        Card card = Card.drawCard("Community Chest");
        card.action(player);
    }

}
