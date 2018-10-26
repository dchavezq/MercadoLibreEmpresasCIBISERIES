package co.proyectobase.myextra.interactions;

import co.proyectobase.myextra.util.Evidencia;
import co.proyectobase.myextra.util.myextra.MyExtra_init;
import co.proyectobase.myextra.util.myextra.Screen;
import co.proyectobase.myextra.util.myextra._Session;
import co.proyectobase.myextra.util.myextra._System;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class EscribirTexto implements Interaction{

	private String texto;
	private int fila;
	private int columna;

	private int gHostSettleTime = 3000;

	public EscribirTexto(String texto, int fila, int columna) {
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
		screen.putString(texto, fila, columna, null);
		screen.waitHostQuiet(gHostSettleTime);
		Evidencia.captureScreen();

	}

}
