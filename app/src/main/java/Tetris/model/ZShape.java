package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class ZShape extends TetrisShape
{
	public ZShape(Color color)
	{
		super(color);
		
		//add the shape to the center top of the array
		center = numCols/2;

		this.blockArray.get(0).get(center-1).setColor(color);
		this.blockArray.get(0).get(center).setColor(color);
		this.blockArray.get(1).get(center).setColor(color);
		this.blockArray.get(1).get(center+1).setColor(color);
		
	}

	public void rotateShape()
	{
	
	}
}
