package view;
import model.*;
import controller.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

public class GameView extends JPanel //implements BlockObserver
{
    private int resolutionX;
    private int resolutionY;
    //Changed to show use case 7 in Driver
    public BlockController controller;
    private GamePanel gamePanel;
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
        this.add(gamePanel.getGameArea());

	SidePanel sidePanel = new SidePanel((int)(resolutionY* 0.3) - 20, resolutionY);
        this.add(sidePanel);
        this.setBackground(Color.LIGHT_GRAY);


	ActionListener listener = new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		controller.timerCallback();
	    }
	};

	ScoreController scoreController = new ScoreController();
	controller = new BlockController(gamePanel);
	controller.setDifficulty("easy", listener);
	controller.addScoreController(scoreController);



        frame.add(this);

        frame.pack();
        frame.setVisible(true);
    }

    public void addTetrisShape(String shape, Color color)
    {
	controller.nextTetrisShape(shape, color);
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
