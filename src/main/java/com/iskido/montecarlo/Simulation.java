package com.iskido.montecarlo;

import org.joda.time.Duration;

import java.util.HashSet;
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
        HashSet<Pair> pairs = new HashSet<Pair>();
        pairs.add(new Pair());
        pairs.add(new Pair());
        pairs.add(new Pair());

        while(tasks.peek() != null) {
            TaskDurationHistory taskDurationHistory = taskDurationHistories.getDurationHistoryFor(tasks.remove());

            Pair leastWorked = pairs.iterator().next();
            for (Pair pair : pairs) {
                if (pair.getTotalDuration().isShorterThan(leastWorked.getTotalDuration())) {
                    leastWorked = pair;
                }
            }

            leastWorked.plus(taskDurationHistory.getTaskDuration());
        }

        Pair mostWorked = pairs.iterator().next();
        for (Pair pair : pairs) {
            if (pair.getTotalDuration().isLongerThan(mostWorked.getTotalDuration())) {
                mostWorked = pair;
            }
        }

        return mostWorked.getTotalDuration();
    }

    private static class Pair {

        private Duration totalDuration;

        public Pair() {
            this.totalDuration = standardDays(0);
        }

        public Duration getTotalDuration() {
            return totalDuration;
        }

        public void plus(Duration duration) {
            totalDuration = totalDuration.plus(duration);
        }
    }
}
