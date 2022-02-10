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

import it.uniroma3.siw.spring.controller.validator.MeccaniciValidator;
import it.uniroma3.siw.spring.model.Meccanici;
import it.uniroma3.siw.spring.service.InterventoSvoltoService;
import it.uniroma3.siw.spring.service.MeccaniciService;

@Controller
public class MeccaniciController {

	@Autowired
	private MeccaniciService meccaniciService;
				
	@Autowired
	private MeccaniciValidator meccaniciValidator;
	
	@Autowired 
	private InterventoSvoltoService interventoSvoltoService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@RequestMapping(value="/admin/meccanici", method = RequestMethod.GET)
	public String addMeccanico(Model model) {
		logger.debug("addIntervento");
		model.addAttribute("meccanici", new Meccanici());
		model.addAttribute("intervento", this.meccaniciService.getInterventoService().tutti());
		return "meccaniciForm";
	}
	 @RequestMapping(value = "/meccanico/{id}", method = RequestMethod.GET)
	    public String getMeccanico(@PathVariable("id") Long id, Model model) {
		 logger.debug("getMeccanico");
	    	Meccanici meccanico = this.meccaniciService.meccanicoPerId(id);
		 model.addAttribute("meccanico", this.meccaniciService.meccanicoPerId(id));
	    	model.addAttribute("interventoSvolto", meccanico.getInterventiSvolti());
	    	return "meccanico";
	    }

	    @RequestMapping(value = "/meccanici", method = RequestMethod.GET)
	    public String getMeccanici(Model model) {
	    		model.addAttribute("meccanici", this.meccaniciService.tutti());
	    		return "meccanici";
	    }
	    
	    @RequestMapping(value = "/admin/meccanici", method = RequestMethod.POST)
	    public String addMeccanico(@ModelAttribute("meccanico") Meccanici meccanico, 
	    									Model model, BindingResult bindingResult) {
	    	this.meccaniciValidator.validate(meccanico, bindingResult);
	        if (!bindingResult.hasErrors()) {
	        	this.meccaniciService.inserisci(meccanico);
	            model.addAttribute("meccanici", this.meccaniciService.tutti());
	            model.addAttribute("interventiSvolti", this.interventoSvoltoService.tutti());
	            return "meccanici";
	        }
	        return "meccaniciForm";
	    }
}
