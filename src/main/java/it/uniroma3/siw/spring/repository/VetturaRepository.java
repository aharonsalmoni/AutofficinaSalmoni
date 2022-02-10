package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Anagrafica;
import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.model.Vettura;

public interface VetturaRepository extends CrudRepository<Vettura, Long> {

	public List<Vettura> findByTarga(String targa);
	
	public List<Vettura> findByMarca(String marca);
	
	public List<Vettura> findByModello(String modello);
	
	public List<Vettura> findByProprietario(User proprietario);
	
	public List<Vettura> findByProprietari(Anagrafica proprietari);
}