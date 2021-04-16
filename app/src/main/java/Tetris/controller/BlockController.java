package controller;
import model.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

public class BlockController implements KeyListener
{
     protected TetrisShape currentTetrisShape;
     protected TetrisArray currentState;
     protected TetrisField tetrisField;
     protected TetrisUserInterface ui;
     protected TetrisFactory factory;
     protected Timer timer;

     public BlockController(TetrisUserInterface ui, TetrisFactory factory)
     {
	this.ui = ui;
	this.factory = factory;
     }

     public void nextTetrisShape(String shape, Color color)
     {
	currentTetrisShape = factory.getShape(shape, color);
     }

     public void setDifficulty(String difficulty)
     {
	if(difficulty.equals("easy");
	{
	     timer = new Timer(500, ActionListener l);
	}
	else if(difficulty.equals("medium");
	{
	    timer = new Timer(400, ActionListener l);
	}
	else if(difficulty.equals("hard");
	{
	    timer = new Timer(300, ActionListener l);
	}
	timer.start();
     }

     @Override
     public void keyPressed(KeyEvent e)
     {
	 if (e.getKeyCode() == KeyEvent.VK_RIGHT)
          {
	      currentTetrisShape.moveHorizontally(1);
	      updateState();
          }
         else if (e.getKeyCode() == KeyEvent.VK_LEFT)
          {
	      currentTetrisShape.moveHorizontally(-1);
	      updateState();
          }
          else if (e.getKeyCode() == KeyEvent.VK_UP)
          {
	      currentTetrisShape.rotateShape();
	      updateState();
          }
          else if (e.getKeyCode() == KeyEvent.VK_DOWN)
          {
	      currentTetrisShape.moveVertically();
	      updateState();
          }
     }

     public void timerCallback()
     {
	//moves the currentTetrisShape down one cell, calls tetrisField.add(currentShape) to update currentState,
	//then calls updateView(currentState)
	currentTetrisSahpe.moveVertically();
	updateState();	
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
