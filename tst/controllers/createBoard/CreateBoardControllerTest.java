package game.controllers.createBoard;

import game.Controller;
import game.controllers.Presenter;
import game.controllers.PresenterEnDummy;
import game.controllers.View;
import game.controllers.ViewDummy;
import game.interactors.BoardGateway;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class CreateBoardControllerTest {

    @Test
    public void testCreateBoardController() throws IOException {
        View view = new ViewDummy();
        Presenter presenter = new PresenterEnDummy();
        BoardGateway gateway = new BoardGatewayDummy();
        CreateBoardInteractorMock interactor = new CreateBoardInteractorMock(presenter, gateway);
        Controller controller = new CreateBoardControllerStub(view, interactor, presenter);
        controller.execute();
        assertTrue(interactor.VerifyHandleMethodCalled);
    }
}