package platform.project;

import java.awt.*;
import java.awt.event.KeyEvent;


public class Player
{

    private int width, height;
    private int xPos, yPos, xOffset;
    private double ySpeed = 5;
    private double currentYSpeed = ySpeed;
    private double gravity = 0.9;
    private boolean jumping = false, falling = false;
    private Rectangle character = null;


    public Player() {
        width = 30;
        height = 30;
        xPos = 100;
        yPos = 500;
        xOffset = 0;
        character = new Rectangle();

    }

    public void init() {


    }
    public void updateGame() {

        setBounds();

        xOffset -=1;
        if (xOffset == -1080) {
            xOffset = 0;
        }

        if (jumping) {
            yPos -= currentYSpeed;
            currentYSpeed -= 0.1;

            if (currentYSpeed <= 0) {
                currentYSpeed = ySpeed;
                jumping = false;
                falling = true;

            }
        }

        if (falling && yPos < 500) {
            yPos += gravity;

            if (gravity < ySpeed) {
                gravity += 0.3;
            }
            if (yPos == 500) {
                falling = false;
            }

        }

        if (!falling) {
            gravity = 0.1;
        }

    }

    public void draw(Graphics g) {
        g.setColor(new Color(88, 88, 88));
        g.fillRect(xPos, yPos, width, height);

    }

    public void setBounds() {
        character.setBounds(xPos, yPos, width, height);
    }

    public void keyPressed(final int k) {
        if(k == KeyEvent.VK_SPACE) {
            if (yPos == 500) {
            jumping = true;

            }
        }
    }
    public void keyReleased(final int k) {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getxOffset() {
        return xOffset;
    }

    public Rectangle getCharacter() {
        return character;
    }
}
