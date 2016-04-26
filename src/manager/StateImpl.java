package game.manager;

import java.io.IOException;

public enum StateImpl implements State {

    VERSION {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createController("VersionOptions");
            manager.callHandleOnController();

            manager.createController("SelectVersion");
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_0);
            manager.initialize();
        }
    },

    CREATE_PLAYER_0 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createController("TokenOptionsFewerThanMinimum");
            manager.callHandleOnController();

            manager.createController("CreatePlayer");
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_1);
            manager.initialize();
        }
    },

    CREATE_PLAYER_1 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createController("TokenOptionsFewerThanMinimum");
            manager.callHandleOnController();

            manager.createController("CreatePlayer");
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_2);
            manager.initialize();

        }
    },

    CREATE_PLAYER_2 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createController("TokenOptionsMinimumToMaximum");
            manager.callHandleOnController();

            manager.createController("CreatePlayer");
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
            manager.setState(GAME_OVER);

            manager.createController("SelectFirst");
            manager.callHandleOnController();

            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_3);
            manager.initialize();
        }
    },

    CREATE_PLAYER_3 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createController("TokenOptionsMinimumToMaximum");
            manager.callHandleOnController();

            manager.createController("CreatePlayer");
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
            manager.setState(GAME_OVER);

            manager.createController("SelectFirst");
            manager.callHandleOnController();

            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_4);
            manager.initialize();
        }
    },

    CREATE_PLAYER_4 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createController("TokenOptionsMinimumToMaximum");
            manager.callHandleOnController();

            manager.createController("CreatePlayer");
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
            manager.setState(GAME_OVER);

            manager.createController("SelectFirst");
            manager.callHandleOnController();

            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_5);
            manager.initialize();
        }
    },

    CREATE_PLAYER_5 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createController("TokenOptionsMinimumToMaximum");
            manager.callHandleOnController();

            manager.createController("CreatePlayer");
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
            manager.setState(GAME_OVER);

            manager.createController("SelectFirst");
            manager.callHandleOnController();

            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_6);
            manager.initialize();
        }
    },

    CREATE_PLAYER_6 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createController("TokenOptionsMinimumToMaximum");
            manager.callHandleOnController();

            manager.createController("CreatePlayer");
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
            manager.setState(GAME_OVER);

            manager.createController("SelectFirst");
            manager.callHandleOnController();

            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(CREATE_PLAYER_7);
            manager.initialize();
        }
    },

    CREATE_PLAYER_7 {
        @Override
        public void initialize(StateManager manager) throws IOException {
            manager.createController("TokenOptionsMinimumToMaximum");
            manager.callHandleOnController();

            manager.createController("CreatePlayer");
            manager.readView();
        }

        @Override
        public void validNumber(StateManager manager) throws IOException {
            manager.setState(GAME_OVER);

            manager.createController("SelectFirst");
            manager.callHandleOnController();

            manager.initialize();
        }

        @Override
        public void validTextEntry(StateManager manager) throws IOException {
            manager.setState(GAME_OVER);

            manager.createController("SelectFirst");
            manager.callHandleOnController();

            manager.initialize();
        }
    },

    GAME_OVER {
        @Override
        public void initialize(StateManager manager) throws IOException {

        }

        @Override
        public void validNumber(StateManager manager) {

        }

        @Override
        public void validTextEntry(StateManager manager) {

        }
    }
}
