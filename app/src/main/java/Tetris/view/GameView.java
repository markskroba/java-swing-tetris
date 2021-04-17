package view;
import model.*;
import controller.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;

public class GameView extends JPanel //implements BlockObserver
{
    private int resolutionX;
    private int resolutionY;

    private JPanel gamePanel;
    private JFrame frame;

    public GameView() 
    {
        // 9:16 ratio
        // lightgrey as bg - 211 211 211
        // 
        resolutionX = 800;
        resolutionY = 900;
        
        frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(resolutionX, resolutionY));

        gamePanel = new GamePanel((int)(resolutionX * 0.7) - 20, 800);
        
        this.add(gamePanel);
        SidePanel sidePanel = new SidePanel((int)(resolutionY* 0.3) - 20, resolutionY);
        this.add(sidePanel);
        this.setBackground(Color.LIGHT_GRAY);

	
        frame.add(this);

        frame.pack();
        frame.setVisible(true);
    }

    
/*
    @Override
    public void update(int row, int column)
    {
	System.out.println("Updates the screen to show the block movement");
	this.revalidate();
	this.repaint();
    }
*/
}
