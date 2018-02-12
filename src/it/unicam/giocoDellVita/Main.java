package it.unicam.giocoDellVita;

import it.unicam.giocoDellVita.Class.*;


public class Main {
	private static Life earth;
	
	public static void main(String[] args) throws java.lang.InterruptedException{
		
		if(args.length > 0)
			earth = initLife(Integer.parseInt(args[0]));
		else
				earth = initLife(20);
		
				earth.drawWorld();
				
				earth.print();
				
				while(earth.move())
				{
					earth.print();
				
					Thread.sleep(5);
				}
				
			}
	
	private static Life initLife(int size) 
	{
		try {
			return new Life(size);
		} catch (Exception e) {
			
			System.err.println(e);
			return null;
		}
	}
	
}
