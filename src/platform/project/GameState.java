package platform.project;

import java.awt.*;

public abstract class GameState
{
    protected GameStateManager gameStateManager;

    protected GameState(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        init();

    }

    public abstract void init();
    public abstract void updateGame();
    public abstract void draw(Graphics g);
    public abstract void keyPressed(int k);
    public abstract void keyReleased(int k);

}
