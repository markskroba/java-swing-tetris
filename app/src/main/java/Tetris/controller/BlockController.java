package controller;
import model.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class BlockController implements KeyListener
{
     protected Block block;

     public BlockController(Block block)
     {
	this.block = block;
     }

     @Override
     public void keyPressed(KeyEvent e)
     {
	 if (e.getKeyCode() == KeyEvent.VK_RIGHT)
          {
            System.out.println("Moving right using Block Controller");
          }
         else if (e.getKeyCode() == KeyEvent.VK_LEFT)
          {
            System.out.println("Moving left using BlockController");
          }
          else if (e.getKeyCode() == KeyEvent.VK_UP)
          {
            System.out.println("Rotating Clockwise");
          }
          else if (e.getKeyCode() == KeyEvent.VK_DOWN)
          {
	      System.out.println("Moving down using BlockController");
          }

     }
}
