package igra;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Mreza extends Panel implements Runnable{

	private Polje[][] matrix;
	private Igra igra;
	private boolean radi;
	
	private int skor=0;
	private Thread nit;
	private Igrac igrac;
	private ArrayList<Tenk> tenkovi=new ArrayList<Tenk>();
	private ArrayList<Novcic> novcici=new ArrayList<Novcic>();
	
	private int dimenzija=0;
	
	public Mreza(int dimenzija,Igra igr) {
		// TODO Auto-generated constructor stub
	this.dimenzija=dimenzija;
	this.igra=igr;
	
	
	
	
	 
	
	
	
	
	
	GridLayout experimentLayout = new GridLayout(dimenzija,dimenzija);
	
	setLayout(experimentLayout);
	
	matrix=new Polje[dimenzija][dimenzija];
	
		
	int s=1;
	
	while (s<dimenzija*dimenzija*0.8)
	{
		int i=(int)(Math.random()*dimenzija);
		int j=(int)(Math.random()*dimenzija);
		
		if( matrix[i][j]==null)
			{
				matrix[i][j]=new Trava(this);
				s++;
			}
		
		
	}
	
	for  (int i=0;i<matrix.length;i++)
		for(int j=0;j<matrix[i].length;j++)
		{
			if (matrix[i][j]==null)
				
				matrix[i][j]=new Zid(this);
			}
	
	
	
	
	for  (int i=0;i<matrix.length;i++)
		for(int j=0;j<matrix[i].length;j++)
		add(matrix[i][j]);
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	public Igra getIgra() {
		return igra;
	}

	
	
	
	
	
	
	
	
	public Igrac getIgrac() {
		return igrac;
	}

	
	
	
	public void Azuriraj(int novc)
	{

		int s=1;
		
		while (s<=novc)
		{
			
			int i=(int)(Math.random()*dimenzija);
			int j=(int)(Math.random()*dimenzija);
			
			if (matrix[i][j] instanceof Trava&& matrix[i][j].figurice.isEmpty())
			{
				
				Novcic n=new Novcic(matrix[i][j]);
				matrix[i][j].setFigurice(n);
				
				novcici.add(n);
				s++;
			}
			
			
		}
		
		s=1;
		
		while (s<=novc/3)
		{
			int i=(int)(Math.random()*dimenzija);
			int j=(int)(Math.random()*dimenzija);
			
			if (matrix[i][j] instanceof Trava)
			{
				Tenk tenk=new Tenk(matrix[i][j]);
				matrix[i][j].setFigurice(tenk);
				tenkovi.add(tenk);
				tenk.pokreni();
				s++;
			}
			
			
		}
	s=1;
		
		while (s<=1)
		{
			int i=(int)(Math.random()*dimenzija);
			int j=(int)(Math.random()*dimenzija);
			
			if (matrix[i][j] instanceof Trava)
			{
				igrac=new Igrac(matrix[i][j]);
				matrix[i][j].setFigurice(igrac);
				s++;
			}
			
			
		}
	}
	
	
	
	
	
	
	public Mreza(Igra igra)
	{
		this(17,igra);
		
		
	}
	
	
	
	
	
	
	


	public void setSkor(int skor) {
		this.skor = skor;
	}






	public int getSkor() {
		return skor;
	}






	public Polje[][] getMatrix() {
		return matrix;
	}

	
	
	
	
	public boolean isRadi() {
		return radi;
	}







	public void setRadi(boolean radi) {
		this.radi = radi;
	}







	public synchronized void pokreni()
	{
		
		nit=new Thread(this);
		nit.start();
		radi=true;
		notifyAll();
	}
	
	
	public void paint(Graphics g)
	{
		for (int i=0;i<matrix.length;i++)
		{
			for (int j=0;j<matrix[i].length;j++)
			{
				matrix[i][j].repaint();
			}
		}
		
	}
	
	
	
	@Override
	public void run() {
		
		Azuriraj(igra.getBroj());
		
		try 
		{
	
			while(!Thread.interrupted())
			{		
				
			synchronized(this)
				{
					while (!radi)
						wait();
				}
			
			
			int j=0;
			boolean bl=false;
			for(int i=0;i<novcici.size();i++)
			{
				Novcic n=novcici.get(i);
				
				if (n.getPolje()==igrac.getPolje())
				{
					j=i;
					bl=true;
					break;
				
					
				}
			}
			
			if (bl)
			{
				novcici.get(j).getPolje().figurice.remove(novcici.get(j));
				novcici.remove(j);
				skor++;
				 igra.getPoeni().setText("Poeni "+getSkor());
				 if (novcici.isEmpty())
				 {
					 /*
					 for (Tenk t1:tenkovi)
							t1.prekini();
							System.out.println(skor);
							nit.interrupt();
				 	*/
					 
					Prekini(); 
				 }
			}
			
			
			for (Tenk t :tenkovi)
			{
				if (t.getPolje()==igrac.getPolje())
				
					
					Prekini();
					/*
				{
					for (Tenk t1:tenkovi)
					t1.prekini();
					System.out.println(skor);
					nit.interrupt();
				}	
				*/
			}
			
			
			
			
			repaint();
			
			
			Thread.sleep(40);
			
			
			
		
	}
		}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

	
		
		
	}
	
	
	
	
	public Thread getNit() {
		return nit;
	}







	public void Prekini()
	{
		if (!tenkovi.isEmpty())
		{
		for (Tenk t1:tenkovi)
			t1.prekini();
			
		}	
			
			
			nit.interrupt();
			
			radi=false;
			
		
			
		for(int i=0;i<matrix.length;i++)
			for (int j=0;j<matrix.length;j++)
				matrix[i][j].figurice.clear();
		
		igrac=null;
		
		novcici.clear();
		
		tenkovi.clear();
		
		skor=0;
			
		igra.getPoeni().setText("Poeni "+getSkor());
			
	}
	
	
	
	
}
