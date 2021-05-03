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
		//highScores = currentHighScores.addHighScore(score);
	}

	public void saveHighScores(String difficulty)
		{}
		
	public HighScores loadHighScores(String difficulty)
	{
		try
		{
			FileInputStream fileInputStream = new FileInputStream(difficulty);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			HighScores loadedHighScores = (HighScores)objectInputStream.readObject();
			objectInputStream.close();
			fileInputStream.close();

			System.out.println("Found highscore!!!");
			return loadedHighScores;
		}
		catch (IOException e)
		{
			//Usually could not find a file since no highscore was saved, creating a new one
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

