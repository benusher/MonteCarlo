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
    private MonteCarloMethod monteCarloMethod;

    @Before
    public void setUp() throws Exception {
        taskDurationHistory = mock(TaskDurationHistory.class);
        when(taskDurationHistory.getTaskDuration()).thenReturn(standardDays(1));

        monteCarloMethod = new MonteCarloMethod(taskDurationHistory);
    }

    @Ignore
    @Test
    public void simulateANumberOfTasks() throws Exception {
        Outcomes expectedOutcomes = new Outcomes();
        expectedOutcomes.add(standardDays(2));

        Outcomes actualOutcomes = monteCarloMethod.simulateFor(2);

        assertThat(actualOutcomes, is(expectedOutcomes));
    }

    @Test
    public void runOneHundredSimulations() throws Exception {
        Outcomes outcomes = monteCarloMethod.simulateFor(1);

        assertThat(outcomes.asList().size(), is(1));
        assertThat(outcomes.asList().get(0).getFrequency(), is(100));
    }
}
