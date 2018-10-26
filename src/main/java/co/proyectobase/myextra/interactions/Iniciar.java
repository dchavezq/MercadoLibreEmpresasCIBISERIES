package co.proyectobase.myextra.interactions;

import java.io.FileReader;
import java.util.Properties;

import co.proyectobase.myextra.util.Evidencia;
import co.proyectobase.myextra.util.MyExtra;
import co.proyectobase.myextra.util.ProcessUtility;
import co.proyectobase.myextra.util.myextra._System;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Iniciar implements Interaction{
	private static final int G_HOST_SETTLE_TIME = 3000;

	@Override
	public <T extends Actor> void performAs(T actor) {

		_System sSystem = null;

		try {
			if (ProcessUtility.isProcessRunning("EXTRA.exe")) {
				MyExtra.cerrarMyExtraAbierto();
			}
			Properties propiedad = new Properties();
			propiedad.load(new FileReader("myExtra.properties"));
			String ruta = propiedad.getProperty("rutaCalidad");
			MyExtra.abrirArchivoDeMyExtra(ruta);
			Thread.sleep(3000);
			sSystem = MyExtra.crearSistema();
			sSystem.timeoutValue(G_HOST_SETTLE_TIME);
			Evidencia.captureScreen();
			actor.attemptsTo(Esperar.aMoment());
		} catch (Exception e) {
		}
	}

	public static Iniciar attachmateMyExtra() {

		return new Iniciar();
	}
}
