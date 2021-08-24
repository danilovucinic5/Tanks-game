package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Trava extends Polje {

	
	
	
	
	public Trava(Mreza m)
	{
		super(m);
		
		

	}

	
	
	
	
	
	




	@Override
	public void paint(Graphics g) {
		
		
		g.setColor(Color.GREEN);
		
		g.fillRect(0, 0, getWidth(), getHeight());
		
		
		
		
		if (!figurice.isEmpty())
		{
			for (Figura f:figurice)
				f.iscrtaj();
		}
		
		
	}






	@Override
	public boolean MozeSeNaci(Figura f) {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
