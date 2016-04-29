package game.manager;

import game.controllers.Controller;
import game.controllers.Handler;
import game.parser.ParserManager;

import java.io.IOException;

public abstract class StateManager implements ParserManager {

    private State state;
    final ControllerFactory factory;
    Controller controller;

    StateManager(ControllerFactory factory) {
        this.factory = factory;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void initialize() throws IOException {
        state.initialize(this);
    }

    @Override
    public void invalidEntry() throws IOException {
        initialize();
    }

    @Override
    public void validTextEntry(String result) throws IOException {
        ((Handler)controller).handle(result);
        state.validTextEntry(this);
    }

    @Override
    public void zeroEntered() throws IOException {
        state.zeroEntered(this);
    }

    @Override
    public void oneEntered() {
        state.oneEntered(this);
    }

    @Override
    public void twoEntered() {
        state.twoEntered(this);

    }

    public abstract void createAndExecuteController(String commandString) throws IOException;
}
