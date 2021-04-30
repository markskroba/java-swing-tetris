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
	
	//Changed to show use case 7 in Driver
	public BlockController controller;
	private GamePanel gamePanel;
	private JFrame frame;

	public enum Shape {LShape, SShape, TShape, Straight, Square, ZShape}
	public enum ShapeColor {Red, Blue, Yellow, Green, Purple}

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
			}
		};

		ScoreController scoreController = new ScoreController();
		controller = new BlockController(gamePanel);
		// setting difficulty from value passed by MainScreenGUI
		controller.setDifficulty(difficulty, listener);
		controller.addScoreController(scoreController);

		//randomly call the first two shapes (hard coded for now)
		String firstShape = controller.getRandomShape();
		Color firstColor = controller.getRandomColor();
		String nextShape = controller.getRandomShape();
		Color nextColor = controller.getRandomColor();

		//add the first shape
		controller.addTetrisShape(firstShape, firstColor);
	
		//show the frame before entering the while loop that controls the game
		frame.add(this);
		frame.pack();
		frame.setVisible(true);


		do
		{
			if(controller.continueMoving() == false)
			{
				controller.addTetrisShape(nextShape, nextColor);
				//just have these as stand ins until the random enum is implemented
				//Set up the next shape and its color
				//nextShape = random call on a shape
				//nextColor = random call on a color
				sidePanel.drawNextFigure(nextShape, nextColor);

			}
			controller.timerCallback();
		}
		while(controller.endGame() == false);
		
		if(controller.endGame() == true)
		{	
			controller.endTimer();
		}


/*		frame.add(this);
		frame.pack();
		frame.setVisible(true);
*/
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
