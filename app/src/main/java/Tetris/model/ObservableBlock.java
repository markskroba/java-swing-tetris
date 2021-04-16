package model;
import java.util.ArrayList;
import java.awt.Color;

public class ObservableBlock extends Block
{
	//protected ArrayList<BlockObserver> observers;
	public ObservableBlock(Color color)
	{
		
		super(color);
		//observers = new ArrayList<BlockObserver>();
		
		System.out.println("ObservableBlock constructor");
	}
	
	public void notifyObservers()
	{
		System.out.println("Updates all the observers in the arrayList");
		/*
		for(int i =0; i < observers.size(); i++)
		{
		  observers.get(i).update();
		}
		*/
	}

	public void addObserver(BlockObserver o)
	{
		System.out.println("Adds the observers to the arrayList of observers");
		//observers.add(o);
	}

	public void moveVertically()
	{
		System.out.println("moves the block vertically");
		//notifyObservers();
	}

	public void moveHorizontally()
	{
		System.out.println("moves the block horizontally");
		//notifyObservers();
	}
	
	public void rotateBlock(int degree)
	{
		System.out.println("rotates the block by thee given degree");
		//notifyObservers();
	}
	
	public void setDifficulty()
	{
		System.out.println("Changes the speed of the blocks in" 
		+ " accordance to the difficulty level");
		//notifyObservers();
	}
	
	public void removeBlock()
	{
		System.out.println("Removes the block from the screen");
		//notifyObservers();
	}
	
}
