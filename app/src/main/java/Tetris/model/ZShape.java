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
		int center = numCols/2;

		this.blockArray.get(0).add(center-1, new Block(color));
		this.blockArray.get(0).add(center, new Block(color));
		this.blockArray.get(1).add(center, new Block(color));
		this.blockArray.get(1).add(center+1, new Block(color));

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
