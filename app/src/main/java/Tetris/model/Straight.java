package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Straight extends TetrisShape
{

	public Straight(Color color)
	{
		super(color);

		//add shape to the center top of shapeArray
		center = numCols/2;

		this.blockArray.get(0).get(center).setColor(this.shapeColor);
		this.blockArray.get(1).get(center).setColor(this.shapeColor);
		this.blockArray.get(2).get(center).setColor(this.shapeColor);
		this.blockArray.get(3).get(center).setColor(this.shapeColor);
		
		}

	public void rotateShape()
	{
		
	}
}

