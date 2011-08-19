package com.iskido.montecarlo;

import org.joda.time.Duration;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.joda.time.Duration.ZERO;
import static org.joda.time.Duration.standardDays;
import static org.junit.Assert.assertThat;

public class WorkChannelTest {

    private WorkChannel workChannel;

    @Before
    public void setUp() throws Exception {
        workChannel = new WorkChannel();
    }

    @Test
    public void aNewWorkChannelHasSpentNoTimeOnWork() throws Exception {
        Duration totalTimeWorked = workChannel.getTotalTimeWorked();

        assertThat(totalTimeWorked, is(ZERO));
    }

    @Test
    public void getTheTotalAmountOfTimeWorked() throws Exception {
        workChannel.doMoreWork(standardDays(1));
        workChannel.doMoreWork(standardDays(1));

        Duration totalTimeWorked = workChannel.getTotalTimeWorked();

        assertThat(totalTimeWorked, is(standardDays(2)));
    }
}
