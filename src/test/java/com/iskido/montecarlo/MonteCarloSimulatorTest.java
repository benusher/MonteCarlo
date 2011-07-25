package com.iskido.montecarlo;

import com.iskido.montecarlo.MonteCarloSimulator;
import com.iskido.montecarlo.TaskDurationHistory;
import org.joda.time.LocalDate;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MonteCarloSimulatorTest {

    @Test
    public void predictsAPossibleDeliveryDate() {
        TaskDurationHistory taskDurationHistory = mock(TaskDurationHistory.class);
        when(taskDurationHistory.getTaskDuration()).thenReturn(2).thenReturn(1);
        int numberOfTasks = 2;
        LocalDate startDate = new LocalDate();
        LocalDate expectedDeliveryDate = startDate.plusDays(3);

        LocalDate predictedDeliveryDate = new MonteCarloSimulator(numberOfTasks, startDate, taskDurationHistory).run();

        assertThat(predictedDeliveryDate, is(expectedDeliveryDate));
    }
}
