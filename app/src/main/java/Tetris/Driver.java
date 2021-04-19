package Tetris;

import controller.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.*;

import model.*;
import view.*;

public class Driver
{
    public static void main(String []args)
    {
		//Demonstrates use case 1 
		System.out.println("Use case 1 demonstrated by opening a JFrame with the main screen.");
		MainScreenGUI mainScreenGUI = new MainScreenGUI();
		
		//Demonstrating use case 2
		System.out.println("Demonstrating use case 2 by clicking the \"Change level\" button");

		/* Demonstrates use case 3
		 * consider putting some of this in an array list to reduce amount of code
		 * should add the steps to import serialized data here
		 */
		System.out.println("Use case 3 demonstrated by instatiating three different high scores.");
		System.out.println("The high scores are then passed to a controller and added to the display");
		HighScores easy = new HighScores();
		HighScores medium = new HighScores();
		HighScores hard = new HighScores();
		ScoreController scoreController = new ScoreController();
		HighScoreController highScoresController = new HighScoreController();
		HighScoresDisplay easyDisplay = new HighScoresDisplay("Easy", 200, highScoresController.getHighScores(easy));
		HighScoresDisplay mediumDisplay = new HighScoresDisplay("Medium", 200, highScoresController.getHighScores(medium));
		HighScoresDisplay hardDisplay = new HighScoresDisplay("Hard", 200, highScoresController.getHighScores(hard));
		HighScoresGUI highScores = new HighScoresGUI(easyDisplay, mediumDisplay, hardDisplay);
		highScores.addReturnToMainListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Button pressed to return to main page");
			}
		});
		
		//Demonstrates use case 4
		System.out.println("Demonstrating use case 4 by opening game screen and instantiating the necessary objects");
		GameView gameView = new GameView();
		gameView.addTetrisShape("LShape", Color.RED);

		//Demonstrates use case 5

		//Demonstrate use case 6
		
		/*Demonstrates use case 7
		 * should use window adaptor to save and serialize the high score data
		 * ^ not sure about that, since we save highscores when user closes a window
		 */
		gameView.addTetrisShape("LShape", Color.RED);
		gameView.controller.updateState();
		String difficulty = mainScreenGUI.getDifficulty();
		if (difficulty == "easy")
		{
			easy.addHighScore(scoreController.getScore());
			System.out.println("Adding a new highscore for easy difficulty");
		}
		else if (difficulty == "medium")
		{
			medium.addHighScore(scoreController.getScore());
			System.out.println("Adding a new highscore for medium difficulty");
		}
		else
		{
			hard.addHighScore(scoreController.getScore());
			System.out.println("Adding a new highscore for hard difficulty");
		}
    }
}
