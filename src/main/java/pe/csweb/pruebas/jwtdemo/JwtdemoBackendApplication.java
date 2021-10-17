package pe.csweb.pruebas.jwtdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JwtdemoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtdemoBackendApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordeEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
