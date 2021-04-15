package model;

import java.util.*;

public class HighScores
{
    private ArrayList<Integer> scores;

    public HighScores()
    {
	scores = new ArrayList<Integer>();  
    }

    public ArrayList<Integer> getHighScores()
    {
	return scores;
    }

    public void addHighScore(int score)
    {
	//add the new score to the list
	this.scores.add(score);

	//sort the scores into order
	Collections.sort(this.scores);
	
	//remove the last integer from the list
	this.scores.remove(10);
    }
}

