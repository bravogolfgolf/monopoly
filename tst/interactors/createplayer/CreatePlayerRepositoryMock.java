package game.interactors.createplayer;

import game.repositories.PlayerRepositoryImpl;

class CreatePlayerRepositoryMock extends PlayerRepositoryImpl {

    boolean verifyCreateCalled = false;
    boolean verifyPlayerLimitExceededCalled = false;
    boolean verifyGetAvailableTokensCalled = false;

    @Override
    public boolean create(String token) {
        verifyCreateCalled = true;
        return !token.equals("InValid");
    }

    @Override
    public boolean playerLimitExceeded() {
        verifyPlayerLimitExceededCalled = true;
        return super.playerLimitExceeded();
    }

    @Override
    public String[] getAvailableTokens() {
        verifyGetAvailableTokensCalled = true;
        return new String[0];
    }
}
