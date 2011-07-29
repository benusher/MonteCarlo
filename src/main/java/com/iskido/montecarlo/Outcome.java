package com.iskido.montecarlo;

import org.joda.time.Duration;

public class Outcome {

    private final Duration duration;
    private final int frequency;

    public Outcome(Duration duration, int frequency) {
        this.duration = duration;
        this.frequency = frequency;
    }

    @Override
    public int hashCode() {
        return org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object o) {
        return org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public String toString() {
        return org.apache.commons.lang.builder.ToStringBuilder.reflectionToString(this, org.apache.commons.lang.builder.ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
