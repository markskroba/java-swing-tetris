package Tetris;
import model.*;
import view.*;
import controller.*;
import java.awt.event.*;

public class Driver
{
    public static void main(String []args)
    {
	HighScoresGUI highScores = new HighScoresGUI();
	highScores.addReturnToMainListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		    System.out.println("Button pressed to return to main page");
		}
	});
    }
}
