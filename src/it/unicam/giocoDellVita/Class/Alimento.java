package it.unicam.giocoDellVita.Class;

public class Alimento extends Pedina{

	
	public Alimento(int x, int y) {
		
		super(x, y);
		
	}
	
	public String getImage()
	{
		return caratteriSpeciali.chCibo();
	}

}
