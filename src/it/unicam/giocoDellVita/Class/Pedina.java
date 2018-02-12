package it.unicam.giocoDellVita.Class;


public abstract class Pedina {
	//La posizione della pedina nella scacchiera
	private int x;
	private int y;
	
	
	
	public Pedina(int x, int y){
		this.x=x;
		this.y=y;
		
	}

	public int getX()
	{
		return x;
		
	}
	
	
	public int getY()
	{
		return y;
		
	}
	
	public String getImage()
	{
		return "";
	}

	public void update(int x, int y)
	{
		if (x >= 0 && y >= 0)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	
	

}
