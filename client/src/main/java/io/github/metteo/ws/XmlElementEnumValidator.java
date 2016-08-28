package io.github.metteo.ws;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class XmlElementEnumValidator implements ConstraintValidator<XmlElementEnum, String> {

	private Class<? extends Enum<?>> enumClass;
	private Enum<?>[] enumConsts;
	private List<String> enumStrings;
	
	@Override
	public void initialize(XmlElementEnum constraintAnnotation) {
		enumClass = constraintAnnotation.value();
		enumConsts = enumClass.getEnumConstants();
		enumStrings = new ArrayList<>();
		
		for(Enum<?> constant : enumConsts) {
			enumStrings.add(constant.name());
		}
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) { return true; }
		if (enumStrings.contains(value)) { return true; }

		//at this point string is invalid enum value, provide possible values in
		//validation message
		context.disableDefaultConstraintViolation();
		String m = context.getDefaultConstraintMessageTemplate() + " " + enumStrings;
		context.buildConstraintViolationWithTemplate(m).addConstraintViolation();
		
		return false;
	}
}
