package com.iskido.montecarlo;

import java.util.LinkedList;
import java.util.Queue;

import static org.joda.time.Days.standardDaysIn;
import static org.joda.time.Duration.standardDays;

public class MonteCarloRunner {

    private static final int NUMBER_OF_CHANNELS = 2;

    public static void main(String[] args) {
        TaskDurationHistories taskDurationHistories = new TaskDurationHistories();
        taskDurationHistories.with(Task.SMALL, smallTasks());
        taskDurationHistories.with(Task.MEDIUM, mediumTasks());

        MonteCarloMethod monteCarloMethod = new MonteCarloMethod(taskDurationHistories);

        Outcomes outcomes = monteCarloMethod.simulateFor(tasks(), NUMBER_OF_CHANNELS);

        displayResultsAsCumulativeProbability(outcomes);
    }

    private static Queue<Task> tasks() {
        LinkedList<Task> tasks = new LinkedList<Task>();

        tasks.add(Task.MEDIUM);
        tasks.add(Task.MEDIUM);
        tasks.add(Task.MEDIUM);
        tasks.add(Task.SMALL);

        return tasks;
    }

    private static void displayResultsAsCumulativeProbability(Outcomes outcomes) {
        int total = 0;
        for (Outcome outcome : outcomes.asList()) {
            total += outcome.getFrequency();
            int days = standardDaysIn(outcome.getDuration().toPeriod()).getDays();
            System.out.println(String.format("by day %d\t:\t%d%%", days, total/10));
        }
    }

    private static TaskDurationHistory smallTasks() {
        TaskDurationHistory tasks = new TaskDurationHistory();
        tasks.add(standardDays(1), 14);
        tasks.add(standardDays(2), 24);
        tasks.add(standardDays(3), 6);
        tasks.add(standardDays(4), 8);
        tasks.add(standardDays(5), 4);
        tasks.add(standardDays(6), 2);
        return tasks;
    }

    private static TaskDurationHistory mediumTasks() {
        TaskDurationHistory tasks = new TaskDurationHistory();
        tasks.add(standardDays(1), 0);
        tasks.add(standardDays(2), 1);
        tasks.add(standardDays(3), 4);
        tasks.add(standardDays(4), 3);
        tasks.add(standardDays(5), 2);
        tasks.add(standardDays(6), 0);
        tasks.add(standardDays(7), 3);
        tasks.add(standardDays(8), 1);
        tasks.add(standardDays(9), 1);
        tasks.add(standardDays(10), 2);
        return tasks;
    }
}
