package com.kevmaughan.app;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kevin on 16/12/18.
 */
public class TestRegAmountMonth {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testRegAmountInvalidMonthAmount() {

        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(Frequency.MONTH);
        regularAmount.setAmount("4");

        Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
        assertEquals(violations.size(), 1);

    }
}
