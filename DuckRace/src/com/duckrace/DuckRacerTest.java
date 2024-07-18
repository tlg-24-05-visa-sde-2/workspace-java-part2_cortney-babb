package com.duckrace;

import java.util.Collection;

class DuckRacerTest {
    public static void main(String[] args) {
        DuckRacer racer = new DuckRacer(1, "Bullen");
        System.out.println(racer);
        racer.win(Reward.PRIZES);
        racer.win(Reward.PRIZES);
        racer.win(Reward.DEBIT_CARD);
        System.out.println(racer);
        System.out.println();

        // fetch collection from this existing duck racer object (read-only view)
        Collection<Reward> rewards = racer.getRewards();
        System.out.println(rewards);

        racer.win(Reward.DEBIT_CARD);
        System.out.println(rewards);
    }
}