package game.interactors.setupgame;

import game.controllers.Interactor;
import game.interactors.InteractorRequest;
import game.interactors.PresenterEnMock;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SelectVersionTest {

    private final PresenterEnMock presenter = new PresenterEnMock();
    private final SelectVersionFactoryFake factory = new SelectVersionFactoryFake();
    private final Interactor interactor = new SelectVersion(presenter, factory);
    private final InteractorRequest request = new InteractorRequest();

    @Test
    public void testValidRequest() {
        request.string = "Valid";
        interactor.handle(request);

        assertTrue(factory.verifyCreateMethodCalled);
        assertTrue(presenter.verifyVersionCreatedMessage);
    }

    @Test
    public void testUserInterfaceOptions() {
        interactor.userInterfaceOptions();

        assertTrue(factory.verifyGetAvailableVersionsCalled);
        assertTrue(presenter.verifyAvailableVersionsMessageCalled);
    }
}