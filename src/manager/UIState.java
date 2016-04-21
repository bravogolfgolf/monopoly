package game.manager;

interface UIState {

    void promptMessage(UIManager manager);

    void validUseCaseEntry(UIManager manager);

    void invalidEntry(UIManager manager);
}