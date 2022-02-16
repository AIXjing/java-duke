package com.aixjing.week2;

import edu.duke.FileResource;
import junit.framework.TestCase;
import org.junit.Test;

public class CharactersInPlayTest {
    CharactersInPlay charactersInPlay
            = new CharactersInPlay(new FileResource("week2/QuizGladLibsData/errors.txt"));

    @Test
    public void findAllCharactersTest () {
        charactersInPlay.findAllCharacters();
//        for (int k = 0; k < charactersInPlay.characters.size(); k++) {
//            System.out.println(charactersInPlay.nums.get(k) + " " + charactersInPlay.characters.get(k));
//        }
//        charactersInPlay.findMostCharacter();
        charactersInPlay.findThirdCharacter();

        charactersInPlay.charactersWithNumParts(10,15);
    }

}