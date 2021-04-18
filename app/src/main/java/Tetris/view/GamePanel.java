package view;
import model.*;
import controller.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class GamePanel implements TetrisUserInterface {
    
    protected BlockController controller;
    protected JPanel gameArea;

    public GamePanel(int x, int y)
    {
        gameArea = new JPanel();
	FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        gameArea.setLayout(layout);
        gameArea.setPreferredSize(new Dimension(x, y));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        gameArea.setBorder(border);
    }


    public void updateView(TetrisArray gameScreen)
    {
	System.out.println("Draws the blocks represented by the TetrisArray");
    }

    public JPanel getGameArea()
    {
	return gameArea;
    }
}
