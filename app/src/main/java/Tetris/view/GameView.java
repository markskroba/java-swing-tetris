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
		
		ScoreController scoreController = new ScoreController();


		gamePanel = new GamePanel((int)(resolutionX * 0.7) - 20, 800);
		this.add(gamePanel.getGameArea());
		

		controller = new BlockController(gamePanel);


			//action listener for the timer (passed to controller when setting difficulty)	
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{


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

				controller.timerCallback();

			}
		};

		// setting difficulty from value passed by MainScreenGUI
		controller.setDifficulty(difficulty, listener);
		controller.addScoreController(scoreController);
		
		//randomly call the first shape
		String firstShape = controller.getRandomShape();
		Color firstColor = controller.getRandomColor();
		
		//add the first shape
		controller.addTetrisShape("SShape", firstColor);
		controller.updateState();
		
		//action listener for the restart button on the side panel
		ActionListener restart = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				controller.restartGame();
				scoreController.resetScore();
				controller.setDifficulty(difficulty, listener);
				frame.addKeyListener(controller);
				frame.setFocusable(true);
			}
		};

		SidePanel sidePanel = new SidePanel((int)(resolutionY* 0.3) - 20, resolutionY, restart);
		this.add(sidePanel);
		this.setBackground(Color.LIGHT_GRAY);


		frame.add(this);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(controller);
		frame.setFocusable(true);
	}

}
