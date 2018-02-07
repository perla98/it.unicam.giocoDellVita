package it.unicam.giocoDellVita.Class;

import java.util.Random;

public class Pedina {
	//La posizione della pedina nella scacchiera
	private int x;
	private int y;
	private boolean currentLifeStatus;
	private static Random random = new Random();
	
	public Pedina(int x, int y){
		this.x=x;
		this.y=y;
		generateLifeStatus();
	}
	
	private void generateLifeStatus()
	{
		if(random.nextInt(2) == 1)
		currentLifeStatus = true;
		else
			currentLifeStatus = false;
	}
	
	public int getX()
	{
		return x;
		
	}
	
	
	public int getY()
	{
		return y;
		
	}
	public boolean getLifeStatus()
	{
		return currentLifeStatus;
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
