package com.aixjing.week3.MarkovWord;

/**
 * Write a description of interface IMarkovModel here.
 * 
 * @author Jing Ai
 * @version 2022-03-10
 */

public interface IMarkovModel {
    public void setTraining(String text);
    
    public void setRandom(int seed);
    
    public String getRandomText(int numWords);

}
