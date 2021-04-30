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

	protected int length;

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
			for (int j=0; j<4; j++)
			{
				nextShape.get(i).add(j, new Block());
			}
		}

		if(shape.equals("LShape"))
		{
			nextShape.get(1).get(0).setColor(color);
			nextShape.get(2).get(0).setColor(color);
			nextShape.get(1).get(1).setColor(color);
			nextShape.get(1).get(2).setColor(color);
		}
		else if(shape.equals("ZShape"))
		{
			nextShape.get(1).get(0).setColor(color);
			nextShape.get(1).get(1).setColor(color);
			nextShape.get(2).get(1).setColor(color);
			nextShape.get(2).get(2).setColor(color);
		}
		else if(shape.equals("SShape"))
		{
			nextShape.get(1).get(1).setColor(color);
			nextShape.get(1).get(2).setColor(color);
			nextShape.get(2).get(0).setColor(color);
			nextShape.get(2).get(1).setColor(color);
		}
		else if(shape.equals("Square"))
		{
			nextShape.get(1).get(2).setColor(color);
			nextShape.get(1).get(1).setColor(color);
			nextShape.get(2).get(2).setColor(color);
			nextShape.get(2).get(1).setColor(color);
		}
		else if(shape.equals("TShape"))
		{
			nextShape.get(1).get(1).setColor(color);
			nextShape.get(2).get(0).setColor(color);
			nextShape.get(2).get(1).setColor(color);
			nextShape.get(2).get(2).setColor(color);
		}
		else if(shape.equals("Straight"))
		{
			nextShape.get(0).get(1).setColor(color);
			nextShape.get(1).get(1).setColor(color);
			nextShape.get(2).get(1).setColor(color);
			nextShape.get(3).get(1).setColor(color);
		}
		
		int side = length/4;
		for (int i=0; i<4; i++)
		{
			for (int j=0; j<4; j++)
			{
				if(nextShape.get(i).get(j).getColor() != null)
				{		
					JPanel block = new JPanel();
					block.setPreferredSize(new Dimension(side,side));
					block.setBackground(color);
					Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
					block.setBorder(border);
					this.add(block);
					this.revalidate();
					this.repaint();
				}
			}
		}

	}
}

