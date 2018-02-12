package it.unicam.giocoDellVita.Class;

 class Alimento extends Pedina{

	
	protected Alimento(int x, int y) {
		
		super(x, y);
		
	}
	
	public String getImage()
	{
		return caratteriSpeciali.chCibo();
	}

}
