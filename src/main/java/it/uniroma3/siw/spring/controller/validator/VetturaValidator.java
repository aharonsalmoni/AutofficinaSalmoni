package it.uniroma3.siw.spring.controller.validator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Vettura;
import it.uniroma3.siw.spring.service.VetturaService;


@Component
public class VetturaValidator implements Validator {
	@Autowired
	private VetturaService vetturaService;
	
    private static final Logger logger = LoggerFactory.getLogger(VetturaValidator.class);

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "targa", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modello", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "marca", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cilindrata", "required");

		if (!errors.hasErrors()) {
			logger.debug("confermato: valori non nulli");
			if (this.vetturaService.alreadyExists((Vettura)o)) {
				logger.debug("e' un duplicato");
				errors.reject("duplicato");
			}
		}
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return Vettura.class.equals(aClass);
	}
}
