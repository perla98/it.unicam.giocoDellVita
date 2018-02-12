package it.unicam.giocoDellVita.Class;

 class Animale extends Pedina {
	private int vita;
	private tipoSpecie specie;
	
	/**
	 * Costruttore per la creazione di un animale
	 * @param x
	 * @param y
	 * @param vita
	 * @param specie
	 */
	protected Animale(int x, int y, tipoSpecie specie ){
		super(x,y);
		this.vita = 10;
		this.specie = specie;
	}
	
	public Pedina[] checkMovement(Pedina pedina, Pedina nextPedina)
	{
		Pedina[] pv = new Pedina[2];
		pv[0] = pedina;
		pv[1] = nextPedina;
		
		if (vita > 0)
		{ 
		if (nextPedina instanceof Alimento)
		{
			vita++;
			pv[1] = new Vuota(pedina.getX(), pedina.getY());
		}
		else
			vita--;
		
		if (nextPedina instanceof Animale)
		{
			if(specie == tipoSpecie.SPECIE1)
			if (vita >= 5 && vita <= 20)
				pv[1] = new Vuota(pedina.getX(), pedina.getY());
		
			if (specie == tipoSpecie.SPECIE2)
				if(vita >= 20)
				{
				pv[1] = new Animale(pedina.getX(), pedina.getY(), tipoSpecie.SPECIE2);
				vita -= 10;
				}
		}
		} else
			pv[0] = new Vuota(pedina.getX(), pedina.getY()); 
		
		return pv;
	}
	
	
	
	
	public String getImage()
	{
	
		return caratteriSpeciali.chAnimale(specie);
	}
	
	
	

}
