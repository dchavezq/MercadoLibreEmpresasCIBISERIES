package co.proyectobase.myextra.interactions;

import co.proyectobase.myextra.model.Target;
import co.proyectobase.myextra.util.Evidencia;
import co.proyectobase.myextra.util.myextra.MyExtra_init;
import co.proyectobase.myextra.util.myextra.Screen;
import co.proyectobase.myextra.util.myextra._Session;
import co.proyectobase.myextra.util.myextra._System;

public class Leer {

	public static int gHostSettleTime = 1000;

	public static String elTextoEn(Target target) {

		_System sSystem = null;
		Screen screen = null;
		_Session sess0 = null;
		String textoPantalla = "";
		sSystem = MyExtra_init.crearSistema();
		sess0 = MyExtra_init.crearSesion(sSystem);
		screen = MyExtra_init.crearPantalla(sess0);

		textoPantalla = screen.getString(target.getRow(), target.getCol(), target.getLenght(), screen);
		Evidencia.captureScreen();

		return textoPantalla;
	}

}
