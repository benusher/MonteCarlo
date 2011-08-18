package com.iskido.montecarlo;

import java.util.LinkedList;
import java.util.Queue;

public class MonteCarloMethod {

    private final TaskDurationHistories taskDurationHistories;

    public MonteCarloMethod(TaskDurationHistories taskDurationHistories) {
        this.taskDurationHistories = taskDurationHistories;
    }

    public Outcomes simulateFor(Queue<Task> tasks) {
        Outcomes outcomes = new Outcomes();

        LinkedList<Task> tasks1 = new LinkedList<Task>();

        for (int i = 0; i < 1000; i++) {
            tasks1.addAll(tasks);
            outcomes.add(new Simulation(tasks1, taskDurationHistories).run());
        }

        return outcomes;
    }
}
