package platform.project;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.List;

public class GameOverState extends GameState
{

    private static final int WIDTH = 840;
    private static final int HEIGHT = 600;
    private BufferedImage platformImage;
    private BufferedImage clouds;
    private List<Spikes> spikesList;
    private Player player;
    private int score;
    private int highscore;

    public GameOverState(GameStateManager gameStateManager, Player player, List<Spikes> spikesList, int score) {
	super(gameStateManager);
	this.spikesList = spikesList;
	this.player = player;
	this.score = score;

    }

    @Override public void init() { // same in every state fix?????????
	BufferedImageLoader imageLoader = new BufferedImageLoader();
	platformImage = imageLoader.loadImg("/images/platform.png");
	clouds = imageLoader.loadImg("/images/clouds.png");
    }

    @Override public void updateGame() {

    }

    @Override public void draw(Graphics g) {
	g.setColor(new Color(25, 190,225)); // random color
	g.fillRect(0, 0, WIDTH, HEIGHT);
	g.drawImage(platformImage,0, 530, null);
	g.drawImage(clouds, -10, 35, null);
	String gameOver = "GAME OVER";
	player.draw(g);
	for(Spikes spikes : spikesList) {
	    spikes.draw(g);
	}
	g.setColor(Color.BLACK);
	g.setFont(new Font("Times New Roman",Font.BOLD, 40));
	g.drawString(gameOver,275, 275);
	String restart = "Press SPACE to restart";
	g.setFont(new Font("Times New Roman",Font.BOLD,16));
	g.drawString(restart,305, 400);
	g.drawString("Your score is " + score, 325, 325);
    }

    @Override public void keyPressed(int k) {
	if (k == KeyEvent.VK_SPACE) {
	    gameStateManager.getGameStates().pop();
	    gameStateManager.getGameStates().pop();
	    gameStateManager.getGameStates().push(new PlayingState(gameStateManager));
	}
	if (k == KeyEvent.VK_ESCAPE) {
	    System.exit(0);
	}
    }

    @Override public void keyReleased(int k) {

    }
}
