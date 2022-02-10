package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Anagrafica;
import it.uniroma3.siw.spring.repository.AnagraficaRepository;

@Service
public class AnagraficaService {

	@Autowired
	private AnagraficaRepository anagraficaRepository;
	
	@Transactional
	public Anagrafica inserisci(Anagrafica anagrafica) {
		return anagraficaRepository.save(anagrafica);
	}

	@Transactional
	public List<Anagrafica> tutti() {
		return (List<Anagrafica>) anagraficaRepository.findAll();
	}

	@Transactional
	public Anagrafica anagraficaPerId(Long id) {
		Optional<Anagrafica> optional = anagraficaRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(Anagrafica anagrafica) {
		List<Anagrafica> anagrafiche = this.anagraficaRepository.findByNome(anagrafica.getNome());
		if (anagrafiche.size() > 0)
			return true;
		else 
			return false;
	}

}
