package com.iskido.montecarlo;

import org.joda.time.Duration;

import java.util.Queue;

public class Simulation {

    private static final int NUMBER_OF_CHANNELS = 3;
    
    private final TaskDurationHistories taskDurationHistories;
    private final Queue<Task> tasks;

    public Simulation(Queue<Task> tasks, TaskDurationHistories TaskDurationHistories) {
        this.tasks = tasks;
        this.taskDurationHistories = TaskDurationHistories;
    }

    public Duration run() {
        Channels channels = Channels.create(NUMBER_OF_CHANNELS);

        while(tasks.peek() != null) {
            TaskDurationHistory taskDurationHistory = taskDurationHistories.getDurationHistoryFor(tasks.remove());

            Channel leastWorked = channels.leastWorked();

            leastWorked.plus(taskDurationHistory.getTaskDuration());
        }

        return channels.mostWorked().getTotalDuration();
    }
}
