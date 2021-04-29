package view;

import model.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

public class NextFigurePanel extends JPanel
{
	public NextFigurePanel(int length) 
	{
		this.setPreferredSize(new Dimension(length, length));
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		this.setBorder(border);
		FlowLayout layout = new FlowLayout();
		layout.setHgap(0);
		layout.setVgap(0);
		this.setLayout(layout);


	}

	public void drawNextFigure(String shape, Color color)
	{
		ArrayList<ArrayList<Block>> nextShape = new ArrayList<ArrayList<Block>> ();
		
		//populate null arraylist
		for(int i=0; i<4; i++)
		{
			for (int j=0; j<3; j++)
			{
				nextShape.get(i).add(j, new Block());
			}
		}

		if(shape.equals("LShape"))
		{
			
		}
		else if(shape.equals("ZShape"))
		{

		}
		else if(shape.equals("SShape"))
		{

		}
		else if(shape.equals("Square"))
		{

		}
		else if(shape.equals("TShape"))
		{

		}
		else if(shape.equals("Straight"))
		{

		}


	}
}

