package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Vettura;
import it.uniroma3.siw.spring.repository.VetturaRepository;

@Service
public class VetturaService {
	
	@Autowired
	private VetturaRepository vetturaRepository;
	
	@Autowired
	private AnagraficaService anagraficaService; 
	
	@Transactional
	public	Vettura inserisci(Vettura vettura) {
		return vetturaRepository.save(vettura);
	}

	@Transactional
	public List<Vettura> tutti() {
		return (List<Vettura>) vetturaRepository.findAll();
	}

	@Transactional
	public Vettura vetturaPerId(Long id) {
		Optional<Vettura> optional = vetturaRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(Vettura vettura) {
		List<Vettura> vetture = this.vetturaRepository.findByTarga(vettura.getTarga());
		if (vetture.size() > 0)
			return true;
		else 
			return false;
	}

	public AnagraficaService getAnagraficaService() {
		// TODO Auto-generated method stub
		return this.anagraficaService;
	}
}
