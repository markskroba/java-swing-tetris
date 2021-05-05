package controller;

import model.*;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class HighScoreController
{
	protected ArrayList<Integer> highScores;

	public HighScoreController()
	{

	}
	
	//pass in if the high scores are easy, medium, or hard along with the scores themselves
	//then return a default list model to be used to generate a HighScoredDisplay
	public DefaultListModel<Integer> getHighScores(HighScores scores)
	{
		highScores = scores.getHighScores();
		
		//Convert the passed in list array into a regular array
		DefaultListModel<Integer> convertedScores = new DefaultListModel<Integer>();
		for(int val: highScores)
		{
			convertedScores.addElement(val);
		}
		return convertedScores;
	}

	public void addHighScore(HighScores currentHighScores, int score)
	{
		currentHighScores.addHighScore(score);
	}

	public void saveHighScores(String difficulty, HighScores scores)
	{
		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream(difficulty);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(scores);
			objectOutputStream.close();
			fileOutputStream.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public HighScores loadHighScores(String difficulty)
	{
		System.out.println("Trying to load highscores for " + difficulty + " difficulty");
		try
		{
			FileInputStream fileInputStream = new FileInputStream(difficulty);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			HighScores loadedHighScores = (HighScores)objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();

			System.out.println("Found highscores for difficulty " + difficulty + ": " + loadedHighScores.getHighScores().size());
			return loadedHighScores;
		}
		catch (IOException e)
		{
			//Usually could not find a file since no highscore was saved, creating a new one
			System.out.println("Could not find highscores for " + difficulty + ", creating a new object");
			HighScores loadedHighScores = new HighScores();
			return loadedHighScores;
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Error loading HighScore object");
			System.out.println(e.getMessage());
		}
		return null;
	}
}

