package com.iskido.montecarlo;

import java.util.HashSet;
import java.util.Set;

public class Channels {

    private final Set<WorkChannel> workChannels;

    public static Channels create(int numberOfChannels) {
        Set<WorkChannel> workChannels = new HashSet<WorkChannel>();

        for (int i = 0; i < numberOfChannels; i++) {
            workChannels.add(new WorkChannel());
        }

        return new Channels(workChannels);
    }

    private Channels(Set<WorkChannel> workChannels) {
        this.workChannels = workChannels;
    }

    public WorkChannel mostWorked() {
        WorkChannel mostWorked = workChannels.iterator().next();
        for (WorkChannel workChannel : workChannels) {
            if (workChannel.getTotalTimeWorked().isLongerThan(mostWorked.getTotalTimeWorked())) {
                mostWorked = workChannel;
            }
        }
        return mostWorked;
    }

    public WorkChannel leastWorked() {
        WorkChannel leastWorked = workChannels.iterator().next();
        for (WorkChannel workChannel : workChannels) {
            if (workChannel.getTotalTimeWorked().isShorterThan(leastWorked.getTotalTimeWorked())) {
                leastWorked = workChannel;
            }
        }
        return leastWorked;
    }
}
