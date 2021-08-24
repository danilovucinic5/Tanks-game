package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Zid extends Polje {

	public Zid(Mreza m) {
		super(m);
		
		

	
	
	
	
	// boja i figura
	
	
}

	
	
	@Override
	public void paint(Graphics g) {
g.setColor(Color.LIGHT_GRAY);
		
		g.fillRect(0, 0, getWidth(), getHeight());
		
	}

	
	

	@Override
	public boolean MozeSeNaci(Figura f) {
		return false;
		
	}
}