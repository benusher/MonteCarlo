package com.iskido.montecarlo;

import org.joda.time.Duration;

import java.util.LinkedList;

import static com.iskido.montecarlo.RandomDataFixtures.pickOneOf;
import static com.iskido.montecarlo.RandomDataFixtures.someNumberBetween;

public class MonteCarloDataFixtures {

    public static Task someTask() {
        return pickOneOf(Task.values());
    }

    public static LinkedList<Task> someTasks() {
        LinkedList<Task> tasks = new LinkedList<Task>();

        for (int i = 0; i < someNumberBetween(1, 3); i++) {
            tasks.add(someTask());
        }

        return tasks;
    }

    public static int someNumberOfWorkChannels() {
        return someNumberBetween(1, 3);
    }

    public static Duration someDays() {
        return Duration.standardDays(someNumberBetween(1, 10));
    }
}
