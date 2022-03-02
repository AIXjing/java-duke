package com.aixjing.week1;

import com.google.common.base.Preconditions;
import com.aixjing.week1.CaeserCipherComb;

public class CaeserCipherTwoKeys {
    private static String alph ="abcdefghijklmnopqrstuvwxyz";
    private static int key1;
    private static int key2;

    public CaeserCipherTwoKeys (int key1, int key2) {
        Preconditions.checkArgument(key1 >=0, "Key1 must not be negative.", key1);
        this.key1 = key1 % 26;
        Preconditions.checkArgument(key2 >=0, "Key2 must not be negative.", key2);
        this.key2 = key2 % 26;
    }

    // encrypt with two Keys
    public String ecryptTwoKeys (String input) {
        String half1 = halfOfString(input,0);
        String half2 = halfOfString(input,1);
        CaeserCipherComb ccKey1 = new CaeserCipherComb(this.key1);
        String encrypted1 = ccKey1.encrypt(half1);
        CaeserCipherComb ccKey2 = new CaeserCipherComb(this.key2);
        String encrypted2 = ccKey2.encrypt(half2);

        // combine two strings together
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < encrypted2.length(); i++) {
            encrypted.append(encrypted1.charAt(i)).append(encrypted2.charAt(i));
        }
        if (encrypted1.length() != encrypted2.length()) { encrypted.append(encrypted1.charAt(encrypted1.length() - 1)); }
        return encrypted.toString();
    }

    // decrypt with two given keys
    public String decryptTwoKeys (String encrypted) {
        CaeserCipherTwoKeys ccTwoKeys = new CaeserCipherTwoKeys(26 - key1, 26 - key2);
        String decrypted = ccTwoKeys.ecryptTwoKeys(encrypted);
        return decrypted;
    }

    // decrypt without knowing keys
    public static String breakCipher (String input) {
        // split into half
        String encrypted1 = halfOfString(input, 0);
        String encrypted2 = halfOfString(input, 1);

        // find the key
        int key1 = CaeserCipherComb.getKey(encrypted1);
        int key2 = CaeserCipherComb.getKey(encrypted2);
        System.out.println("key1: " + key1 + "\n" + "key2: " + key2);

        // decrypt with keys
        CaeserCipherTwoKeys cc = new CaeserCipherTwoKeys(key1,key2);
        String decrypted = cc.decryptTwoKeys(input);
        return decrypted;
    }

    // to split text every second character
    private static String halfOfString(String message, int start) {// start = 1 or 0
        String half = "";
        for (int i = start; i < message.length(); i += 2) {
            half = half + message.charAt(i);
        }
        return half;
    }
}
