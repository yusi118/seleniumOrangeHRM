package automation.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.cucumber.spring.CucumberContextConfiguration;

@Configuration
@ComponentScan("automation")
public class RunFrameworkConfiguration {
	
	public RunFrameworkConfiguration() {
		
	}
}
