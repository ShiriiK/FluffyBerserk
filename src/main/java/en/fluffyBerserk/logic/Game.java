package en.fluffyBerserk.logic;

public class Game {
    private boolean theEnd;
    private final GameState gameState;

    public Game(){
        theEnd = false;
        gameState = new GameState();
    }

    public boolean isTheEnd() {
        return theEnd;
    }

    public void setTheEnd(boolean theEnd) {
        this.theEnd = theEnd;
    }

    public GameState getGameState(){
        return gameState;
    }
}
