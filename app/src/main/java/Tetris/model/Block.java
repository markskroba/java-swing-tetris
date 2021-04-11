//package model;
import java.awt.Color;
import java.util.Random;

public class Block
{
	protected Color blockColor;
	protected boolean isActive;
	protected boolean isSettle;
	protected Color[] colorSelectionArray;
	protected Random rand;
	
	public Block()
	{
		isActive = false;
		isSettle = false;
		
		colorSelectionArray = new Color[7];
		colorSelectionArray[0] = Color.cyan;
		colorSelectionArray[1] = Color.blue;
		colorSelectionArray[2] = Color.orange;
		colorSelectionArray[3] = Color.yellow;
		colorSelectionArray[4] = Color.green;
		colorSelectionArray[5] = Color.magenta;
		colorSelectionArray[6] = Color.red;
		
		rand = new Random();
	}
	
	public void setColor()
	{
		blockColor = colorSelectionArray[rand.nextInt(7)];
	}
	
	public void getColor()
	{
		return blockColor;
	}
	
	public void setIsActive()
	{
		System.out.println("Sets the value of isActive");
	}
	
	public void setIsSettle()
	{
		System.out.println("Sets the value of isSettle");
	}
	
	public boolean isActive()
	{
		return isActive;
	}
	
	public boolean isSettle()
	{
		return isSettle;
	}
}
