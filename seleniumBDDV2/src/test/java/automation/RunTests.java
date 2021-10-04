package automation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//clase para la ejecucion de cucumber clases 
@RunWith(Cucumber.class)
@CucumberOptions(
		//Creando reports
		plugin= {"pretty","html:target/cucumber-reports.html"},
		glue = {"automation/glue"},
		features = "src/main/resources/features"
		)
public class RunTests {
}
