	package it.unicam.giocoDellVita.Class;

public final class caratteriSpeciali {

	
public static String chAnimale(tipoSpecie specie)
	
	{
		if(specie == tipoSpecie.SPECIE1)
			return "\u00A3";
		else return "\u00C6";
	}

public static String chCibo()

	{
		return "\u00A9";
	}
	

public static String chVouta()

	{
		return "\u00D8";
	}

}
