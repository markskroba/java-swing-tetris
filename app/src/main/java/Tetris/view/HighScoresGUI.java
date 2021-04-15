package view;
import model.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HighScoresGUI
{
    private JFrame mainFrame;
    public HighScoresDisplay easy;
    public HighScoresDisplay medium;
    public HighScoresDisplay hard;
    private JButton back;

    public HighScoresGUI(HighScores easy, HighScores medium, HighScores hard)
    {
	//top level container
	mainFrame = new JFrame("High Scores Display");
	mainFrame.setPreferredSize(new Dimension(800, 900));
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//get a scores arraylist for each set of high scores
	ArrayList<Integer> easyScores = new ArrayList<Integer>(easy.getHighScores());
	ArrayList<Integer> mediumScores = new ArrayList<Integer>(medium.getHighScores());
	ArrayList<Integer> hardScores = new ArrayList<Integer>(hard.getHighScores());
	
	//set up objects for each high score column
	this.easy = new HighScoresDisplay("Easy", 200, easyScores);
	this.medium = new HighScoresDisplay("Medium", 200, mediumScores);
	this.hard = new HighScoresDisplay("Hard", 200, hardScores);


	// set up container for the high scores page
	JPanel scoresColumns = new JPanel();
	scoresColumns.setBackground(new Color(211,211,211));
	scoresColumns.setLayout(new BorderLayout());


	//add the columns to the page
	scoresColumns.add(this.easy, BorderLayout.WEST);
        scoresColumns.add(this.medium, BorderLayout.CENTER);
        scoresColumns.add(this.hard, BorderLayout.EAST);


	//make a container for the back to main page button
	back = new JButton("Return to Main Page");
	back.setPreferredSize(new Dimension(800, 50));
	back.setFont(new Font("Serif", Font.BOLD, 30));
	scoresColumns.add(back, BorderLayout.SOUTH);

	//make a label for the top of the page
	JLabel pageTitle = new JLabel("HIGH SCORES");
	pageTitle.setHorizontalAlignment(JLabel.CENTER);
	pageTitle.setFont(new Font("Serif", Font.BOLD, 48));
	pageTitle.setPreferredSize(new Dimension(800, 200));
	scoresColumns.add(pageTitle, BorderLayout.NORTH);
	pageTitle.setForeground(Color.black);

	//place the display on the mainFrame
	mainFrame.add(scoresColumns);
	mainFrame.pack();
	mainFrame.setVisible(true);


    }

    public void addReturnToMainListener(ActionListener l)
    {
	back.addActionListener(l);
    }

    public JFrame displayHighScores()
    {
	return mainFrame;
    }
}


