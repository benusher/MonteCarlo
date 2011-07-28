package com.iskido.montecarlo;

import org.joda.time.Duration;

import java.util.Random;

public class TaskDurationHistory {

    private final Duration[] taskDurations;
    private final Random random;

    public TaskDurationHistory(Duration... taskDurations) {
        this.taskDurations = taskDurations;
        random = new Random();
    }

    public Duration getTaskDuration() {
        return taskDurations[random.nextInt(taskDurations.length)];
    }
}
