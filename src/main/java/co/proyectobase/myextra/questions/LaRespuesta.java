package co.proyectobase.myextra.questions;

import co.proyectobase.myextra.interactions.Leer;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static co.proyectobase.myextra.userinterface.MenuAmbienteIntegradoPruebasPage.TITULO_SQL_PAGE;

public class LaRespuesta implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		
		return Leer.elTextoEn(TITULO_SQL_PAGE);
	}

	public static LaRespuesta es() {
		
		return new LaRespuesta();
	}
	

}
