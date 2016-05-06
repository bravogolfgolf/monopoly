package game.fitnesse;

import game.factories.ControllerFactory;
import game.factories.VersionFactory;
import game.manager.StateImpl;
import game.manager.StateManager;
import game.manager.StateManagerImpl;
import game.parser.Parser;
import game.presenters.Presenter;
import game.presenters.PresenterEn;
import game.repositories.Players;

import java.io.IOException;

final class FitnesseSetup {

    public final Parser parser = new Parser();
    public final FitnesseConsole console = new FitnesseConsole(parser);
    private final Players players = new Players();
    private final VersionFactory factory = new VersionFactory();
    private StateManager manager;

    public void setup(StateImpl state) throws IOException {
        final Presenter presenter = new PresenterEn(console, parser);
        final ControllerFactory controllerFactory = new ControllerFactory(presenter, factory, players, console);
        manager = new StateManagerImpl(controllerFactory);
        parser.setManager(manager);
        manager.setState(state);
    }

    public void start() throws IOException {
        manager.initialize();
    }
}