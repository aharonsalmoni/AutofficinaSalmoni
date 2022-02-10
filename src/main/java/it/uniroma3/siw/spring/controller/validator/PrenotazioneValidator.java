package it.uniroma3.siw.spring.controller.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import it.uniroma3.siw.spring.model.Prenotazione;
import it.uniroma3.siw.spring.service.PrenotazioneService;

@Component
public class PrenotazioneValidator implements Validator  {

	@Autowired
	private PrenotazioneService prenotazioneService;
	
	private static final Logger logger = LoggerFactory.getLogger(PrenotazioneValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Prenotazione.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orario", "required");

		if (!errors.hasErrors()) {
			logger.debug("confermato: valori non nulli");
			if (this.prenotazioneService.alreadyExists((Prenotazione)target)) {
				logger.debug("e' un duplicato");
				errors.reject("duplicato");
			}
		}
		
	}

}
