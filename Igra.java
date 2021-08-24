package igra;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Igra extends Frame{

	private boolean radi=true;
	private Mreza mreza;
	private Polje p;
	
	private MenuBar coda;
	private Menu Rezim;
	private int broj;
	private MenuItem rezimizmena;
	private MenuItem rezimigranje;
	private Button pocni;
	private TextField tf;
	private Label Novcica;
	private Label Poeni;
	private Checkbox trava;
	private Checkbox zid;
	private CheckboxGroup cb;
	public Igra() {
		
		mreza=new Mreza(Igra.this);
		
		setSize(400,400);
		add(mreza,BorderLayout.CENTER);
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			dispose();
			}
			});
		
		
		
		 coda=new MenuBar();
		
		 Rezim=new Menu("Izmena");
		
		 rezimizmena=new MenuItem("Rezim izmena");
		 rezimigranje=new MenuItem("Rezim igranje");
		
		
		Rezim.add(rezimizmena);
		Rezim.add(rezimigranje);
		coda.add(Rezim);
		setMenuBar(coda);
		
		
		Rezim.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				if
				(e.getActionCommand()=="Rezim izmena")
				{
					radi=false;
					
					if (mreza.isRadi())
					mreza.Prekini();
				}
				
				else
				{
					radi=true;
				}
				
			}
				});
		
		
		
		 pocni =new Button("Pocni");
		
		
		 tf=new TextField();
		 Novcica=new Label("Novcica:");
		 Poeni=new Label("Poeni "+mreza.getSkor());
		
		
		 
		
		pocni.addMouseListener(new java.awt.event.MouseAdapter()
	    {
	        public void mousePressed(java.awt.event.MouseEvent evt)
	        {
	        	
	            if (radi)
	            {
	            	String s=tf.getText();
	            	
	            	if (s!="")
	            	
	            	
	            	{
	            	int nov=Integer.parseInt(s);
	            	broj=nov;
	            //	System.out.println("USO");
	            //	System.out.println(mreza.getNit().getState());
	            //	System.out.println(mreza.getNit().isInterrupted());
	            	
	            	/*
	            	if (mreza.getNit().getState()==Thread.State.TERMINATED)
	            	{
	            		System.out.println("uso");
	            		for (int i=0;i<mreza.getMatrix().length;i++)
	            			for (int j=0;j<mreza.getMatrix().length;j++)
	            				mreza.remove(i*mreza.getMatrix().length+j);
	            			mreza.repaint();
	            		
	            		
	            		mreza=new Mreza(Igra.this);
	            		mreza.repaint();
	            	}
	            	*/
	            	
	            	if (mreza.isRadi())
	            	{
	            		mreza.Prekini();
	            	}
	            	
	            	
	        		mreza.pokreni();
	            }
	            }
	        }
	    });
		
		
		
		
		
		Panel down=new Panel();
		
		down.add(Novcica);
		down.add(tf);
		down.add(Poeni);
		down.add(pocni);
		
		
		
		add(down,BorderLayout.SOUTH);
		
		cb=new CheckboxGroup();
		
		trava=new Checkbox("Trava",cb,true);
		
		zid=new Checkbox("Zid",cb,false);
		
		trava.setBackground(Color.GREEN);
		
		zid.setBackground(Color.LIGHT_GRAY);
		
		
		
		Panel travaa=new Panel();
		
		
		GridLayout experimentLayout2 = new GridLayout(0,1);
		
		travaa.setLayout(experimentLayout2);
		
		
		travaa.setBackground(Color.GREEN);
		
		travaa.add(trava,BorderLayout.CENTER);
		
		
		
		
		Panel zidic=new Panel();
		
		GridLayout experimentLayout3 = new GridLayout(0,1);
		
		zidic.setLayout(experimentLayout3);
		
		zidic.setBackground(Color.LIGHT_GRAY);
		
		zidic.add(zid,BorderLayout.CENTER);
		
		
		Panel podloge=new Panel();
		
		
		
		

		GridLayout experimentLayout = new GridLayout(0,1);
		
		podloge.setLayout(experimentLayout);
		
		podloge.add(travaa);
		
		podloge.add(zidic);
		
		
		Panel Sivo=new Panel();
		
		GridLayout experimentLayout4 = new GridLayout(0,1);
		
		Sivo.setLayout(experimentLayout4);
		
		
		Label l=new Label("Podloge:");
		
		l.setBackground(Color.WHITE);
		
		Sivo.add(l,BorderLayout.CENTER);
		
		
		
		
		
		
		
		
		Panel glavni=new Panel();
		
		GridLayout experimentLayout1 = new GridLayout(1,0);
		
		glavni.setLayout(experimentLayout1);
		
		glavni.add(Sivo);
		
		glavni.add(podloge);
		
		
		add(glavni,BorderLayout.EAST);
		
		
		
		
		
		
		
		setVisible(true);
		
		
	}
			
	
	

	
	
public Checkbox getZid() {
		return zid;
	}






	public Checkbox getTrava() {
	return trava;
}






	public void setZid(Checkbox zid) {
		this.zid = zid;
	}






public int getBroj() {
		return broj;
	}






public Label getPoeni() {
		return Poeni;
	}






public boolean isRadi() {
		return radi;
	}




public static void main(String[] args)
{
	
	
	
	Igra gir=new Igra();
	
	
	
	
	
}
	
	
	
}
