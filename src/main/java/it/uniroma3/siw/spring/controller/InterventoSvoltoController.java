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

import it.uniroma3.siw.spring.controller.validator.InterventoSvoltoValidator;
import it.uniroma3.siw.spring.model.InterventoSvolto;
import it.uniroma3.siw.spring.service.InterventoService;
import it.uniroma3.siw.spring.service.InterventoSvoltoService;
import it.uniroma3.siw.spring.service.MeccaniciService;
import it.uniroma3.siw.spring.service.VetturaService;

@Controller
public class InterventoSvoltoController {
	
	@Autowired
	private InterventoSvoltoService interventoSvoltoService;
	
	@Autowired
    private InterventoSvoltoValidator interventoSvoltoValidator;
	
	@Autowired
	private InterventoService interventoService;
	
	@Autowired
	private VetturaService vetturaService;
        
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MeccaniciService meccaniciService;
	
    @RequestMapping(value="/admin/interventoSvolto", method = RequestMethod.GET)
    public String addInterventoSvolto(Long id, Model model) {
    	logger.debug("addInterventoSvolto");
    	model.addAttribute("interventoSvolto", new InterventoSvolto());
    	model.addAttribute("vettura",this.interventoSvoltoService.getVetturaService().tutti());
    	model.addAttribute("intervento",this.interventoSvoltoService.getInterventoService().tutti());
    	model.addAttribute("meccanico", meccaniciService.tutti());
    	return "interventoSvoltoForm";
    }

   

	@RequestMapping(value = "/interventoSvolto/{id}", method = RequestMethod.GET)
    public String getInterventoSvolto(@PathVariable("id") Long id, Model model) {
    	InterventoSvolto interventoSvolto = this.interventoSvoltoService.interventoSvoltoPerId(id);
        model.addAttribute("prenotazione", interventoSvolto.getDataPrenotazione());
    	return "interventoSvolto";
    }

    @RequestMapping(value = "/interventoSvolto", method = RequestMethod.GET)
    public String getInterventiSvolti(Model model) {
    		model.addAttribute("interventiSvolti", this.interventoSvoltoService.tutti());
    		return "interventiSvolti";
    }
    
    @RequestMapping(value = "/admin/interventoSvolto", method = RequestMethod.POST)
    public String addInterventoSvolto(@ModelAttribute("interventosvolto") InterventoSvolto interventoSvolto, 
    									Model model, BindingResult bindingResult) {
    	//this.interventoSvoltoValidator.validate(interventoSvolto, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.interventoSvoltoService.inserisci(interventoSvolto);
            model.addAttribute("interventiSvolti", this.interventoSvoltoService.tutti());
            model.addAttribute("interventi", this.interventoService.tutti());
            model.addAttribute("vetture", this.vetturaService.tutti());
            model.addAttribute("meccanici", this.meccaniciService.tutti());
            return "interventiSvolti";
        }
        return "interventoSvoltoForm";
    }
}