package com.aixjing.week1;

import edu.duke.FileResource;
import junit.framework.TestCase;
import org.junit.Test;

public class CaeserCipherTwoKeysTest {
    @Test
    public void encryptTwoKeysTest () {
        String input = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        CaeserCipherTwoKeys ccTwoKeys = new CaeserCipherTwoKeys(21,8);
        String encrypted = ccTwoKeys.ecryptTwoKeys(input);
        System.out.println(input + "\n" + encrypted);

        String decrypted = ccTwoKeys.decryptTwoKeys(encrypted);
        System.out.println("\n" + decrypted);

        String decryptedTwoKeys = ccTwoKeys.breakCipher(encrypted);
        System.out.println("\n" + decryptedTwoKeys);
    }

    @Test
    public void decryptedTwoKeys (){
        String encrypted = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        CaeserCipherTwoKeys cc = new CaeserCipherTwoKeys(14,24);
        String decrypted = cc.decryptTwoKeys(encrypted);
        System.out.println(encrypted + "\n" + decrypted);
    }

    @Test
    public void decryptedUnknownKeys () {
        String encrypted = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        String decrypted = CaeserCipherTwoKeys.breakCipher(encrypted);
        System.out.println(encrypted + "\n" + decrypted);
    }

    @Test
    public void decryptedFr (){
        FileResource fr = new FileResource("week1/PracticeBreakingCaesarData/mysteryTwoKeysPractice.txt");
        String message = fr.asString();
        String decrypted = CaeserCipherTwoKeys.breakCipher(message);
        System.out.println(message + "\n" + decrypted);
    }
}