package com.iskido.montecarlo;

import com.google.common.collect.HashMultiset;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.joda.time.Duration;

import java.util.ArrayList;
import java.util.List;

public class Outcomes {

    private final HashMultiset<Duration> durations;

    public Outcomes() {
        durations = HashMultiset.create();
    }

    @Deprecated // Use add(Duration) instead
    public void add(Outcome outcome) {
    }

    public void add(Duration duration) {
        durations.add(duration);
    }

    public List<Outcome> asList() {
        ArrayList<Outcome> outcomes = new ArrayList<Outcome>();

        for (Duration duration : durations.elementSet()) {
            outcomes.add(new Outcome(duration, durations.count(duration)));
        }

        return outcomes;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
