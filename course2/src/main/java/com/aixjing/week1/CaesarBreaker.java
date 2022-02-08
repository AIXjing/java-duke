package com.aixjing.week1;

import edu.duke.FileResource;
import com.aixjing.week1.CaesarBreaker;

import static com.google.common.primitives.Ints.max;

public class CaesarBreaker {
    FileResource fr;
    static String alph = "abcdefghijklmnopqrstuvwxyz";

    public CaesarBreaker (FileResource fr){
        this.fr = fr;
    }

    // to count each letter in a text
    public static int[] countLetters (String string) {
        String text = string.toLowerCase();
        int[] counts = new int[26];
        for (int k = 0; k < text.length(); k++){
            char currChar = text.charAt(k);
            int index = alph.indexOf(currChar);
            if (index != -1){ counts[index] += 1; }
        }
        return counts;
    }

    // find the letter has the most count
    public static int indexOfMax (String string) {
        int[] counts = countLetters(string);
        int maxValue = 0;
        int maxValueIndex = 0;
        for (int k = 0; k < counts.length; k++) {
            if (counts[k] > maxValue) {
                maxValue = counts[k];
                maxValueIndex = k;
            }
        }
        return maxValueIndex;
    }

    // decrypt method
    public static String decrypt (String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int key = getKey(encrypted);
        String message = cc.encryptString(26 - key, encrypted);
        return message;
    }

    // decrypt with two keys
    public static String decryptTwoKeys (String encrypted) {
        String half1 = splitString(encrypted, 0);
        String half2 = splitString(encrypted, 1);

        String decrypted1 = decrypt(half1);
        int key1 = getKey(half1);
        System.out.println("key1: " + key1);
        // System.out.println("decrypted1 length: " + decrypted1.length());

        String decrypted2 = decrypt(half2);
        int key2 = getKey(half2);
        System.out.println("key2: " + key2);
        // System.out.println("decrypted2 length: " + decrypted2.length());

        // combine two strings together
        String decrypted = "";
        for (int i = 0; i < half2.length(); i++) {
            decrypted = decrypted + decrypted1.charAt(i) + decrypted2.charAt(i);
        }
        if (half1.length() != half2.length()) { decrypted = decrypted + decrypted1.charAt(half1.length() - 1); }
        return decrypted;
    }

    public static String decryptTwoKeys (String encrypted, int key1, int key2) {
        CaesarCipher cc = new CaesarCipher();
        String half1 = splitString(encrypted, 0);
        String half2 = splitString(encrypted, 1);
        String decrypted1 = cc.encryptString(26 - key1, half1);
        String decrypted2 = cc.encryptString(26 - key2, half2);
        String decrypted = "";
        for (int i = 0; i < half2.length(); i++) {
            decrypted = decrypted + decrypted1.charAt(i) + decrypted2.charAt(i);
        }
        if (half1.length() != half2.length()) { decrypted = decrypted + decrypted1.charAt(half1.length() - 1); }
        return decrypted;
    }

    private static int getKey (String message) {
        int maxValueIndex = indexOfMax(message);
        int key = (26 + (maxValueIndex - 4)) % 26;
        return key;
    }

    // splitString every second letters
    public static String splitString (String message, int start) {// start = 1 or 0
        String half = "";
        for (int i = start; i < message.length(); i += 2) {
            half = half + message.charAt(i);
        }
        return half;
    }
}
