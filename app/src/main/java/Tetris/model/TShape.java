package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class TShape extends TetrisShape
{
     private int orientation;
     private Color color;

     public TShape(Color color)
     {
	 super(color);
	 this.color = color;

	//set up initial T shaped block using array
	blockArray.add(0, new ArrayList<Block>(Arrays.asList(null, new Block(color), null)));
	blockArray.add(1, new ArrayList<Block>(Arrays.asList(new Block(color), new Block(color), new Block(color))));
	
	orientation = 1; 
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
	blockArray.clear();

	if(orientation == 1)
	{

	     blockArray.add(0, new ArrayList<Block>(Arrays.asList(new Block(color))));
	     blockArray.add(1, new ArrayList<Block>(Arrays.asList(new Block(color), new Block(color))));
	     blockArray.add(2, new ArrayList<Block>(Arrays.asList(new Block(color))));

	     orientation = 2;
	}

	else if(orientation == 2)
	{

	     blockArray.add(0, new ArrayList<Block>(Arrays.asList(new Block(color), new Block(color), new Block(color))));
	     blockArray.add(1, new ArrayList<Block>(Arrays.asList(null, new Block(color), null)));
	     
	     orientation = 3;
	}

	else if(orientation == 3)
	{
	     blockArray.add(0, new ArrayList<Block>(Arrays.asList(null, new Block(color))));
	     blockArray.add(1, new ArrayList<Block>(Arrays.asList(new Block(color), new Block(color))));
	     blockArray.add(2, new ArrayList<Block>(Arrays.asList(null, new Block(color))));

	     orientation = 4;
	}

	else if(orientation == 4)
	{
	     blockArray.add(0, new ArrayList<Block>(Arrays.asList(null, new Block(color), null)));
	     blockArray.add(1, new ArrayList<Block>(Arrays.asList(new Block(color), new Block(color), new Block(color))));
	     
	     orientation = 1; 
        }

    }
}


