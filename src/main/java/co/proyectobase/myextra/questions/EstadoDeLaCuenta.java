package co.proyectobase.myextra.questions;


import co.proyectobase.myextra.interactions.Leer;
import co.proyectobase.myextra.userinterface.CambiarEstadoCuentaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class EstadoDeLaCuenta implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {

		return Leer.elTextoEn(CambiarEstadoCuentaPage.ESTADO_DE_CUENTA1);
	}

	public static EstadoDeLaCuenta es() {

		return new EstadoDeLaCuenta();
	}

}
