package com.aixjing.week1;

import java.util.Random;

public class DiceRolling {

    public static int[] countDice (int rolls){
        Random rand = new Random();
        int[] counts = new int[13];

        for (int k = 2; k < rolls; k++){
        // The nextInt(int n) is used to get a random number between 0(inclusive)
        // and the number passed in this argument(n), exclusive.
            int dice1 = rand.nextInt(6) + 1;
            int dice2 = rand.nextInt(6) + 1;
            counts[dice1 + dice2] += 1;
        }
        return counts;
    }



}
