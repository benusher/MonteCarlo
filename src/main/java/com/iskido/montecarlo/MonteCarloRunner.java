package com.iskido.montecarlo;

import java.util.LinkedList;
import java.util.Queue;

import static org.joda.time.Days.standardDaysIn;
import static org.joda.time.Duration.standardDays;

public class MonteCarloRunner {

    private static final int NUMBER_OF_CHANNELS = 3;

    public static void main(String[] args) {
        MonteCarloMethod monteCarloMethod = new MonteCarloMethod(historicalTaskDurations());

        Outcomes outcomes = monteCarloMethod.simulateFor(tasks(), NUMBER_OF_CHANNELS);

        displayResultsAsCumulativeProbability(outcomes);
    }

    private static Queue<Task> tasks() {
        LinkedList<Task> tasks = new LinkedList<Task>();

        tasks.add(Task.MEDIUM);
        tasks.add(Task.MEDIUM);
        tasks.add(Task.MEDIUM);
        tasks.add(Task.MEDIUM);
        tasks.add(Task.MEDIUM);
        tasks.add(Task.SMALL);
        tasks.add(Task.SMALL);
        tasks.add(Task.SMALL);
        tasks.add(Task.SMALL);
        tasks.add(Task.SMALL);
        tasks.add(Task.SMALL);
        tasks.add(Task.SMALL);

        return tasks;
    }

    private static HistoricalTaskDurations historicalTaskDurations() {
        HistoricalTaskDurations historicalTaskDurations = new HistoricalTaskDurations();
        historicalTaskDurations.with(Task.SMALL, smallTasks());
        historicalTaskDurations.with(Task.MEDIUM, mediumTasks());
        
        return historicalTaskDurations;
    }

    private static void displayResultsAsCumulativeProbability(Outcomes outcomes) {
        int totalFrequency = 0;

        for (Outcome outcome : outcomes.asList()) {
            totalFrequency += outcome.getFrequency();
            int days = outcomeDurationInDays(outcome);

            System.out.println(String.format("by day %d\t:\t%d%%", days, totalFrequency/10));
        }
    }

    private static int outcomeDurationInDays(Outcome outcome) {
        return standardDaysIn(outcome.getDuration().toPeriod()).getDays();
    }

    private static HistoricalTaskDuration smallTasks() {
        HistoricalTaskDuration tasks = new HistoricalTaskDuration();
        tasks.add(standardDays(1), 18);
        tasks.add(standardDays(2), 25);
        tasks.add(standardDays(3), 8);
        tasks.add(standardDays(4), 8);
        tasks.add(standardDays(5), 4);
        tasks.add(standardDays(6), 2);
        return tasks;
    }

    private static HistoricalTaskDuration mediumTasks() {
        HistoricalTaskDuration tasks = new HistoricalTaskDuration();
        tasks.add(standardDays(1), 0);
        tasks.add(standardDays(2), 2);
        tasks.add(standardDays(3), 4);
        tasks.add(standardDays(4), 5);
        tasks.add(standardDays(5), 3);
        tasks.add(standardDays(6), 0);
        tasks.add(standardDays(7), 3);
        tasks.add(standardDays(8), 2);
        tasks.add(standardDays(9), 1);
        tasks.add(standardDays(10), 2);
        return tasks;
    }
}
