package it.uniroma3.siw.spring.controller.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.InterventoSvolto;
import it.uniroma3.siw.spring.service.InterventoSvoltoService;

@Component
public class InterventoSvoltoValidator implements Validator  {

	@Autowired
	private InterventoSvoltoService interventoSvoltoService;
	
	private static final Logger logger = LoggerFactory.getLogger(InterventoSvoltoValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return InterventoSvolto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orario", "required");

		if (!errors.hasErrors()) {
			logger.debug("confermato: valori non nulli");
			if (this.interventoSvoltoService.alreadyExists((InterventoSvolto)target)) {
				logger.debug("e' un duplicato");
				errors.reject("duplicato");
			}
		}
		
	}

}
