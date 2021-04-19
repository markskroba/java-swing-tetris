package controller;

import model.*;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

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
}

