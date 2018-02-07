package it.unicam.giocoDellVita;

import it.unicam.giocoDellVita.Class.*;
import it.unicam.giocoDellVita.UI.*;

public class Main {
	
	static Board _board;
	/*
	public static void main(String[] args) 
	
	{
		_board = initBoard(1,10);
		
		if (_board != null)
		
		{
		
			System.out.println(_board.neighboursCountAt(9, 9));
		
	
		
			System.out.println(_board.neighboursCountAt(3, 9));
		
		
		
		
			System.out.println(_board.neighboursCountAt(6, 9));
		
			_board.update();
		
			printBoard();
			
			
		}
		else return;
		
		System.out.println("ciao");
	}
	*/
	
	public static void main(String[] args)
			 throws java.lang.InterruptedException{
				Life earth = new Life(20);
				earth.drawWorld();
				while(true)
				{
				earth.print();
				//	earth.nextGeneration();
				//	earth.drawWorld();
				
				earth.move();
				
				
				earth.print();
				Thread.sleep(300);
				}
				
			}
	
	static Board initBoard(int h, int w)
	{
		try {
			return new Board(h,w);
		} catch (Exception e) {
			
			errDialog.showError(e);
			
		}
		
		return null;
	}
	
	static void printBoard()
	{
		for (int i = 0 ; i < _board.getGrid().length ; i++ )
			for (int h = 0; h < _board.getGrid()[i].length ; h++)
				System.out.println(_board.getGrid()[i][h].getState());
	}
	
}
