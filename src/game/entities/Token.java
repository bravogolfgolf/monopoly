package game.entities;

import game.entities.Board.Space;

public class Token implements Comparable {

    private final String description;
    private Space space;
    private int move;
    private boolean inJail;
    private int cashBalance = 1500;
    private int netWorth = 1500;

    public Token(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public void goToJail() {
        inJail = true;
    }

    public boolean isInJail() {
        return inJail;
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

    @Override
    public int compareTo(Object o) {
        return this.description.compareTo(((Token) o).description);
    }

    public enum TransactionType {PAY_CASH, RECIEVE_CASH, BUY_PROPERTY, MORTGAGE_PROPERTY, UN_MORTGAGE_PROPERTY}
}
