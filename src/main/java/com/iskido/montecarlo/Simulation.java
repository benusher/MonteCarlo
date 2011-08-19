package com.iskido.montecarlo;

import org.joda.time.Duration;

import java.util.Queue;

public class Simulation {

    private final TaskDurationHistories taskDurationHistories;
    private final Queue<Task> tasks;

    public Simulation(Queue<Task> tasks, TaskDurationHistories TaskDurationHistories) {
        this.tasks = tasks;
        this.taskDurationHistories = TaskDurationHistories;
    }

    public Duration run(final WorkChannels workChannels) {
        while(tasks.peek() != null) {
            Duration historicalTaskDuration = taskDurationHistories.getDurationFor(tasks.remove());
            WorkChannel leastWorked = workChannels.leastWorkedChannel();
            leastWorked.doMoreWork(historicalTaskDuration);
        }

        return workChannels.mostWorkedChannel().getTotalTimeWorked();
    }
}
