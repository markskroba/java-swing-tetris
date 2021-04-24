package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class LShape extends TetrisShape
{
	public LShape(Color color)
	{
		super(color);

		//add the shape to the center top of the this.blockArray
		int center = numCols/2;

		this.blockArray.get(0).get(center).setColor(color);
		this.blockArray.get(0).get(center+1).setColor(color);
		this.blockArray.get(0).get(center-1).setColor(color);
		this.blockArray.get(1).get(center-1).setColor(color);

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


