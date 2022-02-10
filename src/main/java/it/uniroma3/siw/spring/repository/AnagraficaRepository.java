package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Anagrafica;

public interface AnagraficaRepository extends CrudRepository<Anagrafica, Long> {
	
	public List<Anagrafica> findByNome(String nome);
	
	public List<Anagrafica> findByCognome(String cognome);
	
	public List<Anagrafica> findByCellulare(String cellulare);
	
	public List<Anagrafica> findByIndirizzo(String indirizzo);
	
	public List<Anagrafica> findByNomeAndCognome(String nome, String cognome);

	public List<Anagrafica> findByNomeOrCognome(String nome, String cognome);

}
