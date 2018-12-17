package com.kevmaughan.app;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Kevin on 16/12/18.
 */
public class RegularAmountValidator implements ConstraintValidator<ValidRegularAmount, RegularAmount> {

    public void initialize(ValidRegularAmount validRegularAmount) {

    }

    @Override
    public boolean isValid(RegularAmount regularAmount,
                           ConstraintValidatorContext constraintValidatorContext) {

        Frequency frequency = regularAmount.getFrequency();
        String amount = regularAmount.getAmount();

        // creating a divisorValue to help check amount is convertible into weekly
        int divisorValue;

        // Switch statement to determine divisorValue for each Frequency
        switch (frequency) {

            case WEEK:
                divisorValue = 1;
                break;

            case TWO_WEEK:
                divisorValue = 2;
                break;

            case FOUR_WEEK:
                divisorValue = 4;
                break;

            // MONTH is not a valid Frequency for this validation
            case MONTH:
                return false;

            case QUARTER:
                divisorValue = 13;
                break;

            case YEAR:
                divisorValue = 52;
                break;

            default:
                return false;

        }

        // Assuming amount has been entered/converted into pence
        int amountAsInt;
        try {
            // Convert amount from String to int
            amountAsInt = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            System.out.println("Input amount as pence need be an int: " + e);
            return false;
        }

        if ((amountAsInt % divisorValue) == 0) {
            // amount is divisible to a weekly value, passes validation
            return true;
        } else {
            return false;
        }
    }
}
