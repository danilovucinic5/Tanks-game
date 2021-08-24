package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Novcic extends Figura {

	public Novcic(Polje p) {
		super(p);
		
		
		
	}

	@Override
	public void iscrtaj() {

		
		Graphics g=this.polje.getGraphics();
		
		
		g.setColor(Color.YELLOW);
		
		
		g.fillOval(polje.getWidth()/4, polje.getHeight()/4, polje.getWidth()/2, polje.getHeight()/2);
		
	
		
	}

}
