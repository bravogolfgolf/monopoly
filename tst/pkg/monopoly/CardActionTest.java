package pkg.monopoly;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardActionTest {

    public static final int PASS_GO = 200;
    public static final int PRICE_OF_ILLINOIS_AVENUE = 240;
    private Game game;
    private List<Space> board;
    private Go go;
    private CommunityChest communityChest;
    private Player player1;
    private Player player2;
    private RealEstate mediterranean;
    private RealEstate baltic;
    private Chance chance;
    private RealEstate illinoisAve;

    @Before
    public void setUp() throws Exception {
        game = new Game("US");
        board = game.getBoard();
        go = (Go) board.get(0);
        communityChest = (CommunityChest) board.get(2);
        chance = (Chance) board.get(36);
        player1 = new Player("Cat");
        player1.setSpace(communityChest);
        player2 = new Player("Dog");
        player2.setSpace(chance);
        mediterranean = (RealEstate) board.get(1);
        baltic = (RealEstate) board.get(3);
        illinoisAve = (RealEstate) board.get(24);
    }

    @After
    public void teardown() {
        game = null;
        board = null;
        go = null;
        communityChest = null;
        chance = null;
        player1 = null;
        player2 = null;
        mediterranean = null;
        baltic = null;
        illinoisAve = null;
    }

    @Test
    public void testGetOutOfJailCardAction() throws GoToJail.GoToJailException {
        Card.clearCards();
        Card getOutOfJail = Card.create("CommunityChest", "Get out of Jail Free – This card may be kept until needed or sold", "GetOutOfJail");
        createCommunityChestCard(getOutOfJail);
        assertTrue(player1.getSpace().equals(communityChest));
        int endingBalance = player1.getCashBalance();
        getOutOfJail.action(player1);
        assertTrue(player1.getSpace().equals(communityChest));
        assertEquals(endingBalance, player1.getCashBalance());
        assertTrue(getOutOfJail.equals(player1.getCard()));
    }

    @Ignore
    public void testMoveBackCardAction() throws GoToJail.GoToJailException {;}

    @Ignore
    public void testMoveForwardNextCardAction() throws GoToJail.GoToJailException {;}

    @Ignore
    public void testMoveForwardSpecificCardAction() throws GoToJail.GoToJailException {
        Card.clearCards();
        Card move = Card.create("Chance", "Advance to Illinois Ave. - If you pass Go, collect $200", "MoveForwardSpecific", "Illinois Avenue");
        createChanceCard(move);
        assertTrue(player2.getSpace().equals(chance));
        int endingBalance = player2.getCashBalance() + PASS_GO;
        endingBalance -= PRICE_OF_ILLINOIS_AVENUE;
        assertEquals(1, Card.getChanceCards().size());
        chance.landOn(player2);
        assertTrue(player2.getSpace().equals(illinoisAve));
        assertEquals(endingBalance, player2.getCashBalance());
        assertEquals(1, Card.getChanceCards().size());
    }

    @Ignore //(expected = GoToJail.GoToJailException.class)
    public void testMoveJail() throws GoToJail.GoToJailException {
        Card.clearCards();
        Card goToJail = Card.create("CommunityChest", "Go to Jail – Go directly to jail – Do not pass Go – Do not collect $200", "MoveJail", "Go to Jail");
        createCommunityChestCard(goToJail);
        assertEquals(1, Card.getCommunityChestCards().size());
        assertTrue(player1.getSpace().equals(communityChest));
        communityChest.landOn(player1);
    }

    @Test
    public void testRepairsCardAction() throws GoToJail.GoToJailException {
        Card.clearCards();
        Card repairs = Card.create("CommunityChest", "You are assessed for street repairs – $40 per house – $115 per hotel", "Repairs", 40, 115);
        createCommunityChestCard(repairs);

        int endingBalance = player1.getCashBalance() - ((40 * 4) + 115);
        assertTrue(player1.getSpace().equals(communityChest));
        mediterranean.setOwner(player1);
        baltic.setOwner(player1);
        addFourHouses(mediterranean);
        addHotel(baltic);
        repairs.action(player1);
        assertTrue(player1.getSpace().equals(communityChest));
        assertEquals(endingBalance, player1.getCashBalance());
    }

    private void addHotel(RealEstate realEstate) {
        realEstate.addImprovements();
        realEstate.addImprovements();
        realEstate.addImprovements();
        realEstate.addImprovements();
        realEstate.addImprovements();
    }

    private void addFourHouses(RealEstate realEstate) {
        realEstate.addImprovements();
        realEstate.addImprovements();
        realEstate.addImprovements();
        realEstate.addImprovements();
    }

    @Test
    public void testLandOnDrawsTransactionCardForBank() throws GoToJail.GoToJailException {
        Card.clearCards();
        Card transaction = Card.create("CommunityChest", "Bank error in your favor – Collect $200", "Transaction", 200, "Bank");
        createCommunityChestCard(transaction);
        assertTrue(player1.getSpace().equals(communityChest));
        int endingBalance = player1.getCashBalance() + 200;
        assertEquals(1, Card.getCommunityChestCards().size());
        transaction.action(player1);
        assertTrue(player1.getSpace().equals(communityChest));
        assertEquals(endingBalance, player1.getCashBalance());
        assertEquals(1, Card.getCommunityChestCards().size());
    }

    @Test
    public void testTransactionCardActionForPlayers() throws GoToJail.GoToJailException {
        Player player2 = new Player("Dog");
        Player player3 = new Player("Ship");

        player1.setNextPlayer(player2);
        player2.setNextPlayer(player3);
        player3.setNextPlayer(player1);

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);

        Card.clearCards();
        Card transaction = Card.create("CommunityChest", "Grand Opera Night – Collect $50 from every player for opening night seats", "Transaction", 50, "Players");
        createCommunityChestCard(transaction);

        assertTrue(player1.getSpace().equals(communityChest));
        int player1EndingBalance = player1.getCashBalance() + 100;
        int player2EndingBalance = player2.getCashBalance() - 50;
        int player3EndingBalance = player3.getCashBalance() - 50;

        transaction.action(player1);
        assertTrue(player1.getSpace().equals(communityChest));
        assertEquals(player1EndingBalance, player1.getCashBalance());
        assertEquals(player2EndingBalance, player2.getCashBalance());
        assertEquals(player3EndingBalance, player3.getCashBalance());
    }

    private void createCommunityChestCard(Card card) {
        List<Card> cards = new ArrayList<Card>();
        cards.add(card);
        Card.addCommunityChestCards(cards);
    }

    private void createChanceCard(Card card) {
        List<Card> cards = new ArrayList<Card>();
        cards.add(card);
        Card.addChanceCards(cards);
    }
}