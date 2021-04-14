package model;
import java.awt.Color;

public class TetrisFactory
{
     public TetrisShape getShape(String shape, int side, Color color)
     {
	if(shape.equals("LShape"))
	{
	     return new LShape(side, color);
	}

	else if(shape.equals("ZShape"))
	{
	     return new ZShape(side, color);
	}

	else if(shape.equals("SShape"))
	{
	     return new SShape(side, color);
	}

	else if(shape.equals("Square"))
	{
	     return new Square(side, color);
	}

	else if(shape.equals("TShape"))
	{
	     return new TShape(side, color);
	}

	else if(shape.equals("Straight"))
	{
	     return new Straight(side, color);
	}

	return null;
     }
}
