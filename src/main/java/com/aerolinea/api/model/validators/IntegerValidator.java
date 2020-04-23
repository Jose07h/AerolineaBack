package com.aerolinea.api.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IntegerValidator implements ConstraintValidator<IsInteger, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (Integer.valueOf(value)==12) {
			return false;
		}
		return true;
	}

}
