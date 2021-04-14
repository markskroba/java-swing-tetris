package model;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;

public class TShape extends JPanel implements TetrisShape
{
     protected Block[][] gridShape;
     private JPanel shapePanel;

     public TShape(int side, Color color)
     {
	GridLayout layout = new GridLayout(3,3);
	layout.setHgap(0);
	layout.setVgap(0);
	this.setLayout(layout);
	this.setPreferredSize(new Dimension(3*side, 3*side));

	gridShape = new Block[3][3];

	//set up initial T shaped block using array
	gridShape[0][0] = new Block(side, color, true, false);
	gridShape[0][1] = new Block(side, color, true, false);
	gridShape[0][2] = new Block(side, color, true, false);
	gridShape[1][0] = new Block(side, color, false, false);
	gridShape[1][1] = new Block(side, color, true, false);
	gridShape[1][2] = new Block(side, color, false, false);
	gridShape[2][0] = new Block(side, color, false, false);
	gridShape[2][1] = new Block(side, color, false, false);
	gridShape[2][2] = new Block(side, color, false, false);

	//add the sub-panels (aka blocks) to a larger panel that can be updated
	for(int i=0; i<3; i++)
	{
	     for(int j=0; j<3; j++)
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
	if(gridShape[0][0].isActive() == true && gridShape[2][0].isActive() == false)
	{
	     gridShape[0][0].setIsActive(false);
	     gridShape[0][1].setIsActive(false);
	     gridShape[1][2].setIsActive(true);
	     gridShape[2][2].setIsActive(true);
	}

	else if(gridShape[0][0].isActive() == false && gridShape[2][0].isActive() == false)
	{
	     gridShape[0][2].setIsActive(false);
	     gridShape[1][2].setIsActive(false);
	     gridShape[2][0].setIsActive(true);
	     gridShape[2][1].setIsActive(true);
	}

	else if(gridShape[0][0].isActive() == false && gridShape[2][0].isActive() == true)
	{
	     gridShape[2][2].setIsActive(false);
	     gridShape[2][1].setIsActive(false);
	     gridShape[0][0].setIsActive(true);
	     gridShape[1][0].setIsActive(true);
	}

	else if(gridShape[0][0].isActive() == true && gridShape[0][1].isActive() == true)
	{
	     gridShape[0][1].setIsActive(true);
	     gridShape[0][2].setIsActive(true);
	     gridShape[1][0].setIsActive(false);
	     gridShape[2][0].setIsActive(false);
	}

	this.revalidate();
	this.repaint();
     }
}



