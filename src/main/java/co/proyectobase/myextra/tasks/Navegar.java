package co.proyectobase.myextra.tasks;

import static co.proyectobase.myextra.userinterface.MenuAmbienteIntegradoPruebasPage.SQL;
import static co.proyectobase.myextra.userinterface.MenuBankvisionPage.BANCOLOMBIA;
import static co.proyectobase.myextra.userinterface.MenuPage.AMBIENTE_PRUEBAS;
import static co.proyectobase.myextra.userinterface.MenuPage.CONFIRMACION_AMBIENTE_PRUEBAS;

import co.proyectobase.myextra.interactions.Digitar;
import co.proyectobase.myextra.interactions.Escribir;
import co.proyectobase.myextra.interactions.Ir;
import co.proyectobase.myextra.model.Tecla;
import co.proyectobase.myextra.userinterface.MenuBankvisionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Navegar implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		actor.attemptsTo(Ir.hastaVerTexto("Ubicarse").en(MenuBankvisionPage.TEXTO_UBICARSE));
		actor.attemptsTo(Escribir.elTexto("1").en(BANCOLOMBIA));
		actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));
		actor.attemptsTo(Escribir.elTexto("1").en(AMBIENTE_PRUEBAS));
		actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));
		actor.attemptsTo(Escribir.elTexto("1").en(CONFIRMACION_AMBIENTE_PRUEBAS));
		actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));
		actor.attemptsTo(Escribir.elTexto("1").en(SQL));
		actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));
		actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));
	}

	public static Navegar aUnMenu() {

		return Tasks.instrumented(Navegar.class);
	}

}
