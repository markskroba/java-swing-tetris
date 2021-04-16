package view;
import model.*;
import controller.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class GamePanel extends JPanel {
    
    protected BlockController controller;

    public GamePanel(int x, int y)
    {
        FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(x, y));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);
    }

/*    public void addTetrisShape(TetrisShape shape)
    {
	controller = new BlockController(shape);

	this.addKeyListener(controller);

    }*/
}
