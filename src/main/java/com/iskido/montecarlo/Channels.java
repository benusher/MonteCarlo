package com.iskido.montecarlo;

import java.util.HashSet;
import java.util.Set;

public class Channels {

    private final Set<Channel> channels;

    public static Channels create(int numberOfChannels) {
        Set<Channel> channels = new HashSet<Channel>();

        for (int i = 0; i < numberOfChannels; i++) {
            channels.add(new Channel());
        }

        return new Channels(channels);
    }

    private Channels(Set<Channel> channels) {
        this.channels = channels;
    }

    public Channel mostWorked() {
        Channel mostWorked = channels.iterator().next();
        for (Channel channel : channels) {
            if (channel.getTotalDuration().isLongerThan(mostWorked.getTotalDuration())) {
                mostWorked = channel;
            }
        }
        return mostWorked;
    }

    public Channel leastWorked() {
        Channel leastWorked = channels.iterator().next();
        for (Channel channel : channels) {
            if (channel.getTotalDuration().isShorterThan(leastWorked.getTotalDuration())) {
                leastWorked = channel;
            }
        }
        return leastWorked;
    }
}
