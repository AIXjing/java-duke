package com.aixjing.week4;

import edu.duke.FileResource;
import junit.framework.TestCase;
import org.junit.Test;

public class CaesarCipherTest {
    CaesarCipher caesarCipher = new CaesarCipher(5);

    FileResource fr = new FileResource("week4/VigenereTestData/titus-small.txt");
    String testText = fr.asString();
    @Test
    public void CCTest (){
        String encrypted = caesarCipher.encrypt(testText);
        System.out.println(encrypted);

        System.out.println();

        String decrypted = caesarCipher.decrypt(encrypted);
        System.out.println(decrypted);
    }


}