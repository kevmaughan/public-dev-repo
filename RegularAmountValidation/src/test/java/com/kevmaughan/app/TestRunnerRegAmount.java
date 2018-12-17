package com.kevmaughan.app;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Kevin on 16/12/18.
 */
public class TestRunnerRegAmount {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSuiteRegAmount.class);

        for (Failure failure : result.getFailures()) {
            System.out.println("Test Failure: "+failure.toString());
        }

        System.out.println("Tests Success: "+result.wasSuccessful());
    }
}

