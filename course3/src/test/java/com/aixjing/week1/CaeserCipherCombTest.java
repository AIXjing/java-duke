package com.aixjing.week1;

import edu.duke.FileResource;
import junit.framework.TestCase;
import org.junit.Test;

public class CaeserCipherCombTest {

    @Test
    public void encryptTest () {
        CaeserCipherComb ccc = new CaeserCipherComb(15);

        String input = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encrypted = ccc.encrypt(input);
        System.out.println(input + "\n" + "encrypted with key 15: " + encrypted);

        String decrypted1 = ccc.decrypt(encrypted);
        System.out.println("\n" + "decrypted: " + decrypted1);

        String decrypted2 = ccc.breakCipher(encrypted);
        System.out.println("\n" + "decrypted without knowing key: " + decrypted2);
    }


}