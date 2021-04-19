package view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

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

		drawNextFigure();
	}

	private void drawNextFigure()
	{
		System.out.println("Draws a next figure to be dropped");
	}
}

