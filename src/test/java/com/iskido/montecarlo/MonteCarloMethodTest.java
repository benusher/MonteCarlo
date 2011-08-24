package com.iskido.montecarlo;

import org.junit.Before;
import org.junit.Test;

import static com.iskido.montecarlo.MonteCarloDataFixtures.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MonteCarloMethodTest {

    private MonteCarloMethod monteCarloMethod;

    @Before
    public void setUp() throws Exception {
        HistoricalTaskDurations historicalTaskDurations = mock(HistoricalTaskDurations.class);
        when(historicalTaskDurations.getDurationFor(any(Task.class))).thenReturn(someDays());

        monteCarloMethod = new MonteCarloMethod(historicalTaskDurations);
    }

    @Test
    public void performsOneThousandSimulations() throws Exception {
        Outcomes outcomes = monteCarloMethod.simulateFor(someTasks(), someNumberOfWorkChannels());

        assertThat(totalNumberOfResultsIn(outcomes), is(1000));
    }

    private int totalNumberOfResultsIn(Outcomes outcomes) {
        int totalNumberOfResults = 0;

        for (Outcome outcome : outcomes.asList()) {
            totalNumberOfResults += outcome.getFrequency();
        }
        
        return totalNumberOfResults;
    }
}
