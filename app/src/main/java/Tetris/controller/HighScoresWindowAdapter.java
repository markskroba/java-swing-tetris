package view;

import model.*;

import java.awt.event.*;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class HighScoresWindowAdapter extends WindowAdapter
{
	HighScores scores;
	String fileName;

	public HighScoresWindowAdapter(HighScores scores, String fileName)
	{
		this.scores = scores;
		this.fileName = fileName;
	}
	
	@Override
	public void windowClosing(WindowEvent e)
	{
		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream(this.fileName);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(this.scores);
			objectOutputStream.close();
			fileOutputStream.close();
		}
		catch(IOException exception)
		{
			System.out.println(exception.getMessage());
		}
	}
}

