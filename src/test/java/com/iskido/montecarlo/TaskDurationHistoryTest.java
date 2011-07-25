package com.iskido.montecarlo;

import com.google.code.tempusfugit.temporal.Condition;
import com.google.code.tempusfugit.temporal.WaitFor;
import com.iskido.montecarlo.TaskDurationHistory;
import org.junit.Test;

import static com.google.code.tempusfugit.temporal.Duration.seconds;
import static com.google.code.tempusfugit.temporal.Timeout.timeout;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TaskDurationHistoryTest {

    @Test
    public void getAHistoricalTaskDuration() throws Exception {
        final int taskDuration1 = 1;
        int taskDuration2 = 3;
        final TaskDurationHistory taskDurationHistory = new TaskDurationHistory(taskDuration1, taskDuration2);

        WaitFor.waitOrTimeout(new Condition() {
            @Override
            public boolean isSatisfied() {
                if (taskDurationHistory.getTaskDuration() == taskDuration1) {

                }
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }
        }, timeout(seconds(1)));

        int actualTaskDuration = taskDurationHistory.getTaskDuration();

        assertThat(actualTaskDuration, is(taskDuration1));
    }
}
