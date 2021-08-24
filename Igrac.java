package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Figura{

	public Igrac(Polje p)
	{
		
		super(p);
		
	}

	@Override
	public void iscrtaj() 
	{
			
			int w=this.polje.getWidth();
			int h=this.polje.getHeight();
			
			Graphics g=this.polje.getGraphics();
			
			g.setColor(Color.RED);
			
			g.drawLine(polje.getWidth()/2, 0,polje.getWidth()/2 , polje.getHeight());
			g.drawLine(0, polje.getHeight()/2, polje.getWidth(), polje.getHeight()/2);
			
			
			
		
		
	}

}
