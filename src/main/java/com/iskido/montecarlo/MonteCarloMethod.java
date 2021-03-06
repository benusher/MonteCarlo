package com.iskido.montecarlo;

import org.joda.time.Duration;

import java.util.LinkedList;
import java.util.Queue;

public class MonteCarloMethod {

    private final HistoricalTaskDurations historicalTaskDurations;

    public MonteCarloMethod(HistoricalTaskDurations historicalTaskDurations) {
        this.historicalTaskDurations = historicalTaskDurations;
    }

    public Outcomes simulateFor(final Queue<Task> tasks, final int numberOfChannels) {
        Outcomes outcomes = new Outcomes();

        Queue<Task> simulationTasks = new LinkedList<Task>();

        for (int i = 0; i < 1000; i++) {
            simulationTasks.addAll(tasks);
            Simulation simulation = new Simulation(simulationTasks, historicalTaskDurations);
            Duration duration = simulation.run(WorkChannels.create(numberOfChannels));
            outcomes.add(duration);
        }

        return outcomes;
    }
}
