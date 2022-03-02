package com.aixjing.week2;

import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {
    public ArrayList<String> characters;
    public ArrayList<Integer> nums;
    private FileResource fr;

    public CharactersInPlay (FileResource fr) {
        this.characters = new ArrayList<String>();
        this.nums = new ArrayList<Integer>();
        this.fr = fr;
    }

    public void findAllCharacters () {
        this.characters.clear();
        this.nums.clear();
        for (String line : fr.lines()) {
            int indexOfPeriod = line.indexOf(".");
            if (indexOfPeriod != -1) {
                String name = line.substring(0, indexOfPeriod).toLowerCase();
                update(name);
            }
        }
    }

    // a method to find out the number of names between num1 and num2, assuming num1 <= num2
    public void charactersWithNumParts (int num1, int num2) {
        for (int k = 0; k < characters.size(); k++) {
            if ((nums.get(k) >= num1) && (nums.get(k) <= num2)) {
                System.out.println(characters.get(k) + " " + nums.get(k));
            }
        }
    }

    // find the most name as speaking part
    public int findMostCharacter () {
        int max = 0;
        int indexOfMax = 0;
        for (int k = 0; k < characters.size(); k++) {
            if (max < nums.get(k)) {
                max = nums.get(k);
                indexOfMax = k;
            }
        }
        System.out.println("The most character is "
                + characters.get(indexOfMax)
                + " for "
                + nums.get(indexOfMax));
        return max;
    }

    // find the most name as speaking part
    public int findSecondCharacter () {
        int second = 0;
        int max = findMostCharacter();
        int indexOfSecond = 0;
        for (int k = 0; k < characters.size(); k++) {
            if (second < nums.get(k) && nums.get(k) < max) {
                second = nums.get(k);
                indexOfSecond = k;
            }
        }
        System.out.println("The Second character is "
                + characters.get(indexOfSecond)
                + " for "
                + nums.get(indexOfSecond));
        return second;
    }

    // find the most name as speaking part
    public int findThirdCharacter () {
        int third = 0;
        int second = findSecondCharacter();
        int indexOfThird = 0;
        for (int k = 0; k < characters.size(); k++) {
            if (third < nums.get(k) && nums.get(k) < second) {
                third = nums.get(k);
                indexOfThird = k;
            }
        }
        System.out.println("The Third character is "
                + characters.get(indexOfThird)
                + " for "
                + nums.get(indexOfThird));
        return third;
    }

    private void update (String name) {
        if (!this.characters.contains(name)) {
            characters.add(name);
            nums.add(1);
        }
        else {
            int index = characters.indexOf(name);
            int currNum = nums.get(index);
            nums.set(index, currNum + 1);
        }
    }
}
