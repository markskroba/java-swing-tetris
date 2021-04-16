package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Square extends TetrisShape
{
     private int orientation;
     private Color color;

     public Square(Color color)
     {
	 super(color);
	 this.color = color;

	//set up initial Square shaped block using array
	blockArray.add(0, new ArrayList<Block>(Arrays.asList(new Block(color), new Block(color))));
	blockArray.add(1, new ArrayList<Block>(Arrays.asList(new Block(color), new Block(color))));
	 
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
	//Does not have an effect on a square
     }
}


