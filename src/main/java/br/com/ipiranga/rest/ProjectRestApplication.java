package br.com.ipiranga.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.ipiranga.rest.modelo.Empresa;
import br.com.ipiranga.rest.repositories.EmpresaRepository;
import br.com.ipiranga.rest.utils.SenhaUtils;

@SpringBootApplication
public class ProjectRestApplication {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	
	
	@Value("${qtde.pgn}")
	private int qtdePagina;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectRestApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			Empresa empresa = new Empresa();
			empresa.setRazaoSocial("Barney IT");
			empresa.setCnpj("66242916000166");
			
			this.empresaRepository.save(empresa);
			
			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);
			
			Empresa empresaDb = empresaRepository.findOne(1L);
			System.out.println("Empresa por ID: " + empresaDb);
			
			empresaDb.setRazaoSocial("Barney IT WEB");
			this.empresaRepository.save(empresaDb);
			
			Empresa empresaCnpj = empresaRepository.findByCnpj("66242916000166");
			System.out.println("Empresa por CNPJ: " + empresaCnpj);
			
			this.empresaRepository.delete(1L);
			empresas = empresaRepository.findAll();
			System.out.println("Empresas: " + empresas.size());
			
			System.out.println("Quanidade de elementos por pagina = " + this.qtdePagina);
			
			String senhaEncoded = SenhaUtils.geraBcrypt("123456");
			System.out.println("Senha encoded = " + senhaEncoded);

			senhaEncoded = SenhaUtils.geraBcrypt("123456");
			System.out.println("Senha encoded novamente = " + senhaEncoded);
			
			System.out.println("senha valida = " + SenhaUtils.senhaValida("123456", senhaEncoded));
			
			
		};
	}
}
