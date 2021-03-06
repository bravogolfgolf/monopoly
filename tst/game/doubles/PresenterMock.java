package game.doubles;

import game.display.Console;
import game.interactors.communitychest.DrawCommunityChestCardResponse;
import game.interactors.gotojail.GoToJailResponse;
import game.interactors.incometax.CollectIncomeTaxResponse;
import game.interactors.landon.LandOnResponse;
import game.interactors.movetoken.MoveTokenResponse;
import game.interactors.partneroptions.PartnerOptionsResponse;
import game.interactors.propertyoptions.PropertyOptionsResponse;
import game.interactors.rolldice.RollDiceResponse;
import game.interactors.selectfirst.SelectFirstResponse;
import game.interactors.tokenoptions.TokenOptionsResponse;
import game.interactors.versionoptions.VersionOptionsResponse;
import game.parser.Parser;
import game.presenters.Presenter;

public class PresenterMock extends Presenter {

    public boolean verifySelectVersionPromptMessageCalled = false;
    public boolean verifyAvailableVersionsMessageCalled = false;
    public boolean verifyVersionCreatedMessage = false;
    public boolean verifyCreatePlayerPromptMessageFewerThanMinimumMessage = false;
    public boolean verifyCreatePlayerPromptMessageMinimumToMaximumMessage = false;
    public boolean verifyAvailableTokensMessage = false;
    public boolean verifyPlayerCreatedMessage = false;
    public boolean verifyPlayerSelectedToGoFirstMessage = false;
    public boolean verifySelectPropertyPromptMessageCalled = false;
    public boolean verifyPropertyOptionsMessageCalled = false;
    public boolean verifySelectTradingPartnerPromptMessageCalled = false;
    public boolean verifyPartnerOptionsMessageCalled = false;
    public boolean verifyRollMessageCalled = false;
    public boolean verifyStartTurnMessageCalled = false;
    public boolean verifyWriteMessageCalled = false;
    public boolean verifyPassGoMessageCalled = false;
    public boolean verifyPaySalaryMessageCalled = false;
    public boolean verifyLandOnMessageCalled = false;
    public boolean verifyGoToJailMessageCalled = false;
    public boolean verifyCollectIncomeTaxMessageCalled = false;
    public boolean verifyCollectLuxuryTaxMessageCalled = false;
    public boolean verifyCardMessageCalled = false;

    public PresenterMock(Console console, Parser parser) {
        super(console, parser);
    }


    @Override
    public void selectVersionPromptMessage() {
        verifySelectVersionPromptMessageCalled = true;
    }

    @Override
    public void availableVersionsMessage(VersionOptionsResponse response) {
        verifyAvailableVersionsMessageCalled = true;
    }

    @Override
    public void versionCreatedMessage(VersionOptionsResponse response) {
        verifyVersionCreatedMessage = true;
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
    public void playerCreatedMessage(TokenOptionsResponse response) {
        verifyPlayerCreatedMessage = true;
    }

    @Override
    public void playerSelectedToGoFirstMessage(SelectFirstResponse response) {
        verifyPlayerSelectedToGoFirstMessage = true;
    }

    @Override
    public void startTurnMessage() {
        verifyStartTurnMessageCalled = true;
    }

    @Override
    public void rollMessage(RollDiceResponse dice) {
        verifyRollMessageCalled = true;
    }

    @Override
    public void selectPropertyPromptMessage() {
        verifySelectPropertyPromptMessageCalled = true;
    }

    @Override
    public void writeMessage() {
        verifyWriteMessageCalled = true;
    }

    @Override
    public void propertyOptionsMessage(PropertyOptionsResponse response) {
        verifyPropertyOptionsMessageCalled = true;
    }

    @Override
    public void landOnMessage(LandOnResponse response) {
        verifyLandOnMessageCalled = true;
    }

    @Override
    public void goToJailMessage(GoToJailResponse response) {
        verifyGoToJailMessageCalled = true;
    }

    @Override
    public void collectIncomeTaxMessage(CollectIncomeTaxResponse response) {
        verifyCollectIncomeTaxMessageCalled = true;
    }

    @Override
    public void collectLuxuryTaxMessage() {
        verifyCollectLuxuryTaxMessageCalled = true;
    }

    @Override
    public void cardMessage(DrawCommunityChestCardResponse response) {
        verifyCardMessageCalled = true;
    }

    @Override
    public void selectTradingPartnerPromptMessage() {
        verifySelectTradingPartnerPromptMessageCalled = true;
    }

    @Override
    public void partnerOptionsMessage(PartnerOptionsResponse response) {
        verifyPartnerOptionsMessageCalled = true;
    }

    @Override
    public void paySalaryMessage() {
        verifyPaySalaryMessageCalled = true;
    }

    @Override
    public void passGoMessage(MoveTokenResponse response) {
        verifyPassGoMessageCalled = true;
    }
}
