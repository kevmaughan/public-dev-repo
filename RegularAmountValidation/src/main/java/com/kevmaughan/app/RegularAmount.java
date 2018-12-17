package com.kevmaughan.app;

/**
 * Created by Kevin on 16/12/18.
 */
@ValidRegularAmount
public class RegularAmount {

    private Frequency frequency;
    private String amount;

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
