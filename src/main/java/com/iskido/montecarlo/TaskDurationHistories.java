package com.iskido.montecarlo;

import org.joda.time.Duration;

import java.util.HashMap;
import java.util.Map;

public class TaskDurationHistories {

    private final Map<Task, TaskDurationHistory> durationHistories;

    public TaskDurationHistories() {
        durationHistories = new HashMap<Task, TaskDurationHistory>();
    }

    public void with(Task task, TaskDurationHistory taskDurationHistory) {
        durationHistories.put(task, taskDurationHistory);
    }

    public Duration getDurationFor(Task task) {
        return durationHistories.get(task).getTaskDuration();
    }
}
