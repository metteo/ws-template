package io.github.metteo.ws;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {XmlElementEnumValidator.class})
@Documented
public @interface XmlElementEnum {
	
	String message() default "{io.github.metteo.ws.XmlElementEnum.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	Class<? extends Enum<?>> value();

	@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List {
		XmlElementEnum[] value();
	}
}
