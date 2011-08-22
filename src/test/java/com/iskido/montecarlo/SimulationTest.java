package com.iskido.montecarlo;

import org.joda.time.Duration;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Queue;

import static org.hamcrest.CoreMatchers.is;
import static org.joda.time.Duration.standardDays;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimulationTest {

    private Queue<Task> tasks;

    @Before
    public void setUp() throws Exception {
        //noinspection unchecked
        tasks = mock(Queue.class);
    }

    @Ignore
    @Test
    public void thingy() throws Exception {
        Simulation simulation = new Simulation(tasks, null);
        when(tasks.peek()).thenReturn(MonteCarloDataFixtures.someTask()).thenReturn(null);

        Duration simulationDuration = simulation.run(null);

        assertThat(simulationDuration, is(standardDays(1)));
    }
}
