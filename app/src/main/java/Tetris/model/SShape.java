package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class SShape extends TetrisShape
{
public SShape(Color color)
{
	super(color);

	//add shape to the center top of the shapeArray
	int center = numCols/2;

	this.blockArray.get(1).add(center-1, new Block(this.shapeColor));
	this.blockArray.get(1).add(center, new Block(this.shapeColor));
	this.blockArray.get(0).add(center, new Block(this.shapeColor));
	this.blockArray.get(0).add(center+1, new Block(this.shapeColor));

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

