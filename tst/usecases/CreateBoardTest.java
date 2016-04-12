package game.usecases;

import game.Controller;
import game.controllers.Interactor;
import game.controllers.Presenter;
import game.entitiies.Board;
import game.factories.BoardFactoryImpl;
import game.interactors.BoardGateway;
import game.interactors.createboard.CreateBoardInteractor;
import game.presenters.PresenterEn;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class CreateBoardTest {

    @Test
    public void testCreateBoard() throws IOException {
        ViewMock view = new ViewMock();
        Presenter presenter = new PresenterEn();
        BoardGateway gateway = new Board(new BoardFactoryImpl());
        Interactor interactor = new CreateBoardInteractor(presenter, gateway);
        Controller controller = new CreateBoardControllerFake(view, interactor, presenter);
        String expected = "Select versions of board you would like to use.\n" +
                "Available boards: FRA, USA\n" +
                "USA versions of board created.\n";

        controller.execute();

        assertTrue(view.VerifyOutputMethodCalled(expected));
    }
}