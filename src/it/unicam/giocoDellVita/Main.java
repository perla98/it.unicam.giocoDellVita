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
				
				earth.print();
				
				while(earth.move())
				{
					earth.print();
				
					Thread.sleep(1);
				}
				
			}
	
}
