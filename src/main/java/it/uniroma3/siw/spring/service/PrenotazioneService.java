package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Prenotazione;
import it.uniroma3.siw.spring.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepository;
	
	@Autowired
	private VetturaService vetturaService;

	@Autowired
	private InterventoService interventoService;
	
	@Transactional
	public Prenotazione prenotazionePerId(Long id) {
		// TODO Auto-generated method stub
		Optional<Prenotazione> optional = prenotazioneRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}
	@Transactional
	public List<Prenotazione> tutti() {
		return (List<Prenotazione>) prenotazioneRepository.findAll();
	}
	
	@Transactional
	public boolean alreadyExists(Prenotazione prenotazione) {
		List<Prenotazione> prenotazioni = this.prenotazioneRepository.findByDataPrenotazione(prenotazione.getDataPrenotazione());
		if (prenotazioni.size() > 0)
			return true;
		else 
			return false;
	}
	@Transactional
	public Prenotazione inserisci(Prenotazione prenotazione) {
		return prenotazioneRepository.save(prenotazione);
	}
	public VetturaService getVetturaService() {
		// TODO Auto-generated method stub
		return this.vetturaService;
	}
	public InterventoService getInterventoService() {
		// TODO Auto-generated method stub
		return this.interventoService;
	}

}
