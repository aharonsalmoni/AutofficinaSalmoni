package it.uniroma3.siw.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.spring.controller.validator.PrenotazioneValidator;
import it.uniroma3.siw.spring.model.Prenotazione;
import it.uniroma3.siw.spring.service.PrenotazioneService;

@Controller
public class PrenotazioneController {
	
	@Autowired
	private PrenotazioneService prenotazioneService;
	
	@Autowired
    private PrenotazioneValidator prenotazioneValidator;
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @RequestMapping(value="/admin/prenotazione", method = RequestMethod.GET)
    public String addPrenotazione(Model model, Long id) {
    	logger.debug("addPrenotazione");
    	model.addAttribute("prenotazione", new Prenotazione());
    	model.addAttribute("vetture",this.prenotazioneService.getVetturaService().tutti());
    	model.addAttribute("intervento", this.prenotazioneService.getInterventoService().tutti());
    	return "prenotazioneForm";
    }

    @RequestMapping(value = "/prenotazione/{id}", method = RequestMethod.GET)
    public String getPrenotazione(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("prenotazione", this.prenotazioneService.prenotazionePerId(id));
    	return "prenotazione";
    }

    @RequestMapping(value = "/prenotazione", method = RequestMethod.GET)
    public String getPrenotazioni(Model model) {
    		model.addAttribute("prenotazioni", this.prenotazioneService.tutti());
    		return "prenotazioni";
    }
    
    @RequestMapping(value = "/admin/prenotazione", method = RequestMethod.POST)
    public String addPrenotazione(@ModelAttribute("prenotazione") Prenotazione prenotazione, 
    									Model model, BindingResult bindingResult) {
    	//this.prenotazioneValidator.validate(prenotazione, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.prenotazioneService.inserisci(prenotazione);
            model.addAttribute("prenotazioni", this.prenotazioneService.tutti());
            return "prenotazioni";
        }
        return "prenotazioneForm";
    }
}