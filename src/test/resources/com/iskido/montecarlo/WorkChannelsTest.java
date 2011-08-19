package com.iskido.montecarlo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.joda.time.Duration.standardDays;
import static org.junit.Assert.assertThat;

public class WorkChannelsTest {

    @Test
    public void mostWorkedChannelIsWorkChannelWithTheMostTimeSpentWorking() throws Exception {
        WorkChannels workChannels = WorkChannels.create(2);

        WorkChannel mostWorkedChannel = workChannels.mostWorkedChannel();
        mostWorkedChannel.doMoreWork(standardDays(1));

        assertThat(workChannels.mostWorkedChannel(), is(mostWorkedChannel));
    }

    @Test
    public void leasrWorkedChannelIsWorkChannelWithTheLeastTimeSpentWorking() throws Exception {
        WorkChannels workChannels = WorkChannels.create(2);

        WorkChannel mostWorkedChannel = workChannels.mostWorkedChannel();
        mostWorkedChannel.doMoreWork(standardDays(1));

        assertThat(workChannels.leastWorkedChannel(), not(is(mostWorkedChannel)));
    }
}
