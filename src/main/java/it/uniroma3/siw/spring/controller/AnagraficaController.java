package it.uniroma3.siw.spring.controller;

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

import it.uniroma3.siw.spring.controller.validator.AnagraficaValidator;
import it.uniroma3.siw.spring.model.Anagrafica;
import it.uniroma3.siw.spring.service.AnagraficaService;
import it.uniroma3.siw.spring.service.VetturaService;

@Controller
public class AnagraficaController {
	
	@Autowired
	private AnagraficaService anagraficaService;
	
	@Autowired
    private AnagraficaValidator anagraficaValidator;
	
	@Autowired
	private VetturaService vetturaService;
	
        
    @RequestMapping(value="/admin/anagrafica", method = RequestMethod.GET)
    public String addAnagrafica(Model model, Long id) {
    	model.addAttribute("anagrafica", new Anagrafica());
        return "anagraficaForm";
    }

    @RequestMapping(value = "/anagrafica/{id}", method = RequestMethod.GET)
    public String getAnagrafica(@PathVariable("id") Long id, Model model) {
    	Anagrafica anagrafica = this.anagraficaService.anagraficaPerId(id);
    	model.addAttribute("anagrafica", this.anagraficaService.anagraficaPerId(id));
    	model.addAttribute("vettura", anagrafica.getAuto());
    	return "anagrafica";
    }

    @RequestMapping(value = "/anagrafica", method = RequestMethod.GET)
    public String getAnagrafiche(Model model) {
    		model.addAttribute("anagrafiche", this.anagraficaService.tutti());
    		return "anagrafiche";
    }
    
    @RequestMapping(value = "/admin/anagrafica", method = RequestMethod.POST)
    public String addAnagrafica(@ModelAttribute("anagrafica") Anagrafica anagrafica, 
    									Model model, BindingResult bindingResult) {
    	this.anagraficaValidator.validate(anagrafica, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.anagraficaService.inserisci(anagrafica);
        	model.addAttribute("anagrafiche", this.anagraficaService.tutti());
            model.addAttribute("vetture", this.vetturaService.tutti());
        	return "anagrafiche";
        }
        return "anagraficaForm";
    }
}