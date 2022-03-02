package com.aixjing.week1;

import edu.duke.FileResource;
import junit.framework.TestCase;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

public class CaesarBreakerTest {
    // CaesarBreaker caesarBreaker = new CaesarBreaker(new FileResource());

    @Test
    public void countLettersTest (){
        FileResource fr = new FileResource("week1/CommonWordsData/romeo.txt");
        String testString = fr.asString();
        int[] counts = CaesarBreaker.countLetters(testString);
        for (int k = 0; k < counts.length; k++){
            System.out.println(CaesarBreaker.alph.charAt(k) + " counts: " + counts[k]);
        }

        int maxIndex = CaesarBreaker.indexOfMax(testString);
        System.out.println("The most letter is " + CaesarBreaker.alph.charAt(maxIndex));
    }

    @Test
    public void decryptTest () {
        // encrypt a text
        CaesarCipher cc = new CaesarCipher();
        String text = "Just a test string with lots of eeeeeeeeeeeeeeeees";
        String encrypted = cc.encryptString(5, text);
        System.out.println(text + "\n" + "message after encryption: " + encrypted + "\n");

        // decrypt above encrypted text
        String decrypted = CaesarBreaker.decrypt(encrypted);
        System.out.println("after decryption: " + decrypted);

        String splited = CaesarBreaker.splitString(text, 0);
        System.out.println(splited);
    }

    @Test // Test the functionality of the method
    public void decryptTwoKeysTest1 () {
        // encrypt with two keys
        CaesarCipher cc = new CaesarCipher();
        String text = "Just a test string with lots of eeeeeeeeeeeeeeeeees";
        String encryptWithTwoKeys = cc.encryptTwoKeys(4, 8, text);
        System.out.println(text + "\n" + "message after encryption: " + encryptWithTwoKeys + "\n");

        // decrypt with two keys
        String decryptedTwoKeys = CaesarBreaker.decryptTwoKeys(encryptWithTwoKeys);
        System.out.println("after decryption with two keys: " + decryptedTwoKeys );
    }

    @Test // test the decrypt method with two known keys
    public void decryptTwoKeysTest2 (){
        String encrypted = "Top ncmy qkff vi vguv vbg ycpx";
        String decryptedTwoKeys = CaesarBreaker.decryptTwoKeys(encrypted, 2, 20);
        System.out.println(encrypted + "\n" + "after decryption with two keys: " + decryptedTwoKeys );
    }

    @Test // test the decrypt method with two unknown keys
    public void decryptTwoKeysTest3 () {
        FileResource fr = new FileResource("week1/PracticeBreakingCaesarData/mysteryTwoKeysPractice.txt");
        String encrypted = fr.asString();
        String decryptedTwoKeys = CaesarBreaker.decryptTwoKeys(encrypted);
        System.out.println( decryptedTwoKeys );


    }

}