package com.aixjing.week1;

import edu.duke.FileResource;
import org.junit.Test;

public class CaesarCipherTest {

    @Test
    public void encryptTest1() {
        String input = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";

        String encrypted = CaesarCipher.encryptString(15, input);
        System.out.println(input + "\n" + " after encryption with key 15 is " + "\n" + encrypted);

        String encryptedTwoKeys = CaesarCipher.encryptTwoKeys(8, 21, input);
        System.out.println(input + "\n" + " after encryption with keys (8,21) is " + "\n" + encryptedTwoKeys);
    }

    @Test
    public void encryptTest2() {
        String input = new FileResource("src/main/resources/week1/message1.txt").asString();

        String encrypted = CaesarCipher.encryptString(0, input);
        System.out.println("Encryption with key 23 is: " + "\n" + encrypted);

        String encryptedTwoKeys = CaesarCipher.encryptTwoKeys(23, 17, input);
        System.out.println("Encryption with keys (23,27) is: " + "\n" + encryptedTwoKeys);
    }

}