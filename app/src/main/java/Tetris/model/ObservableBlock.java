package model;
import java.util.ArrayList;

public class ObservableBlock extends Block
{
	//protected ArrayList<BlockObserver> observers;
	public ObservableBlock()
	{
		/*
		super();
		observers = new ArrayList<BlockObserver>();
		*/
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

	public void moveVertically(int length)
	{
		System.out.println("moves the block vertically");
		//notifyObservers();
	}

	public void moveHorizontally(int length)
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
