package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Meccanici;
import it.uniroma3.siw.spring.repository.MeccaniciRepository;

@Service
public class MeccaniciService {

	@Autowired
	private MeccaniciRepository meccaniciRepository;
	
	@Autowired
	private InterventoService interventoService;
	
	@Transactional
	public Meccanici inserisci(Meccanici meccanici) {
		return meccaniciRepository.save(meccanici);
	}

	@Transactional
	public List<Meccanici> tutti() {
		return (List<Meccanici>) meccaniciRepository.findAll();
	}

	@Transactional
	public Meccanici meccanicoPerId(Long id) {
		Optional<Meccanici> optional = meccaniciRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(Meccanici meccanico) {
		List<Meccanici> meccanici = this.meccaniciRepository.findByNome(meccanico.getNome());
		if (meccanici.size() > 0)
			return true;
		else 
			return false;
	}

	public InterventoService getInterventoService() {
		// TODO Auto-generated method stub
		return this.interventoService;
	}

}
