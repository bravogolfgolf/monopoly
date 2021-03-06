package game.display;

import game.controllers.ControllerConsole;
import game.presenters.PresenterConsole;

import java.io.*;

public class Console implements ControllerConsole, PresenterConsole {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final ConsoleParser parser;

    public Console(ConsoleParser parser) {
        this.parser = parser;
    }

    @Override
    public void read() throws IOException {
        parser.parse(reader.readLine());
    }

    @Override
    public void write(String text) throws IOException {
        writer.write(text);
        writer.flush();
    }
}
