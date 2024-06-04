package com.duckrace;

import java.util.Collection;

public class DuckRacerTest {
    public static void main(String[] args) {
        //instantiate a duck object and make it win a few times
        DuckRacer duck = new DuckRacer(1, "Amir");
        duck.win(Reward.DEBIT_CARD);
        duck.win(Reward.PRIZES);
        duck.win(Reward.PRIZES);
        duck.win(Reward.DEBIT_CARD);
        duck.win(Reward.PRIZES);

        System.out.println(duck); //toString() automatically called

        //I can cheat, and get more rewards without "win()ning" - no longer possible b/c we're now returning a ReadOnly list
        Collection<Reward> rewards = duck.getRewards();
        System.out.println(rewards);
        duck.win(Reward.DEBIT_CARD);
        System.out.println(rewards);
        //rewards.add(Reward.PRIZES);
        //rewards.add(Reward.PRIZES);
    }
}
