package platform.project;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class MenuState extends GameState
{

    private static final int HEIGHT = 600;
    private static final int WIDTH = 840;
    private static final int PLATFORM_LEVEL = 500;
    private int playerChoice = 0;
    private BufferedImage platformImage;
    private BufferedImage clouds;


    public MenuState(GameStateManager gameStateManager) {
	super(gameStateManager);
    }

    @Override public void init() {
	BufferedImageLoader imageLoader = new BufferedImageLoader();
	platformImage = imageLoader.loadImg("/images/platform.png");
	clouds = imageLoader.loadImg("/images/clouds.png");
    }

    @Override public void updateGame() {

    }

    @Override public void draw(Graphics g) {

	g.setColor(new Color(25, 190,225)); // random color
	g.fillRect(0, 0, WIDTH, HEIGHT);
	g.setColor(Color.BLACK);

	int playerHeight = 30;
	g.drawImage(platformImage, 0, PLATFORM_LEVEL + playerHeight, null);
	g.drawImage(clouds, -10, 35, null);

	g.setFont(new Font("Times New Roman", Font.PLAIN,32));
	String play = "Press SPACE to start";
	g.drawString(play, WIDTH / 2 - 150, 300 );

	g.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	String quitGame = "Esc to quit";
	g.drawString(quitGame, WIDTH / 2 - 35, 350);

	g.setFont(new Font("Times New Roman", Font.BOLD, 68));
	g.setColor(new Color(150, 10, 20)); // random color
	String gameName = "Platformer";
	g.drawString(gameName, WIDTH / 2 - 200, 110);


    }

    @Override public void keyPressed(int k) {
	if(k == KeyEvent.VK_SPACE) {
	    gameStateManager.getGameStates().push(new PlayingState(gameStateManager));

	}
	else if (k == KeyEvent.VK_ESCAPE) {
	    System.exit(0);
	}
    }

    @Override public void keyReleased(int k) {

    }


}