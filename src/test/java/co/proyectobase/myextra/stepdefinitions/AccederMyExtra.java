package co.proyectobase.myextra.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.openqa.selenium.WebDriver;

import co.proyectobase.myextra.model.Credenciales;
import co.proyectobase.myextra.questions.LaRespuesta;
import co.proyectobase.myextra.tasks.Abrir;
import co.proyectobase.myextra.tasks.IniciarSesion;
import co.proyectobase.myextra.tasks.Navegar;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class AccederMyExtra {

	@Managed(driver = "chrome")
	private WebDriver herBrowser;
	private Actor marcela = Actor.named("Analista de pruebas");

	@Before
	public void configuracionInicial() {
		marcela.can(BrowseTheWeb.with(herBrowser));

	}

	@Dado("^Que Marcela desea realizar consultar en iseries, Marcela abre myExtra$")
	public void queMarcelaDeseaRealizarConsultarEnIseriesMarcelaAbreMyExtra() {
		marcela.attemptsTo(Abrir.myExtra());
	}

	@Cuando("^Ingresa sus credenciales$")
	public void ingresaSusCredenciales(List<Credenciales> datos) {

		marcela.attemptsTo(IniciarSesion.enMyExtra(datos));
	}

	@Cuando("^y Navega en el menu$")
	public void yNavegaEnElMenu() throws Exception {
		marcela.attemptsTo(Navegar.aUnMenu());

	}

	@Entonces("^Verifica que inicio sesion correctamente$")
	public void verificaQueInicioSesionCorrectamente() {

		marcela.should(seeThat(LaRespuesta.es(), equalTo("Introducir sentencias SQL")));

	}

}
