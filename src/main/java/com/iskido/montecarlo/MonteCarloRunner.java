package com.iskido.montecarlo;

import static org.joda.time.Days.standardDaysIn;
import static org.joda.time.Duration.standardDays;

public class MonteCarloRunner {

    public static void main(String[] args) {
        TaskDurationHistory taskDurationHistory = new TaskDurationHistory(standardDays(1), standardDays(1), standardDays(1), standardDays(2));
        MonteCarloMethod monteCarloMethod = new MonteCarloMethod(taskDurationHistory);

        Outcomes outcomes = monteCarloMethod.simulateFor(10);

        for (Outcome outcome : outcomes.asList()) {
            System.out.println(standardDaysIn(outcome.getDuration().toPeriod()).getDays() + ", " + outcome.getFrequency());
        }
    }
}
