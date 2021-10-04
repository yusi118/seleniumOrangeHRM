package automation.utilities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:/framework.properties")
public class ConfigurationProperties {
	
	public ConfigurationProperties() {
		
	}

	@Value("${browser}")
	private String browser;
	
	@Value("${username3}")
	private String username3;
	
	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getUsername() {
		return username3;
	}

	public void setUsername(String username) {
		this.username3 = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Value("${password}")
	private String password;
}
