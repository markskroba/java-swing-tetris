package view;
import model.*;
import controller.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.util.Random;

public class GameView extends JPanel
{
	private int resolutionX;
	private int resolutionY;
	

	public BlockController controller;
	private GamePanel gamePanel;
	private JFrame frame;


	public GameView(String difficulty) 
	{
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

				if(controller.continueMoving() == false)
				{
					//Set up the next shape and its color
					String nextShape = controller.getRandomShape();
					Color nextColor = controller.getRandomColor();
					//sidePanel.drawNextFigure(nextShape, nextColor);

					controller.addTetrisShape(nextShape, nextColor);
				}

				if(controller.endGame() == true)
				{
					controller.endTimer();
				}

			}
		};

		ScoreController scoreController = new ScoreController();
		controller = new BlockController(gamePanel);
		// setting difficulty from value passed by MainScreenGUI
		controller.setDifficulty(difficulty, listener);
		controller.addScoreController(scoreController);
		
		//randomly call the first shape
		String firstShape = getRandomShape();
		Color firstColor = getRandomColor();
		
		//add the first shape
		controller.addTetrisShape(firstShape, firstColor);


		frame.add(this);
		frame.pack();
		frame.setVisible(true);

	}

}
