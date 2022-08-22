package us.tfg.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CoberturaDAO extends CrudRepository<Cobertura, Long> {

	public List<Cobertura> findByOperadora(String operadora);
	
	public List<Cobertura> findAll();
}
