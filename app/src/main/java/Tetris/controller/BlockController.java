package controller;
import model.*;

import java.awt.event.*;
import javax.swing.Timer;
import java.awt.Color;

public class BlockController implements KeyListener
{
     protected TetrisShape currentTetrisShape;
     protected TetrisArray currentState;
     protected TetrisField tetrisField;
     protected TetrisUserInterface ui;
     protected TetrisFactory factory;
     protected Timer timer;

     public BlockController(TetrisUserInterface ui)
     {
	this.ui = ui;
	this.factory = new TetrisFactory();
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
//	updateState();	
     }

     public void updateState()
     {
	currentState = tetrisField.add(currentTetrisShape);
	ui.updateView(currentState);
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
