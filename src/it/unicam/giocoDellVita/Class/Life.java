package it.unicam.giocoDellVita.Class;

import java.util.Random;

public class Life {
	
	private Pedina[][] world;
	private int dimension;
	private long generation ;
	private Random random = new Random();
	
	public Life(int dimension) throws Exception{
		if (dimension < 2) throw new Exception("Invalid size");
		this.dimension = dimension;
		createNewWorld();
		this.generation = 0;
		
	}

	private void createNewWorld(){
		Pedina[][] newWorld = new Pedina[dimension][dimension];
		world = newWorld;
	}

	
	public void drawWorld(){
		
		for(int row = 0; row < world.length; row++ ){
			for(int col = 0; col < world[row].length; col++ )
				world[row][col]=assignType(row, col);
		}
		
	}

	
	private Pedina assignType(int x, int y)
	{
		
		int rdn = random.nextInt(4);
		
	if (rdn == 2)
		return new Animale(x , y, tipoSpecie.SPECIE2);
	
	if (rdn == 3)
		return new Animale(x , y, tipoSpecie.SPECIE1);
			
	if (rdn == 1)
		return new Alimento(x , y);
		
	
		return new Vuota(x , y);
		
	}
	
	
	public boolean move()
	{
		if (checkGameOver())
		{
		moveRow();
		moveCol();
		generation++;
		return true;
		}
		else return false;
	}
	
	private void moveRow()
	{
		int col = random.nextInt(dimension);
		int row = random.nextInt(dimension);
		if(row+1 <world[col].length)
		{
		Pedina temp1 = world[col][row];
		Pedina temp2 = world[col][row+1];
		 
		
	
		if (temp1 instanceof Animale)
		{
			Pedina pv[];
			pv = ((Animale) temp1).checkMovement(temp1, temp2);
			temp1 = pv[0];
			temp2 = pv[1];

		} 
			
			
		updateReferences(temp1, col, row+1);
		updateReferences(temp2, col, row);
		
	
		world[col][row+1] = temp1;
		world[col][row] = temp2;
		
		}	
		else moveRow();
		
		
	}
	
	private void moveCol()
	{
		int col = random.nextInt(dimension);
		int row = random.nextInt(dimension);
		
		if(col+1 <world.length)
		{
		Pedina temp1 = world[col][row];
		Pedina temp2 = world[col+1][row];
		 
		
	
		if (temp1 instanceof Animale)
		{
			Pedina pv[];
			pv = ((Animale) temp1).checkMovement(temp1, temp2);
			temp1 = pv[0];
			temp2 = pv[1];
			
			
		} 

		updateReferences(temp1, col+1, row);
		updateReferences(temp2, col, row);
		
		
		world[col+1][row] = temp1;
		world[col][row] = temp2;
		
		}	
		else moveCol();
	}
	
	
	private void updateReferences(Pedina pedina, int x, int y)
	
	{
		pedina.update(x,y);
	}
	
	
	private boolean checkGameOver()
	{
		for(int row = 0; row < world.length; row++ ){
			for(int col = 0; col < world[row].length; col++ )
				if(world[row][col] instanceof Animale )
					return true;

		}
		return false;
	}

	public void print()
	
	{
		for(int row = 0; row < world.length; row++ ){
			for(int col = 0; col < world[row].length; col++ )
				System.out.print(world[row][col].getImage()+ "  ");
		
			
			System.out.println();
		}
		
		System.out.println("Generation: " + generation);
	}
}