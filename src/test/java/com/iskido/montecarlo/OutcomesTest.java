package com.iskido.montecarlo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.joda.time.Duration.standardDays;
import static org.junit.Assert.assertThat;

public class OutcomesTest {
    
    @Test
    public void doATotallingThing() throws Exception {
        List<Outcome> expectedOutcomeList = new ArrayList<Outcome>();
        expectedOutcomeList.add(new Outcome(standardDays(1), 1));
        Outcomes outcomes = new Outcomes();

        outcomes.add(standardDays(1));

        assertThat(outcomes.asList(), is(expectedOutcomeList));
    }
}
