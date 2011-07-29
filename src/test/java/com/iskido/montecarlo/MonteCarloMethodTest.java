package com.iskido.montecarlo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.joda.time.Duration.standardDays;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MonteCarloMethodTest {

    @Test
    public void aggregateProjections() throws Exception {
        Outcomes expectedOutcomes = new Outcomes(new Outcome(standardDays(1), 0));
        TaskDurationHistory taskDurationHistory = mock(TaskDurationHistory.class);
        when(taskDurationHistory.getTaskDuration()).thenReturn(standardDays(1));
        MonteCarloMethod monteCarloMethod = new MonteCarloMethod(taskDurationHistory);

        Outcomes actualOutcomes = monteCarloMethod.simulateFor(1);

        assertThat(actualOutcomes, is(expectedOutcomes));
    }
}
