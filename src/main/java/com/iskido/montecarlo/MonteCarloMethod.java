package com.iskido.montecarlo;

public class MonteCarloMethod {

    private final TaskDurationHistory taskDurationHistory;

    public MonteCarloMethod(TaskDurationHistory taskDurationHistory) {
        this.taskDurationHistory = taskDurationHistory;
    }

    public Outcomes simulateFor(int numberOfTasks) {
        Outcomes outcomes = new Outcomes();

        for (int i = 0; i < 100; i++) {
            outcomes.add(new Simulation(numberOfTasks, taskDurationHistory).run());
        }

        return outcomes;
    }
}
