package view;
import model.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.ActionListener;

public class HighScoresGUI
{
    private JFrame mainFrame;
    public HighScores easy;
    public HighScores medium;
    public HighScores hard;
    private JButton back;

    public HighScoresGUI()
    {
	//top level container
	mainFrame = new JFrame("High Scores Display");
	mainFrame.setPreferredSize(new Dimension(800, 900));
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	//set up objects for each high score column
	this.easy = new HighScores("Easy", 200);
	this.medium = new HighScores("Medium", 200);
	this.hard = new HighScores("Hard", 200);


	// set up container for the high scores page
	JPanel highScoresDisplay = new JPanel();
	highScoresDisplay.setBackground(new Color(211,211,211));
	highScoresDisplay.setLayout(new BorderLayout());


	//add the columns to the page
	highScoresDisplay.add(this.easy, BorderLayout.WEST);
        highScoresDisplay.add(this.medium, BorderLayout.CENTER);
        highScoresDisplay.add(this.hard, BorderLayout.EAST);


	//make a container for the back to main page button
	back = new JButton("Return to Main Page");
	back.setPreferredSize(new Dimension(800, 50));
	back.setFont(new Font("Serif", Font.BOLD, 30));
	highScoresDisplay.add(back, BorderLayout.SOUTH);

	//make a label for the top of the page
	JLabel pageTitle = new JLabel("HIGH SCORES");
	pageTitle.setHorizontalAlignment(JLabel.CENTER);
	pageTitle.setFont(new Font("Serif", Font.BOLD, 48));
	pageTitle.setPreferredSize(new Dimension(800, 200));
	highScoresDisplay.add(pageTitle, BorderLayout.NORTH);
	pageTitle.setForeground(Color.black);

	//place the display on the mainFrame
	mainFrame.add(highScoresDisplay);
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


