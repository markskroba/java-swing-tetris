package controller;
import model.*;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class HighScoreController
{
    protected ArrayList<Integer> highScores;

    public HighScoreController(HighScores scores)
    {
        highScores = scores.getHighScores();
    }

    public DefaultListModel<Integer> getHighScores()
    {
        //Convert the passed in list array into a regular array
        DefaultListModel<Integer> convertedScores = new DefaultListModel<Integer>();
        for(int val: highScores)
        {
             convertedScores.addElement(val);
        }

        return convertedScores;
    }


}

