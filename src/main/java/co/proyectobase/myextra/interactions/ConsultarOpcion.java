package co.proyectobase.myextra.interactions;

import java.util.List;


import co.proyectobase.myextra.model.MantenimientoCuentasInscritas;
import co.proyectobase.myextra.model.Target;
import co.proyectobase.myextra.model.Tecla;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class ConsultarOpcion implements Interaction {

	
	private List<MantenimientoCuentasInscritas> programa;

	public ConsultarOpcion(List<MantenimientoCuentasInscritas> programa) {

		this.programa = programa;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		Target texto;
		Target posicion;
		for (int i = 9; i < 22; i++) {

			texto = Target.the("Linea de la tabla").locatedBy(i, 3, 57);
			String consulta = Leer.elTextoEn(texto);
			if (consulta.contains(programa.get(0).getDocumento().toUpperCase())
					&& consulta.contains(programa.get(0).getCuenta().toUpperCase())) {
				posicion = Target.the("posicion para consultar").locatedBy(i, 3);
				actor.attemptsTo(Escribir.elTexto(programa.get(0).getOpciones()).en(posicion));
				actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));
			}

		}

	}
	
	public static ConsultarOpcion hastaEncontrar(List<MantenimientoCuentasInscritas> programa) {
		return Tasks.instrumented(ConsultarOpcion.class, programa);
		
	}

}
