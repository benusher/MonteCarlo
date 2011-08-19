package com.iskido.montecarlo;

import org.joda.time.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TaskDurationHistory {

    private final List<Duration> taskDurations;
    private final Random random;

    public TaskDurationHistory(Duration... taskDurations) {
        this.taskDurations = new ArrayList<Duration>(Arrays.asList(taskDurations));
        random = new Random();
    }

    public Duration getTaskDuration() {
        return taskDurations.get(random.nextInt(taskDurations.size()));
    }

    public void add(Duration duration, int count) {
        for (int i = 0; i < count; i++) {
            taskDurations.add(duration);
        }
    }
}
