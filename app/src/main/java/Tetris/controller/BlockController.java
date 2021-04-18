package controller;
import model.*;

import java.awt.event.*;
import javax.swing.Timer;
import java.awt.Color;
import java.util.ArrayList;

public class BlockController implements KeyListener
{
     protected TetrisShape currentTetrisShape;
     protected TetrisArray currentState;
     protected TetrisField tetrisField;
     protected TetrisUserInterface ui;
     protected TetrisFactory factory;
     protected Timer timer;
     protected ScoreController scoreController;

     public BlockController(TetrisUserInterface ui)
     {
	this.ui = ui;
	this.factory = new TetrisFactory();
          this.tetrisField = new TetrisField();
     }

     public void nextTetrisShape(String shape, Color color)
     {
	currentTetrisShape = factory.getShape(shape, color);
     }

     public void setDifficulty(String difficulty, ActionListener l)
     {
	System.out.println("Setting the difficulty by starting a timer with different periods");

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
	System.out.println("Tetris shape will move down based on timer");
//	timer.start();
     }

     @Override
     public void keyPressed(KeyEvent e)
     {
	 if (e.getKeyCode() == KeyEvent.VK_RIGHT)
          {
	      currentTetrisShape.moveHorizontally(1);
//	      updateState();
          }
         else if (e.getKeyCode() == KeyEvent.VK_LEFT)
          {
	      currentTetrisShape.moveHorizontally(-1);
//	      updateState();
          }
          else if (e.getKeyCode() == KeyEvent.VK_UP)
          {
	      currentTetrisShape.rotateShape();
//	      updateState();
          }
          else if (e.getKeyCode() == KeyEvent.VK_DOWN)
          {
	      currentTetrisShape.moveVertically();
//	      updateState();
          }
     }

     public void timerCallback()
     {
	//moves the currentTetrisShape down one cell, calls tetrisField.add(currentShape) to update currentState,
	//then calls updateView(currentState)
	System.out.println("Move the TetrisShape down based on timer");
//	currentTetrisShape.moveVertically();
	ArrayList<Integer> fullRows = getFullRows();
	if(fullRows != null)
	{
	    clearRow();
	    scoreController.calculateScore(fullRows.size());
	}
//	updateState();	
     }

     public void addScoreController(ScoreController controller)
     {
	this.scoreController = controller;
     }

     public void updateState()
     {
     // System.out.println(tetrisField);
	currentState = tetrisField.add(currentTetrisShape);
          if (currentState == null)
          {
               System.out.println("Updating view to null as a result of being unnable to add a new block");
               ui.updateView(null);
          } 
          else 
          {
               ui.updateView(currentState);
          }
     }


     public ArrayList<Integer> getFullRows()
     {
	ArrayList<Integer> fullRows = new ArrayList<Integer>();
	fullRows = tetrisField.locateFullRow();

	return fullRows;
     }

    
     public void clearRow()
     {
	System.out.println("Row is cleared when there are no null spaces and all blocks above move down");
	tetrisField.clearRows();
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
