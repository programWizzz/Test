package platform.project;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class PlayingState extends GameState
{
    private Player player;
    private BufferedImage platformImage;
    private BufferedImage clouds;
    private List<Spikes> spikesList;
    private int counter;
    private int score;



    public PlayingState(GameStateManager gameStateManager) {
	super(gameStateManager);
        counter = 2000;
        score = 0;
        player = new Player();
        Spikes spikes = new Spikes();
        spikesList = new ArrayList<>();
        spikesList.add(spikes);
    }

    @Override public void init() {
        BufferedImageLoader imageLoader = new BufferedImageLoader();
        platformImage = imageLoader.loadImg("/images/platform.png");
        clouds = imageLoader.loadImg("/images/clouds.png");

    }

    @Override public void updateGame() {

        player.updateGame();
        for(Spikes spikes : spikesList) {
            spikes.updateGame();
            if(player.getCharacter().intersects(spikes.getBounds())) {
                gameStateManager.getGameStates().push(new GameOverState(gameStateManager, player, spikesList, score));
                // GAME OVER
            }
        }
        if (player.getxOffset() == -200) {
            Spikes spikes = new Spikes();
            spikesList.add(spikes);
        }
        if (counter == 0) {
            spikesList.remove(0);
            counter = 1600;
        }
        counter -=1;
        score += 1;

    }

    @Override public void draw(Graphics g) {
        int windowHeight = 640;
        int windowWidth = 840;
        int yLevel = 500 + 1;

        g.setColor(new Color(25, 190,225)); // random color
        g.fillRect(0, 0, windowWidth, windowHeight);
        g.drawImage(platformImage, player.getxOffset(), yLevel + player.getHeight(), null);
        g.drawImage(clouds, -10, 35, null);

        if (player.getxOffset() < player.getxOffset() - platformImage.getWidth()){ // -1080
            g.drawImage(platformImage, player.getxOffset() + platformImage.getWidth(), yLevel + player.getHeight(), null);
        }
        player.draw(g);
        for(Spikes spikes : spikesList) {
            spikes.draw(g);
        }
        g.setFont(new Font("Times New Roman", Font.BOLD, 14));
        g.drawString(String.valueOf(score), 780, 260);

    }

    @Override public void keyPressed(final int k) {
        player.keyPressed(k);

    }

    @Override public void keyReleased(final int k) {
        player.keyReleased(k);
    }
}
