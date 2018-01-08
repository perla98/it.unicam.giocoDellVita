package it.unicam.giocoDellVita;

import it.unicam.giocoDellVita.Class.*;

public class Main {
	
	static Board _board;
	
	public static void main(String[] args) 
	
	{
		
		_board = new Board(10, 10, 1);
		_board.update();
	}
	
}
