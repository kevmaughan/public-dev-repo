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
public class TestRegAmountTwoWeeks {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
     public void testRegAmountValidTwoWeeksAmount() {

        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(Frequency.TWO_WEEK);
        regularAmount.setAmount("4");

        Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
        assertEquals(violations.size(), 0);

    }

    @Test
    public void testRegAmountInvalidTwoWeeksAmount() {

        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(Frequency.TWO_WEEK);
        regularAmount.setAmount("5");

        Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
        assertEquals(violations.size(), 1);

    }
}
