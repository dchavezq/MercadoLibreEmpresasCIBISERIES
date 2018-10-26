package co.proyectobase.myextra.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.openqa.selenium.WebDriver;


import co.proyectobase.myextra.model.MantenimientoCuentasInscritas;
import co.proyectobase.myextra.questions.EstadoDeLaCuenta;
import co.proyectobase.myextra.questions.MensajeParaCuentasEstadoRechazado;
import co.proyectobase.myextra.tasks.CambiarEstado;
import co.proyectobase.myextra.tasks.ConsultaLaCuenta;
import cucumber.api.java.Before;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class MantenimientoCibomtositStepDefinitions {
	
	@Managed(driver = "chrome")
	private WebDriver herBrowser;
	private Actor marcela = Actor.named("Analista de pruebas");

	@Before
	public void configuracionInicial() {
		marcela.can(BrowseTheWeb.with(herBrowser));

	}

	@Dado("^Realizar el cambio de estado de pendiente verificacion a activa$")
	public void realizarElCambioDeEstadoDePendienteVerificacionAActiva(List<MantenimientoCuentasInscritas> programa) {
		marcela.attemptsTo(CambiarEstado.deLaCuenta(programa));
	}

	@Cuando("^Consultar  las cuentas inscritas por la sucursal virtual empresas$")
	public void consultarLasCuentasInscritasPorLaSucursalVirtualEmpresas(List<MantenimientoCuentasInscritas> programa) {
		marcela.attemptsTo(ConsultaLaCuenta.en(programa));
	}

	@Entonces("^Verifica que la cuenta quede en estado activa$")
	public void verificaQueLaCuentaQuedeEnEstadoActiva() {
		marcela.should(seeThat(EstadoDeLaCuenta.es(), equalTo("A")));

	}

	@Dado("^Realizar el cambio de estado de pendiente verificacion a rechazada$")
	public void realizarElCambioDeEstadoDePendienteVerificacionARechazada(
			List<MantenimientoCuentasInscritas> programa) {
		marcela.attemptsTo(CambiarEstado.deLaCuenta(programa));

	}

	@Dado("^Realizar el cambio de estado de pendiente verificacion a fraude$")
	public void realizarElCambioDeEstadoDePendienteVerificacionAFraude(List<MantenimientoCuentasInscritas> programa) {
		marcela.attemptsTo(CambiarEstado.deLaCuenta(programa));
	}

	@Entonces("^Verifica que la cuenta quede en estado rechazada$")
	public void verificaQueLaCuentaQuedeEnEstadoRechazada() {
		marcela.should(seeThat(EstadoDeLaCuenta.es(), equalTo("Z")));

	}

	@Entonces("^Verifica que la cuenta quede en estado fraude$")
	public void verificaQueLaCuentaQuedeEnEstadoFraude() {
		marcela.should(seeThat(EstadoDeLaCuenta.es(), equalTo("U")));

	}

	@Dado("^Realizar el cambio de estado  rechazada a pendiente verificacion$")
	public void realizarElCambioDeEstadoRechazadaAPendienteVerificacion(List<MantenimientoCuentasInscritas> programa) {
		marcela.attemptsTo(CambiarEstado.deLaCuenta(programa));

	}

	@Entonces("^Verifica que la cuenta no se pueda cambiar a estado pendiente verificacion$")
	public void verificaQueLaCuentaNoSePuedaCambiarAEstadoPendienteVerificacion() {

		marcela.should(seeThat(MensajeParaCuentasEstadoRechazado.al(),
				equalTo("Estado Rechazado (Z) sólo puede cambiar a Activo (A) o Fraude (U)")));

	}
	
	@Entonces("^Verifica que la cuenta no se pueda cambiar de estado activa  a estado pendiente verificacion$")
	public void verificaQueLaCuentaNoSePuedaCambiarDeEstadoActivaAEstadoPendienteVerificacion() {
		marcela.should(seeThat(MensajeParaCuentasEstadoRechazado.al(),
				equalTo("Estado Activo (A) sólo puede cambiar a Fraude (U) o Rechazado (Z)")));
	   
	}

}
