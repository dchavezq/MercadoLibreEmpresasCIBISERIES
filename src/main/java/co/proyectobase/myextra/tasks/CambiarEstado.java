package co.proyectobase.myextra.tasks;



import java.util.List;
import co.proyectobase.myextra.interactions.ConsultarOpcion;
import co.proyectobase.myextra.interactions.Digitar;
import co.proyectobase.myextra.interactions.Escribir;
import co.proyectobase.myextra.model.MantenimientoCuentasInscritas;
import co.proyectobase.myextra.model.Tecla;
import co.proyectobase.myextra.userinterface.CambiarEstadoCuentaPage;
import co.proyectobase.myextra.userinterface.IntroducirSentenciasSql;
import co.proyectobase.myextra.userinterface.MantenimientoCibomtositPage;

import static co.proyectobase.myextra.userinterface.CambiarEstadoCuentaPage.ESTADO_DE_CUENTA;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CambiarEstado implements Task {

	private List<MantenimientoCuentasInscritas> programa;

	public CambiarEstado(List<MantenimientoCuentasInscritas> programa) {
		this.programa = programa;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		actor.attemptsTo(Escribir.elTexto(programa.get(0).getPrograma()).en(IntroducirSentenciasSql.POSICION_SQL));
		actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));
		actor.attemptsTo(Escribir.elTexto(programa.get(0).getDocumento()).en(MantenimientoCibomtositPage.DOCUMENTO));
		actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));
		actor.attemptsTo(Escribir.elTexto(programa.get(0).getCuenta()).en(MantenimientoCibomtositPage.CUENTA_BENEFICIARIO));
		actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));
		actor.attemptsTo(ConsultarOpcion.hastaEncontrar(programa));
		actor.attemptsTo(Escribir.elTexto(programa.get(0).getEstado().toUpperCase()).en(ESTADO_DE_CUENTA));
		actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));
		actor.attemptsTo(Escribir.elTexto("S").en(CambiarEstadoCuentaPage.CONFIRMAR_CAMBIO_DE_ESTADO));
		actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));
		actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));


	}

	public static CambiarEstado deLaCuenta(List<MantenimientoCuentasInscritas> programa) {

		return Tasks.instrumented(CambiarEstado.class, programa);
	}

}
