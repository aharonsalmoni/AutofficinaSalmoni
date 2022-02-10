package it.uniroma3.siw.spring.controller.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import it.uniroma3.siw.spring.model.Intervento;
import it.uniroma3.siw.spring.service.InterventoService;

@Component
public class InterventoValidator implements Validator  {

	@Autowired
	private InterventoService interventoService;
	
	private static final Logger logger = LoggerFactory.getLogger(InterventoValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Intervento.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prezzo", "required");

		if (!errors.hasErrors()) {
			logger.debug("confermato: valori non nulli");
			if (this.interventoService.alreadyExists((Intervento)target)) {
				logger.debug("e' un duplicato");
				errors.reject("duplicato");
			}
		}
		
	}

}
