//package view;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.event.*;

public class MainScreenGUI
{
	private MainScreenFrame mainScreenFrame;
	private DifficultyPanel difficultyPanel;
	private ScoreBoardPanel scoreBoardPanel;
	private JLabel gameTitleLabel;
	private JButton playButton;
	private JButton difficultyButton;
	private JLabel levelLabel;
	private JLabel highScoreLabelTitle;
	private JLabel highScoreLabel;
	
	public MainScreenGUI()
	{
		gameTitleLabel = new JLabel();
		gameTitleLabel.setText("TETRIS");
		gameTitleLabel.setForeground(new Color(0,0,0));
		gameTitleLabel.setFont(new Font("Serif",Font.BOLD,130));
		gameTitleLabel.setBounds(150,20,500,120);
		Border border = BorderFactory.createLineBorder(Color.black,3);
		gameTitleLabel.setBorder(border);
		gameTitleLabel.setBackground(new Color(24,123,205));
		gameTitleLabel.setOpaque(true);
		gameTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		Border border1 = BorderFactory.createLineBorder(Color.black,1);
		playButton = new JButton();
		playButton.setText("PLAY!");
		playButton.setForeground(new Color(255,255,255));
		playButton.setFont(new Font("sansSerif",Font.PLAIN,40));
		playButton.setBounds(290,200,200,50);
		playButton.setBackground(new Color(65,169,76));
		playButton.setOpaque(true);
		playButton.setBorder(border1);
		
		playButton.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("The play button was clicked. You will be" 
                + "taken to the game screen");
            }
        });
		
		difficultyButton = new JButton();
		difficultyButton.setText("Change Level");
		difficultyButton.setForeground(new Color(0,0,0));
		difficultyButton.setFont(new Font("sansSerif",Font.PLAIN,15));
		difficultyButton.setBounds(45,15,130,40);
		difficultyButton.setHorizontalAlignment(JLabel.CENTER);
		
		difficultyButton.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("The difficulty button was clicked. The" 
                + " difficulty will switch between easy, medium, and hard." 
                + " These terms will be seen on the label to right of the button ");
            }
        });
		
		Border border2 = BorderFactory.createLineBorder(Color.black,2);
		//levelLabel.setText("Intermediate");
		levelLabel = new JLabel();
		levelLabel.setForeground(Color.black);
		levelLabel.setFont((new Font("sansSerif",Font.PLAIN,20)));
		levelLabel.setBounds(220,15,130,40);
		levelLabel.setBorder(border2);
		levelLabel.setHorizontalAlignment(JLabel.CENTER);
		levelLabel.setBackground(Color.white);
		levelLabel.setOpaque(true);
		
		highScoreLabelTitle = new JLabel();
		highScoreLabelTitle.setText("High Score");
		highScoreLabelTitle.setForeground(new Color(255,255,255));
		highScoreLabelTitle.setFont(new Font("MV Boli",Font.PLAIN,20));
		highScoreLabelTitle.setBounds(25,-10,400,70);
		
		//highScoreLabel.setText("205");
		highScoreLabel = new JLabel();
		highScoreLabel.setForeground(new Color(0,0,0));
		highScoreLabel.setFont(new Font("Serif",Font.PLAIN,16));
		highScoreLabel.setBackground(Color.white);
		highScoreLabel.setOpaque(true);
		highScoreLabel.setBounds(25,50,100,45);
		highScoreLabel.setHorizontalAlignment(JLabel.CENTER);
		
		difficultyPanel = new DifficultyPanel();
		difficultyPanel.add(difficultyButton);
		difficultyPanel.add(levelLabel);
		
		scoreBoardPanel = new ScoreBoardPanel();
		scoreBoardPanel.add(highScoreLabelTitle);
		scoreBoardPanel.add(highScoreLabel);

		mainScreenFrame = new MainScreenFrame();
		mainScreenFrame.add(gameTitleLabel);
		mainScreenFrame.add(playButton);
		mainScreenFrame.add(difficultyPanel);
		mainScreenFrame.add(scoreBoardPanel);
		mainScreenFrame.setLayout(null);
	}
}
