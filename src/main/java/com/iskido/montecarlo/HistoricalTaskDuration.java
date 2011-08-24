package com.iskido.montecarlo;

import org.joda.time.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HistoricalTaskDuration {

    private final List<Duration> taskDurations;
    private final Random random;

    public HistoricalTaskDuration(Duration... taskDurations) {
        this.taskDurations = new ArrayList<Duration>(Arrays.asList(taskDurations));
        random = new Random();
    }

    public void add(Duration duration, int numberOfOccurrences) {
        for (int i = 0; i < numberOfOccurrences; i++) {
            taskDurations.add(duration);
        }
    }

    public Duration getTaskDuration() {
        return taskDurations.get(random.nextInt(taskDurations.size()));
    }
}
