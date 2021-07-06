package br.com.zupacademy.hugo.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CPForCNPJvalidator.class)
public @interface CPForCNPJ {

    String message() default "CPF/CNPJ invalido!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
