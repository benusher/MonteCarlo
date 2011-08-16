package com.iskido.montecarlo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.joda.time.Duration.standardDays;
import static org.junit.Assert.assertThat;

public class OutcomesTest {
    
    @Test
    public void totalIdenticalDurations() throws Exception {
        List<Outcome> expectedOutcomeList = new ArrayList<Outcome>();
        expectedOutcomeList.add(new Outcome(standardDays(1), 2));
        Outcomes outcomes = new Outcomes();

        outcomes.add(standardDays(1));
        outcomes.add(standardDays(1));

        assertThat(outcomes.asList(), is(expectedOutcomeList));
    }
    
    @Test
    public void sortOutcomesByIncreasingDuration() throws Exception {
        List<Outcome> expectedOutcomeList = new ArrayList<Outcome>();
        expectedOutcomeList.add(new Outcome(standardDays(1), 1));
        expectedOutcomeList.add(new Outcome(standardDays(2), 1));
        expectedOutcomeList.add(new Outcome(standardDays(3), 1));
        Outcomes outcomes = new Outcomes();

        outcomes.add(standardDays(3));
        outcomes.add(standardDays(1));
        outcomes.add(standardDays(2));

        assertThat(outcomes.asList(), is(expectedOutcomeList));
    }
}
