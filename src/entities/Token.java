package game.entities;

import game.entities.Board.Space;

public class Token implements Comparable {

    private static final int INITIAL_STARTING_SPACE_ID = 0;
    public final int spaceID = INITIAL_STARTING_SPACE_ID;

    public final TurnState turnState = new TurnState();

    public enum TransactionType {PAY_CASH, RECIEVE_CASH, BUY_PROPERTY, MORTGAGE_PROPERTY, UN_MORTGAGE_PROPERTY}

    private final String description;
    private Space space;
    private int cashBalance = 1500;
    private int netWorth = 1500;

    public Token(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Object o) {
        return this.description.compareTo(((Token) o).description);
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public int cashBalance() {
        return cashBalance;
    }

    public int netWorth() {
        return netWorth;
    }

    public void transaction(int amount, TransactionType type) {
        switch (type) {
            case RECIEVE_CASH:
                cashBalance += amount;
                netWorth += amount;
                break;
            case PAY_CASH:
                cashBalance -= amount;
                netWorth -= amount;
                break;
            case BUY_PROPERTY:
                cashBalance -= amount;
                netWorth += (amount / 2);
                break;
            case MORTGAGE_PROPERTY:
                cashBalance += amount / 2;
                break;
            case UN_MORTGAGE_PROPERTY:
                cashBalance -= (amount / 2) * 1.1;
                break;
        }
    }

    public class TurnState {
        public boolean passedGO = false;
    }
}
