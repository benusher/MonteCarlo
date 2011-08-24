package com.iskido.montecarlo;

import org.joda.time.Duration;

import java.util.HashMap;
import java.util.Map;

public class HistoricalTaskDurations {

    private final Map<Task, HistoricalTaskDuration> durationHistories;

    public HistoricalTaskDurations() {
        durationHistories = new HashMap<Task, HistoricalTaskDuration>();
    }

    public void with(Task task, HistoricalTaskDuration historicalTaskDuration) {
        durationHistories.put(task, historicalTaskDuration);
    }

    public Duration getDurationFor(Task task) {
        return durationHistories.get(task).getTaskDuration();
    }
}
