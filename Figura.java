package igra;

public abstract class Figura {

	
	
	protected Polje polje;
	public Figura(Polje p) {
		
		
		polje=p;
		// TODO Auto-generated constructor stub
	}
	public Polje getPolje() {
		return polje;
	}
	
	
	public void pomeri(Polje p)
	{
		polje=p;
	}
	
	
	
	
	public boolean jednak(Figura f)
	{
		if (this.polje==f.getPolje())
			return true;
		else return false;
	}
	

	public abstract void iscrtaj();
	
	
}
