package com.iskido.montecarlo;

import org.joda.time.Duration;

import java.util.Queue;

public class Simulation {

    private final HistoricalTaskDurations historicalTaskDurations;
    private final Queue<Task> tasks;

    public Simulation(Queue<Task> tasks, HistoricalTaskDurations historicalTaskDurations) {
        this.tasks = tasks;
        this.historicalTaskDurations = historicalTaskDurations;
    }

    public Duration run(final WorkChannels workChannels) {
        while(tasks.peek() != null) {
            Duration historicalTaskDuration = historicalTaskDurations.getDurationFor(tasks.remove());
            WorkChannel leastWorked = workChannels.leastWorkedChannel();
            leastWorked.doMoreWork(historicalTaskDuration);
        }

        return workChannels.mostWorkedChannel().durationWorked();
    }
}
