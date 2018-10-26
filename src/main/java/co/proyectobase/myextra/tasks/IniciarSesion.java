package co.proyectobase.myextra.tasks;

import static co.proyectobase.myextra.userinterface.IniciarSesionPage.CONTRASEÑA;
import static co.proyectobase.myextra.userinterface.IniciarSesionPage.UBICACION;
import static co.proyectobase.myextra.userinterface.IniciarSesionPage.USUARIO;

import java.util.List;

import co.proyectobase.myextra.interactions.Digitar;
import co.proyectobase.myextra.interactions.Escribir;
import co.proyectobase.myextra.interactions.Ir;
import co.proyectobase.myextra.model.Credenciales;
import co.proyectobase.myextra.model.Tecla;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class IniciarSesion implements Task {

	private List<Credenciales> datos;

	public IniciarSesion(List<Credenciales> datos) {
		super();
		this.datos = datos;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Escribir.elTexto(datos.get(0).getUsuario()).en(USUARIO));
		actor.attemptsTo(Escribir.elTexto(datos.get(0).getContrasena()).en(CONTRASEÑA));
		actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));
		actor.attemptsTo(Ir.hastaVerTexto(datos.get(0).getUbicacion()).en(UBICACION));
		actor.attemptsTo(Digitar.laTecla(Tecla.ENTER.getTecla()));

	}

	public static IniciarSesion enMyExtra(List<Credenciales> datos) {

		return Tasks.instrumented(IniciarSesion.class, datos);
	}

}
