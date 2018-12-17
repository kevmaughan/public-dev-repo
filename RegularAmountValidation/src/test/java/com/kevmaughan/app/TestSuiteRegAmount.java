package com.kevmaughan.app;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * Created by Kevin on 16/12/18.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                TestRegAmountOneWeek.class,
                TestRegAmountTwoWeeks.class,
                TestRegAmountFourWeeks.class,
                TestRegAmountMonth.class,
                TestRegAmountQuarter.class,
                TestRegAmountYear.class
        }
)
public class TestSuiteRegAmount {
}
