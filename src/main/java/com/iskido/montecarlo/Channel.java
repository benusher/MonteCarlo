package com.iskido.montecarlo;

import org.joda.time.Duration;

import static org.joda.time.Duration.standardDays;

public class Channel {

    private Duration totalDuration;

    public Channel() {
        this.totalDuration = standardDays(0);
    }

    public Duration getTotalDuration() {
        return totalDuration;
    }

    public void plus(Duration duration) {
        totalDuration = totalDuration.plus(duration);
    }
}
