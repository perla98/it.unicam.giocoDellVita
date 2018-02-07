package it.unicam.giocoDellVita;

import it.unicam.giocoDellVita.Class.*;


public class Main {
	
	public static void main(String[] args)
			 throws java.lang.InterruptedException{
				Life earth = new Life(20);
				earth.drawWorld();
				while(true)
				{
					earth.print();
				
					earth.move();

					Thread.sleep(300);
				}
				
			}
	
}
