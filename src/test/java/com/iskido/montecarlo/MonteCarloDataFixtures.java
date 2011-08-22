package com.iskido.montecarlo;

import static com.iskido.montecarlo.RandomDataFixtures.pickOneOf;

public class MonteCarloDataFixtures {
    public static Task someTask() {
        return pickOneOf(Task.values());
    }
}
