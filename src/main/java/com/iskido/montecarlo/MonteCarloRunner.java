package com.iskido.montecarlo;

import java.util.LinkedList;

import static org.joda.time.Days.standardDaysIn;
import static org.joda.time.Duration.standardDays;

public class MonteCarloRunner {

    public static void main(String[] args) {
        TaskDurationHistories taskDurationHistories = new TaskDurationHistories();

        TaskDurationHistory smallTasks = smallTasks();
        taskDurationHistories.with(Task.SMALL, smallTasks);

        TaskDurationHistory mediumTasks = mediumTasks();
        taskDurationHistories.with(Task.MEDIUM, mediumTasks);

        MonteCarloMethod monteCarloMethod = new MonteCarloMethod(taskDurationHistories);

        LinkedList<Task> tasks = new LinkedList<Task>();
        tasks.add(Task.MEDIUM);
        tasks.add(Task.MEDIUM);
        tasks.add(Task.SMALL);
        tasks.add(Task.SMALL);
        tasks.add(Task.SMALL);
        tasks.add(Task.SMALL);
        tasks.add(Task.SMALL);

        Outcomes outcomes = monteCarloMethod.simulateFor(tasks);

        int total = 0;
        for (Outcome outcome : outcomes.asList()) {
            total += outcome.getFrequency();
            System.out.println(standardDaysIn(outcome.getDuration().toPeriod()).getDays() + ", " + total/10);
        }
    }

    private static TaskDurationHistory smallTasks() {
        TaskDurationHistory tasks = new TaskDurationHistory();
        tasks.add(standardDays(1), 14);
        tasks.add(standardDays(2), 19);
        tasks.add(standardDays(3), 5);
        tasks.add(standardDays(4), 8);
        tasks.add(standardDays(5), 2);
        tasks.add(standardDays(6), 2);
        return tasks;
    }

    private static TaskDurationHistory mediumTasks() {
        TaskDurationHistory tasks = new TaskDurationHistory();
        tasks.add(standardDays(1), 0);
        tasks.add(standardDays(2), 1);
        tasks.add(standardDays(3), 4);
        tasks.add(standardDays(4), 2);
        tasks.add(standardDays(5), 1);
        tasks.add(standardDays(6), 0);
        tasks.add(standardDays(7), 1);
        tasks.add(standardDays(8), 1);
        tasks.add(standardDays(9), 1);
        tasks.add(standardDays(10), 2);
        return tasks;
    }
}
