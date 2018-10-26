package co.proyectobase.myextra.questions;



import co.proyectobase.myextra.interactions.Leer;
import co.proyectobase.myextra.userinterface.CambiarEstadoCuentaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class MensajeParaCuentasEstadoRechazado implements Question<String>{

	@Override
	public String answeredBy(Actor actor) {
		return Leer.elTextoEn(CambiarEstadoCuentaPage.MENSAJE_CAMBIAR_ESTADO_CUENTA);
	}

	
	public static MensajeParaCuentasEstadoRechazado al() {

		return new MensajeParaCuentasEstadoRechazado();
	}

}
