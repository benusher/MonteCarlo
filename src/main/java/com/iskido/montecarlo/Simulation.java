package com.iskido.montecarlo;

import org.joda.time.Duration;

import java.util.Queue;

import static org.joda.time.Duration.standardDays;

public class Simulation {

    private final TaskDurationHistories taskDurationHistories;
    private final Queue<Task> tasks;

    public Simulation(Queue<Task> tasks, TaskDurationHistories TaskDurationHistories) {
        this.tasks = tasks;
        this.taskDurationHistories = TaskDurationHistories;
    }

    public Duration run() {
        Duration totalDuration = standardDays(0);

        while(tasks.peek() != null) {
            TaskDurationHistory taskDurationHistory = taskDurationHistories.getDurationHistoryFor(tasks.remove());
            totalDuration = totalDuration.plus(taskDurationHistory.getTaskDuration());
        }

        return totalDuration;
    }
}
