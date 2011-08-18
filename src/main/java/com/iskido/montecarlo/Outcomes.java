package com.iskido.montecarlo;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.joda.time.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.apache.commons.lang.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class Outcomes {

    private final HashMultiset<Duration> durations;

    public Outcomes() {
        durations = HashMultiset.create();
    }

    public void add(Duration duration) {
        durations.add(duration);
    }

    public List<Outcome> asList() {
        ArrayList<Outcome> outcomes = new ArrayList<Outcome>();

        for (Multiset.Entry<Duration> duration : durations.entrySet()) {
            outcomes.add(new Outcome(duration.getElement(), duration.getCount()));
        }

        sortByIncreasingDuration(outcomes);

        return outcomes;
    }

    private void sortByIncreasingDuration(List<Outcome> outcomes) {
        // TODO: It might be nice if this returned a new List instead of modifying this one

        Collections.sort(outcomes, new Comparator<Outcome>() {
            @Override
            public int compare(Outcome outcome1, Outcome outcome2) {
                return outcome1.getDuration().compareTo(outcome2.getDuration());
            }
        });
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
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}
