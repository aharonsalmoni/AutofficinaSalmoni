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
import it.uniroma3.siw.spring.controller.validator.InterventoValidator;
import it.uniroma3.siw.spring.model.Intervento;
import it.uniroma3.siw.spring.service.InterventoService;
import it.uniroma3.siw.spring.service.InterventoSvoltoService;
import it.uniroma3.siw.spring.service.MeccaniciService;
import it.uniroma3.siw.spring.service.PrenotazioneService;

@Controller
public class InterventoController {
	
	@Autowired
	private InterventoService interventoService;
	
	@Autowired
    private InterventoValidator interventoValidator;
	
	@Autowired
	private InterventoSvoltoService interventoSvoltoService;
	
	@Autowired
	private PrenotazioneService prenotazioneService;
	
	@Autowired
	private MeccaniciService meccaniciService;
        
    @RequestMapping(value="/admin/intervento", method = RequestMethod.GET)
    public String addIntervento(Model model) {
    	model.addAttribute("intervento", new Intervento());
        return "interventoForm";
    }

    @RequestMapping(value = "/intervento/{id}", method = RequestMethod.GET)
    public String getIntervento(@PathVariable("id") Long id, Model model) {
    	Intervento intervento = this.interventoService.interventoPerId(id);
    	model.addAttribute("intervento", this.interventoService.interventoPerId(id));
    	model.addAttribute("interventoSvolto", intervento.getInterventoSvolto());
    	model.addAttribute("prenotazione", intervento.getPrenotazione());
    	model.addAttribute("meccanico", intervento.getMeccanico());
    	return "intervento";
    }

    @RequestMapping(value = "/intervento", method = RequestMethod.GET)
    public String getInterventi(Model model) {
    		model.addAttribute("interventi", this.interventoService.tutti());
    		return "interventi";
    }
    
    @RequestMapping(value = "/admin/intervento", method = RequestMethod.POST)
    public String addIntervento(@ModelAttribute("intervento") Intervento intervento, 
    									Model model, BindingResult bindingResult) {
    	this.interventoValidator.validate(intervento, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.interventoService.inserisci(intervento);
            model.addAttribute("interventi", this.interventoService.tutti());
            model.addAttribute("interventiSvolti", this.interventoSvoltoService.tutti());
            model.addAttribute("prenotazioni", this.prenotazioneService.tutti());
            model.addAttribute("meccanici", this.meccaniciService.tutti());
            return "interventi";
        }
        return "interventoForm";
    }
}