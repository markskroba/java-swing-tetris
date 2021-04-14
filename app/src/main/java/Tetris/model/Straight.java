package model;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;


public class Straight extends JPanel implements TetrisShape
{
     protected Block[][] gridShape;
     private JPanel shapePanel;
     private GridLayout vertical;
     private GridLayout horizontal;
     private String layout;
     private Color color;
     private int side;

     public Straight(int side, Color color)
     {
	verticalLayout(side, color);
	this.color = color;
	this.side = side;
     }

     public void moveHorizontally()
     {
	System.out.println("Figure how to move horizontally later");
     }

     public void moveVertically()
     {
	System.out.println("Figure how to move vertically later");
     }

     public void verticalLayout(int side, Color color)
     {
	vertical = new GridLayout(4,1);
        this.layout = "vertical";
        vertical.setHgap(0);
        vertical.setVgap(0);
        shapePanel.setLayout(vertical);
        shapePanel.setPreferredSize(new Dimension(4*side, 1*side));

        gridShape = new Block[4][1];

        //set up initial L shaped block using array
        gridShape[0][0] = new Block(side, color, true, false);
        gridShape[1][0] = new Block(side, color, true, false);
        gridShape[2][0] = new Block(side, color, true, false);
        gridShape[3][0] = new Block(side, color, true, false);

        //add the sub-panels (aka blocks) to a larger panel that can be updated
        for(int i=0; i<4; i++)
        {
             for(int j=0; j<1; j++)
             {
                shapePanel.add(gridShape[i][j]);
	     }
	}
     }

     public void horizontalLayout(int side, Color color)
     {
	horizontal = new GridLayout(1,4);
        this.layout = "horizontal";
        horizontal.setHgap(0);
        horizontal.setVgap(0);
        shapePanel.setLayout(horizontal);
        shapePanel.setPreferredSize(new Dimension(1*side, 4*side));

        gridShape = new Block[1][4];

        //set up initial L shaped block using array
        gridShape[0][0] = new Block(side, color, true, false);
        gridShape[0][1] = new Block(side, color, true, false);
        gridShape[0][2] = new Block(side, color, true, false);
        gridShape[0][3] = new Block(side, color, true, false);

        //add the sub-panels (aka blocks) to a larger panel that can be updated
        for(int i=0; i<1; i++)
        {
             for(int j=0; j<4; j++)
             {
                shapePanel.add(gridShape[i][j]);
     	     }
	}
     }

     public void rotateShape()
     {
	if(this.layout.equals("vertical"))
	{
	     horizontalLayout(this.side, this.color);
	}

	else
	{
	     verticalLayout(this.side, this.color);
	}
	this.revalidate();
	this.repaint();
     }
}


