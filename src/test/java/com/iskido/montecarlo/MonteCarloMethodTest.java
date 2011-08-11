package com.iskido.montecarlo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.joda.time.Duration.standardDays;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MonteCarloMethodTest {

    private TaskDurationHistory taskDurationHistory;

    @Before
    public void setUp() throws Exception {
        taskDurationHistory = mock(TaskDurationHistory.class);
    }

    @Ignore
    @Test
    public void aggregateProjections() throws Exception {
        Outcomes expectedOutcomes = new Outcomes();
        expectedOutcomes.add(new Outcome(standardDays(1), 2));
        expectedOutcomes.add(new Outcome(standardDays(2), 1));

        when(taskDurationHistory.getTaskDuration()).thenReturn(standardDays(1));
        MonteCarloMethod monteCarloMethod = new MonteCarloMethod(taskDurationHistory);

        Outcomes actualOutcomes = monteCarloMethod.simulateFor(2);

        assertThat(actualOutcomes, is(expectedOutcomes));
    }
}
