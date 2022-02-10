package it.uniroma3.siw.spring.controller.validator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Anagrafica;
import it.uniroma3.siw.spring.service.AnagraficaService;


@Component
public class AnagraficaValidator implements Validator {
	@Autowired
	private AnagraficaService anagraficaService;
	
    private static final Logger logger = LoggerFactory.getLogger(AnagraficaValidator.class);

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cellulare", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "required");

		if (!errors.hasErrors()) {
			logger.debug("confermato: valori non nulli");
			if (this.anagraficaService.alreadyExists((Anagrafica)o)) {
				logger.debug("e' un duplicato");
				errors.reject("duplicato");
			}
		}
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Anagrafica.class.equals(aClass);
	}
}
