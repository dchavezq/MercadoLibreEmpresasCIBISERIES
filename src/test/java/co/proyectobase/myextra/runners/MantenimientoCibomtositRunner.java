package co.proyectobase.myextra.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features="src/test/resources/features/mantenimiento_cibomtosit.feature",
		tags="@CasoPruebaEstadodeCuentasActivas",
		glue = "co.proyectobase.myextra.stepdefinitions",
		snippets = SnippetType.CAMELCASE)
public class MantenimientoCibomtositRunner {

}
