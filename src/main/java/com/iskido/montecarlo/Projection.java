package com.iskido.montecarlo;

import org.joda.time.Duration;

import static org.joda.time.Duration.standardDays;

public class Projection {

    private final int numberOfTasks;
    private final TaskDurationHistory taskDurationHistory;

    public Projection(int numberOfTasks, TaskDurationHistory taskDurationHistory) {
        this.numberOfTasks = numberOfTasks;
        this.taskDurationHistory = taskDurationHistory;
    }

    public Duration run() {
        Duration totalDuration = standardDays(0);

        for (int i = 0; i < numberOfTasks; i++) {
            totalDuration = totalDuration.plus(taskDurationHistory.getTaskDuration());
        }

        return totalDuration;
    }
}
