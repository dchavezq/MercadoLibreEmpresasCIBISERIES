package co.proyectobase.myextra.interactions;


import co.proyectobase.myextra.util.myextra.MyExtra_init;
import co.proyectobase.myextra.util.myextra.Screen;
import co.proyectobase.myextra.util.myextra._Session;
import co.proyectobase.myextra.util.myextra._System;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Digitar implements Interaction{

	private String key;

	private int gHostSettleTime = 2500;

	public Digitar(String key) {
		this.key = key;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		_Session sess0 = null;
		Screen screen = null;
		_System sSystem = null;
		sSystem = MyExtra_init.crearSistema();
		sess0 = MyExtra_init.crearSesion(sSystem);
		screen = MyExtra_init.crearPantalla(sess0);

		screen.sendKeys("<" + key + ">");
		screen.waitHostQuiet(gHostSettleTime);
		actor.attemptsTo(Esperar.aMoment());

	}

	public static Digitar laTecla(String key) {
		
		return new Digitar(key);
	}
	
	

}
