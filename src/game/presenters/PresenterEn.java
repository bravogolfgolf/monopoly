package game.presenters;

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

public class PresenterEn extends Presenter {

    public PresenterEn(Console console, Parser parser) {
        super(console, parser);
    }

    @Override
    public void selectVersionPromptMessage() {
        template = "Select version of game you would like to play.";
        addMessageToBuffer(template);
    }

    @Override
    public void availableVersionsMessage(VersionOptionsResponse response) {
        template = "Available versions: %s";
        variables = response.versions;
        createMenuMap(variables);
        addMenuToBuffer(template, menuMap);
    }

    @Override
    public void versionCreatedMessage(VersionOptionsResponse response) {
        template = "\n%s version of game created.";
        variables = new String[]{response.version};
        addMessageToBuffer(template, variables);
    }

    @Override
    public void createPlayerPromptMessageFewerThanMinimumMessage() {
        template = "Please select token for player. (Players 2 - 8)";
        addMessageToBuffer(template);
    }

    @Override
    public void createPlayerPromptMessageMinimumToMaximumMessage() {
        template = "Please select token for player or (0)Play to begin. (Players 2 - 8)";
        addMessageToBuffer(template);
    }

    @Override
    public void availableTokensMessage(TokenOptionsResponse response) {
        template = "Available tokens: %s";
        createMenuMap(response.tokens);
        addMenuToBuffer(template, menuMap);
    }

    @Override
    public void playerCreatedMessage(TokenOptionsResponse response) {
        template = "\nPlayer created with %s token.";
        variables = new String[]{response.token};
        addMessageToBuffer(template, variables);
    }

    @Override
    public void playerSelectedToGoFirstMessage(SelectFirstResponse response) {
        template = "\n%s selected to go first.";
        variables = new String[]{response.token};
        addMessageToBuffer(template, variables);
    }

    @Override
    public void startTurnMessage() {
        template = "Available options: (0)Roll (1)Manage Properties (2)Trade.";
        addMessageToBuffer(template);
    }

    @Override
    public void rollMessage(RollDiceResponse response) {
        if (response.isDoubles) template = String.format("Doubles! You rolled %d.", response.rolled);
        else template = String.format("You rolled %d.", response.rolled);
        addMessageToBuffer(template);
    }

    @Override
    public void selectPropertyPromptMessage() {
        template = "Select property to manage or (0)Done to return to previous menu.";
        addMessageToBuffer(template);
    }

    @Override
    public void propertyOptionsMessage(PropertyOptionsResponse response) {
        if (response.properties.isEmpty())
            template = "No properties to manage.";
        addMessageToBuffer(template);
    }

    @Override
    public void landOnMessage(LandOnResponse response) {
        template = String.format("Landed on %s.", response.space);
        addMessageToBuffer(template);
    }

    @Override
    public void goToJailMessage(GoToJailResponse response) {
        template = String.format("Do not pass %s. Do not collect 200.", response.GO);
        addMessageToBuffer(template);
    }

    @Override
    public void collectIncomeTaxMessage(CollectIncomeTaxResponse response) {
        template = String.format("Income Tax Due. Pay %d.", response.amount);
        addMessageToBuffer(template);
    }

    @Override
    public void collectLuxuryTaxMessage() {
        template = "Luxury Tax Due. Pay 75.";
        addMessageToBuffer(template);
    }

    @Override
    public void cardMessage(DrawCommunityChestCardResponse response) {
        addMessageToBuffer(response.cardText);
    }

    @Override
    public void selectTradingPartnerPromptMessage() {
        template = "Select player to trade with or (0)Done to return to previous menu.";
        addMessageToBuffer(template);
    }

    @Override
    public void partnerOptionsMessage(PartnerOptionsResponse response) {
        template = "Available trading partners: %s";
        createMenuMap(response.players);
        addMenuToBuffer(template, menuMap);
    }

    @Override
    public void paySalaryMessage() {
        template = "Collect 200.";
        addMessageToBuffer(template);
    }

    @Override
    public void passGoMessage(MoveTokenResponse response) {
        template = String.format("Passed %s!", response.GO);
        addMessageToBuffer(template);
    }
}