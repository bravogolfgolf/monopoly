package interactors.createboard;

import controllers.Interactor;
import controllers.Presenter;
import interactors.BoardGateway;
import interactors.Request;
import utilities.StringFormatter;

public class CreateBoardInteractor implements Interactor {
    private final Presenter presenter;
    private final BoardGateway gateway;

    public CreateBoardInteractor(Presenter presenter, BoardGateway gateway) {
        this.presenter = presenter;
        this.gateway = gateway;
    }

    @Override
    public void handle(Request request) {
        CreateBoardResponse response = new CreateBoardResponse();
        CreateBoardRequest createBoardRequest = (CreateBoardRequest) request;

        if (createBoardRequest.version == null) {
            response.message = StringFormatter.addNewLine("Select version of board you would like to use.");
            presenter.present(response);

        } else {
            gateway.setVersion(createBoardRequest.version);
            response.message = StringFormatter.addNewLine(String.format("%s version of board created.", gateway.getVersion()));
            presenter.present(response);
        }
    }
}
