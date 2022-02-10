package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Meccanici;

public interface MeccaniciRepository extends CrudRepository<Meccanici, Long> {

	public List<Meccanici> findByNome(String nome);
	
	public List<Meccanici> findByNomeAndCognome(String nome, String cognome);

	public List<Meccanici> findByNomeOrCognome(String nome, String cognome);

}
