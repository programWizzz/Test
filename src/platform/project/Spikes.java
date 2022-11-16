package platform.project;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Spikes
{

    private final static int SPIKE_LEVEL= 463;
    private int xPos, yPos;
    private BufferedImage spikesPic = null;
    private Random random;
    private Rectangle rectangle;



    public Spikes() {
	yPos = SPIKE_LEVEL;
	random = new Random();
	rectangle = new Rectangle();
	init();
    }

    public void init() {
	int delay = 50;
	int windowWidth = 840;
	xPos = windowWidth + delay;
	BufferedImageLoader imageLoader = new BufferedImageLoader();
	switch (ranodmizeSpikes()) {
	    case 0:
		spikesPic = imageLoader.loadImg("/images/double_spikes.png");
		break;
	    case 1:
		spikesPic = imageLoader.loadImg("/images/spikes.png");
		break;
	}
	rectangle.width = spikesPic.getWidth();
	rectangle.height = spikesPic.getHeight();
    }

    public int ranodmizeSpikes() {
	int spikeSelection = random.nextInt(2);
	return spikeSelection;
    }

    public void updateGame() {
	xPos -= 2;
	rectangle.x = xPos;
	rectangle.y = yPos;
	if (xPos < -100) {
	    init();
	}
    }

    public void draw(Graphics g) {
	g.drawImage(spikesPic, xPos, yPos, null);
    }

    public Rectangle getBounds() {
	return rectangle.getBounds();
    }


}
