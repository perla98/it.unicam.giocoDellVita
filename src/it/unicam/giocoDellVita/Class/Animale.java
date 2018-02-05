package it.unicam.giocoDellVita.Class;
/**
 * 
 */

/**
 * @author Alessandro
 *
 */
public class Animale extends Pedina {
	private int vita;
	private tipoSpecie specie;
	
	/**
	 * Costruttore per la creazione di un animale
	 * @param x
	 * @param y
	 * @param vita
	 * @param specie
	 */
	public Animale(int x, int y ){
		super(x,y);
		
	}
	
	public String getImage()
	{
		return "animale";
	}

}
