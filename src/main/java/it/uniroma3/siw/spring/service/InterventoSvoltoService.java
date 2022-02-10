package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.InterventoSvolto;
import it.uniroma3.siw.spring.repository.InterventoSvoltoRepository;

@Service
public class InterventoSvoltoService {
	
	@Autowired
	private InterventoSvoltoRepository interventoSvoltoRepository;
	
	@Autowired
	private VetturaService vetturaService;

	@Autowired
	private InterventoService interventoService;

	private MeccaniciService meccaniciService; 
	
	@Transactional
	public InterventoSvolto inserisci(InterventoSvolto interventoSvolto) {
		return interventoSvoltoRepository.save(interventoSvolto);
	}

	@Transactional
	public List<InterventoSvolto> tutti() {
		return (List<InterventoSvolto>) interventoSvoltoRepository.findAll();
	}

	@Transactional
	public InterventoSvolto interventoSvoltoPerId(Long id) {
		Optional<InterventoSvolto> optional = interventoSvoltoRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(InterventoSvolto interventoSvolto) {
		List<InterventoSvolto> interventiSvolti = this.interventoSvoltoRepository.findByDataEffettuato(interventoSvolto.getDataEffettuato());
		if (interventiSvolti.size() > 0)
			return true;
		else 
			return false;
	}

	public VetturaService getVetturaService() {
		// TODO Auto-generated method stub
		return this.vetturaService;
	}

	public InterventoService getInterventoService() {
		// TODO Auto-generated method stub
		return this.interventoService;
	}

	public MeccaniciService getMeccaniciService() {
		// TODO Auto-generated method stub
		return this.meccaniciService;
	}
}
