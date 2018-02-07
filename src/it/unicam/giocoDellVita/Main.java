package it.unicam.giocoDellVita;

import it.unicam.giocoDellVita.Class.*;


public class Main {
	static Life earth;
	
	public static void main(String[] args) throws java.lang.InterruptedException{
		
		if(args.length > 0)
			earth = new Life(Integer.parseInt(args[0]));
		else
				earth = new Life(20);
		
				earth.drawWorld();
				
				while(true)
				{
					earth.print();
				
					earth.move();

					Thread.sleep(3);
				}
				
			}
	
}
