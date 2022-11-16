package platform.project;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BufferedImageLoader
{

    private BufferedImage image = null;

    public BufferedImage loadImg (String imagePath) {
        try {
            image = ImageIO.read(getClass().getResource(imagePath));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return image;
    }
}
