package com.iskido.montecarlo;

import org.joda.time.LocalDate;

public class MonteCarloSimulator {

    private final int numberOfTasks;
    private final LocalDate startDate;
    private final TaskDurationHistory taskDurationHistory;

    public MonteCarloSimulator(int numberOfTasks, LocalDate startDate, TaskDurationHistory taskDurationHistory) {
        this.numberOfTasks = numberOfTasks;
        this.startDate = startDate;
        this.taskDurationHistory = taskDurationHistory;
    }

    public LocalDate run() {
        int totalDurationInDays = 0;

        for (int i = 0; i < numberOfTasks; i++) {
            totalDurationInDays += taskDurationHistory.getTaskDuration();
        }

        return startDate.plusDays(totalDurationInDays);
    }
}
