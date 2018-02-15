package br.com.ipiranga.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ipiranga.rest.modelo.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
	Empresa findByCnpj(String cnpj);
}
