package com.iskido.montecarlo;

import java.util.LinkedList;

import static org.joda.time.Days.standardDaysIn;
import static org.joda.time.Duration.standardDays;

public class MonteCarloRunner {

    public static void main(String[] args) {
        TaskDurationHistories taskDurationHistories = new TaskDurationHistories();
        taskDurationHistories.with(Task.SMALL, new TaskDurationHistory(standardDays(1), standardDays(1), standardDays(1), standardDays(2)));
        taskDurationHistories.with(Task.MEDIUM, new TaskDurationHistory(standardDays(2), standardDays(3), standardDays(4)));

        MonteCarloMethod monteCarloMethod = new MonteCarloMethod(taskDurationHistories);

        LinkedList<Task> tasks = new LinkedList<Task>();
        tasks.add(Task.MEDIUM);
        tasks.add(Task.MEDIUM);
        tasks.add(Task.SMALL);
        tasks.add(Task.SMALL);
        tasks.add(Task.SMALL);

        Outcomes outcomes = monteCarloMethod.simulateFor(tasks);

        for (Outcome outcome : outcomes.asList()) {
            System.out.println(standardDaysIn(outcome.getDuration().toPeriod()).getDays() + ", " + outcome.getFrequency());
        }
    }
}
