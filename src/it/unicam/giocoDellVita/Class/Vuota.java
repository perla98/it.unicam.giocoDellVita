package it.unicam.giocoDellVita.Class;

 class Vuota extends Pedina{

	protected Vuota(int x, int y) {
		super(x, y);
		
	}
	
	public String getImage()
	{
		return caratteriSpeciali.chVuota();
	}
	

}
