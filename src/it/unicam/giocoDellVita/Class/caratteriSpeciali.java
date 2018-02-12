	package it.unicam.giocoDellVita.Class;

 final class caratteriSpeciali {

	
protected static String chAnimale(tipoSpecie specie)
	
	{
		if(specie == tipoSpecie.SPECIE1)
			return "\u00A3";
		else return "\u00C6";
	}

protected static String chCibo()

	{
		return "\u00A9";
	}
	

protected static String chVuota()

	{
		return "\u00D8";
	}

}
