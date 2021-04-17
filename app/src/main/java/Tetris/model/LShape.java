package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class LShape extends TetrisShape
{
     private ArrayList<ArrayList<Block>> shapeArray;
     private Color color;

     public LShape(Color color)
     {
	 super(color);
	 shapeArray = new ArrayList<ArrayList<Block>>();
	 this.color = color;

	 //create an empty array for the new shape that is the same size as the TetrisArray
	 for(int i=0; i<numRows; i++)
	 {
	    shapeArray.add(new ArrayList<Block>());
	    
	    for(int j=0; j<numCols; j++)
	    {
		shapeArray.get(i).add(j, null);
	    }
	 }



	//add the shape to the center top of the shapeArray
	int center = numCols/2;
		
	shapeArray.get(center).add(0, new Block(color));
	shapeArray.get(center+1).add(0, new Block(color));
	shapeArray.get(center-1).add(0, new Block(color));
	shapeArray.get(center-1).add(1, new Block(color)); 

     }

     public void moveHorizontally(int direction)
     {
	System.out.println("Figure how to move horizontally later");
     }

     public void moveVertically()
     {
	System.out.println("Figure how to move vertically later");
     }

     public void rotateShape()
     {
	System.out.println("Figure out how to rotate later");
     }
}


