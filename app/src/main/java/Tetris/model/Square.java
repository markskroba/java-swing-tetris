package model;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;

public class Square extends JPanel implements TetrisShape
{
     protected Block[][] gridShape;
     private JPanel shapePanel;

     public Square(int side, Color color)
     {
	GridLayout layout = new GridLayout(2,2);
	layout.setHgap(0);
	layout.setVgap(0);
	this.setLayout(layout);
	this.setPreferredSize(new Dimension(2*side, 2*side));

	gridShape = new Block[2][2];

	//set up initial Square shaped block using array
	gridShape[0][0] = new Block(side, color, true, false);
	gridShape[0][1] = new Block(side, color, true, false);
	gridShape[1][0] = new Block(side, color, true, false);
	gridShape[1][1] = new Block(side, color, false, false);

	//add the sub-panels (aka blocks) to a larger panel that can be updated
	for(int i=0; i<2; i++)
	{
	     for(int j=0; j<2; j++)
	     {
		this.add(gridShape[i][j]);
	     }
	}
     }

     public void moveHorizontally()
     {
	System.out.println("Figure how to move horizontally later");
     }

     public void moveVertically()
     {
	System.out.println("Figure how to move vertically later");
     }

     public void rotateShape()
     {
	//don't need to code anything because rotating a square 90 deg doesn't change how it looks
     }
}
