package it.unicam.giocoDellVita.Class;

import java.util.Random;

public class Board {
	
	private static Random _random = new Random();
	private Cell[][] _grid;
    private int _height=3; //bottom right pos: grid[height-1][width-1]
    private int _width=3;

    public Board(Cell[][] grid) {
        this._grid = grid;
        _height = _width = grid.length;
    }

    /**
     * @param height
     * @param width
     * @throws Exception 
     */
	
	  public Board(int height, int width) throws Exception {
		  if(height > 1 && width > 1) {
	        this._height=height;
	        this._width = width;
	        _grid = new Cell[height][width];
	        
	        for (int h=0; h<_grid.length; h++){
	            for (int w=0; w<_grid[h].length; w++){
	                _grid[h][w] = new Cell();
	                generateState(h,w);
	            }
	        }
		  }
		  else throw new Exception("dimensioni non valide");
	    }

	    public Cell[][] getGrid() {
	        return _grid;
	    }
	    
	    public int getSize() {
	        return _width;
	    }
	    
	   

	    public int neighboursCountAt(int row, int col) {
	        int sum=0;
	        // Positions numbered as phone dial
	        if (row != 0 && col != 0){    //1
	            if(isAlive(row-1,col-1))
	                sum++;
	            
	        }
	        
	        if (row != 0){
	            if(isAlive(row-1,col)) //2
	            sum++;
	            
	        }
	        
	        if (row != 0 && col != _width-1){//3
	            if(isAlive(row-1,col+1))
	                sum++;
	            
	        }
	        if (col != 0){
	            if(isAlive(row,col-1)) //4
	            sum++;
	            
	        }
	        //self
	        if (col != _width-1){
	            if(isAlive(row,col+1)) //6
	                sum++;
	            
	        }

	        if (row != _height-1 && col != 0){
	            if(isAlive(row+1,col-1)) //7
	                sum++;
	            
	        }

	        if (row != _height-1){
	            if(isAlive(row+1,col)) //8
	            sum++;
	            
	        }

	        if (row != _height-1 && col != _width-1){
	            if(isAlive(row+1,col+1)) //9
	                sum++;
	            
	        }

	        return sum;
	    }

	    public boolean isAlive(int row, int col) {
	        return _grid[row][col].getState();
	    }
	    
	    
	    private void generateState(int x, int y)
	    {
	    	if (_random.nextDouble() <= 1){
                _grid[x][y].setNewState(true);
                _grid[x][y].updateState();
            }
	    }

	    public void update() {
	        prepare();
	        commit();
	    }

	    /**
	     * Assigns new state to individual Cells 
	     * according to GoF rules
	     */
	    private void prepare() {
	        for (int h=0; h<_grid.length; h++){
	            for (int w=0; w<_grid[h].length; w++){
	                int nr = neighboursCountAt(h,w);                
	                if (nr < 2) { _grid[h][w].setNewState(false);}  //underpop
	                else if (nr > 3) { _grid[h][w].setNewState(false);} //overcrowd
	                else if (nr == 3) { _grid[h][w].setNewState(true);} //born
	                else if (nr == 2) { _grid[h][w].setNewState(_grid[h][w].getState());} // stay same
	            }
	        }
	    }

	    /**
	     * Updates Cell state based on newState
	     */
	    
	    
	    private void commit() {
	        for (int h=0; h<_grid.length; h++)
	            for (int w=0; w<_grid[h].length; w++)
	                _grid[h][w].updateState();
	            
	        
	    }

}
