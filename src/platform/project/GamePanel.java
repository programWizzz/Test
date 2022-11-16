package platform.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements Runnable, KeyListener
{

    private static final int HEIGHT = 600;
    private static final int WIDTH = 840;
    private static final int framesPerSecond = 60;
    private boolean isRunning = false;
    private GameStateManager gameStateManager = new GameStateManager();

    public GamePanel() {
	setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        addKeyListener(this);

        initThread();
    }


    public void initThread() {

        Thread gameThread = new Thread(this);
        gameThread.start();
        isRunning = true;
    }

    @Override public void run() {

        while(isRunning) {  // game loop
            long startTime = System.nanoTime();

            updateGame();
            repaint();


            long elapsedTime = System.nanoTime() - startTime;

            int targetTime = 1000 / framesPerSecond;
            long waitingTime = targetTime - (elapsedTime / 1000000);

            try {
                if (waitingTime < 0) {
                    waitingTime = 5;
                }
                Thread.sleep(waitingTime);
            }
            catch(Exception e) {
                e.printStackTrace();
                }
        }
    }

    public void updateGame() { // update game info
        gameStateManager.updateGame();
        
    }
    
    public void paintComponent(Graphics g) { // draw the game with updated info
        super.paintComponent(g);
        g.clearRect(0,0, WIDTH, HEIGHT); // clear
        gameStateManager.draw(g);
        
    }

    @Override public void keyTyped(final KeyEvent keyEvent) {

    }

    @Override public void keyPressed(KeyEvent keyEvent) {
        gameStateManager.keyPressed(keyEvent.getKeyCode());
    }

    @Override public void keyReleased(KeyEvent keyEvent) {
        gameStateManager.keyRelease(keyEvent.getKeyCode());
    }


}