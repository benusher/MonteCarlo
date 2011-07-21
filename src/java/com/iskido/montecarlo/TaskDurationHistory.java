package com.iskido.montecarlo;

public class TaskDurationHistory {

    private final int[] taskDuration;

    public TaskDurationHistory(int... taskDuration) {
        this.taskDuration = taskDuration;
    }

    public int getTaskDuration() {
        return taskDuration[0];
    }
}
