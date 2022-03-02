package com.aixjing.week1;

import com.aixjing.week1.DiceRolling;
import org.junit.Test;

public class DiceRollingTest {

    @Test
    public void countDiceTest() {
        int rolls = 1000;
        int[] counts = DiceRolling.countDice(rolls);
        for (int k = 2; k < counts.length; k++){
            System.out.println(k + "counts is " + counts[k]);
        }
    }

}