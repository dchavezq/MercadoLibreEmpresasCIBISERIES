package co.proyectobase.myextra.tasks;

import static co.proyectobase.myextra.userinterface.MantenimientoCibomtositPage.CUENTA_BENEFICIARIO;
import static co.proyectobase.myextra.userinterface.MantenimientoCibomtositPage.DOCUMENTO;

import java.util.List;

import co.proyectobase.myextra.interactions.Digitar;
import co.proyectobase.myextra.interactions.Escribir;
import co.proyectobase.myextra.model.MantenimientoCuentasInscritas;
import co.proyectobase.myextra.model.Tecla;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsultaLaCuenta implements Task {

	private List<MantenimientoCuentasInscritas> programa;

	public ConsultaLaCuenta(List<MantenimientoCuentasInscritas> programa) {
		this.programa = programa;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Escribir.elTexto(programa.get(0).getDocumento()).en(DOCUMENTO));
		actor.attemptsTo(Escribir.elTexto(programa.get(0).getCuenta()).en(CUENTA_BENEFICIARIO));
		actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));
	}

	public static ConsultaLaCuenta en(List<MantenimientoCuentasInscritas> programa) {

		return Tasks.instrumented(ConsultaLaCuenta.class, programa);
	}

}
