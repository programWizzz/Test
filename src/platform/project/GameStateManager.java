package platform.project;

import java.awt.*;
import java.util.Stack;


public class GameStateManager
{

    private Stack<GameState> gameStates;


    public GameStateManager() {
        gameStates = new Stack<>();
        gameStates.push(new MenuState(this));
    }

    public void updateGame() {
        gameStates.peek().updateGame();

    }
    public void draw(Graphics g) {
        gameStates.peek().draw(g);
    }

    public void keyPressed(int k) {
        gameStates.peek().keyPressed(k);
    }

    public void keyRelease(int k) {
        gameStates.peek().keyReleased(k);
    }

    public Stack<GameState> getGameStates() {
        return gameStates;
          }
}
