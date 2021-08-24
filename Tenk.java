package igra;

import java.awt.Color;
import java.awt.Graphics;

public class Tenk extends Figura implements Runnable {

	private boolean radi;
	
	private Thread nit=new Thread(this);
	
	
	
	public Tenk(Polje p) {
		
		super(p);
		nit.start();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void iscrtaj() {
		
		
		int w=this.polje.getWidth();
		int h=this.polje.getHeight();
		
		Graphics g=this.polje.getGraphics();
		
		g.setColor(Color.BLACK);
		
		g.drawLine(0, 0,polje.getWidth() , polje.getHeight());
		g.drawLine(0, polje.getHeight(), polje.getWidth(), 0);
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	public void prekini()
	{
		nit.interrupt();
	}
	public synchronized void pokreni()
	{
		radi=true;
		notifyAll();
	}
	@Override
	public void run() {
	
		try 
		{
	
			while(!Thread.interrupted())
			{		
				
			synchronized(this)
				{
					while (!radi)
						wait();
				}	
			
			
			
			
			int rnd=(int)(Math.random()*4+1);
			
			switch (rnd)
			{
			
			case 1:
			
				
				
				int[] niz=this.polje.Koordinate();
				int x=niz[0];
				int y=niz[1];
				
				if (x+1<this.polje.getM().getMatrix().length&& polje.getM().getMatrix()[x+1][y] instanceof Trava)
				{
					this.polje.getM().getMatrix()[x][y].figurice.remove(this);
					this.pomeri(this.polje.getM().getMatrix()[x+1][y]);
					this.polje.getM().getMatrix()[x+1][y].setFigurice(this);
					
				}	
				
				
			break;
			
			case 2:
				/*
				Polje p1=this.polje.dohvatiSaPomerajemKolona(-1);
				if (p1==null||p1 instanceof Zid)
					break;
				else
				{
					this.polje.setF(null);
					p1.setF(this);                                                                           
					this.pomeri(p1);
					
				}
			*/
				
				
			
				
				int[] niz1=this.polje.Koordinate();
				int x1=niz1[0];
				int y1=niz1[1];
				
				if (x1-1>=0&& polje.getM().getMatrix()[x1-1][y1] instanceof Trava)
				{
					this.polje.getM().getMatrix()[x1][y1].figurice.remove(this);
					this.pomeri(this.polje.getM().getMatrix()[x1-1][y1]);
					this.polje.getM().getMatrix()[x1-1][y1].setFigurice(this);
					
				}	
				
	
				
				
				
				
				
				
			break;
			case 3:
			
			int[] niz2=this.polje.Koordinate();
			int x2=niz2[0];
			int y2=niz2[1];
			
			if (y2+1<this.polje.getM().getMatrix().length&& polje.getM().getMatrix()[x2][y2+1] instanceof Trava)
			{
				
				
				this.polje.getM().getMatrix()[x2][y2].figurice.remove(this);
				this.pomeri(this.polje.getM().getMatrix()[x2][y2+1]);
				this.polje.getM().getMatrix()[x2][y2+1].setFigurice(this);
				
			}	
				
			
			
			break;
			
			
			case 4:
				
				int[] niz3=this.polje.Koordinate();
				int x3=niz3[0];
				int y3=niz3[1];
				
				if (y3-1>=0&& polje.getM().getMatrix()[x3][y3-1] instanceof Trava)
				{
					this.polje.getM().getMatrix()[x3][y3].figurice.remove(this);
					this.pomeri(this.polje.getM().getMatrix()[x3][y3-1]);
					this.polje.getM().getMatrix()[x3][y3-1].setFigurice(this);
					
				}	
				
				
					break;
				}
			
				//this.polje.getM().repaint();
				Thread.sleep(500);
			
			}
		
	
		}
			
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

}
	
}
