package co.proyectobase.myextra.model;

public enum Tecla {
	
	ENTER ("ENTER"),
	F12 ("Pf12"),
	AVPAG("pagedn");
	

	private final String tecla;
	
	Tecla(String tecla)
	{
		this.tecla=tecla;
	}
	
	public String getTecla()
	{
		return tecla;
	}
	

}
