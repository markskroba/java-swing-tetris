package Tetris;
import model.*;
import view.*;
import controller.*;
import java.awt.event.*;

public class Driver
{
    public static void main(String []args)
    {
	
	//Demonstrates use case 3
	HighScoresGUI highScores = new HighScoresGUI();
	highScores.addReturnToMainListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		    System.out.println("Button pressed to return to main page");
		}
	});

	//Demonstrates use case 4
	GameView gameView = new GameView();
	

	//Demonstrates use case 1 and 2
	MainScreenGUI mainScreenGUI = new MainScreenGUI();
	
	//Demonstrate use case 5
	
    }
}
