package com.alura.desafio;

import com.alura.desafio.model.Cantante;
import com.alura.desafio.principal.Principal;
import com.alura.desafio.repository.CantanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioApplication  implements CommandLineRunner {

	@Autowired
	private CantanteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.muestraElMenu();

	}
}
