package com.kevmaughan.app;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import static org.junit.Assert.*;

/**
 * Created by Kevin on 16/12/18.
 */
public class TestRegAmountOneWeek {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
     public void testRegAmountValidOneWeekAmount() {

        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(Frequency.WEEK);
        regularAmount.setAmount("2");

        Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
        assertEquals(violations.size(), 0);

    }

    @Test
    public void testRegAmountInvalidOneWeekAmount() {

        RegularAmount regularAmount = new RegularAmount();
        regularAmount.setFrequency(Frequency.WEEK);
        regularAmount.setAmount("2.5");

        Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
        assertEquals(violations.size(), 1);

    }
}
