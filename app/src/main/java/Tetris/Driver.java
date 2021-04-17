package Tetris;
import model.*;
import view.*;
import controller.*;
import java.awt.event.*;
import java.awt.Color;

public class Driver
{
    public static void main(String []args)
    {
	
	//Demonstrates use case 3
	HighScores easy = new HighScores();
	HighScores medium = new HighScores();
	HighScores hard = new HighScores();
	HighScoresGUI highScores = new HighScoresGUI(easy, medium, hard);
	highScores.addReturnToMainListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
		    System.out.println("Button pressed to return to main page");
		}
	});
	


	//Demonstrates use case 4 and 5
	GameView gameView = new GameView();
	TetrisFactory factory = new TetrisFactory();
	TetrisShape shape = factory.getShape("LShape", Color.RED);



	

	//Demonstrates use case 1 and 2
	MainScreenGUI mainScreenGUI = new MainScreenGUI();
	
	//Demonstrate use case 6 and 7
	Scores score = new Scores();
	
	score.calculateScore(1);
	score.getScore();

	
    }
}
