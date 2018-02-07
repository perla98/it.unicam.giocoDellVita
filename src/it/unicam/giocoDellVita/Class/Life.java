package it.unicam.giocoDellVita.Class;

import java.util.Random;

public class Life {
	private int dimension;
	private Pedina[][] world;
	private long generation;
	public Life(int dimension){
		this.dimension = dimension;
		createNewWorld();
		this.generation = 0;
		
	}

	// Contains the logic for the starting scenario.
	// Which cells are alive or dead in generation 0.
	private void createNewWorld(){
		Pedina[][] newWorld = new Pedina[dimension][dimension];
		for(int row = 0; row < newWorld.length; row++ ){
			for(int col = 0; col < newWorld[row].length; col++ ){
				newWorld[row][col] = new Pedina(row, col);
			}
		}
		world = newWorld;
	}

	// Draws the world in the terminal.
	public void drawWorld(){
		//System.out.print("\033[H\033[2J"); // Simulates a clear screen on linux machines
		for(int row = 0; row < world.length; row++ ){
			for(int col = 0; col < world[row].length; col++ )
				world[row][col]=assignType(world[row][col]);
	

			
			
		}
		//System.out.println("Generation:" + generation);
	}

	// Create the next generation
	public void nextGeneration(){
		Pedina[][] newWorld = new Pedina[dimension][dimension];
		for(int row = 0; row < newWorld.length; row++ ){
			for(int col = 0; col < newWorld[row].length; col++ ){
				newWorld[row][col] = new Pedina(row,col);
			}
		}
		world = newWorld;
		generation++;
	}

	// Calculate if an individual cell should be alive in the next generation.
	// Based on the game logic:
	/*
		Any live cell with fewer than two live neighbours dies, as if by needs caused by underpopulation.
		Any live cell with more than three live neighbours dies, as if by overcrowding.
		Any live cell with two or three live neighbours lives, unchanged, to the next generation.
		Any dead cell with exactly three live neighbours cells will come to life.
	*/
	
	
	private Pedina assignType(Pedina pedina)
	{
		
		int rdn = new Random().nextInt(4);
		
	if (rdn == 2)
		return new Animale(pedina.getX() , pedina.getY(), tipoSpecie.SPECIE2);
	
	if (rdn == 3)
		return new Animale(pedina.getX() , pedina.getY(), tipoSpecie.SPECIE1);
			
	if (rdn == 1)
		return new Alimento(pedina.getX() , pedina.getY());
		
	
		return new Vuota(pedina.getX() , pedina.getY());
		
	}
	


	
	
	private boolean isAlive(Pedina pedina)
		{
		
			   
				return	pedina.getLifeStatus();
		}
	
	public void move()
	{
		moveRow();
		moveCol();
	}
	
	private void moveRow()
	{
		int rdn = new Random().nextInt(dimension);
		
		if(rdn+1 <world[rdn].length)
		{
		Pedina temp1 = world[rdn][rdn];
		Pedina temp2 = world[rdn][rdn+1];
		 
		world[rdn][rdn+1] = temp1;
		world[rdn][rdn] = temp2;
	
		if (temp1 instanceof Animale)
			((Animale) temp1).checkMovement(temp1, temp2);
		
		updateReferences(temp1, rdn, rdn+1);
		updateReferences(temp2, rdn, rdn);
		}	
		else moveRow();
	}
	
	private void moveCol()
	{
		int rdn = new Random().nextInt(dimension);
		
		if(rdn+1 <world.length)
		{
		Pedina temp1 = world[rdn][rdn];
		Pedina temp2 = world[rdn+1][rdn];
		 
		world[rdn+1][rdn] = temp1;
		world[rdn][rdn] = temp2;
	
		if (temp1 instanceof Animale)
			((Animale) temp1).checkMovement(temp1, temp2);
		
		updateReferences(temp1, rdn+1, rdn);
		updateReferences(temp2, rdn, rdn);
		}	
		else moveCol();
	}
	
	
	private void updateReferences(Pedina pedina, int x, int y)
	
	{
		pedina.update(x,y);
	}
	
	public void print()
	
	{
		for(int row = 0; row < world.length; row++ ){
			for(int col = 0; col < world[row].length; col++ )
				System.out.print(world[row][col].getImage());
		//System.out.print(isAlive(world[row][col]));
		// System.out.print(isAlive(world[row][col]) ? '@' : '.');
			System.out.print(' ');
			System.out.println();
		}
		
		System.out.println("Generation:" + generation);
	}
}