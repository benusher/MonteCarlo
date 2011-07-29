package com.iskido.montecarlo;

import org.joda.time.Duration;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.joda.time.Duration.standardDays;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimulationTest {

    @Test
    public void predictsAPossibleTotalDuration() {
        TaskDurationHistory taskDurationHistory = mock(TaskDurationHistory.class);
        when(taskDurationHistory.getTaskDuration()).thenReturn(standardDays(2)).thenReturn(standardDays(1));
        int numberOfTasks = 2;
        Duration expectedTotalDuration = standardDays(3);

        Duration predictedTotalDuration = new Simulation(numberOfTasks, taskDurationHistory).run();

        assertThat(predictedTotalDuration, is(expectedTotalDuration));
    }
}
