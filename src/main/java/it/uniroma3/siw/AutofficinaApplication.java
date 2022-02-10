package it.uniroma3.siw;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.service.CredentialsService;

@SpringBootApplication
public class AutofficinaApplication {

	@Autowired
	CredentialsService credentialsService;
	
	public static void main(String[] args) {
		SpringApplication.run(AutofficinaApplication.class, args);
		
	}

	@Bean
    public InitializingBean populateDatabaseIfEmpty() {
        return () -> {
            if (credentialsService.countAll() == 0) {
                User cliente1 = new User("Aharon", "Salmoni");
                // Users
                Credentials credcliente = credentialsService.saveCredentials(new Credentials(
                        "cliente",
                        "password",
                        Credentials.DEFAULT_ROLE,
                        new User("aharon", "s"))
                );

                Credentials credadmin = credentialsService.saveCredentials(new Credentials(
                        "admin",
                        "admin",
                        Credentials.ADMIN_ROLE,
                        new User("Aharon", "Salmoni"))
                );

            }

        };
    }
}
