package br.com.ipiranga.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProjectRestApplicationTests {
	
	@Value("${qtde.pgn}")
	private int qtdePagina;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCarregarContextDeTeste() {
		assertEquals(100, qtdePagina);
	}
	
}
