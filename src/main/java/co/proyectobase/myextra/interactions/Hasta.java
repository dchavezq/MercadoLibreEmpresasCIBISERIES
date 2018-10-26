package co.proyectobase.myextra.interactions;

import co.proyectobase.myextra.util.Evidencia;
import co.proyectobase.myextra.util.myextra.MyExtra_init;
import co.proyectobase.myextra.util.myextra.Screen;
import co.proyectobase.myextra.util.myextra._Session;
import co.proyectobase.myextra.util.myextra._System;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Hasta implements Interaction{
	
	private int gHostSettleTime = 3000;

	private String texto;
	private int fila;
	private int columna;

	public Hasta(String texto, int fila, int columna) {

		this.texto = texto;
		this.fila = fila;
		this.columna = columna;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		_System sSystem = null;
		Screen screen = null;
		_Session sess0 = null;

		sSystem = MyExtra_init.crearSistema();
		sess0 = MyExtra_init.crearSesion(sSystem);
		screen = MyExtra_init.crearPantalla(sess0);
		int i = 0;
		String textoPantalla;
		try {

			while (true) {
				i++;
				Thread.sleep(2000);
				textoPantalla = screen.getString(fila, columna, texto.length(), screen);
				if (!textoPantalla.equals(texto) && i != 5) {
					screen.sendKeys("<Enter>");
					screen.waitHostQuiet(gHostSettleTime);
				} else {
					break;
				}

			}
			Evidencia.captureScreen();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
