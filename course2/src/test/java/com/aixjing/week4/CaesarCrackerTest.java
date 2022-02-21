package com.aixjing.week4;

import edu.duke.FileResource;
import org.junit.Test;

public class CaesarCrackerTest {
    FileResource fr = new FileResource("week4/VigenereTestData/oslusiadas_key17.txt");
    String text = fr.asString();
    CaesarCracker cc = new CaesarCracker('a');

    @Test
    public void CCrackerTest () {
        System.out.println(cc.decrypt(text));
    }

}