package igra;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public abstract class Polje extends Canvas {

	
	protected ArrayList<Figura> figurice=new ArrayList<Figura>();
	
	
	
	private Mreza m;
	
	public Polje(Mreza m) {
		this.m=m;
		
		
		
		setSize(20,20);
	
		addMouseListener(new MouseAdapter()
				{
			
			
			
			public void mousePressed(MouseEvent e) 
			
			{	
				if (!m.getIgra().isRadi())
				{
					
					
					
					
				int[] niz=Koordinate();
				
				int x=niz[0];
				int y=niz[1];
				
				if (m.getIgra().getZid().getState())
				{
				Zid zid=new Zid(m);
				m.getMatrix()[x][y]=zid;
				
				
				
				m.remove(x*m.getMatrix().length+y);
				m.add(zid,x*m.getMatrix().length+y);
				m.revalidate();
				}
				else 
					if (m.getIgra().getTrava().getState())
				{
						
					Trava trava=new Trava(m);
					m.getMatrix()[x][y]=trava;
					
					
					
					m.remove(x*m.getMatrix().length+y);
					m.add(trava,x*m.getMatrix().length+y);
					m.revalidate();
					
				}
			
				
				}
				
				
				
				//m.add(zid, x*m.getMatrix().length+y);
			}
			
				});
		
		
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed (KeyEvent e) {
				
				
				switch (e.getKeyCode())
				{
				case KeyEvent.VK_W: {
				
						
						int[] niz=m.getIgrac().getPolje().Koordinate();
	
						int x=niz[0];
						int y=niz[1];
						
						if (x-1>=0&& m.getMatrix()[x-1][y] instanceof Trava)
						{
							
							m.getMatrix()[x][y].figurice.remove(m.getIgrac());
							m.getIgrac().pomeri(m.getMatrix()[x-1][y]);
						//	if (m.getMatrix()[x-1][y].getF() instanceof Novcic)
							//	m.setSkor(m.getSkor()+1);
							m.getMatrix()[x-1][y].setFigurice(m.getIgrac());
							
							
						}
							
					
					break;
				}
				
				case KeyEvent.VK_S: {
					

					int[] niz=m.getIgrac().polje.Koordinate();
					int x=niz[0];
					int y=niz[1];
					
					if (x+1<m.getMatrix().length&& m.getMatrix()[x+1][y] instanceof Trava)
					{
						m.getMatrix()[x][y].figurice.remove(m.getIgrac());
						m.getIgrac().pomeri(m.getMatrix()[x+1][y]);
						//if (m.getMatrix()[x+1][y].getF() instanceof Novcic)
						//	m.setSkor(m.getSkor()+1);
						m.getMatrix()[x+1][y].setFigurice(m.getIgrac());
						
					}
					
					break;
				}
	case KeyEvent.VK_A: {
					
		
		

					int[] niz=m.getIgrac().polje.Koordinate();
					int x=niz[0];
					int y=niz[1];
					
					if (y-1>=0&& m.getMatrix()[x][y-1] instanceof Trava)
					{
						m.getMatrix()[x][y].figurice.remove(m.getIgrac());
						m.getIgrac().pomeri(m.getMatrix()[x][y-1]);
						
					//	if (m.getMatrix()[x][y-1].getF() instanceof Novcic)
						//	m.setSkor(m.getSkor()+1);
						m.getMatrix()[x][y-1].setFigurice(m.getIgrac());
						
					}
					
					break;
				}
	case KeyEvent.VK_D: {
		
		
		int[] niz=m.getIgrac().polje.Koordinate();
		int x=niz[0];
		int y=niz[1];
		
		if (y+1<m.getMatrix().length&& m.getMatrix()[x][y+1] instanceof Trava)
		{
			m.getMatrix()[x][y].figurice.remove(m.getIgrac());
			m.getIgrac().pomeri(m.getMatrix()[x][y+1]);
		//	if (m.getMatrix()[x][y+1].getF() instanceof Novcic)
			//	m.setSkor(m.getSkor()+1);
			m.getMatrix()[x][y+1].setFigurice(m.getIgrac());
			
		}
		
		break;
	}
				}
				
			//	System.out.println("napso sam");
			//	repaint();
				//m.repaint();
				//m.getIgra().repaint();
				
			}
		});
	
	
	
	
	}

	public Mreza getM() {
		return m;
		
		
	}

	
	
	
	
	
	public int[] Koordinate()
	{
		
		
		 for (int i = 0; i < m.getMatrix().length; i++) 
			  
	            // Loop through all elements of current row 
	            for (int j = 0; j < m.getMatrix().length; j++) 
	                
	            {
	            	
	            	if (m.getMatrix()[i][j]==this)
	            	{
	            		int[] niz=new int[2];
	            		niz[0]=i;
	            		niz[1]=j;
	            		return niz;
	            	}
	            	
	            }
		 return null;
			
			}
	
	
	
	public Polje dohvatiSaPomerajemVrsta(int p)
	{
		
		int[] niz=this.Koordinate();
		
		int i=niz[0];
		int j=niz[1];
	
		if (i+p<m.getMatrix().length&&i+p>=0)
			
					
			
			 return  m.getMatrix()[i+p][j];
		else
			return null;
		
	}
	
	
	
	
	
	
	
	@Override
	public abstract void paint(Graphics g);
	
		
	
	
	public Polje dohvatiSaPomerajemKolona(int p)
	{
		
		int[] niz=this.Koordinate();
		
		int i=niz[0];
		int j=niz[1];
	
		if (j+p<m.getMatrix().length&&j+p>=0)
			
					
			return  m.getMatrix()[i][j+p];
		else
			return null;

		
	}
	
	
	
	public abstract boolean MozeSeNaci(Figura f);
	
	public Polje dohvatiSaPomerajemKVrstaIKolona(int vrsta,int kolona)
	{
		
		int[] niz=this.Koordinate();
		
		int i=niz[0];
		int j=niz[1];
	
		if (j+kolona<m.getMatrix().length&&j+kolona>=0&&i+vrsta<m.getMatrix().length&&i+vrsta>=0)
			
					
			return  m.getMatrix()[i+vrsta][j+kolona];
		else
			return null;

		
	}

	public ArrayList<Figura> getFigurice() {
		return figurice;
	}

	public void setFigurice(Figura figurica) {
		figurice.add(figurica);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
