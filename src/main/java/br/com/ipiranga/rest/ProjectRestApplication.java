package br.com.ipiranga.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.ipiranga.rest.utils.SenhaUtils;

@SpringBootApplication
public class ProjectRestApplication {
	
	@Value("${qtde.pgn}")
	private int qtdePagina;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectRestApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Quanidade de elementos por pagina = " + this.qtdePagina);
			
			String senhaEncoded = SenhaUtils.geraBcrypt("123456");
			System.out.println("Senha encoded = " + senhaEncoded);

			senhaEncoded = SenhaUtils.geraBcrypt("123456");
			System.out.println("Senha encoded novamente = " + senhaEncoded);
			
			System.out.println("senha valida = " + SenhaUtils.senhaValida("123456", senhaEncoded));
			
			
		};
	}
}
