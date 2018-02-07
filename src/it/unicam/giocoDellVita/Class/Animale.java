package it.unicam.giocoDellVita.Class;

public class Animale extends Pedina {
	private int vita = 10;
	private tipoSpecie specie;
	
	/**
	 * Costruttore per la creazione di un animale
	 * @param x
	 * @param y
	 * @param vita
	 * @param specie
	 */
	public Animale(int x, int y, tipoSpecie specie ){
		super(x,y);
		this.specie = specie;
	}
	
	public void checkMovement(Pedina pedina, Pedina nextPedina)
	{
		if (vita > 0)
		{
		if (nextPedina instanceof Alimento)
		{
			vita++;
			nextPedina  = new Vuota(pedina.getX(), pedina.getY());
		}
		else
			vita--;
		
		if (nextPedina instanceof Animale)
		{
			if(specie == tipoSpecie.SPECIE1)
			if (vita >= 5 && vita <= 20)
				nextPedina = new Vuota(pedina.getX(), pedina.getY());
		
			if (specie == tipoSpecie.SPECIE2)
				if(vita >= 20)
				{
				nextPedina = new Animale(pedina.getX(), pedina.getY(), tipoSpecie.SPECIE2);
				vita -= 10;
				}
		}
		} else
			pedina = new Vuota(pedina.getX(), pedina.getY());
	}
	
	public String getImage()
	{
		if (specie == tipoSpecie.SPECIE1)
		return caratteriSpeciali.chAnimale1();
		
		else
			return caratteriSpeciali.chAnimale2();
	}
	
	
	

}
