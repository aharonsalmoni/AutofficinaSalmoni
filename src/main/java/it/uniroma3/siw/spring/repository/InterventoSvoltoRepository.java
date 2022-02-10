package it.uniroma3.siw.spring.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.InterventoSvolto;

public interface InterventoSvoltoRepository extends CrudRepository<InterventoSvolto, Long> {

	public List<InterventoSvolto> findByDataEffettuato(LocalDate dataEffettuato);
	

}