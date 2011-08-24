package com.iskido.montecarlo;

import org.joda.time.Duration;

import static org.joda.time.Duration.standardDays;

public class WorkChannel {

    private Duration totalDuration;

    public WorkChannel() {
        this.totalDuration = standardDays(0);
    }

    public Duration durationWorked() {
        return totalDuration;
    }

    public void doMoreWork(Duration duration) {
        totalDuration = totalDuration.plus(duration);
    }
}
