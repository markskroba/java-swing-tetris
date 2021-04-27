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
		MainScreenGUI mainScreenGUI = new MainScreenGUI();
		
		
		/* Demonstrates use case 3
		 * consider putting some of this in an array list to reduce amount of code
		 * should add the steps to import serialized data here
		 */
		System.out.println("Use case 3 demonstrated by instatiating three different high scores.");
		System.out.println("The high scores are then passed to a controller and added to the display");
		ScoreController scoreController = new ScoreController();
		
		HighScoreController highScoresController = new HighScoreController();

		HighScores easy = highScoresController.loadHighScores("easy");
		HighScores medium = highScoresController.loadHighScores("medium");
		HighScores hard = highScoresController.loadHighScores("hard");

		HighScoresDisplay easyDisplay = new HighScoresDisplay("Easy", 200, highScoresController.getHighScores(easy));
		HighScoresDisplay mediumDisplay = new HighScoresDisplay("Medium", 200, highScoresController.getHighScores(medium));
		HighScoresDisplay hardDisplay = new HighScoresDisplay("Hard", 200, highScoresController.getHighScores(hard));
		
		/*Demonstrates use case 7
		 * should use window adaptor to save and serialize the high score data
		 * ^ not sure about that, since we save highscores when user closes a window
		 */

		//gameView.controller.updateState();
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
