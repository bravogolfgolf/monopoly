package game.interactors;

import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.selectfirst.SelectFirstResponse;
import game.interactors.selectversion.SelectVersionResponse;
import game.interactors.tokenoptions.TokenOptionsResponse;
import game.interactors.versionoptions.VersionOptionsResponse;
import game.presenters.Presenter;

class PresenterMock extends Presenter {

    boolean verifySelectVersionPromptMessageCalled = false;
    boolean verifyVersionCreatedMessage = false;
    boolean verifyAvailableVersionsMessageCalled = false;
    boolean verifyPlayerCreatedMessage = false;
    boolean verifyCreatePlayerPromptMessageFewerThanMinimumMessage = false;
    boolean verifyCreatePlayerPromptMessageMinimumToMaximumMessage = false;
    boolean verifyAvailableTokensMessage = false;
    boolean verifyPlayerSelectedToGoFirstMessage = false;
    boolean verifyStartTurnCalled = false;

    @Override
    public void selectVersionPromptMessage() {
        verifySelectVersionPromptMessageCalled = true;
    }

    @Override
    public void versionCreatedMessage(SelectVersionResponse response) {
        verifyVersionCreatedMessage = true;
    }

    @Override
    public void availableVersionsMessage(VersionOptionsResponse response) {
        verifyAvailableVersionsMessageCalled = true;
    }

    @Override
    public void playerCreatedMessage(CreatePlayerResponse response) {
        verifyPlayerCreatedMessage = true;
    }

    @Override
    public void createPlayerPromptMessageFewerThanMinimumMessage() {
        verifyCreatePlayerPromptMessageFewerThanMinimumMessage = true;
    }

    @Override
    public void createPlayerPromptMessageMinimumToMaximumMessage() {
        verifyCreatePlayerPromptMessageMinimumToMaximumMessage = true;
    }

    @Override
    public void availableTokensMessage(TokenOptionsResponse response) {
        verifyAvailableTokensMessage = true;
    }

    @Override
    public void playerSelectedToGoFirstMessage(SelectFirstResponse response) {
        verifyPlayerSelectedToGoFirstMessage = true;
    }

    @Override
    public void startTurn() {
        verifyStartTurnCalled = true;
    }
}
