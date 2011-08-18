package com.iskido.montecarlo;

import java.util.HashMap;

public class TaskDurationHistories {

    private final HashMap<Task,TaskDurationHistory> durationHistories;

    public TaskDurationHistories() {
        durationHistories = new HashMap<Task, TaskDurationHistory>();
    }

    public void with(Task task, TaskDurationHistory taskDurationHistory) {
        durationHistories.put(task, taskDurationHistory);
    }

    public TaskDurationHistory getDurationHistoryFor(Task task) {
        return durationHistories.get(task);
    }
}
