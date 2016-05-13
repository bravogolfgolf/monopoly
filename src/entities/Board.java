package game.entities;

import game.interactors.movetoken.MoveTokenBoardGateway;
import game.interactors.passgo.PassGoBoardGateway;
import game.interactors.tokenoptions.TokenOptionsBoardGateway;
import game.manager.State;
import game.manager.StateImpl;

import java.util.List;

public class Board implements TokenOptionsBoardGateway, PassGoBoardGateway, MoveTokenBoardGateway {

    private final List<Space> board;

    protected Board(List<Space> board) {
        this.board = board;
    }

    public static Board create(List<Space> spaces) {
        for (int i = 1; i < spaces.size(); i++)
            spaces.get(i - 1).setNextSpace(spaces.get(i));
        spaces.get(39).setNextSpace(spaces.get(0));
        return new Board(spaces);
    }

    @Override
    public boolean move(Token token) {
        boolean passedGo = false;
        Space space = token.space.nextSpace;
        for (int i = 1; i < token.move; i++) {
            if (!passedGo)
                passedGo = space.passedGO();
            space = space.nextSpace;
        }
        token.space = space;
        return passedGo;
    }

    @Override
    public void setInitialSpace(Token token) {
        token.space = board.get(0);
    }

    @Override
    public String getInitialSpaceDescription() {
        return board.get(0).getDescription();
    }

    public abstract static class Space {

        private final int spaceID;
        private final String description;
        private Space nextSpace;

        private Space(int spaceID, String description) {
            this.spaceID = spaceID;
            this.description = description;
        }

        public int getSpaceID() {
            return spaceID;
        }

        public String getDescription() {
            return description;
        }

        private void setNextSpace(Space nextSpace) {
            this.nextSpace = nextSpace;
        }

        protected boolean passedGO() {
            return false;
        }

        public abstract State determineState();

        public static class Go extends Space {

            public Go(int ID, String description) {
                super(ID, description);
            }

            @Override
            public boolean passedGO() {
                return true;
            }

            @Override
            public State determineState() {
                return StateImpl.PASS_GO;
            }
        }

        public static class JustVisiting extends Space {
            public JustVisiting(int ID, String description) {
                super(ID, description);
            }

            @Override
            public State determineState() {
                return null;
            }
        }

        public static class FreeParking extends Space {
            public FreeParking(int ID, String description) {
                super(ID, description);
            }

            @Override
            public State determineState() {
                return null;
            }
        }

        public static class GoToJail extends Space {
            public GoToJail(int ID, String description) {
                super(ID, description);
            }

            @Override
            public State determineState() {
                return null;
            }
        }

        public static class RealEstate extends Space {
            public RealEstate(int ID, String description) {
                super(ID, description);
            }

            @Override
            public State determineState() {
                return null;
            }
        }

        public static class Railroad extends Space {
            public Railroad(int ID, String description) {
                super(ID, description);
            }

            @Override
            public State determineState() {
                return null;
            }
        }

        public static class Utility extends Space {
            public Utility(int ID, String description) {
                super(ID, description);
            }

            @Override
            public State determineState() {
                return null;
            }
        }

        public static class CommunityChest extends Space {
            public CommunityChest(int ID, String description) {
                super(ID, description);
            }

            @Override
            public State determineState() {
                return null;
            }
        }

        public static class Chance extends Space {
            public Chance(int ID, String description) {
                super(ID, description);
            }

            @Override
            public State determineState() {
                return null;
            }
        }

        public static class IncomeTax extends Space {
            public IncomeTax(int ID, String description) {
                super(ID, description);
            }

            @Override
            public State determineState() {
                return null;
            }
        }

        public static class LuxuryTax extends Space {
            public LuxuryTax(int ID, String description) {
                super(ID, description);
            }

            @Override
            public State determineState() {
                return null;
            }
        }
    }
}