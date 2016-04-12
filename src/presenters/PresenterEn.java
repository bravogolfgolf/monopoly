package game.presenters;

import game.controllers.Presenter;
import game.interactors.createboard.CreateBoardResponse;
import game.interactors.createplayer.CreatePlayerResponse;

import java.util.Arrays;

public class PresenterEn extends Presenter {
    private String template;
    private CharSequence[] charSequences;
    private String variable;
    private String formattedMessage;


    @Override
    public void boardCreatedMessage(CreateBoardResponse response) {
        template = "%s versions of board created.";
        charSequences = response.versions;
        variable = arrayToCommaDelimitedString(charSequences);
        formattedMessage = formatMessage(template, variable);
        addToBuffer(formattedMessage);
    }

    @Override
    public void availableBoardsMessage(CreateBoardResponse response) {
        template = "Available boards: %s";
        Arrays.sort(response.versions);
        charSequences = response.versions;
        variable = arrayToCommaDelimitedString(charSequences);
        formattedMessage = formatMessage(template, variable);
        addToBuffer(formattedMessage);
    }

    @Override
    public void boardPromptMessage() {
        template = "Select versions of board you would like to use.";
        formattedMessage = formatMessage(template, null);
        addToBuffer(formattedMessage);
    }

    @Override
    public void exceededPlayerLimitMessage() {
        template = "Exceeded eight player limit.";
        formattedMessage = formatMessage(template, null);
        addToBuffer(formattedMessage);
    }

    @Override
    public void playerCreatedMessage(CreatePlayerResponse response) {
        template = "Player created with %s tokens.";
        charSequences = response.tokens;
        variable = arrayToCommaDelimitedString(charSequences);
        formattedMessage = formatMessage(template, variable);
        addToBuffer(formattedMessage);
    }

    @Override
    public void playerPromptMessage() {
        template = "Please select tokens for player.";
        formattedMessage = formatMessage(template, null);
        addToBuffer(formattedMessage);
    }

    @Override
    public void tokenInUseMessage(CreatePlayerResponse response) {
        template = "%s tokens already in use.";
        charSequences = response.tokens;
        variable = arrayToCommaDelimitedString(charSequences);
        formattedMessage = formatMessage(template, variable);
        addToBuffer(formattedMessage);
    }
}
