package game;

import game.display.Console;
import game.entities.Banker;
import game.factories.ControllerFactory;
import game.factories.InteractorFactory;
import game.factories.VersionFactory;
import game.manager.StateImpl;
import game.manager.StateManager;
import game.parser.Parser;
import game.presenters.Presenter;
import game.presenters.PresenterEn;

import java.io.IOException;

final class Monopoly {

    private final Parser parser = new Parser();
    private final Console console = new Console(parser);
    private final VersionFactory versionFactory = new VersionFactory();
    private final Banker banker = new Banker();
    private StateManager manager;

    public static void main(String[] args) throws IOException {
        Monopoly monopoly = new Monopoly();
        monopoly.setup(StateImpl.VERSION);
        monopoly.start();
    }

    private void setup(StateImpl state) throws IOException {
        final Presenter presenter = new PresenterEn(console, parser);
        final InteractorFactory interactorFactory = new InteractorFactory(presenter, versionFactory, banker);
        final ControllerFactory controllerFactory = new ControllerFactory(presenter, interactorFactory, console);
        manager = new StateManager(controllerFactory);
        parser.setManager(manager);
        manager.setState(state);
    }

    private void start() throws IOException {
        manager.initialize();

    }
}