package com.iskido.montecarlo;

import org.joda.time.Duration;
import org.junit.Test;

import java.util.HashSet;

import static org.hamcrest.CoreMatchers.is;
import static org.joda.time.Duration.standardDays;
import static org.junit.Assert.assertThat;

public class HistoricalTaskDurationTest {

    private static final int REASONABLE_DEGREE_OF_CONFIDENCE = 100;

    @Test
    public void getAHistoricalTaskDuration() throws Exception {
        Duration duration1 = standardDays(1);
        Duration duration2 = standardDays(2);
        Duration duration3 = standardDays(3);
        HashSet<Duration> expectedDurations = new HashSet<Duration>();
        expectedDurations.add(duration1);
        expectedDurations.add(duration2);
        expectedDurations.add(duration3);

        HistoricalTaskDuration historicalTaskDuration = new HistoricalTaskDuration(duration1, duration2, duration3);

        HashSet<Duration> actualDurations = new HashSet<Duration>();
        for (int i = 0; i < REASONABLE_DEGREE_OF_CONFIDENCE; i++) {
            actualDurations.add(historicalTaskDuration.getTaskDuration());
        }

        assertThat(actualDurations, is(expectedDurations));
    }
}
