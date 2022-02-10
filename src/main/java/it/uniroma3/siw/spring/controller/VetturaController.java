package it.uniroma3.siw.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.VetturaValidator;
import it.uniroma3.siw.spring.model.Vettura;
import it.uniroma3.siw.spring.service.InterventoSvoltoService;
import it.uniroma3.siw.spring.service.VetturaService;

@Controller
public class VetturaController {
	
	@Autowired
	private VetturaService vetturaService;
	
	@Autowired
    private VetturaValidator vetturaValidator;
	
	
	@Autowired
	private InterventoSvoltoService interventoSvoltoService;
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
        
    @RequestMapping(value="/admin/vettura", method = RequestMethod.GET)
    public String addVettura(Model model) {
    	logger.debug("addVettura");
    	model.addAttribute("vettura", new Vettura());
    	model.addAttribute("anagrafiche",this.vetturaService.getAnagraficaService().tutti());
        return "vetturaForm";
    }

    @RequestMapping(value = "/vettura/{id}", method = RequestMethod.GET)
    public String getVettura(@PathVariable("id") Long id, Model model) {
    	Vettura vettura = this.vetturaService.vetturaPerId(id);
    	model.addAttribute("vettura", this.vetturaService.vetturaPerId(id));
    	model.addAttribute("interventoSvolto", vettura.getInterventoSvolto());
    	return "vettura";
    }

    @RequestMapping(value = "/vettura", method = RequestMethod.GET)
    public String getVetture(Model model) {
    		model.addAttribute("vetture", this.vetturaService.tutti());
    		return "vetture";
    }
    
    @RequestMapping(value = "/admin/vettura", method = RequestMethod.POST)
    public String addVettura(@ModelAttribute("vettura") Vettura vettura, 
    									Model model, BindingResult bindingResult) {
    	this.vetturaValidator.validate(vettura, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.vetturaService.inserisci(vettura);
            model.addAttribute("vetture", this.vetturaService.tutti());
            model.addAttribute("interventiSvolti",this.interventoSvoltoService.tutti());
            return "vetture";
        }
        return "vetturaForm";
    }
}
