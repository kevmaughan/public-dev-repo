package com.kevmaughan.app;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Kevin on 16/12/18.
 */
@Documented
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = {RegularAmountValidator.class})
public @interface ValidRegularAmount {

    String message() default "{com.kevmaughan.app}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

