package com.iskido.montecarlo;

import static org.joda.time.Duration.standardDays;

public class MonteCarloMethod {

    public MonteCarloMethod(TaskDurationHistory taskDurationHistory) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public Outcomes simulateFor(int numberOfTasks) {
        return new Outcomes(new Outcome(standardDays(1), 1));
    }
}
