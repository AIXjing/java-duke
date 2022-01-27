package com.aixjing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void playWithReduce() {
        List<Integer> numbers = List.of(1,2,3,4);
        var reduced = numbers.stream()
                .filter(n -> n % 2 == 0) // only 2, 4 can pass
                .map(n -> n*n)
                .reduce(0, Integer::sum);
        System.out.println(reduced);
    }
}
