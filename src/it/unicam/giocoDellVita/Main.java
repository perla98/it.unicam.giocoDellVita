package it.unicam.giocoDellVita;

import it.unicam.giocoDellVita.Class.*;
import it.unicam.giocoDellVita.UI.*;

public class Main {
	
	public static void main(String[] args)
			 throws java.lang.InterruptedException{
				Life earth = new Life(20);
				earth.drawWorld();
				while(true)
				{
				earth.print();
			
				
				earth.move();
				
				
				earth.print();
				
				
				Thread.sleep(300);
				}
				
			}
	
}
