package platform.project;

import javax.swing.*;
import java.awt.BorderLayout;

public class Main
{

    public static void main(String[] args)
    {
	JFrame frame = new JFrame("Don't touch the spikes");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setLayout(new BorderLayout());
	frame.add(new GamePanel(), BorderLayout.CENTER);
	frame.pack();
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);

	GamePanel gamePanel = new GamePanel();
    }
}
