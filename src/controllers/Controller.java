package game.controllers;

import game.parser.ControllerConsole;

import java.io.IOException;

public abstract class Controller {

    protected final ControllerConsole console;

    public Controller(ControllerConsole console) {
        this.console = console;
    }

    public abstract void execute() throws IOException;
}
