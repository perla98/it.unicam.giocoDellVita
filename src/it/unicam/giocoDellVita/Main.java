package it.unicam.giocoDellVita;

import it.unicam.giocoDellVita.Class.*;

public class Main {
	
	static Board _board;
	
	public static void main(String[] args) 
	
	{
		
		_board = new Board(10, 10, 1.6);
		
		System.out.println(_board.neighboursCountAt(9, 9));
		
	
		
		System.out.println(_board.neighboursCountAt(3, 9));
		
		
		
		
		System.out.println(_board.neighboursCountAt(6, 9));
		
		_board.update();
		
		printBoard();
		
	}
	
	
	static void printBoard()
	{
		for (int i = 0 ; i < _board.getGrid().length ; i++ )
			for (int h = 0; h < _board.getGrid()[i].length ; h++)
				System.out.println(_board.getGrid()[i][h].getState());
	}
	
}
