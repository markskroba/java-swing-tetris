package controller;

import model.*;

import java.awt.event.*;
import javax.swing.Timer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class BlockController implements KeyListener
{
	protected TetrisShape currentTetrisShape;
	protected TetrisShape nextTetrisShape;
	protected TetrisArray currentState;
	protected TetrisArray previousState;
	protected TetrisField tetrisField;
	protected TetrisUserInterface ui;
	protected TetrisFactory factory;
	protected Timer timer;
	protected ScoreController scoreController;
	private boolean endGame;
	private boolean continueMoving;

	public BlockController(TetrisUserInterface ui)
	{
		this.ui = ui;
		this.factory = new TetrisFactory();
		this.tetrisField = new TetrisField();
		this.previousState = new TetrisArray();
		this.endGame = false;
		this.continueMoving = true;
	}

	/*
	 *Changes the current shape
	 */
	public void addTetrisShape(String shape, Color color)
	{
		currentTetrisShape = factory.getShape(shape, color);
	}

	public String getRandomShape()
	{
		String shapes[] = new String[]{"LShape", "ZShape", "SShape", "Square", "Square", "TShape", "Straight"};
		Random random = new Random();
		int randomShape = random.nextInt(shapes.length);
		return shapes[randomShape];
	}

	public Color getRandomColor()
	{
		Color colors[] = new Color[]{Color.RED, Color.GREEN, Color.BLUE};
		Random random = new Random();
		int randomColor = random.nextInt(colors.length);
		return colors[randomColor];
	}


	/*
	 *Sets the difficulty by determining the period of the timer
	 */
	public void setDifficulty(String difficulty, ActionListener l)
	{

		if(difficulty.equals("easy"))
		{
			timer = new Timer(500, l);
		}
		else if(difficulty.equals("medium"))
		{
			timer = new Timer(400, l);
		}
		else if(difficulty.equals("hard"))
		{
			timer = new Timer(300, l);
		}
		timer.start();
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			currentTetrisShape.moveHorizontally(1);
			System.out.println("Moving right");
			updateState();
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			currentTetrisShape.moveHorizontally(-1);
			System.out.println("Moving left");
			updateState();
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			currentTetrisShape.rotateShape();
			System.out.println("Rotate shape");
			updateState();
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			currentTetrisShape.moveVertically();
			System.out.println("Moving down");
			updateState();
		}
	}
	
	/*
	 * moves the currentTetrisShape down one cell, updates the state, the checks for any full rows and updates
	 * if there are any
	 */
	public void timerCallback()
	{
		currentTetrisShape.moveVertically();
		updateState();
		ArrayList<Integer> fullRows = getFullRows();
		if(fullRows != null)
		{
			clearRow();
			scoreController.calculateScore(fullRows.size());
			updateState();
		}	
	}

	/*
	 *Adds a controller to keep track of the scores so that view does not interact directly
	 */
	public void addScoreController(ScoreController controller)
	{
		this.scoreController = controller;
	}

	/*
	 *Updates the current state of the TetrisArray then calls updateView
	 *this is done based on the timer and when the shape is affected by the keyListener
	 */
	public void updateState()
	{

		System.out.println("Update state Called");
		currentState = tetrisField.add(currentTetrisShape);
		
		if (currentState == null)
		{
			ui.updateView(previousState);
			endGame = tetrisField.endGame();
			continueMoving = tetrisField.continueMoving();
		} 
		else 
		{
			ui.updateView(currentState);
			previousState = tetrisField.add(currentTetrisShape);
		}
	}

	/*
	 *Returns true when the game is over
	 */
	public boolean endGame()
	{
		return endGame;
	}

	/*
	 *Returns false when a new block needs to be added
	 */
	public boolean continueMoving()
	{
		return continueMoving;
	}

	/*
	 *Called when the game is over
	 */
	public void endTimer()
	{
		timer.stop();
	}


	/*
	 *Locate any full rows each time the ui is updated so the score can be calculated
	 */
	public ArrayList<Integer> getFullRows()
	{
		ArrayList<Integer> fullRows = new ArrayList<Integer>();
		fullRows = tetrisField.locateFullRow();

		return fullRows;
	}


	/*
	 *Clear the full rows and move all the blocks down
	 */
	public void clearRow()
	{
		tetrisField.clearRows();
	}

	public void restartGame()
	{
		tetrisField.clearField();
		updateState();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		//not used but need to over ride
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		//not used but need to over ride
	}
}
